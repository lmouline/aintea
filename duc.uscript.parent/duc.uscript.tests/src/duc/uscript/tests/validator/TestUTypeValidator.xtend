package duc.uscript.tests.validator

import org.junit.jupiter.api.^extension.ExtendWith
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import duc.uscript.tests.UScriptInjectorProvider
import com.google.inject.Inject
import org.eclipse.xtext.testing.util.ParseHelper
import duc.uscript.uScript.Program
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.jupiter.api.Test
import duc.uscript.validation.UTypeValidator
import duc.uscript.uScript.UScriptPackage
import static duc.uscript.typing.InternalTypeDcl.*

@ExtendWith(InjectionExtension)
@InjectWith(UScriptInjectorProvider)
class TestUTypeValidator {
	@Inject extension ParseHelper<Program>
	@Inject extension ValidationTestHelper
	
	
	//Check errors variable declaration
	@Test
	def void checkNoErrorBerBool() {
		val script = '''
			class A {
				Bernoulli<bool> att1;
			}
		'''.parse
		
		script.assertNoError(UTypeValidator.WRONG_UTYPE)
	}
	
	@Test
	def void checkErrorBerFloat() {
		val types= #["float", "double", "byte", "short", "int", "long", "char", "string", "B"]
		
		for (t : types) {
			val script = '''
				class A {
					Bernoulli<«t»> att1;
				}
				
				class B {}
			'''.parse
		
			script.assertError(
				UScriptPackage.eINSTANCE.typeRef, 
				UTypeValidator.WRONG_UTYPE, 
				'''Bernoulli distribution can only be applied on boolean. Actual: «t»'''
			)
		}
	}
	
	@Test
	def void checkNoErrorGaussRayleigh() {
		val uTypes= #["Gaussian", "Rayleigh"]
		val types= #["float", "double"]
		
		for (uT: uTypes) {
			for (t : types) {
				val script = '''
					class A {
						«uT»<«t»> att1;
					}
					
					class B {}
				'''.parse
				script.assertNoError(UTypeValidator.WRONG_UTYPE)
			}
		}	
	}
	
	@Test
	def void checkErrorsGaussRayleigh() {
		val uTypes= #["Gaussian", "Rayleigh"]
		val types= #["bool", "byte", "short", "int", "long", "char", "string", "B"]
		
		for (uT: uTypes) {
			for (t : types) {
				val script = '''
					class A {
						«uT»<«t»> att1;
					}
					
					class B {}
				'''.parse
				script.assertError(
					UScriptPackage.eINSTANCE.typeRef, 
					UTypeValidator.WRONG_UTYPE, 
					'''«uT» distribution can only be applied on (float, double). Actual: «t»'''
				)
			}
		}	
	}
	
	@Test
	def void checkNoErrorBin() {
		val types= #["short", "int", "long"]
		
		for (t : types) {
			val script = '''
				class A {
					Binomial<«t»> att1;
				}
			'''.parse
		
			script.assertNoError(UTypeValidator.WRONG_UTYPE)
		}
		
	}
	
	@Test
	def void checkErrorsBin() {
		val types= #["float", "double", "byte", "bool", "char", "string", "B"]
		
		for (t : types) {
			val script = '''
				class A {
					Binomial<«t»> att1;
				}
				
				class B {}
			'''.parse
		
			script.assertError(
				UScriptPackage.eINSTANCE.typeRef, 
				UTypeValidator.WRONG_UTYPE, 
				'''Binomial distribution can only be applied on (short, int, long). Actual: «t»'''
			)
		}
	}
	
	@Test
	def void checkNoErrorDirac() {
		val types= #["float", "double", "byte", "short", "int", "long"]
		
		for (t : types) {
			val script = '''
				class A {
					DiracDeltaFct<«t»> att1;
				}
				
				class B {}
			'''.parse
			script.assertNoError(UTypeValidator.WRONG_UTYPE)
		}
			
	}
	
	@Test
	def void checkErrorsDirac() {
		val types= #["bool", "char", "string", "B"]
		
		for (t : types) {
			val script = '''
				class A {
					DiracDeltaFct<«t»> att1;
				}
				
				class B {}
			'''.parse
			script.assertError(
				UScriptPackage.eINSTANCE.typeRef, 
				UTypeValidator.WRONG_UTYPE, 
				'''Dirac delta function distribution can only be applied on (short, int, long, float, double, byte). Actual: «t»'''
			)
		}	
	}
	
}