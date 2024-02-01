package org.imt.tdl.libraryGenerator;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.etsi.mts.tdl.Package;
import org.etsi.mts.tdl.TDLtxStandaloneSetup;
import org.imt.tdl.utilities.DSLProcessor;
import org.imt.tdl.utilities.PathHelper;

import com.google.inject.Injector;

public class TDLCodeGenerator {

	public static Set<String> KEYWORDS = new HashSet<>(Arrays.asList("exception", "Entity", "Configuration", "PICS",
			"constraints", "bind", "containing", "(", ")", "optional", "*", "then", "+", "triggers", ",", "an",
			"execute", "-", ".", "/", "as", "SUT", "at", "size", "stop", "Note", "returns", "assigned", ":", "receives",
			";", "<", "!=", "conditions", "=", ">", "?", "@", "into", "default", "by", "xor", "where", "quiet", "after",
			"attribute", "[", "]", "connect", "a", "alternatively", "set", "replaced", "the", "component", "calls",
			"associated", "Event", "to", "{", "returned", "Initial", "}", "Constraint", "bindings", "run", "predefined",
			"Name", "Test", "Procedure", "Expected", "ensure", "last", "test", "extends", "name", "carrying", "some",
			"Action", "hidden", "for", "description", "Time", "Gate", "timeout", "not", "now", "Component", "every",
			"derived", "previous", "start", "perform", "false", "multiple", "merged", "Purpose", "label", "with",
			"gate", "time", "Import", "mod", "optionally", "during", "type", "occurs", "when", "else", "action", "if",
			"having", "waits", "in", "is", "it", "Out", "Variant", "verdict", "Package", "terminate", "Map", "wait",
			"Description", "In", "Implementation", "out", "Enumerated", "indicating", "assert", "Structure", "event",
			"Final", "break", "within", "Use", "Reference", "trigger", "Annotation", "sends", "Type", "behaviour",
			"Predefined", "first", "entity", "<=", "argument", "instance", "before", "several", "while", "Template",
			"that", "TestDescription", "interrupt", "only", "few", "create", "from", "all", "==", "otherwise", "new",
			"accepts", "Objective", "->", "true", "mapped", "Collection", "omit", ">=", "no", "Tester", "Message",
			"configuration", "responds", "point", "Function", "timer", "times", "parallel", "and", "of", "parameter",
			"repeat", "value", "on", "or", "any", "Exception", "contained", "corresponding", "References", "response",
			"Signature", "variable", "uses", "objectives"));

	private Package commonPackage;
	private Package dslSpecificEventsPackage;
	private Package dslSpecificTypesPackage;
	private Package testConfigurationPackage;
	private Package testSuitePackage;

	public TDLCodeGenerator(String dslFilePath, String tdlProjectPath) throws IOException {
		Path dslPath = (new PathHelper()).getPath(dslFilePath);
		DSLProcessor dslProcessor = new DSLProcessor(dslPath);

		System.out.println("Start TDL Code generation");
		DSLSpecificTypesGenerator dslSpecificTypesGenerator = new DSLSpecificTypesGenerator();
		dslSpecificTypesPackage = dslSpecificTypesGenerator
				.generateDslSpecificTypes(dslProcessor.getMetamodelRootElement());

		CommonPackageGenerator commonPackageGenerator = new CommonPackageGenerator(dslSpecificTypesGenerator);
		commonPackage = commonPackageGenerator.generateCommonPackage();

		DSLSpecificEventsGenerator dslSpecificEventsGenerator = null;
		if (dslProcessor.dslHasBehavioralInterface()) {
			dslSpecificEventsGenerator = new DSLSpecificEventsGenerator(dslSpecificTypesGenerator);
			dslSpecificEventsPackage = dslSpecificEventsGenerator
					.generateDSLSpecificEventsPackage(dslProcessor.getBehavioralInterfaceRootElement());
		}

		TestConfigurationGenerator testConfigurationGenerator = new TestConfigurationGenerator(
				dslProcessor.getDSLName(), dslProcessor.getDSLID(), commonPackageGenerator, dslSpecificEventsGenerator);
		testConfigurationPackage = testConfigurationGenerator.generateTestConfigurationPackage();

		TestSuitePackageGenerator testSuitePackageGenerator = new TestSuitePackageGenerator(commonPackage,
				dslSpecificTypesPackage, dslSpecificEventsPackage, testConfigurationPackage);
		testSuitePackage = testSuitePackageGenerator.generateTestSuitePackage();

		System.out.println("start saving packages");
		Job job = new Job("Saving generated packages") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				savePackages(tdlProjectPath);
				return MultiStatus.OK_STATUS;
			}
		};
		job.schedule();

		savePackages(tdlProjectPath);
		System.out.println("all packages are saved successfully");
	}

	private static final String GEN_FOLDER = "generated";
	private static final String TDL_EXTENSION = ".tdltx";

	public void savePackages(String tdlProjectPath) {
		Injector injector = new TDLtxStandaloneSetup().createInjectorAndDoEMFRegistration();
		ResourceSet rs = injector.getInstance(ResourceSet.class);

		String path = Paths.get(tdlProjectPath, GEN_FOLDER, (commonPackage.getName() + TDL_EXTENSION)).toString();
		Resource commonPackageRes = rs.createResource(URI.createPlatformResourceURI(path, false));
		commonPackageRes.getContents().add(commonPackage);

		Resource dslSpecificEventsRes = null;
		if (dslSpecificEventsPackage != null) {
			path = Paths.get(tdlProjectPath, GEN_FOLDER, dslSpecificEventsPackage.getName() + TDL_EXTENSION).toString();
			dslSpecificEventsRes = rs.createResource(URI.createPlatformResourceURI(path, false));
			dslSpecificEventsRes.getContents().add(dslSpecificEventsPackage);
		}
		path = Paths.get(tdlProjectPath, GEN_FOLDER, dslSpecificTypesPackage.getName() + TDL_EXTENSION).toString();
		Resource dslSpecificTypesRes = rs.createResource(URI.createPlatformResourceURI(path, false));
		dslSpecificTypesRes.getContents().add(dslSpecificTypesPackage);

		path = Paths.get(tdlProjectPath, GEN_FOLDER, testConfigurationPackage.getName() + TDL_EXTENSION).toString();
		Resource configurationRes = rs.createResource(URI.createPlatformResourceURI(path, false));
		configurationRes.getContents().add(testConfigurationPackage);

		path = Paths.get(tdlProjectPath, testSuitePackage.getName() + TDL_EXTENSION).toString();
		Resource testSuitePackageRes = rs.createResource(URI.createPlatformResourceURI(path, false));
		testSuitePackageRes.getContents().add(testSuitePackage);

		try {
			dslSpecificTypesRes.save(Collections.emptyMap());
			commonPackageRes.save(Collections.emptyMap());
			if (dslSpecificEventsRes != null) {
				dslSpecificEventsRes.save(Collections.emptyMap());
			}
			configurationRes.save(Collections.emptyMap());
			testSuitePackageRes.save(Collections.emptyMap());
		} catch (IOException e) {
			// TODO: handle exception
		}

		dslSpecificTypesRes.unload();
		commonPackageRes.unload();
		if (dslSpecificEventsRes != null) {
			dslSpecificEventsRes.unload();
		}
		configurationRes.unload();
		testSuitePackageRes.unload();
		rs = null;
	}

	public static String getValidName(String name) {
		return TDLCodeGenerator.KEYWORDS.contains(name) ? "_" + name : name;
	}

	public static String getValidTypeName(String name) {
		String valid = getValidName(name);
		if (valid.startsWith("_")) {
			valid = getValidName(valid.substring(1, 2).toUpperCase() + valid.substring(2));
		} else {
			valid = valid.substring(0, 1).toUpperCase() + valid.substring(1);
		}
		return valid;
	}
}
