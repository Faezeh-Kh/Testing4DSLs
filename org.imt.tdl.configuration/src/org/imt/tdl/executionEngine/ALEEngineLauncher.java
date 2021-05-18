package org.imt.tdl.executionEngine;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.parser.ParsedFile;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.eclipse.gemoc.ale.interpreted.engine.AleEngine;
import org.eclipse.gemoc.ale.interpreted.engine.Helper;
import org.eclipse.gemoc.ale.interpreted.engine.sirius.ALESiriusInterpreter;
import org.eclipse.gemoc.ale.interpreted.engine.sirius.ALESiriusInterpreterProviderAddon;
import org.eclipse.gemoc.dsl.Dsl;
import org.eclipse.gemoc.dsl.debug.ide.launch.AbstractDSLLaunchConfigurationDelegate;
import org.eclipse.gemoc.dsl.debug.ide.sirius.ui.launch.AbstractDSLLaunchConfigurationDelegateSiriusUI;
import org.eclipse.gemoc.executionframework.engine.commons.DslHelper;
import org.eclipse.gemoc.executionframework.engine.commons.EngineContextException;
import org.eclipse.gemoc.executionframework.engine.commons.sequential.SequentialRunConfiguration;
import org.eclipse.gemoc.executionframework.engine.ui.Activator;
import org.eclipse.gemoc.xdsmlframework.api.core.ExecutionMode;
import org.eclipse.gemoc.xdsmlframework.api.engine_addon.IEngineAddon;

public class ALEEngineLauncher extends AbstractEngine{

	@Override
	public String executeModel() {
		AleEngine aleEngine = null;
		try{
			aleEngine = createExecutionEngine();
		}catch (EngineContextException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "FAIL: Cannot execute the model under test";
		}
		aleEngine.startSynchronous();
		this.setModelResource(aleEngine.getExecutionContext().getResourceModel());
		aleEngine.dispose();
		return "PASS: The model under test executed successfully";
	}
	private AleEngine createExecutionEngine() throws EngineContextException{
		AleEngine engine = new AleEngine();
		//if the resource is updated (e.g., the value of its dynamic features are set by the test case)
		//then the execution context should be updated
		this.executioncontext.setResourceModel(this.getModelResource());
		engine.initialize(this.executioncontext);
		
		// declare this engine as available for ale: queries in the odesign
		ALESiriusInterpreter.getDefault().addAleEngine(engine);
		// create and add addon to unregister when the engine will be disposed
		IEngineAddon aleRTDInterpreter = new ALESiriusInterpreterProviderAddon();
		Activator.getDefault().getMessaggingSystem().debug("Enabled implicit addon: "+ aleRTDInterpreter.getAddonID(), Activator.PLUGIN_ID);
		engine.getExecutionContext().getExecutionPlatform().addEngineAddon(aleRTDInterpreter);
		return engine;
	}
	@Override
	protected String getModelEntryPointMethodName(){
		EClass target = null;
		final EClass finalTarget = target;
		org.eclipse.gemoc.dsl.Dsl language = DslHelper.load(this._language);
		IAleEnvironment environment = Helper.gemocDslToAleDsl(language);
		
		List<ParsedFile<ModelUnit>> parsedSemantics = environment.getBehaviors().getParsedFiles();
		List<Method> mainOperations =
    		parsedSemantics
	    	.stream()
	    	.filter(sem -> sem.getRoot() != null)
	    	.map(sem -> sem.getRoot())
	    	.flatMap(unit -> unit.getClassExtensions().stream())
	    	.filter(xtdCls -> finalTarget == null || finalTarget == xtdCls.getBaseClass())
	    	.flatMap(xtdCls -> xtdCls.getMethods().stream())
    		.filter(op -> op.getTags().contains("main"))
    		.collect(Collectors.toList());
		
		Iterator it = mainOperations.iterator();
		return provideMethodLabel(it.next());
	}
	@Override
	protected String getModelInitializationMethodName() {
		if (this._language != null && this._entryPointMethod != null) {

			List<String> segments = Arrays.asList(this._entryPointMethod.split("::"));
			if (segments.size() >= 2) {
				String tagetClassName = segments.get(segments.size() - 2);
				org.eclipse.gemoc.dsl.Dsl language = DslHelper.load(this._language);

				try(IAleEnvironment environment = Helper.gemocDslToAleDsl(language)) {
					Optional<Method> initOperation = Optional.empty();
					try {
						List<ParsedFile<ModelUnit>> parsedSemantics =environment.getBehaviors().getParsedFiles();
						initOperation = parsedSemantics.stream().filter(sem -> sem.getRoot() != null)
								.map(sem -> sem.getRoot()).flatMap(unit -> unit.getClassExtensions().stream())
								.filter(xtdCls -> xtdCls.getBaseClass().getName().equals(tagetClassName))
								.flatMap(xtdCls -> xtdCls.getMethods().stream()).filter(op -> op.getTags().contains("init"))
								.findFirst();
					} catch (Exception e) {
					}
	
					if (initOperation.isPresent()) {
						return provideMethodLabel(initOperation.get());
					}
				}
			}
		}
		return "";
	}
	public String provideMethodLabel(Object element) {
		
		if(element instanceof Method) {
			Method mtd = (Method) element;
			ExtendedClass base = (ExtendedClass) mtd.eContainer();
			
			if(base.getBaseClass() != mtd.getOperationRef().getEContainingClass()) {
				return provideClassLabel(base.getBaseClass()) + "::" + mtd.getOperationRef().getName();
			}
			else {
				return provideClassLabel(mtd.getOperationRef());
			}
		}
		
		return provideClassLabel(element);
	}
	public String provideClassLabel(Object element) {
		if(element instanceof ENamedElement){
			StringBuilder sb = new StringBuilder();
			if(((ENamedElement)element).eContainer() != null){
				sb.append(provideClassLabel(((ENamedElement)element).eContainer()));
				sb.append("::");
			}
			sb.append(((ENamedElement)element).getName());
			return sb.toString();
		}
		else return element == null ? "" : element.toString();
	}
}
