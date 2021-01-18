package org.imt.ale.customLaunchConfig;

import java.util.ArrayList;


import java.util.Iterator;
import java.util.LinkedHashSet;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.Query;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.labels.DefaultLabelGeneratorBuilder;
import org.eclipse.ocl.pivot.labels.ILabelGenerator;
import org.eclipse.ocl.pivot.labels.ILabelGenerator.Registry;

public class OCLLauncher {

	protected OCL ocl = null;
	protected OCLHelper oclHelper = null;

	protected OCLExpression<EClassifier> expression = null;
	protected Query<EClassifier, EClass, EObject> queryEval = null;

	public void setUp() {
		this.ocl = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);
		this.oclHelper = ocl.createOCLHelper();
	}

	public ArrayList<String> runQuery(Resource MUTResource, String query) throws ParserException {
		// The root element of the dsl is the context for ocl
		this.oclHelper.setContext(MUTResource.getContents().get(0).eClass());
		this.expression = this.oclHelper.createQuery(query);
		this.queryEval = this.ocl.createQuery(this.expression);
		// the ocl query will be evaluated on the root element of MUT
		Object res = this.queryEval.evaluate(MUTResource.getContents().get(0));
		//TODO: The type of res can be different based on the query
		LinkedHashSet<?> queryResult =  (LinkedHashSet<?>) res;
		ArrayList<String> labeledResult = new ArrayList<>();
		//Registry labelGeneratorRegistry = ILabelGenerator.Registry.INSTANCE;
		Iterator it = queryResult.iterator();
		while (it.hasNext()) {
			EObject object = (EObject) it.next();
			labeledResult.add(queryResultLabelProvider(object));
			/*@NonNull
			DefaultLabelGeneratorBuilder labelBuilder = new DefaultLabelGeneratorBuilder(labelGeneratorRegistry, object,null);
			labelBuilder.setOption(labelBuilder.SHOW_QUALIFIER, "::");
			labelBuilder.buildLabelFor(object);
			labeledResult.add(labelBuilder.toString());*/
		}
		return labeledResult;
	}

	public String queryResultLabelProvider(EObject object) {
		final Class<?> IItemLabelProviderClass = IItemLabelProvider.class;
		final Class<?> ITreeItemContentProviderClass = ITreeItemContentProvider.class;
		ArrayList<AdapterFactory> factories = new ArrayList<AdapterFactory>();
		factories.add(new ResourceItemProviderAdapterFactory());
		factories.add(new EcoreItemProviderAdapterFactory());
		factories.add(new ReflectiveItemProviderAdapterFactory());
		
		ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory(factories);
	    IItemLabelProvider itemLabelProvider  ;  
	    ITreeItemContentProvider treeItemContentProvider ;
    	AdapterFactory adapterFactory = composedAdapterFactory;
    	
    	itemLabelProvider = (IItemLabelProvider)adapterFactory.adapt(object, IItemLabelProviderClass);
	    String objectLabel = itemLabelProvider.getText(object) ;
	    
	    treeItemContentProvider = (ITreeItemContentProvider)adapterFactory.adapt(object, ITreeItemContentProviderClass);
        Object container = treeItemContentProvider.getParent(object) ; 
        itemLabelProvider = (IItemLabelProvider)adapterFactory.adapt(container, IItemLabelProviderClass);
        String containerLabel = itemLabelProvider.getText(container);
        
		return (containerLabel + "::" + objectLabel);
	}
	public void tearDown() throws Exception {
		this.oclHelper = null;
		this.ocl = null;
		this.expression = null;
		this.queryEval = null;
		Runtime.getRuntime().gc();
	}
}
