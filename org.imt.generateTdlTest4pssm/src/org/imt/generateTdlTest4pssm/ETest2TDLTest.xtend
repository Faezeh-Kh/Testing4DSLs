package org.imt.generateTdlTest4pssm

import java.io.File
import java.io.IOException
import java.util.Collections
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.gemoc.executionframework.behavioralinterface.behavioralInterface.BehavioralInterface
import org.eclipse.gemoc.executionframework.event.model.event.EventOccurrence
import org.eclipse.gemoc.executionframework.event.model.event.EventPackage
import org.eclipse.gemoc.executionframework.event.testsuite.TestCase
import org.eclipse.gemoc.executionframework.event.testsuite.TestSuite
import org.eclipse.gemoc.executionframework.event.testsuite.TestsuitePackage
import org.eclipse.gemoc.executionframework.value.model.value.ValuePackage
import org.etsi.mts.tdl.Annotation
import org.etsi.mts.tdl.AnnotationType
import org.etsi.mts.tdl.BehaviourDescription
import org.etsi.mts.tdl.Block
import org.etsi.mts.tdl.ComponentInstance
import org.etsi.mts.tdl.ComponentInstanceRole
import org.etsi.mts.tdl.ComponentType
import org.etsi.mts.tdl.CompoundBehaviour
import org.etsi.mts.tdl.Connection
import org.etsi.mts.tdl.ElementImport
import org.etsi.mts.tdl.GateReference
import org.etsi.mts.tdl.Message
import org.etsi.mts.tdl.Package
import org.etsi.mts.tdl.TestConfiguration
import org.etsi.mts.tdl.TestDescription
import org.etsi.mts.tdl.tdlFactory
import org.etsi.mts.tdl.tdlPackage
import org.etsi.mts.tdl.util.tdlResourceFactoryImpl
import org.imt.pssm.model.statemachines.StateMachine
import org.imt.pssm.model.statemachines.StatemachinesPackage
import org.eclipse.emf.ecore.util.EcoreUtil
import java.lang.reflect.Proxy
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl
import java.util.Map
import java.util.HashMap
import org.eclipse.emf.ecore.xmi.XMIResource
import org.imt.pssm.model.statemachines.CustomSystem

class ETest2TDLTest {
	
	private static var pluginName = "/org.imt.generateTdlTest4pssm"
	
	static tdlFactory TDL_FACTORY = tdlFactory.eINSTANCE
	private var Package commonPackage
	private var Package pssmTypesPackage
	private var Package pssmEventsPackage
	private var Package testConfigurationPackage 
	private var Package tdlTestSutiePackage 
	
	def void transformTestSuite() {
		//load the existing TDL packages (generated previously)
		loadTdlPackages
		//perform the transformation
		generateTDLTestSuitePackage
		PSSMTestSuite.testCases.forEach[c|tdlTestSutiePackage.packagedElement.add(testCase2testDescription(c))]

		savePackages
	}
	
	def void loadTdlPackages(){
		val rs = new ResourceSetImpl
//		val p = tdlPackage.eINSTANCE
//		rs.getPackageRegistry().put(p.getNsURI(), p)
//		rs.resourceFactoryRegistry.extensionToFactoryMap.put("tdlan2", new tdlResourceFactoryImpl)

		var File tdlFile = new File(getTDLPackageURI("common").toString);
		var Resource res = rs.getResource(getTDLPackageURI("common"), true)
		commonPackage = res.contents.get(0) as Package
		
		tdlFile = new File(getTDLPackageURI("pssmSpecificTypes").toString);
		res = rs.getResource(getTDLPackageURI("pssmSpecificTypes"), true)
		pssmTypesPackage = res.contents.get(0) as Package
		
		tdlFile = new File(getTDLPackageURI("pssmSpecificEvents").toString);
		res = rs.getResource(getTDLPackageURI("pssmSpecificEvents"), true)
		pssmEventsPackage = res.contents.get(0) as Package
		
		tdlFile = new File(getTDLPackageURI("testConfiguration").toString);
		res = rs.getResource(getTDLPackageURI("testConfiguration"), true)
		testConfigurationPackage = res.contents.get(0) as Package
	}
	
	def void generateTDLTestSuitePackage(){
		tdlTestSutiePackage = TDL_FACTORY.createPackage	
		tdlTestSutiePackage.name = "PSSMTestSuite"
		//generate imports
		var ElementImport commonPackageImport = TDL_FACTORY.createElementImport();
		commonPackageImport.setImportedPackage(commonPackage);
		var ElementImport dslSpecificTypesPackageImport = TDL_FACTORY.createElementImport();
		dslSpecificTypesPackageImport.setImportedPackage(pssmTypesPackage);
		var ElementImport dslSpecificEventsPackageImport = TDL_FACTORY.createElementImport();
		dslSpecificEventsPackageImport.setImportedPackage(pssmEventsPackage);
		var ElementImport testConfigurationImport = TDL_FACTORY.createElementImport();
		testConfigurationImport.setImportedPackage(testConfigurationPackage);
		tdlTestSutiePackage.getImport().add(commonPackageImport);
		tdlTestSutiePackage.getImport().add(dslSpecificTypesPackageImport);
		tdlTestSutiePackage.getImport().add(dslSpecificEventsPackageImport);
		tdlTestSutiePackage.getImport().add(testConfigurationImport);
	}
	
	def TestDescription testCase2testDescription (TestCase testcase){
		//generate a specific test configuration for each test case (for each PSSM model)
		val CustomSystem system = loadPSSMModel(testcase.model)
		val TestConfiguration configuration = generateTestConfiguration(system.statemachine)
		
		//generate a tdl test case for each PSSM test case (for each PSSM model)
		val TestDescription tdlTestCase = TDL_FACTORY.createTestDescription
		tdlTestCase.name = testcase.name
		tdlTestCase.testConfiguration = configuration
		
		val BehaviourDescription bd = TDL_FACTORY.createBehaviourDescription
		tdlTestCase.behaviourDescription = bd
		
		val CompoundBehaviour cb = TDL_FACTORY.createCompoundBehaviour
		bd.behaviour = cb
		
		val Block block = TDL_FACTORY.createBlock
		cb.block = block
		
		testcase.scenario.forEach[s | block.behaviour.add(eventOccurance2message(s))]
		
		return null
	}

	def TestConfiguration generateTestConfiguration(StateMachine stateMachine){
		//generate one test configuration per statemachine
		var TestConfiguration dslSpecificConfiguration = TDL_FACTORY.createTestConfiguration();
		dslSpecificConfiguration.setName("configuration4" + stateMachine.name);
		//generate one component instance as TESTER
		
//		var ComponentType testComponent = null
//		var ComponentType mutComponent = null
//		var AnnotationType mutPathAnnotationType = null
//		var AnnotationType dslNameAnnotationType = null
//		for (i:0..<testConfigurationPackage.packagedElement.size){
//			val e = testConfigurationPackage.packagedElement.get(i)
//			if (e instanceof ComponentType && e.name.equals("TestSystem")){
//				testComponent = e as ComponentType
//			}else if (e instanceof ComponentType && e.name.equals("MUT")){
//				mutComponent = e as ComponentType
//			}else if (e instanceof AnnotationType && e.name.equals("MUTPath")){
//				mutPathAnnotationType = e as AnnotationType
//			}else if (e instanceof AnnotationType && e.name.equals("DSLName")){
//				dslNameAnnotationType = e as AnnotationType
//			}
//		}
		
		var ComponentInstance testerInstance = TDL_FACTORY.createComponentInstance();
		testerInstance.setName("tester");
		testerInstance.setRole(ComponentInstanceRole.TESTER);
		val testComponent = testConfigurationPackage.packagedElement.findFirst[
			e | e instanceof ComponentType && e.name.equals("TestSystem")
		] as ComponentType
		testerInstance.setType(testComponent);
		dslSpecificConfiguration.getComponentInstance().add(testerInstance);
		
		//generate one component instance for Model-Under Test (MUT) as SUT
		//that has annotations for MUTPath and DSLName
		var ComponentInstance mutInstance = TDL_FACTORY.createComponentInstance();
		mutInstance.setName("PSSM");
		mutInstance.setRole(ComponentInstanceRole.SUT);
		val mutComponent = testConfigurationPackage.packagedElement.findFirst[
			e | e instanceof ComponentType && e.name.equals("MUT")
		] as ComponentType
		mutInstance.setType(mutComponent);
		
		var Annotation mutPathAnnotation = TDL_FACTORY.createAnnotation();
		mutPathAnnotation.setAnnotatedElement(mutInstance);
		val mutPathAnnotationType = testConfigurationPackage.packagedElement.findFirst[
			e | e instanceof AnnotationType && e.name.equals("MUTPath")
		] as AnnotationType
		mutPathAnnotation.setKey(mutPathAnnotationType);
		mutPathAnnotation.setValue("\'" + stateMachine.name.stateMachineURI.toString + "\'");
		mutInstance.getAnnotation().add(mutPathAnnotation);
		
		var Annotation dslNameAnnotation = TDL_FACTORY.createAnnotation();
		dslNameAnnotation.setAnnotatedElement(mutInstance);
		val dslNameAnnotationType = testConfigurationPackage.packagedElement.findFirst[
			e | e instanceof AnnotationType && e.name.equals("DSLName")
		] as AnnotationType
		dslNameAnnotation.setKey(dslNameAnnotationType);
		dslNameAnnotation.setValue("\'org.imt.pssm.InterpretedStatemachines'");
		mutInstance.getAnnotation().add(dslNameAnnotation);
		dslSpecificConfiguration.getComponentInstance().add(mutInstance);
		
		//generate connection between the gates
		var Connection gateConnection = TDL_FACTORY.createConnection();
		var GateReference referenceToTestGate = TDL_FACTORY.createGateReference();
		referenceToTestGate.setComponent(testerInstance);
		referenceToTestGate.setGate(testComponent.allGates.findFirst[g | g.name.equals("dslSpecificTestGate")]);
		var GateReference referenceToMUTGate = TDL_FACTORY.createGateReference();
		referenceToMUTGate.setComponent(mutInstance);
		referenceToMUTGate.setGate(testComponent.allGates.findFirst[g | g.name.equals("dslSpecificMUTGate")]);
		
		gateConnection.getEndPoint().add(referenceToTestGate);
		gateConnection.getEndPoint().add(referenceToMUTGate);
		dslSpecificConfiguration.getConnection().add(gateConnection);
		
		testConfigurationPackage.getPackagedElement().add(dslSpecificConfiguration)
		return dslSpecificConfiguration
	}
	
	def Message eventOccurance2message (EventOccurrence scenario){
		val rs = new ResourceSetImpl
		val bi = loadBehavioralInterface(behavioralInterfaceURI, rs)
		return null
	}
	
	def static URI getBehavioralInterfaceURI() {
		//URI::createFileURI(plugin.getFile("InterpretedStateMachines.bi").locationURI.path)
		URI::createFileURI( pluginName + "/InterpretedStateMachines.bi")
	}
	def static URI getPSSMTestSuiteURI() {
		//URI::createFileURI(plugin.getFolder("models").getFile("StateMachineTestSuite.xmi").locationURI.path)
		URI::createFileURI( pluginName + "/models/StateMachineTestSuite.xmi")
	}
	def static URI getStateMachineURI(String stateMachineName) {
		URI::createFileURI( pluginName + "/models/" + stateMachineName + ".xmi")
	}
	def static URI getTDLPackageURI(String packageName) {
		URI::createFileURI( pluginName + "/generatedTDLPackages/" + packageName + ".tdlan2")
	}
	def static BehavioralInterface loadBehavioralInterface(URI uri, ResourceSet resourceSet) {
		val Resource res = resourceSet.getResource(uri, true)
		try {
			res.load(Collections.emptyMap())
		} catch (IOException e) {
			e.printStackTrace()
		}
		return (res.getContents().get(0)) as BehavioralInterface
	}
	
	def TestSuite getPSSMTestSuite() {
		val rs = new ResourceSetImpl
		val p1 = TestsuitePackage.eINSTANCE
		val p2 = EventPackage.eINSTANCE
		val p3 = StatemachinesPackage.eINSTANCE
		val p4 = ValuePackage.eINSTANCE
		rs.getPackageRegistry().put(p1.getNsURI(), p1);
		rs.getPackageRegistry().put(p2.getNsURI(), p2);
		rs.getPackageRegistry().put(p3.getNsURI(), p3);
		rs.getPackageRegistry().put(p4.getNsURI(), p4);
		rs.resourceFactoryRegistry.extensionToFactoryMap.put("xmi", new XMIResourceFactoryImpl)
		
		val File pssmTestSuiteFile = new File(PSSMTestSuiteURI.toString);
		val res = rs.getResource(PSSMTestSuiteURI, true)
		return res.contents.get(0) as TestSuite
	}
	
	def CustomSystem loadPSSMModel(EObject pssmModel) {
		val rs = new ResourceSetImpl
		val p = StatemachinesPackage.eINSTANCE
		rs.getPackageRegistry().put(p.getNsURI(), p);
		rs.resourceFactoryRegistry.extensionToFactoryMap.put("xmi", new XMIResourceFactoryImpl)
		
		val proxyURI = EcoreUtil.getURI(pssmModel).toString
		val pssmName = proxyURI.substring(0, proxyURI.lastIndexOf(".xmi"))
		val Resource resource = rs.createResource(getStateMachineURI(pssmName))
		resource.load(null)
		
		return resource.getContents().get(0) as CustomSystem
	}
	
	def void savePackages(){
		val rs = new ResourceSetImpl
		val Resource commonRes = rs.createResource(getTDLPackageURI("common"));
		val Resource pssmTypesRes = rs.createResource(getTDLPackageURI("pssmSpecificTypes"));
		val Resource pssmEventsRes = rs.createResource(getTDLPackageURI("pssmSpecificEvents"));
		val Resource configurationRes = rs.createResource(getTDLPackageURI("testConfiguration"));
		val Resource testSuiteRes = rs.createResource(getTDLPackageURI("TDLTestSuite4PSSM"));

		commonRes.getContents().add(commonPackage);
		pssmTypesRes.getContents().add(pssmTypesPackage);
		pssmEventsRes.getContents().add(pssmEventsPackage);
		configurationRes.getContents().add(testConfigurationPackage);
		testSuiteRes.getContents().add(tdlTestSutiePackage);
		
		commonRes.save(null);
		pssmTypesRes.save(null);
		pssmEventsRes.save(null);
		configurationRes.save(null);
		testSuiteRes.save(null);
		
		commonRes.unload();
		pssmTypesRes.unload();
		pssmEventsRes.unload();
		configurationRes.unload();
		testSuiteRes.unload();
	}
}