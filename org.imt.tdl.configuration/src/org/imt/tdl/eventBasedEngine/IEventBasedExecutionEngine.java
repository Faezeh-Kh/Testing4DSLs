package org.imt.tdl.eventBasedEngine;

import java.util.Map;

import org.imt.tdl.sequentialEngine.IExecutionEngine;

public interface IEventBasedExecutionEngine extends IExecutionEngine {
	
	public void startEngine();
	public String processAcceptedEvent(String eventName, Map<String, Object> parameters);
	public String assertExposedEvent(String eventName, Map<String, Object> parameters);
	public String sendStopEvent(boolean checkStatus);
	public Boolean isEngineStarted();
}