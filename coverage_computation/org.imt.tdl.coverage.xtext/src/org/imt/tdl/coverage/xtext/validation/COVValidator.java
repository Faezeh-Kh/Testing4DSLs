/*
 * generated by Xtext 2.26.0
 */
package org.imt.tdl.coverage.xtext.validation;

import org.eclipse.emf.common.util.URI;

import org.eclipse.ocl.xtext.completeocl.validation.CompleteOCLEObjectValidator;
import org.eclipse.xtext.validation.EValidatorRegistrar;
import org.imt.tdl.coverage.Activator;

import DSLSpecificCoverage.DSLSpecificCoveragePackage;

/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
public class COVValidator extends AbstractCOVValidator {
	
	
	/**
	 * Register the OCL validator for the DSL Specific Coverage Package
	 * 
	 * */
	@Override
	public void register(EValidatorRegistrar registrar) {
		super.register(registrar);
		final DSLSpecificCoveragePackage ePackageDSLCov = DSLSpecificCoveragePackage.eINSTANCE;
		
		//Activate the Plugin to get the OCL 
		URI basicSpecValOclURI = URI.createURI(Activator.getDefault().getBundle().getResource("model/ocl/DSLSpecConvValidation.ocl").toString());
		
		//Register
		registrar.register(ePackageDSLCov, new CompleteOCLEObjectValidator(ePackageDSLCov, basicSpecValOclURI));		
	}
	
	
//	public static final String INVALID_NAME = "invalidName";
//
//	@Check
//	public void checkGreetingStartsWithCapital(Greeting greeting) {
//		if (!Character.isUpperCase(greeting.getName().charAt(0))) {
//			warning("Name should start with a capital",
//					COVPackage.Literals.GREETING__NAME,
//					INVALID_NAME);
//		}
//	}
	
}
