package org.imt.tdl.sbfl.evaluation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.AttributeChange;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.ReferenceChange;
import org.eclipse.emf.compare.internal.spec.MatchSpec;
import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.rcp.EMFCompareRCPPlugin;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

@SuppressWarnings("restriction")
public class FaultyObjectFinder {
	
	public EObject findFaultyObjectOfMutant(Resource mutant, Resource originalModel) {					
		final IComparisonScope scope = new DefaultComparisonScope(mutant, originalModel, null);		
		IMatchEngine.Factory.Registry registry = EMFCompareRCPPlugin.getDefault().getMatchEngineFactoryRegistry();	
		Comparison comparison = EMFCompare.builder().setMatchEngineFactoryRegistry(registry).build().compare(scope);
		EList<Diff> diffs = comparison.getDifferences();
		if (diffs.size() == 1) {
			return getDiffObject(diffs.get(0));
		}
		
		//Filter diffs that are pointing to objects of the mutant
		List<Diff> mutantDiffs = new ArrayList<>();
		for (Diff diff:diffs) {
			if (diff instanceof AttributeChange && ((MatchSpec) diff.eContainer()).getLeft().eResource() == mutant) {
				mutantDiffs.add(diff);
			}
			if (diff instanceof ReferenceChange && ((ReferenceChange) diff).getValue().eResource() == mutant) {
				mutantDiffs.add(diff);
			}
		}
		if (mutantDiffs.size() == 1) {
			return getDiffObject(mutantDiffs.get(0));
		}
		//Filter diffs that do not have any equivalence and requirement, or they require the diffs related to the seed model
		List<Diff> mutantDiffsFiltered = mutantDiffs.stream().
				filter(md -> (md.getRequires() == null || md.getRequires().size() == 0 || !mutantDiffs.containsAll(md.getRequires())) && 
				(md.getEquivalence() == null || md.getEquivalence().getDifferences().size() == 0)).collect(Collectors.toList());
		if (mutantDiffsFiltered.size() == 1) {
			return getDiffObject(mutantDiffsFiltered.get(0));
		}
		else if (mutantDiffsFiltered.size() == 0) {
			//Filter diff objects that is because of CHANGE
			mutantDiffsFiltered = mutantDiffs.stream().filter(md -> md.getKind() == DifferenceKind.CHANGE).collect(Collectors.toList());
			if (mutantDiffsFiltered.size() == 1) {
				return getDiffObject(mutantDiffsFiltered.get(0));
			}
			else if (mutantDiffsFiltered.size() == 0) {
				System.out.println("no main diffs for mutant: " + mutant.getURI().toString());
				throw new NullPointerException();
			}
		}
		System.out.println("several main diffs for mutant: " + mutant.getURI().toString());
		throw new NullPointerException();
	}
	
	private EObject getDiffObject(Diff diff) {
		if (diff instanceof AttributeChange) {
			return ((MatchSpec)diff.eContainer()).getLeft();
		}
		else if (diff instanceof ReferenceChange) {
			ReferenceChange refDiff = (ReferenceChange) diff;
			if (refDiff.getReference().isContainment()) {
				return refDiff.getValue();
			}
			else {
				return ((MatchSpec)refDiff.eContainer()).getLeft();
			}
		}
		return null;
	}
}