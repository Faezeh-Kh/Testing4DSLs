/*
 * generated by Xtext 2.10.0
 */
package org.imt.xminijava.xtext.validation

import com.google.common.collect.HashMultimap


import com.google.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.CheckType
import org.imt.xminijava.xtext.XMiniJavaModelUtil
import org.imt.minijava.xminiJava.Block
import org.imt.minijava.xminiJava.Class
import org.imt.minijava.xminiJava.Expression
import org.imt.minijava.xminiJava.FieldAccess
import org.imt.minijava.xminiJava.Method
import org.imt.minijava.xminiJava.MethodCall
import org.imt.minijava.xminiJava.XminiJavaPackage
import org.imt.minijava.xminiJava.NamedElement
import org.imt.minijava.xminiJava.Program
import org.imt.minijava.xminiJava.Return
import org.imt.minijava.xminiJava.Super
import org.imt.minijava.xminiJava.VariableDeclaration
import org.imt.xminijava.xtext.scoping.XMiniJavaIndex

import static extension org.eclipse.xtext.EcoreUtil2.*
import org.imt.minijava.xminiJava.ClassRef
import org.imt.minijava.xminiJava.Interface
import org.imt.minijava.xminiJava.Field
import org.imt.minijava.xminiJava.TypeDeclaration
import java.util.HashSet
import java.util.Set
import org.imt.minijava.xminiJava.NewObject
import org.imt.xminijava.xtext.typing.XMiniJavaTypeComputer
import org.imt.xminijava.xtext.typing.XMiniJavaTypeConformance

/**
 * This class contains custom validation rules. 
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class XMiniJavaValidator extends AbstractXMiniJavaValidator {

	protected static val ISSUE_CODE_PREFIX = "org.tetrabox.minijava.xtext."
	public static val HIERARCHY_CYCLE = ISSUE_CODE_PREFIX + "HierarchyCycle"
	public static val FIELD_SELECTION_ON_METHOD = ISSUE_CODE_PREFIX + "FieldSelectionOnMethod"
	public static val METHOD_INVOCATION_ON_FIELD = ISSUE_CODE_PREFIX + "MethodInvocationOnField"
	public static val UNREACHABLE_CODE = ISSUE_CODE_PREFIX + "UnreachableCode"
	public static val MISSING_FINAL_RETURN = ISSUE_CODE_PREFIX + "MissingFinalReturn"
	public static val EXTRA_FINAL_RETURN = ISSUE_CODE_PREFIX + "ExtraFinalReturn"
	public static val DUPLICATE_ELEMENT = ISSUE_CODE_PREFIX + "DuplicateElement"
	public static val INCOMPATIBLE_TYPES = ISSUE_CODE_PREFIX + "IncompatibleTypes"
	public static val INVALID_ARGS = ISSUE_CODE_PREFIX + "InvalidArgs"
	public static val WRONG_METHOD_OVERRIDE = ISSUE_CODE_PREFIX + "WrongMethodOverride"
	public static val MEMBER_NOT_ACCESSIBLE = ISSUE_CODE_PREFIX + "MemberNotAccessible"
	public static val DUPLICATE_CLASS = ISSUE_CODE_PREFIX + "DuplicateClass"
	public static val WRONG_SUPER_USAGE = ISSUE_CODE_PREFIX + "WrongSuperUsage"
	public static val REDUCED_ACCESSIBILITY = ISSUE_CODE_PREFIX + "ReducedAccessibility"
	public static val ABSTRACT_METHOD_BODY = ISSUE_CODE_PREFIX + "AbstractMethodBody"
	public static val ABSTRACT_METHOD_CLASS = ISSUE_CODE_PREFIX + "AbstractMethodClass"
	public static val CONSTRUCTOR_CLASS = ISSUE_CODE_PREFIX + "ConstructorClass"
	public static val CONSTRUCTOR_ABSTRACT = ISSUE_CODE_PREFIX + "ConstructorAbstract"
	public static val INTERFACE_MEMBERS = ISSUE_CODE_PREFIX + "InterfaceMembers"
	public static val INTERFACE_SUPERTYPE = ISSUE_CODE_PREFIX + "InterfaceSuperType"
	public static val CLASS_SUPERTYPE = ISSUE_CODE_PREFIX + "ClassSuperType"

	@Inject extension XMiniJavaModelUtil
	@Inject extension XMiniJavaTypeComputer
	@Inject extension XMiniJavaTypeConformance
	@Inject extension XMiniJavaAccessibility
	@Inject extension XMiniJavaIndex
	@Inject extension IQualifiedNameProvider

	@Check
	def checkClassHierarchy(TypeDeclaration c) {
		if (c.classHierarchy.contains(c)) {
			error("Cycle in hierarchy of class '" + c.name + "'.", XminiJavaPackage.eINSTANCE.namedElement_Name,
				HIERARCHY_CYCLE, c.name)
		}
	}

	def boolean isAnImplementionOf(Method m1, Method m2) {
		val c = m1.eContainer as Class
		val t = m2.eContainer as TypeDeclaration
		val conforms = c.isConformant(t)
		val returnConforms = m1.typeRef.type.isConformant(m2.typeRef.type)
		val m1paramtypes = m1.params.map[typeRef].map[type]
		val m2paramtypes = m2.params.map[typeRef].map[type]

		return (conforms && m1.name == m2.name && returnConforms && m1paramtypes.elementsEqual(m2paramtypes))
	}

	// TODO improve localization of error highlighting
	@Check def checkAllMethodsImplemented(Class c) {
		if (! c.abstract) {
			// store implemented methods
			val nonAbstract = new HashSet<Method>
			nonAbstract.addAll(c.methods.filter[!it.abstract])
			val abstract = new HashSet<Method>

			val Set<TypeDeclaration> visited = newLinkedHashSet()
			val current = c.superTypes

			while (! current.isEmpty) {
				// Analyze super types
				val superTypesMethods = current.map[members].flatten.filter(Method).toSet
				val sorting = superTypesMethods.groupBy[it.abstract || it.eContainer instanceof Interface]
				val Set<Method> superTypeAbstractMethods = if (sorting.containsKey(true))
						sorting.get(true).toSet
					else
						#{}
				val Set<Method> superTypeNonAbstractMethods = if (sorting.containsKey(false))
						sorting.get(false).toSet
					else
						#{}
				nonAbstract.addAll(superTypeNonAbstractMethods)

				abstract.addAll(superTypeAbstractMethods)

				// Continue visiting
				visited.addAll(current)
				val copy = newLinkedHashSet()
				copy.addAll(current)
				current.clear
				current.addAll(copy.map[superTypes].flatten.filter[!visited.contains(it)])
			}

			if (abstract.exists[a|!nonAbstract.exists[na|na.isAnImplementionOf(a)]]) {
				error('''All abstract methods must be implemented, or the class must be made abstract.''', c,
					XminiJavaPackage.eINSTANCE.class_SuperClass, ABSTRACT_METHOD_CLASS);
			}

		}
	}

	@Check
	def void checkUnreachableCode(Block block) {
		val statements = block.statements
		for (var i = 0; i < statements.length - 1; i++) {
			if (statements.get(i) instanceof Return) {
				// put the error on the statement after the return
				error("Unreachable code", statements.get(i + 1), null, // EStructuralFeature
				UNREACHABLE_CODE)
				return // no need to report further errors
			}
		}
	}

	@Check
	def void checkReturn(Method method) {
		if (method.name !== null) {
			if (method.typeRef.eClass !== XminiJavaPackage::eINSTANCE.voidTypeRef) {
				if (method.returnStatement === null) {
					error(
						"Method must end with a return statement",
						XminiJavaPackage.eINSTANCE.method_Body,
						MISSING_FINAL_RETURN
					)
				}
			} else {
				if (method.returnStatement !== null) {
					error(
						"Void method must not end with a return statement",
						XminiJavaPackage.eINSTANCE.method_Body,
						EXTRA_FINAL_RETURN
					)
				}
			}
		}
	}

	@Check def void checkNoDuplicateClasses(Program p) {
		checkNoDuplicateElements(p.classes, "class")
	}

	@Check def void checkNoDuplicateMembers(Class c) {
		checkNoDuplicateElements(c.fields, "field")
		checkNoDuplicateElements(c.methods.filter[it.name !== null], "method")
	}

	@Check def void checkNoDuplicateSymbols(Method m) {
		checkNoDuplicateElements(m.params, "parameter")
		checkNoDuplicateElements(m.body.getAllContentsOfType(VariableDeclaration), "variable")
	}

	@Check def void checkConformance(Expression exp) {
		val actualType = exp.typeFor
		val expectedType = exp.expectedType
		if (expectedType === null || actualType === null)
			return; // nothing to check
		if (!actualType.isConformant(expectedType)) {
			error("Incompatible types. Expected '" + expectedType.name + "' but was '" + actualType.name + "'", null,
				INCOMPATIBLE_TYPES);
		}
	}

	@Check def void checkMethodInvocationArguments(MethodCall sel) {
		val method = sel.method
		if (method.params.size != sel.args.size) {
			error("Invalid number of arguments: expected " + method.params.size + " but was " + sel.args.size,
				XminiJavaPackage.eINSTANCE.methodCall_Method, INVALID_ARGS)
		}
	}

	@Check def void checkConstructorAbstractClass(NewObject n) {
		if (n.type.abstract) {
			error("Cannot construct an instance of an abstract class.", XminiJavaPackage.eINSTANCE.newObject_Type,
				CONSTRUCTOR_ABSTRACT)
		}
	}

	@Check def void checkMethodOverride(Class c) {
		val hierarchyMethods = c.classHierarchyMethods

		for (m : c.methods) {
			val overridden = hierarchyMethods.get(m.name)
			if (overridden !== null && (!m.typeRef.type.isConformant(overridden.typeRef.type) || !m.params.map [
				typeRef
			].map[type].elementsEqual(overridden.params.map[typeRef].map[type]))) {
				error("The method '" + m.name + "' must override a superclass method", m,
					XminiJavaPackage.eINSTANCE.namedElement_Name, WRONG_METHOD_OVERRIDE)
			} else if (m.access < overridden.access) {
				error("Cannot reduce access from " + overridden.access + " to " + m.access, m,
					XminiJavaPackage.eINSTANCE.member_Access, REDUCED_ACCESSIBILITY)
			}
		}
	}

	static def boolean isAbstractOrInterface(TypeDeclaration t) {
		if (t instanceof Class) {
			return t.abstract
		} else if (t instanceof Interface) {
			return true
		}
		return false;
	}

	@Check
	def void checkMethodAbstract(Method method) {
		if (method.abstract && method.body !== null) {
			error('''The abstract method «method.name» cannot have a body.''', method,
				XminiJavaPackage.eINSTANCE.method_Body, ABSTRACT_METHOD_BODY)
		}

		if (method.abstract && !(method.eContainer as TypeDeclaration).isAbstractOrInterface) {
			error('''The abstract method «method.name» must be contained in an abstract class or in an interface.''',
				method, XminiJavaPackage.eINSTANCE.method_Abstract, ABSTRACT_METHOD_CLASS)
		}
	}

	@Check
	def void checkInterfaceMembers(Interface i) {
		if (i.members.exists[it instanceof Field]) {
			error("An interface cannot contain a field.", i, XminiJavaPackage.eINSTANCE.typeDeclaration_Members,
				INTERFACE_MEMBERS)
		}

	}

	@Check
	def void checkConstructor(Method constructor) {
		if (constructor.name === null) {
			val parentClass = (constructor.eContainer as Class)
			if ((constructor.typeRef as ClassRef).referencedClass !== parentClass) {
				error("A constructor must be in the same class as its name.", constructor,
					XminiJavaPackage.eINSTANCE.typedDeclaration_TypeRef, CONSTRUCTOR_CLASS)
			}
		}
	}

	@Check def void checkAccessibility(FieldAccess sel) {
		val field = sel.field
		if (field.name !== null && !field.isAccessibleFrom(sel))
			error(
				'''The «field.access» member «field.name» is not accessible here''',
				XminiJavaPackage.eINSTANCE.fieldAccess_Field,
				MEMBER_NOT_ACCESSIBLE
			)
	}

	@Check def void checkAccessibility(MethodCall sel) {
		val method = sel.method
		if (method.name !== null && !method.isAccessibleFrom(sel))
			error(
				'''The «method.access» member «method.name» is not accessible here''',
				XminiJavaPackage.eINSTANCE.methodCall_Method,
				MEMBER_NOT_ACCESSIBLE
			)
	}

	@Check def void checkAccessibility(NewObject n) {
		val constructor = n.type.members.filter(Method).findFirst [
			it.name === null && it.params.size === n.args.size
		]
		if (!constructor.isAccessibleFrom(n))
			error(
				'''This constructor is not accessible here.''',
				XminiJavaPackage.eINSTANCE.newObject_Type,
				MEMBER_NOT_ACCESSIBLE
			)
	}

// perform this check only on file save
	@Check(CheckType.NORMAL)
	def checkDuplicateClassesInFiles(Program p) {
		val externalClasses = p.getVisibleExternalClassesDescriptions
		for (c : p.classes) {
			val className = c.fullyQualifiedName
			if (externalClasses.containsKey(className)) {
				error("The type " + c.name + " is already defined", c, XminiJavaPackage.eINSTANCE.namedElement_Name,
					DUPLICATE_CLASS)
			}
		}
	}

	@Check
	def void checkSuper(Super s) {
		if (s.eContainingFeature != XminiJavaPackage.eINSTANCE.methodCall_Receiver &&
			s.eContainingFeature != XminiJavaPackage.eINSTANCE.fieldAccess_Receiver)
			error("'super' can be used only as member selection receiver", null, WRONG_SUPER_USAGE)
	}

	def private void checkNoDuplicateElements(Iterable<? extends NamedElement> elements, String desc) {
		val multiMap = HashMultimap.create()

		for (e : elements)
			multiMap.put(e.name, e)

		for (entry : multiMap.asMap.entrySet) {
			val duplicates = entry.value
			if (duplicates.size > 1) {
				for (d : duplicates)
					error("Duplicate " + desc + " '" + d.name + "'", d, XminiJavaPackage.eINSTANCE.namedElement_Name,
						DUPLICATE_ELEMENT)
			}
		}
	}
}
