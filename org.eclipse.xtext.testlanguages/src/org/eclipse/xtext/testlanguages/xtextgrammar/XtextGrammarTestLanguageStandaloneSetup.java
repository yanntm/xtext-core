/*
 * generated by Xtext
 */
package org.eclipse.xtext.testlanguages.xtextgrammar;


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
public class XtextGrammarTestLanguageStandaloneSetup extends XtextGrammarTestLanguageStandaloneSetupGenerated {

	public static void doSetup() {
		new XtextGrammarTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}				
}
