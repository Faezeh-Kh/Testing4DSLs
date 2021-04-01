package org.imt.k3tdl.k3dsa

import fr.inria.diverse.k3.al.annotationprocessor.Aspect

import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod
import fr.inria.diverse.k3.al.annotationprocessor.Step
import java.util.ArrayList
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.gemoc.dsl.Dsl
import org.eclipse.gemoc.executionframework.behavioralinterface.behavioralInterface.BehavioralInterface
import org.etsi.mts.tdl.DataInstance
import org.etsi.mts.tdl.DataInstanceUse
import org.etsi.mts.tdl.DataType
import org.etsi.mts.tdl.DataUse
import org.etsi.mts.tdl.LiteralValueUse
import org.etsi.mts.tdl.Member
import org.etsi.mts.tdl.MemberAssignment
import org.etsi.mts.tdl.ParameterBinding
import org.etsi.mts.tdl.SimpleDataInstance
import org.etsi.mts.tdl.SpecialValueUse
import org.etsi.mts.tdl.StaticDataUse
import org.etsi.mts.tdl.StructuredDataInstance
import org.etsi.mts.tdl.StructuredDataType

import static extension org.imt.k3tdl.k3dsa.DataInstanceAspect.*
import static extension org.imt.k3tdl.k3dsa.DataTypeAspect.*
import static extension org.imt.k3tdl.k3dsa.DataUseAspect.*
import static extension org.imt.k3tdl.k3dsa.MemberAspect.*
import static extension org.imt.k3tdl.k3dsa.MemberAssignmentAspect.*
import static extension org.imt.k3tdl.k3dsa.ParameterBindingAspect.*
import static extension org.imt.k3tdl.k3dsa.StaticDataUseAspect.*
import static extension org.imt.k3tdl.k3dsa.StructuredDataInstanceAspect.*

@Aspect (className = DataType)
class DataTypeAspect{
	def boolean isDynamicType() {
		if (_self instanceof StructuredDataType){
			val StructuredDataType type = _self as StructuredDataType
			//check if the type has a 'dynamic' annotation itself
			for (i : 0 ..<type.annotation.size){
				if (type.annotation.get(i).key.name.toString.contains("dynamic")) {
					return true;
				}
			}
			//check if as least one of the members of type has a 'dynamic' annotation
			for (i : 0 ..<type.member.size){
				val Member m = type.member.get(i)
				for (j : 0 ..<m.annotation.size){
					if (m.annotation.get(j).key.name.toString.contains("dynamic")) {
						return true;
					}
				}
			}
		}
		return false;
	}
	def boolean isConcreteEcoreType(String DSLPath) {
		var dslRes = (new ResourceSetImpl()).getResource(URI.createURI(DSLPath), true);
		var dsl = dslRes.getContents().get(0) as Dsl;
		if (dsl.getEntry("ecore") != null) {
			var metamodelPath = dsl.getEntry("ecore").getValue().replaceFirst("resource", "plugin");
			var metamodelRes = (new ResourceSetImpl()).getResource(URI.createURI(metamodelPath), true);
			var metamodelRootElement = metamodelRes.getContents().get(0) as EPackage;
			return metamodelRootElement.EClassifiers.exists[c | c.name.equals(_self.getValidName) && !c.eClass.abstract]
		}
		return false;
	}
	def boolean isAcceptedEvent(String DSLPath) {
		var dslRes = (new ResourceSetImpl()).getResource(URI.createURI(DSLPath), true);
		var dsl = dslRes.getContents().get(0) as Dsl;
		if (dsl.getEntry("behavioralInterface") != null) {
			var interfacePath = dsl.getEntry("behavioralInterface").getValue().replaceFirst("resource", "plugin");
			var interfaceRes = (new ResourceSetImpl()).getResource(URI.createURI(interfacePath), true);
			var BehavioralInterface interfaceRootElement= interfaceRes.getContents().get(0) as BehavioralInterface;
			return interfaceRootElement.events.exists[e | e.name.equals(_self.getValidName) && e.type.getName() != "EXPOSED"]
		}
		return false;
	}
	def boolean isExposedEvent(String DSLPath) {
		var dslRes = (new ResourceSetImpl()).getResource(URI.createURI(DSLPath), true);
		var dsl = dslRes.getContents().get(0) as Dsl;
		if (dsl.getEntry("behavioralInterface") != null) {
			var interfacePath = dsl.getEntry("behavioralInterface").getValue().replaceFirst("resource", "plugin");
			var interfaceRes = (new ResourceSetImpl()).getResource(URI.createURI(interfacePath), true);
			var BehavioralInterface interfaceRootElement= interfaceRes.getContents().get(0) as BehavioralInterface;
			return interfaceRootElement.events.exists[e | e.name.equals(_self.getValidName) && e.type.getName() != "ACCEPTED"]
		}
		return false;
	}
	def String getValidName(){
		var tdlName = _self.name
		if (_self.name.startsWith("_")){
			return tdlName.substring(1)
		}
		return tdlName
	}
}
@Aspect (className = DataInstance)
class DataInstanceAspect{
	public String info = null
	def EObject getMatchedMUTElement(ArrayList<EObject> rootElement, Resource MUTResource, boolean isAssertion, String DSLPath){
		
	}
}
@Aspect (className = SimpleDataInstance)
class SimpleDataInstanceAspect extends DataInstanceAspect{
	@OverrideAspectMethod
	def EObject getMatchedMUTElement(ArrayList<EObject> rootElement, Resource MUTResource, boolean isAssertion, String DSLPath){
		println("The " + _self.name + " element cannot be found since it has no identifier")
		_self.info = "FAIL: The " + _self.name + " element cannot be found since it has no identifier"
		return null;
	}
}
@Aspect (className = StructuredDataInstance)
class StructuredDataInstanceAspect extends DataInstanceAspect{
	@OverrideAspectMethod
	def EObject getMatchedMUTElement(ArrayList<EObject> rootElement, Resource MUTResource, boolean isAssertion, String DSLPath){
		var EObject matchedElement = null
		//find matched elements based on the memberAssignments of dataInstance
		for (i:0 ..<rootElement.size){
			matchedElement = rootElement.get(i)
			var boolean elementFound = true;
			for (j : 0 ..<_self.memberAssignment.size){
				if (isAssertion){//all the arguments (static and dynamic) have to be matched
					_self.info = _self.memberAssignment.get(j).isMatchedMember(matchedElement, MUTResource, DSLPath)
					if(_self.info.contains("FAIL")){
						elementFound = false
					}
				}else{//only static arguments have to be matched
					if (!_self.memberAssignment.get(j).member.dataType.isDynamicType
						&& !_self.memberAssignment.get(j).member.isDynamicMember){
						_self.info = _self.memberAssignment.get(j).isMatchedMember(matchedElement, MUTResource, DSLPath)
						if(_self.info.contains("FAIL")){
							elementFound = false
						}
					}
				}
			}
			//all the members are matched with the attributes of the rootElement.get(i)
			if(elementFound){
				return matchedElement
			}
		}
		return null
	}
	def String setMatchedMUTElement(EObject matchedObject, Resource MUTResource, String DSLPath){
		var String status = ""
		for (i : 0 ..<_self.memberAssignment.size){
			var memberAssig = _self.memberAssignment.get(i)
			if (memberAssig.member.dataType.isDynamicType
				|| memberAssig.member.isDynamicMember){
					status = memberAssig.setMatchedMember(matchedObject, MUTResource, DSLPath)
			}
			if (status.contains("FAIL")){
				return status
			}
		}
		return status
	}
}
@Aspect (className = DataInstanceUse)
class DataInstanceUseAspect extends StaticDataUseAspect{
	def EObject getMatchedMUTElement(Resource MUTResource, boolean isAssertion, String DSLPath){
		var ArrayList<EObject> rootElement = new ArrayList
		//if data type is abstract return null
		if (!_self.dataInstance.dataType.isConcreteEcoreType(DSLPath)){
			println("The " + _self.dataInstance.name + " element is abstract")
			_self.dataInstance.info = "FAIL: The " + _self.dataInstance.name + " element is abstract"
			return null;
		}
		val dataTypeName = _self.dataInstance.dataType.validName
		rootElement.add(MUTResource.getContents().get(0))
		if (!rootElement.get(0).eClass.name.equals(dataTypeName)){
			var container = rootElement.get(0)
			rootElement.remove(0)
			for (EObject object: container.eContents){				
				if (object.eClass.name.equals(dataTypeName)){
					rootElement.add(object)
				}
			}
		}
		var EObject matchedElement = null
		if (_self.dataInstance instanceof StructuredDataInstance){
			//some attributes are set as member assignments for dataInstance
			//so find the matched element based on the dataInstance
			val dataIns = _self.dataInstance as StructuredDataInstance
			if (dataIns.memberAssignment.size>0){//if some values are assigned to the members of data instance
				matchedElement = dataIns.getMatchedMUTElement(rootElement, MUTResource, isAssertion, DSLPath)
				if (matchedElement == null){
					_self.dataInstance.info = "FAIL: There is no MUT element matched with " + dataIns.name
					return null
				}else{
					_self.dataInstance.info = _self.isMatchedParametrizedElement(matchedElement, MUTResource, isAssertion, DSLPath)
					if (_self.dataInstance.info.contains("PASS")){
						return matchedElement
					}
					return null
				}
			}	
		}
		//when the program reach to this line, it means all the values are assigned as parameter bindings (so no member assignment)
		//therefore, all the elements identified as root must be checked to find the matched element
		//find matched elements based on the parameter bindings of dataInstanceUse
		for (i:0 ..<rootElement.size){
			matchedElement = rootElement.get(i)
			_self.dataInstance.info = _self.isMatchedParametrizedElement(matchedElement, MUTResource, isAssertion, DSLPath)
			if (_self.dataInstance.info.contains("PASS")){
				return matchedElement
			}
		}
		return null
	}
	def String isMatchedParametrizedElement(EObject rootElement, Resource MUTResource, boolean isAssertion, String DSLPath){
		var EObject matchedElement = null
		//find matched element based on the parameter bindings of dataInstance
		for (i : 0 ..<_self.argument.size){
			val parameterBinding = _self.argument.get(i);
			if (isAssertion){//all the arguments (static and dynamic) have to be matched
				val status = parameterBinding.isMatchedParameter(rootElement, MUTResource, DSLPath)
				if (status.contains("FAIL")){
					return status;
				}
			}else{//only static arguments have to be matched
				if (!parameterBinding.parameter.dataType.isDynamicType
					&& !(parameterBinding.parameter as Member).isDynamicMember){
					val status = parameterBinding.isMatchedParameter(rootElement, MUTResource, DSLPath)
					if (status.contains("FAIL")){
						return status;
					}
				}
			}			
		}
		return "PASS";
	}
	@Step
	def String setMatchedMUTElement(Resource MUTResource, String DSLPath){
		//the second parameter is isAssertion that has to be set as false
		//so only static elements will be matched to then set the values of its dynamic features
		var EObject matchedObject = _self.getMatchedMUTElement(MUTResource, false, DSLPath)
		if (matchedObject == null){
			println("There is no matched object in the model under test")
			return "FAIL: There is no MUT element matched with " + _self.dataInstance.name
		}
		var String status = "";
		if (_self.dataInstance instanceof StructuredDataInstance){			
			//some attributes are set as member assignments for dataInstance
			//so find the matched element based on the dataInstance
			val dataIns = _self.dataInstance as StructuredDataInstance
			status = dataIns.setMatchedMUTElement(matchedObject, MUTResource, DSLPath)
			if (status.contains("FAIL")){
				return status
			}
		}
		//find matched elements based on the parameter bindings of dataInstanceUse
		for (i : 0 ..<_self.argument.size){
			var parameterBinding = _self.argument.get(i);
			if (parameterBinding.parameter.dataType.isDynamicType
				|| (parameterBinding.parameter as Member).isDynamicMember){
				status = parameterBinding.setMatchedParameter(matchedObject, MUTResource, DSLPath);
			}
			if (status.contains("FAIL")){
				return status
			}			
		}
		return status;
	}
	@OverrideAspectMethod
	def String assertEquals(Resource MUTResource, Object featureValue, String DSLPath){
		val ArrayList<EObject> matchedObjects = new ArrayList
		if (_self.item != null && _self.item.size > 0){//there are several intances of data
			for (i : 0 ..<_self.item.size){
				val matchedObject = (_self.item.get(i) as DataInstanceUse).getMatchedMUTElement(MUTResource , true, DSLPath)			
				val propertyName = (_self.item.get(i) as DataInstanceUse).dataInstance.name
				if (matchedObject == null){
					println("There is no " + propertyName + " property in the MUT")
					return "FAIL: There is no MUT element matched with " + propertyName
				}
				matchedObjects.add(matchedObject)
			}
			if ((featureValue as EList).equals(matchedObjects)){
				return "PASS: The expected data is equal to the MUT data"
			}
			return "FAIL: The expected data is: " + (featureValue as EList).toString + 
				" , but the MUT data is: " + matchedObjects.toString;
		}else{//there is just one data instance
			val matchedObject = _self.getMatchedMUTElement(MUTResource , true, DSLPath)
			if (matchedObject == null){
				println("There is no " + _self.dataInstance.name + " property in the MUT")
				return "FAIL: There is no MUT element matched with " + _self.dataInstance.name
			}else if (matchedObject.equals(featureValue)){
				return "PASS: The expected data is equal to the MUT data"
			}
			return "FAIL: The expected data is: " + featureValue.toString + 
				" , but the MUT data is: " + matchedObject.toString;
		}
	}
	@OverrideAspectMethod
	@Step
	def String updateData(Resource MUTResource, EObject object, EStructuralFeature matchedFeature, String DSLPath){
		val ArrayList<EObject> matchedObjects = new ArrayList
		if (_self.item != null && _self.item.size > 0){//there are several intances of data
			for (i : 0 ..<_self.item.size){
				val matchedObject = (_self.item.get(i) as DataInstanceUse).getMatchedMUTElement(MUTResource , true, DSLPath)			
				val propertyName = (_self.item.get(i) as DataInstanceUse).dataInstance.name
				if (matchedObject == null){
					println("There is no " + propertyName + " property in the MUT")
					return "FAIL: There is no MUT element matched with " + propertyName
				}
				matchedObjects.add(matchedObject)
			}
			try{
				object.eSet(matchedFeature, matchedObjects)
			}catch(IllegalArgumentException e){
				println("New value cannot be set for the " + matchedFeature.name + " property of the MUT")
				return "FAIL: New value cannot be set for the " + matchedFeature.name + " property of the MUT"
			}
		}else{//there is just one data instance
			val matchedObject = _self.getMatchedMUTElement(MUTResource, true, DSLPath)
			if (matchedObject == null){
				println("There is no " + _self.dataInstance.name + " property in the MUT")
					return "FAIL: There is no MUT element matched with " + _self.dataInstance.name
			}
			try{
				object.eSet(matchedFeature, matchedObject)
			}catch(IllegalArgumentException e){
				println("New value cannot be set for the " + matchedFeature.name + " property of the MUT")
				return "FAIL: New value cannot be set for the " + matchedFeature.name + " property of the MUT"
			}
		}
		return "PASS: New value is set for the " + matchedFeature.name + " property of the MUT"
	}
}
@Aspect (className = MemberAssignment)
class MemberAssignmentAspect{
	def String isMatchedMember(EObject rootElement, Resource MUTResource, String DSLPath){
		val EStructuralFeature matchedFeature = _self.member.getMatchedFeature(rootElement)	
		if (matchedFeature == null){
			println("There is no " + _self.member.name + " property in the MUT")
			return "FAIL: There is no MUT element matched with " + _self.member.name
		}
		val featureValue = rootElement.eGet(matchedFeature)
		//Assert the data instances of the member assignment
		if (_self.memberSpec instanceof DataInstanceUse){
			return _self.memberSpec.assertEquals(MUTResource, featureValue, DSLPath)
		}
		return _self.memberSpec.assertEquals(featureValue)
	} 
	def String setMatchedMember(EObject rootElement, Resource MUTResource, String DSLPath){
		val validDataType = _self.member.dataType.validName
		val EStructuralFeature matchedFeature = _self.member.getMatchedFeature(rootElement)	
		if (_self.memberSpec instanceof DataInstanceUse){
			return _self.memberSpec.updateData(MUTResource, rootElement, matchedFeature, DSLPath)
		}
		return _self.memberSpec.updateData(rootElement, matchedFeature)
	} 
}
@Aspect (className = ParameterBinding)
class ParameterBindingAspect{
	def String isMatchedParameter(EObject rootElement, Resource MUTResource, String DSLPath){
		val EStructuralFeature matchedFeature = (_self.parameter as Member).getMatchedFeature(rootElement) 
		if (matchedFeature == null){
			println("There is no " + _self.parameter.name + " property in the MUT")
			return "FAIL: There is no MUT element matched with " + _self.parameter.name
		}
		val featureValue = rootElement.eGet(matchedFeature)
		if (_self.dataUse instanceof DataInstanceUse){
			return _self.dataUse.assertEquals(MUTResource, featureValue, DSLPath)
		}
		return _self.dataUse.assertEquals(featureValue)
	} 
	def String setMatchedParameter(EObject rootElement, Resource MUTResource, String DSLPath){
		val EStructuralFeature matchedFeature = (_self.parameter as Member).getMatchedFeature(rootElement)
		if (_self.dataUse instanceof DataInstanceUse){
			return _self.dataUse.updateData(MUTResource, rootElement, matchedFeature, DSLPath)
		}
		return _self.dataUse.updateData(rootElement, matchedFeature)
	} 
}
@Aspect (className = Member)
class MemberAspect{
	def EStructuralFeature getMatchedFeature(EObject rootElement){
		val EStructuralFeature matchedFeature = rootElement.eClass.EAllStructuralFeatures.
				findFirst[f | f.name.equals(_self.validName)]
		return matchedFeature	
	}
	def String getValidName(){
		var tdlName = _self.name
		if (_self.name.startsWith("_")){
			return tdlName.substring(1)
		}
		return tdlName
	}
	def boolean isDynamicMember() {
		for (j : 0 ..<_self.annotation.size){
			if (_self.annotation.get(j).key.name.toString.contains("dynamic")) {
				return true
			}
		}
		return false
	}
}
@Aspect (className = DataUse)
class DataUseAspect{
	def String assertEquals(Object featureValue){
		return "";
	}
	def String assertEquals(Resource MUTResource, Object featureValue, String DSLPath){
		return "";
	}
	def String updateData(EObject object, EStructuralFeature matchedFeature){
		return "";
	}
	def String updateData(Resource MUTResource, EObject object, EStructuralFeature matchedFeature, String DSLPath){
		return "";
	}
}
@Aspect (className = StaticDataUse)
class StaticDataUseAspect extends DataUseAspect{
	@OverrideAspectMethod
	def String assertEquals(Object featureValue){
		return "";
	}
	@OverrideAspectMethod
	def String assertEquals(Resource MUTResource, Object featureValue, String DSLPath){
		return "";
	}
	@OverrideAspectMethod
	def String updateData(EObject object, EStructuralFeature matchedFeature){
		return "";
	}
	@OverrideAspectMethod
	def String updateData(Resource MUTResource, EObject object, EStructuralFeature matchedFeature, String DSLPath){
		return "";
	}
}
@Aspect (className = LiteralValueUse)
class LiteralValueUseAspect extends StaticDataUseAspect{
	@OverrideAspectMethod
	def String assertEquals(Object featureValue){
		var String parameterValue = _self.value
		parameterValue = parameterValue.substring(1, parameterValue.length-1)//remove quotation marks
		if (featureValue.toString.equals(parameterValue)){
			return "PASS: The expected data is equal to the MUT data"
		}
		return "FAIL: The expected data is: " + parameterValue + ", but the MUT data is: " + featureValue
	}
	@OverrideAspectMethod
	def String updateData(EObject object, EStructuralFeature matchedFeature){
		var String parameterValue = _self.value
		parameterValue = parameterValue.substring(1, parameterValue.length-1)//remove quotation marks
		try{
			object.eSet(matchedFeature, parameterValue)
		}catch(IllegalArgumentException e){
			println("FAIL: The new value cannot be set for the " + matchedFeature.name + " property of the MUT")
			return "FAIL: The new value cannot be set for the " + matchedFeature.name + " property of the MUT"
		}
		return "PASS: New value is set for the " + matchedFeature.name + " property of the MUT"
	}
}
@Aspect (className = SpecialValueUse)
class SpecialValueUseAspect extends StaticDataUseAspect{
	@OverrideAspectMethod
	def String assertEquals(Object featureValue){
		//the value is ('?' or '*' or 'omit') that should be ignored
		return "PASS";
	}
	@OverrideAspectMethod
	def String updateData(EObject object, EStructuralFeature matchedFeature){
		//the value is ('?' or '*' or 'omit') that should be ignored
		return "PASS";
	}
}