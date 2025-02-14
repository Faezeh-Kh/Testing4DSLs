package org.imt.tdl.coverage.dslSpecific;

import java.nio.file.Path;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gemoc.dsl.Dsl;

import org.imt.tdl.coverage.computation.TDLCoverageUtil;

public class DSLSpecificCoverageHandler {
	
	private static final String COVERAGE_POINT_ID = "coverage.extensionpoint.DSLSpecificCoverage";
	private static final String COVERAGE_ID = "coverageId";
	
	public IDSLSpecificCoverage getDSLSpecificCoverage() {
		IConfigurationElement[] dslSpecificCoverages = Platform.getExtensionRegistry().getConfigurationElementsFor(COVERAGE_POINT_ID);
		try {
			for (IConfigurationElement dslSpecificCoverage : dslSpecificCoverages) {
				String dslCoverageComputationId = getDSLCoverageComputationId (TDLCoverageUtil.getInstance().getDSLPath());
				if (dslSpecificCoverage.getAttribute("id").equals(dslCoverageComputationId)) {
					final Object o = dslSpecificCoverage.createExecutableExtension("class");
					if (o instanceof IDSLSpecificCoverage) {	
						return (IDSLSpecificCoverage) o;
					}
				}
			}
		} catch (CoreException ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}

	private String getDSLCoverageComputationId(Path dslFilePath) {
		String path = dslFilePath.toString().replace("\\\\", "/");
		Resource dslRes = (new ResourceSetImpl()).getResource(URI.createPlatformPluginURI(path, false), true);
		Dsl dsl = (Dsl)dslRes.getContents().get(0);
		return dsl.getEntry(COVERAGE_ID) != null ? dsl.getEntry(COVERAGE_ID).getValue().toString() : null;
	}
}