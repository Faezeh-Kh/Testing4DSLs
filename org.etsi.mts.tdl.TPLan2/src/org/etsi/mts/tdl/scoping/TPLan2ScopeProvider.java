/*
 * generated by Xtext 2.10.0
 */
package org.etsi.mts.tdl.scoping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.etsi.mts.tdl.DataInstanceUse;
import org.etsi.mts.tdl.DataUse;
import org.etsi.mts.tdl.Element;
import org.etsi.mts.tdl.ElementImport;
import org.etsi.mts.tdl.GateInstance;
import org.etsi.mts.tdl.GateReference;
import org.etsi.mts.tdl.MemberAssignment;
import org.etsi.mts.tdl.MemberReference;
import org.etsi.mts.tdl.NamedElement;
import org.etsi.mts.tdl.Package;
import org.etsi.mts.tdl.PackageableElement;
import org.etsi.mts.tdl.Parameter;
import org.etsi.mts.tdl.ParameterBinding;
import org.etsi.mts.tdl.StructuredDataInstance;
import org.etsi.mts.tdl.StructuredDataType;
import org.etsi.mts.tdl.structuredobjectives.Content;
import org.etsi.mts.tdl.structuredobjectives.ContentReference;
import org.etsi.mts.tdl.structuredobjectives.DataReference;
import org.etsi.mts.tdl.structuredobjectives.EventOccurrenceSpecification;
import org.etsi.mts.tdl.structuredobjectives.EventSequence;
import org.etsi.mts.tdl.structuredobjectives.LiteralValue;
import org.etsi.mts.tdl.structuredobjectives.LiteralValueReference;
import org.etsi.mts.tdl.structuredobjectives.StructuredTestObjective;
import org.etsi.mts.tdl.structuredobjectives.VariantBinding;

import com.google.common.base.Function;
import com.google.inject.Inject;

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
public class TPLan2ScopeProvider extends TDLScopeProvider {
	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Override
	public IScope getScope(EObject context, EReference reference) {
//		if (PackageableElement.class.isAssignableFrom(reference.getEType().getInstanceClass())
//				&& !(context instanceof ElementImport)) {
//			EList<EObject> elements = getScopedElementsOfType(context, reference.getEType().getInstanceClass());
//			IScope scope = Scopes.scopeFor(elements);
//			return scope;
//		}
		
		if (Parameter.class.isAssignableFrom(reference.getEType().getInstanceClass())) {
			if (context instanceof Content) {
				if (context.eContainer() instanceof LiteralValue) {
					if (((LiteralValue)context.eContainer()).getDataType() instanceof StructuredDataType) {
						IScope scope = Scopes.scopeFor(((StructuredDataType)((LiteralValue)context.eContainer()).getDataType()).allMembers());
						return scope;
					}
				} else if (context.eContainer() instanceof Content) {
					if (((Content)context.eContainer()).getMember().getDataType() instanceof StructuredDataType) {
						IScope scope = Scopes.scopeFor(((StructuredDataType)((Content)context.eContainer()).getMember().getDataType()).allMembers());
						return scope;
					}
				}
			}
		} else if (context.eContainer() instanceof VariantBinding) {
//			System.out.println(context +" -> " + reference);
			if (context instanceof LiteralValueReference) {
				StructuredTestObjective sto = EcoreUtil2.getContainerOfType(context, StructuredTestObjective.class);
				List<LiteralValue> literalValues = new ArrayList<>();
				if (sto.getInitialConditions() != null) {
					literalValues.addAll(EcoreUtil2.getAllContentsOfType(sto.getInitialConditions(), LiteralValue.class));
				}
				if (sto.getExpectedBehaviour() != null) {
					literalValues.addAll(EcoreUtil2.getAllContentsOfType(sto.getExpectedBehaviour(), LiteralValue.class));
				}
				if (sto.getFinalConditions() != null) {
					literalValues.addAll(EcoreUtil2.getAllContentsOfType(sto.getFinalConditions(), LiteralValue.class));
				}
				
				IScope scope = Scopes.scopeFor(literalValues);
				return scope;
			} else if (context instanceof ContentReference) {
				StructuredTestObjective sto = EcoreUtil2.getContainerOfType(context, StructuredTestObjective.class);
				List<Content> content = EcoreUtil2.getAllContentsOfType(sto, Content.class);
				IScope scope = Scopes.scopeFor(content);
				return scope;
			}
		} else {
		}
		
		IScope scope = super.getScope(context, reference);
		return scope;
	}
}