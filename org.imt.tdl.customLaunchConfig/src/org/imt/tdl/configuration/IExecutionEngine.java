package org.imt.tdl.configuration;

import org.eclipse.emf.ecore.resource.Resource;

public interface IExecutionEngine {
	
	public void setUp(String MUTPath, String DSLPath);
	public void executeModel();
	public void setModelResource(Resource resource);
	public Resource getModelResource();
}