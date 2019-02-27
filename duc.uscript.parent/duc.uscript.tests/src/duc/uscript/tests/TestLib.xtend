package duc.uscript.tests

import org.eclipse.xtext.testing.InjectWith
import com.google.inject.Inject
import org.eclipse.xtext.testing.util.ParseHelper
import duc.uscript.uScript.Script
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import duc.uscript.UScriptLang
import org.eclipse.emf.ecore.resource.ResourceSet
import com.google.inject.Provider
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith
import org.eclipse.xtext.testing.extensions.InjectionExtension

@ExtendWith(InjectionExtension)
@InjectWith(UScriptInjectorProvider)
class TestLib {
	@Inject extension ParseHelper<Script>
	@Inject extension ValidationTestHelper
	@Inject	extension UScriptLang
	@Inject Provider<ResourceSet> rsp

	
	@Test 
	def void testImplicitImports() { 
		'''
		package a
				
		class C {
		       BernoulliDist s;
		       String i;
		}
		'''.loadLibAndParse.assertNoErrors
	}
	
	def private loadLibAndParse(CharSequence p) {
		val resourceSet = rsp.get 
		loadLib(resourceSet) 
		p.parse(resourceSet)
	}
	
	
	
}