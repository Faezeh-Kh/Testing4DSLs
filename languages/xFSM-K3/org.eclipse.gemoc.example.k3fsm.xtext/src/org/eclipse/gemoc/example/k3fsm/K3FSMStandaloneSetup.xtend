/*
 * generated by Xtext 2.12.0
 */
package org.eclipse.gemoc.example.k3fsm


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class K3FSMStandaloneSetup extends K3FSMStandaloneSetupGenerated {

	def static void doSetup() {
		new K3FSMStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
}