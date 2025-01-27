package org.imt.tdl.amplification.filtering;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

import org.eclipse.emf.ecore.EObject;
import org.etsi.mts.tdl.Package;
import org.etsi.mts.tdl.TestDescription;
import org.imt.k3tdl.interpreter.PackageAspect;
import org.imt.k3tdl.interpreter.TestDescriptionAspect;
import org.imt.tdl.amplification.AmplificationRuntimeException;
import org.imt.tdl.coverage.computation.TDLCoverageUtil;
import org.imt.tdl.coverage.computation.TDLTestCaseCoverage;
import org.imt.tdl.coverage.computation.TDLTestSuiteCoverage;
import org.imt.tdl.coverage.report.TestCoverageReport;
import org.imt.tdl.testResult.TDLTestResultUtil;

public class FilterByCoverage implements ITestSelector{
	
	TestCoverageReport tsCoverageReport;
	
	double coveragePercentageThreshold;
	
	int numOfCoveredElements;
	int numOfCoverableElements;

	List<String> tsObjectCoverageStatus;
	HashMap<String, List<EObject>> testCase_newCoveredObjs;
	
	public FilterByCoverage (double threshold) {
		coveragePercentageThreshold = threshold;
		tsObjectCoverageStatus = new ArrayList<>();
		testCase_newCoveredObjs = new HashMap<>();
	}

	@Override
	public double calculateInitialScore(Package testSuite) throws AmplificationRuntimeException {
		PackageAspect.initializeModel(testSuite, null);
		PackageAspect.main(testSuite);
		TDLCoverageUtil.getInstance().runCoverageComputation();
		TDLTestSuiteCoverage testSuiteCoverage = TDLCoverageUtil.getInstance().getTestSuiteCoverage();
		tsCoverageReport = testSuiteCoverage.getTsObjectCoverageRepot();
		tsObjectCoverageStatus = tsCoverageReport.getObjectCoverageStatus();
		numOfCoveredElements = (int) tsObjectCoverageStatus.stream()
				.filter(c -> c == TDLCoverageUtil.COVERED).count();
		numOfCoverableElements = (int) tsObjectCoverageStatus.stream()
				.filter(c -> c != TDLCoverageUtil.NOSTATUS).count();
		return tsCoverageReport.getCoveragePercentage();
	}

	@Override
	public boolean testCaseImprovesScore(TestDescription testCase) {
		testCase_newCoveredObjs.put(testCase.getName(), new ArrayList<>());
		TDLTestCaseCoverage coverageRunner = TestDescriptionAspect.testCaseCoverage(testCase);
		coverageRunner.calculateTCCoverage();
		TestCoverageReport tcCoverageReport = coverageRunner.getTcObjectCoverageRepot();
		List<String> tcObjectCoverageStatus = tcCoverageReport.getObjectCoverageStatus();
		boolean scoreImproved = false;
		for (int i=0; i<tsObjectCoverageStatus.size();i++) {
			if (tsObjectCoverageStatus.get(i) != TDLCoverageUtil.COVERED 
					&& tcObjectCoverageStatus.get(i) == TDLCoverageUtil.COVERED) {
				tsObjectCoverageStatus.set(i, TDLCoverageUtil.COVERED);
				testCase_newCoveredObjs.get(testCase.getName()).add(tcCoverageReport.getObjects().get(i));
				numOfCoveredElements++;
				scoreImproved = true;
			}
		}
		return scoreImproved;
	}

	@Override
	public double getCurrentScore() {
		double score = ((double) numOfCoveredElements/numOfCoverableElements)*100;
		BigDecimal bd = new BigDecimal(score).setScale(2, RoundingMode.HALF_UP);
		score = bd.doubleValue();
		return score;
	}

	@Override
	public void generateOverallScoreReport(StringBuilder stringBuilder) {
		double initialCoverage = tsCoverageReport.getCoveragePercentage();
		double amplifiedCoverage = getCurrentScore();
		double improvement = amplifiedCoverage - initialCoverage;
		stringBuilder.append("Total number of model elements: " + tsObjectCoverageStatus.size() + "\n");
		stringBuilder.append("Total number of coverable model elements: " + numOfCoverableElements + "\n");
		stringBuilder.append("- initial number of covered elements: " + tsCoverageReport.getNumOfCoveredObjs() + "\n");
		stringBuilder.append("- initial test suite coverage: " + (initialCoverage) + "%" + "\n\n");
		stringBuilder.append("- number of covered elements by improved test cases: " + (numOfCoveredElements-tsCoverageReport.getNumOfCoveredObjs())+ "\n");
		stringBuilder.append("- total number of covered elements: " + numOfCoveredElements + "\n");
		stringBuilder.append("- final test suite coverage: " + amplifiedCoverage + "%" + "\n");
		stringBuilder.append("=> improvement in the coverage percentage: " + (new BigDecimal(improvement).setScale(2, RoundingMode.HALF_UP)).doubleValue() + "%" + "\n");
		stringBuilder.append("--------------------------------------------------\n");

		stringBuilder.append("Yet not-covered elements after amplification: \n");
		int j = 1;
		for (int i=0; i<tsObjectCoverageStatus.size();i++) {
			if (tsObjectCoverageStatus.get(i) == TDLCoverageUtil.NOT_COVERED) {
				EObject element = tsCoverageReport.getObjects().get(i);
				stringBuilder.append("Not-covered element " + (j++) + ": " + TDLTestResultUtil.getInstance().eObjectLabelProvider(element) + "\n");
			}
		}
        stringBuilder.append("--------------------------------------------------\n");
        System.out.println(stringBuilder);
        
		stringBuilder.append("Initial Coverage Matrix: \n");
		List<ElementCoverageStatus> initialCoverageMatrix = new ArrayList<>();
		for (int i=0; i<tsCoverageReport.getObjectCoverageStatus().size(); i++) {
			String coverage = tsCoverageReport.getObjectCoverageStatus().get(i);
			if (coverage != TDLCoverageUtil.NOSTATUS) {
				ElementCoverageStatus entry = new ElementCoverageStatus();
				entry.elementName = TDLTestResultUtil.getInstance().eObjectLabelProvider(tsCoverageReport.getObjects().get(i));
				entry.coverageStatus = coverage;
				initialCoverageMatrix.add(entry);
			}
		}
		TableStringBuilder<ElementCoverageStatus> t = new TableStringBuilder<>();
        t.addColumn("Model element name", ElementCoverageStatus::getElementName);
        t.addColumn("Coverage status", ElementCoverageStatus::getCoverageStatus);
        String s = t.createString(initialCoverageMatrix);
        stringBuilder.append(s);
        stringBuilder.append("--------------------------------------------------\n");     
	}

	@Override
	public void generateAmplifiedTestcaseScoreReport(TestDescription testCase, StringBuilder stringBuilder) {
		stringBuilder.append("Amplified Test Case: " + testCase.getName()+"\n");
		int j = 1;
		for (EObject object:testCase_newCoveredObjs.get(testCase.getName())) {
			stringBuilder.append("New covered model element " + (j++) + ": " + TDLTestResultUtil.getInstance().eObjectLabelProvider(object) + "\n");
		}
		stringBuilder.append("\n");
	}

	class ElementCoverageStatus{
		String elementName;
		String coverageStatus;
		
		public String getElementName() {
			return elementName;
		}
		
		public String getCoverageStatus() {
			return coverageStatus;
		}
	}
	
	class TableStringBuilder<T>{
	    private final List<String> columnNames;
	    private final List<Function<? super T, String>> stringFunctions;

	    TableStringBuilder(){
	        columnNames = new ArrayList<String>();
	        stringFunctions = new ArrayList<Function<? super T, String>>();
	    }

	    void addColumn(String columnName, Function<? super T, ?> fieldFunction){
	        columnNames.add(columnName);
	        stringFunctions.add((p) -> (String.valueOf(fieldFunction.apply(p))));
	    }

	    private int computeMaxWidth(int column, Iterable<? extends T> elements){
	        int n = columnNames.get(column).length();
	        Function<? super T, String> f = stringFunctions.get(column);
	        for (T element : elements) {
	            String s = f.apply(element);
	            n = Math.max(n, s.length());
	        }
	        return n;
	    }

	    private String padLeft(String s, char c, int length){
	        while (s.length() < length){
	            s = c + s;
	        }
	        return s;
	    }

	    private List<Integer> computeColumnWidths(Iterable<? extends T> elements) {
	        List<Integer> columnWidths = new ArrayList<Integer>();
	        for (int c=0; c<columnNames.size(); c++){
	            int maxWidth = computeMaxWidth(c, elements);
	            columnWidths.add(maxWidth);
	        }
	        return columnWidths;
	    }

	    public String createString(Iterable<? extends T> elements){
	        List<Integer> columnWidths = computeColumnWidths(elements);

	        StringBuilder sb = new StringBuilder();
	        for (int c=0; c<columnNames.size(); c++){
	            if (c > 0){
	                sb.append("|");
	            }
	            String format = "%"+columnWidths.get(c)+"s";
	            sb.append(String.format(format, columnNames.get(c)));
	        }
	        sb.append("\n");
	        for (int c=0; c<columnNames.size(); c++){
	            if (c > 0){
	                sb.append("+");
	            }
	            sb.append(padLeft("", '-', columnWidths.get(c)));
	        }
	        sb.append("\n");

	        for (T element : elements){
	            for (int c=0; c<columnNames.size(); c++) {
	                if (c > 0){
	                    sb.append("|");
	                }
	                String format = "%"+columnWidths.get(c)+"s";
	                Function<? super T, String> f = stringFunctions.get(c);
	                String s = f.apply(element);
	                sb.append(String.format(format, s));
	            }
	            sb.append("\n");
	        }
	        return sb.toString();
	    }
	}

	@Override
	public double getScoreThreshold() {
		return coveragePercentageThreshold;
	}
}
