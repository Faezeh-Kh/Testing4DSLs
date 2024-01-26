package org.imt.tdl.libraryGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.gemoc.executionframework.behavioralinterface.behavioralInterface.BehavioralInterface;
import org.eclipse.gemoc.executionframework.behavioralinterface.behavioralInterface.Event;
import org.eclipse.gemoc.executionframework.behavioralinterface.behavioralInterface.EventType;
import org.etsi.mts.tdl.Annotation;
import org.etsi.mts.tdl.AnnotationType;
import org.etsi.mts.tdl.AnyValue;
import org.etsi.mts.tdl.DataType;
import org.etsi.mts.tdl.ElementImport;
import org.etsi.mts.tdl.Member;
import org.etsi.mts.tdl.MemberAssignment;
import org.etsi.mts.tdl.Package;
import org.etsi.mts.tdl.StructuredDataInstance;
import org.etsi.mts.tdl.StructuredDataType;
import org.etsi.mts.tdl.UnassignedMemberTreatment;
import org.etsi.mts.tdl.tdlFactory;

public class DSLSpecificEventsGenerator {

	private tdlFactory factory;
	private Package dslSpecificEventsPackage;

	private Package dslSpecificTypesPackage;
	private Map<String, DataType> dslSpecificTypes = new HashMap<String, DataType>();

	private List<DataType> dslInterfaceTypes = new ArrayList<DataType>();

	public DSLSpecificEventsGenerator(DSLSpecificTypesGenerator dslSpecificTypesGenerator) {
		factory = tdlFactory.eINSTANCE;
		dslSpecificTypesPackage = dslSpecificTypesGenerator.getDslSpecificTypesPackage();
		dslSpecificTypes = dslSpecificTypesGenerator.getDslSpecificTypes();
	}

	public Package generateDSLSpecificEventsPackage(BehavioralInterface behavioralInterface) {
		dslSpecificEventsPackage = factory.createPackage();
		dslSpecificEventsPackage.setName(getPackageName(behavioralInterface.getName()));
		generateImports();
		generateTypeForDSLInterfaces(behavioralInterface);
		System.out.println("dsl-specific events package generated successfully");
		return dslSpecificEventsPackage;
	}

	private String getPackageName(String name) {
		String interfaceText = "Interface";
		name = name.substring(0, 1).toLowerCase() + name.substring(1);
		return name.contains(interfaceText) ? name : name.toLowerCase() + interfaceText;
	}

	private void generateImports() {
		ElementImport PackageImport = factory.createElementImport();
		PackageImport.setImportedPackage(dslSpecificTypesPackage);
		dslSpecificEventsPackage.getImport().add(PackageImport);
	}

	private void generateTypeForDSLInterfaces(BehavioralInterface behavioralInterface) {
		AnnotationType acceptedEvent = factory.createAnnotationType();
		acceptedEvent.setName("AcceptedEvent");
		AnnotationType exposedEvent = factory.createAnnotationType();
		exposedEvent.setName("ExposedEvent");
		dslSpecificEventsPackage.getPackagedElement().add(acceptedEvent);
		dslSpecificEventsPackage.getPackagedElement().add(exposedEvent);

		for (int i = 0; i < behavioralInterface.getEvents().size(); i++) {
			Event event = behavioralInterface.getEvents().get(i);
			StructuredDataType typeForEvent = factory.createStructuredDataType();
			typeForEvent.setName(TDLCodeGenerator.getValidTypeName(event.getName()));
			Annotation annotation = factory.createAnnotation();
			if (event.getType() == EventType.ACCEPTED) {
				annotation.setKey(acceptedEvent);
			} else if (event.getType() == EventType.EXPOSED) {
				annotation.setKey(exposedEvent);
			}
			annotation.setAnnotatedElement(typeForEvent);
			typeForEvent.getAnnotation().add(annotation);
			// generating an instance of the event type to be able to use it when writing
			// test cases
			StructuredDataInstance eventInstance = factory.createStructuredDataInstance();
			eventInstance.setName(TDLCodeGenerator.getValidName(typeForEvent.getName().toLowerCase()));
			eventInstance.setDataType(typeForEvent);
			eventInstance.setUnassignedMember(UnassignedMemberTreatment.ANY_VALUE);

			for (int j = 0; j < event.getParams().size(); j++) {
				String paramName = TDLCodeGenerator.getValidName(event.getParams().get(j).getName());
				String paramType = event.getParams().get(j).getType().toLowerCase();
				if (paramType.contains(".")) {
					paramType = paramType.substring(paramType.lastIndexOf(".") + 1, paramType.length());
				}
				if (dslSpecificTypes.get(paramType) != null) {
					Member member = factory.createMember();
					member.setName(paramName);
					member.setDataType(dslSpecificTypes.get(paramType));
					typeForEvent.getMember().add(member);

					MemberAssignment memberAssign = factory.createMemberAssignment();
					memberAssign.setMember(member);
					AnyValue anyValue = factory.createAnyValue();
					anyValue.setName("?");
					memberAssign.setMemberSpec(anyValue);
					eventInstance.getMemberAssignment().add(memberAssign);
				}
			}
			dslSpecificEventsPackage.getPackagedElement().add(typeForEvent);
			dslSpecificEventsPackage.getPackagedElement().add(eventInstance);
			dslInterfaceTypes.add(typeForEvent);
		}
	}

	public Package getDslSpecificEventsPackage() {
		return dslSpecificEventsPackage;
	}

	public List<DataType> getTypesOfDslInterfaces() {
		return dslInterfaceTypes;
	}
}
