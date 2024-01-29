package org.imt.tdl.libraryGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.etsi.mts.tdl.Annotation;
import org.etsi.mts.tdl.AnnotationType;
import org.etsi.mts.tdl.CollectionDataType;
import org.etsi.mts.tdl.DataType;
import org.etsi.mts.tdl.Element;
import org.etsi.mts.tdl.ElementImport;
import org.etsi.mts.tdl.Extension;
import org.etsi.mts.tdl.Member;
import org.etsi.mts.tdl.Package;
import org.etsi.mts.tdl.PackageableElement;
import org.etsi.mts.tdl.SimpleDataInstance;
import org.etsi.mts.tdl.SimpleDataType;
import org.etsi.mts.tdl.StructuredDataType;
import org.etsi.mts.tdl.tdlFactory;

public class Ecore2TDLTransformation {
	private tdlFactory factory;

	private Package rootTdlPackage;

	private AnnotationType abstractAnnotationType;
	private AnnotationType dynamicAnnotationType;
	private AnnotationType containmentAnnotationType;

	private static final String ABSTRACT = "abstract";
	private static final String DYNAMIC = "dynamic";
	private static final String ASPECT = "aspect";
	private static final String CONTAINMENT = "containment";

	private Map<EClassifier, DataType> eclass2type = new HashMap<>();
	private Map<DataType, CollectionDataType> type2collectionType = new HashMap<>();

	/**
	 * List of DataTypes that either themselves or one of their features have
	 * dynamic/aspect annotation
	 */
	private Set<DataType> dynamicTypes = new HashSet<>();

	public Ecore2TDLTransformation() {
		factory = tdlFactory.eINSTANCE;
	}

	public void run(EPackage rootPackage) {
		transform(rootPackage);

		generateType4EObject();
		generateType4EDataTypes();

		// once all classes are transformed to a TDL type, transform the eclass
		// features and supertypes as we need to reference the generated TDL type of
		// other eclasses
		eclass2type.forEach((eclass, tdlType) -> {
			if (eclass instanceof EClass && tdlType instanceof StructuredDataType) {
				transformEClassFeatures((EClass) eclass, (StructuredDataType) tdlType);
				transformEClassSupertypes((EClass) eclass, (StructuredDataType) tdlType);
			}
		});
	}

	private void transform(EPackage rootEPackage) {
		this.rootTdlPackage = factory.createPackage();
		rootTdlPackage.setName(rootEPackage.getName() + "Types");
		transformPackageElements(rootEPackage, rootTdlPackage);
	}

	private void transformPackageElements(EPackage epackage, Package tdlPackage) {
		epackage.getESubpackages().forEach(epack -> {
			Package tdlPack = ePackage2tdlPackage(epack);
			tdlPackage.getNestedPackage().add(tdlPack);
		});
		epackage.getEClassifiers().forEach(eclassifier -> {
			DataType tdlType = classifier2tdlType(eclassifier, tdlPackage);
			if (tdlType != null) {
				tdlPackage.getPackagedElement().add(tdlType);
				setAnnotations(eclassifier, tdlType);
				eclass2type.put(eclassifier, tdlType);
			}
		});
	}

	private Package ePackage2tdlPackage(EPackage epackage) {
		Package tdlPackage = factory.createPackage();
		tdlPackage.setName(TDLCodeGenerator.getValidName(epackage.getName()));
		transformPackageElements(epackage, tdlPackage);
		return tdlPackage;
	}

	private DataType classifier2tdlType(EClassifier eclassifier, Package tdlPackage) {
		if (eclassifier instanceof EClass) {
			return eClass2structuredType((EClass) eclassifier);
		} else if (eclassifier instanceof EDataType) {
			if (eclassifier instanceof EEnum) {
				SimpleDataType simpleType = eEnum2tdlType((EEnum) eclassifier);
				((EEnum) eclassifier).getELiterals().forEach(literal -> {
					SimpleDataInstance tdlInstance = eEnumLiteral2tdlInstance(literal, simpleType);
					tdlPackage.getPackagedElement().add(tdlInstance);
				});
				return simpleType;
			} else {
				return eDataType2tdlType((EDataType) eclassifier);
			}
		}
		return null;
	}

	private StructuredDataType eClass2structuredType(EClass eclass) {
		StructuredDataType tdlType = factory.createStructuredDataType();
		tdlType.setName(TDLCodeGenerator.getValidTypeName(eclass.getName()));
		return tdlType;
	}

	private void transformEClassFeatures(EClass eclass, StructuredDataType tdlType) {
		eclass.getEStructuralFeatures().forEach(feature -> {
			eFeature2member(feature, tdlType);
		});
	}

	private void transformEClassSupertypes(EClass eclass, StructuredDataType tdlType) {
		eclass.getEAllSuperTypes().forEach(eSuperType -> {
			eSuperType2extension(eSuperType, tdlType);
		});
	}

	private void eFeature2member(EStructuralFeature efeature, StructuredDataType ownerType) {
		DataType memberType = eclass2type.get(efeature.getEType());
		if (memberType != null) {
			Package ownerPackage = (Package) ownerType.eContainer();
			boolean isContainment = false;
			Member member = factory.createMember();
			member.setName(TDLCodeGenerator.getValidName(efeature.getName()));
			if (efeature instanceof EReference) {
				// for EReferences that can have many values, a CollectionDataType must be set
				EReference reference = (EReference) efeature;
				if (reference.isMany()) {
					memberType = getCollectionDataType(memberType, ownerPackage);
				}
				if (reference.isContainment()) {
					isContainment = true;
				}

			}
			member.setDataType(memberType);

			// if the type does not exist in the package, add an import to its owner package
			checkImport(ownerPackage, memberType);

			if (isDynamic(efeature)) {
				addAnnotation(member, getDynamicAnnotationType());
				// if a feature is dynamic, its owner type is considered as dynamic
				dynamicTypes.add(ownerType);
			}
			if (isContainment) {
				addAnnotation(member, getContainmentAnnotationType());
			}
			ownerType.getMember().add(member);
		}
	}

	private DataType getCollectionDataType(DataType memberType, Package ownerPackage) {
		return type2collectionType.computeIfAbsent(memberType, (type) -> {
			CollectionDataType collectionType = factory.createCollectionDataType();
			collectionType.setName(TDLCodeGenerator.getValidTypeName(memberType.getName() + "s"));
			collectionType.setItemType(memberType);
			ownerPackage.getPackagedElement().add(collectionType);
			checkImport(ownerPackage, memberType);
			return collectionType;
		});
	}

	// if the required element belongs to another package, generate an import in
	// the owner package for the required package
	private void checkImport(Package ownerPackage, PackageableElement requiredElement) {
		Package requiredPackage = (Package) requiredElement.eContainer();
		if (!EcoreUtil.equals(ownerPackage, requiredPackage)
				&& !alreadyImported(ownerPackage, requiredPackage, requiredElement)) {
			ElementImport tdlImport = factory.createElementImport();
			tdlImport.setImportedPackage(requiredPackage);
			tdlImport.getImportedElement().add(requiredElement);
			ownerPackage.getImport().add(tdlImport);
		}
	}

	private boolean alreadyImported(Package ownerPackage, Package requiredPackage, PackageableElement requiredElement) {
		return ownerPackage.getImport().stream().anyMatch(
				impo -> impo.getImportedPackage().equals(requiredPackage) && (impo.getImportedElement() == null
						|| impo.getImportedElement().isEmpty() || impo.getImportedElement().contains(requiredElement)));
	}

	private void eSuperType2extension(EClass eSuperType, StructuredDataType ownerType) {
		DataType tdlSuperType = eclass2type.get(eSuperType);
		if (tdlSuperType != null) {
			Extension extension = factory.createExtension();
			extension.setExtending(tdlSuperType);

			checkImport((Package) ownerType.eContainer(), tdlSuperType);

			ownerType.getExtension().add(extension);

			// a type is dynamic if any of its super classes are dynamic
			if (isDynamic(eSuperType) || eSuperType.getEAllSuperTypes().stream().anyMatch(type -> isDynamic(type))) {
				addAnnotation(ownerType, getDynamicAnnotationType());
				dynamicTypes.add(ownerType);
			}
		}
	}

	/**
	 * It adds "abstract" and "dynamic" annotations to the tdlType if the eclass is
	 * abstract and is dynamic, respectively. IMPORTANT: due to a bug in TDL
	 * implementation (https://labs.etsi.org/rep/top/ide/-/issues/52), it is not
	 * possible to add two annotations to the same element. Accordingly, we only set
	 * dynamic annotation to non-abstract elements for now.
	 * 
	 * @param eclassifier
	 * @param tdlType
	 */
	private void setAnnotations(EClassifier eclassifier, DataType tdlType) {
		if (isDynamic(eclassifier)) {
			addAnnotation(tdlType, getDynamicAnnotationType());
			dynamicTypes.add(tdlType);
		} else if (eclassifier instanceof EClass && ((EClass) eclassifier).isAbstract()) {
			addAnnotation(tdlType, getAbstractAnnotationType());
		}
	}

	private boolean isDynamic(EModelElement eelement) {
		return eelement.getEAnnotation(DYNAMIC) != null || eelement.getEAnnotation(ASPECT) != null;
	}

	private void addAnnotation(Element annotated, AnnotationType annotationType) {
		// due to a bug in TDL implementation
		// (https://labs.etsi.org/rep/top/ide/-/issues/52), it is not possible to add
		// two annotations to the same element.
		if (annotated.getAnnotation().isEmpty()) {
			Annotation annot = factory.createAnnotation();
			annot.setKey(annotationType);
			annot.setAnnotatedElement(annotated);
			annotated.getAnnotation().add(annot);
			if (annotated.eContainer() != null && annotated.eContainer() instanceof Package) {
				checkImport((Package) annotated.eContainer(), annotationType);
			}
		}
	}

	private SimpleDataType eDataType2tdlType(EDataType etype) {
		return generateSimpleDataType(etype.getName());
	}

	private SimpleDataType eEnum2tdlType(EEnum eenum) {
		return generateSimpleDataType(eenum.getName());
	}

	private SimpleDataInstance eEnumLiteral2tdlInstance(EEnumLiteral literal, SimpleDataType tdlType4enum) {
		SimpleDataInstance tdlInstance = factory.createSimpleDataInstance();
		tdlInstance.setName(literal.getName());
		tdlInstance.setDataType(tdlType4enum);
		return tdlInstance;
	}

	/**
	 * generating {@link SimpleDataType} for {@link EObject}
	 */
	private void generateType4EObject() {
		// generating a simple type for EObject
		EClass eObject = EcorePackage.eINSTANCE.getEObject();
		SimpleDataType eobjectType = generateSimpleDataType(eObject.getName());
		rootTdlPackage.getPackagedElement().add(eobjectType);
		eclass2type.put(eObject, eobjectType);
	}

	/**
	 * generating {@link SimpleDataType} for {@link EDataType} of Ecore such as
	 * EString, EBoolean, ...
	 */
	private void generateType4EDataTypes() {
		EcorePackage.eINSTANCE.eContents().stream().filter(EDataType.class::isInstance).map(EDataType.class::cast)
				.forEach(etype -> {
					SimpleDataType tdlType = eDataType2tdlType(etype);
					rootTdlPackage.getPackagedElement().add(tdlType);
					eclass2type.put(etype, tdlType);
				});
	}

	private SimpleDataType generateSimpleDataType(String name) {
		SimpleDataType tdlType = factory.createSimpleDataType();
		tdlType.setName(TDLCodeGenerator.getValidTypeName(name));
		return tdlType;
	}

	private AnnotationType getAbstractAnnotationType() {
		if (abstractAnnotationType == null) {
			abstractAnnotationType = generateAnnotationType(ABSTRACT);
			rootTdlPackage.getPackagedElement().add(abstractAnnotationType);
		}
		return abstractAnnotationType;
	}

	private AnnotationType getDynamicAnnotationType() {
		if (dynamicAnnotationType == null) {
			dynamicAnnotationType = generateAnnotationType(DYNAMIC);
			rootTdlPackage.getPackagedElement().add(dynamicAnnotationType);
		}
		return dynamicAnnotationType;
	}

	private AnnotationType getContainmentAnnotationType() {
		if (containmentAnnotationType == null) {
			containmentAnnotationType = generateAnnotationType(CONTAINMENT);
			rootTdlPackage.getPackagedElement().add(containmentAnnotationType);
		}
		return containmentAnnotationType;
	}

	private AnnotationType generateAnnotationType(String name) {
		AnnotationType annoType = factory.createAnnotationType();
		annoType.setName(name);
		return annoType;
	}

	public Package getRootTdlPackage() {
		return rootTdlPackage;
	}

	public Map<String, DataType> getDslSpecificTypes() {
		Map<String, DataType> types = new HashMap<>();
		eclass2type.forEach((eclass, tdlType) -> types.put(eclass.getName().toLowerCase(), tdlType));
		type2collectionType.values().forEach(ctype -> types.put(ctype.getName(), ctype));
		return types;
	}

	public List<DataType> getDynamicTypes() {
		return new ArrayList<>(dynamicTypes);
	}
}
