package org.imt.k3tdl.k3dsa

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.Step

import org.etsi.mts.tdl.ComponentType
import org.etsi.mts.tdl.GateType
import org.etsi.mts.tdl.GateReference					
import org.etsi.mts.tdl.GateInstance
import org.etsi.mts.tdl.ComponentInstance
import org.etsi.mts.tdl.Connection
import org.etsi.mts.tdl.DataUse
import java.util.List
import java.util.ArrayList
import org.imt.ale.customLaunchConfig.CustomLauncher
import static extension org.imt.k3tdl.k3dsa.GateInstanceAspect.*
import org.eclipse.core.runtime.CoreException
import org.eclipse.gemoc.executionframework.engine.commons.EngineContextException
import org.etsi.mts.tdl.DataInstanceUse
import org.etsi.mts.tdl.LiteralValueUse

@Aspect (className = GateType)
class GateTypeAspect{
	@Step
	def void defineGateType(){
		
	}
}
@Aspect (className = GateInstance)
class GateInstanceAspect{
	public List<DataUse> testerIncomingData = new ArrayList<DataUse>
	public List<DataUse> sutIncomingData = new ArrayList<DataUse>
	CustomLauncher launcher;
	@Step
	//setting up the related launcher based on the gate type 
	def void configureLauncher(String MUTPath){
		println("Start configuring the MUT launcher")
		_self.launcher = new CustomLauncher();
		if (_self.name.equals('genericMUTGate')){
			println("Start configuring ALE Engine launcher")
			_self.launcher.setUp(CustomLauncher.GENERIC, MUTPath);
		}else if (_self.name.equals('dslSpecificMUTGate')){
			println("Start configuring the Event manager launcher")
			_self.launcher.setUp(CustomLauncher.DSL_SPECIFIC, MUTPath);
		}else if (_self.name.equals('oclMUTGate')){
			println("Start configuring the OCL Interpreter launcher")
			_self.launcher.setUp(CustomLauncher.OCL, MUTPath);
		}
		println("Configuration of the MUT launcher finished successfully")
	}
	
	@Step
	def void tester_receive(DataUse argument){
		println("The tester component received data")
		_self.testerIncomingData.add(argument)
	}
	@Step
	def void sut_receive(DataUse argument){
		println("The MUT component received data")
		_self.sutIncomingData.add(argument)
		if (argument instanceof DataInstanceUse){
			println("Start sending the argument to the corresponding ENGINE")
			if ((argument as DataInstanceUse).dataInstance.name == 'runMUT'){
				println("Sending the argument to the ALE engine")
				_self.launcher.executeGenericCommand();
			}else if ((argument as DataInstanceUse).dataInstance.name == 'setModelState'){
				//TODO: Set the model state
			}else if ((argument as DataInstanceUse).dataInstance.name == 'getModelState'){
				//TODO: Get the model state
			}
			//if the message is an OCL query
			else if ((argument as DataInstanceUse).dataInstance.dataType.name == 'OCL'){
				println("Sending the argument to the OCL engine")
				//TODO: extracting the query from the argument and sending to the OCL interpreter
				var query = argument.argument.get(0).dataUse as LiteralValueUse;
				var queryResult = _self.launcher.executeOCLCommand(query.value);
			}//otherwise the message is an event conforming to the behavioral interface of the DSL
			else{
				println("Sending the argument to the Event Manager")
				//TODO: Sending the related argument
				_self.launcher.executeDSLSpecificCommand("");
			}
			println("Sending the argument done!")
		}
	}
}
@Aspect (className = ComponentType)
class ComponentTypeAspect{
	@Step
	def void defineComponentType(){
		
	}
}
@Aspect (className = ComponentInstance)
class ComponentInstanceAspect{

}
@Aspect (className = GateReference)
class GateReferenceAspect{
	@Step
	def void referenceToGate(){
		
	}
}
@Aspect (className = Connection)
class ConnectionAspect{
}