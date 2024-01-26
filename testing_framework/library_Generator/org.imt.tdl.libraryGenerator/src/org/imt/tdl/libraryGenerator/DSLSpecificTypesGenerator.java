package org.imt.tdl.libraryGenerator;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.etsi.mts.tdl.DataType;
import org.etsi.mts.tdl.Package;

public class DSLSpecificTypesGenerator {

	private Ecore2TDLTransformation transformer;

	public DSLSpecificTypesGenerator() {
	}

	public Package generateDslSpecificTypes(EPackage ePackage) {
		transformer = new Ecore2TDLTransformation();
		transformer.run(ePackage);
		System.out.println("dsl-specific types package generated successfully");
		return transformer.getRootTdlPackage();
	}

	public Map<String, DataType> getDslSpecificTypes() {
		return transformer.getDslSpecificTypes();
	}

	public Package getDslSpecificTypesPackage() {
		return transformer.getRootTdlPackage();
	}

	public List<DataType> getDynamicTypes() {
		return transformer.getDynamicTypes();
	}
}
