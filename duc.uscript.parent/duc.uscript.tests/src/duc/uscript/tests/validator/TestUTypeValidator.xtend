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
import org.eclipse.xtext.util.Strings
import java.util.Arrays
import static duc.uscript.typing.InternalTypeDcl.*

@ExtendWith(InjectionExtension)
@InjectWith(UScriptInjectorProvider)
class TestUTypeValidator {
	@Inject extension ParseHelper<Program>
	@Inject extension ValidationTestHelper
	
	
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
	
	@Test
	def void checkNoErrorNewBernoulli() {
		val script = '''
			void m() {
				Bernoulli<bool> b = new Bernoulli<bool>(true, 0.1);
			}
		'''.parse
		script.assertNoError(UTypeValidator.WRONG_UTYPE_CONSTRUCTOR)
	}
	
	@Test
	def void checkErrorsNbArgsNewBernoulli() {
		val args = #["", "true", "true, 0.1, true"]
		val length = #[0, 1, 3];
		
		for(var i=0; i<args.length; i++) {
			val a = args.get(i)
			val l = length.get(i)
			val script = '''
				void m() {
					Bernoulli<bool> b = new Bernoulli<bool>(«a»);
				}
				'''.parse
			
			script.assertError(
				UScriptPackage.eINSTANCE.newUObject, 
				UTypeValidator.WRONG_UTYPE_CONSTRUCTOR, 
				'''Bernoulli constructor needs exactly 2 argument: boolean falue and confidence. Actual: «l»'''
			)
		}
	}
	
	@Test
	def void checkErrorsTypeArg1NewBernoulli() {
		val args = #["\"aString\"","1", "1.2", "1L", "null", "new A()"]
		val typeName = #[STRING_TYPE.name, BYTE_TYPE.name, FLOAT_TYPE.name, LONG_TYPE.name, NULL_TYPE.name, "A"]
		
		for(var i=0; i<args.length; i++) {
			val a = args.get(i)
			val n = typeName.get(i)
			val script = '''
				class A {}
				
				void m() {
					Bernoulli<bool> b = new Bernoulli<bool>(«a», 0.1);
				}
				'''.parse
							
			script.assertError(
				UScriptPackage.eINSTANCE.newUObject, 
				UTypeValidator.WRONG_UTYPE_CONSTRUCTOR, 
				'''First argument of the Bernoulli constructor needs to be a boolean expression. Actual: «n»'''
			)
		}
	}
	
	@Test
	def void checkErrorsTypeArg2NewBernoulli() {
		val args = #["\"aString\"", "null", "new A()", "true"]
		val typeName = #[STRING_TYPE.name, NULL_TYPE.name, "A", BOOLEAN_TYPE.name]
		
		for(var i=0; i<args.length; i++) {
			val a = args.get(i)
			val n = typeName.get(i)
			val script = '''
				class A {}
				
				void m() {
					Bernoulli<bool> b = new Bernoulli<bool>(true, «a»);
				}
				'''.parse
							
			script.assertError(
				UScriptPackage.eINSTANCE.newUObject, 
				UTypeValidator.WRONG_UTYPE_CONSTRUCTOR, 
				'''Second argument of the Bernoulli constructor needs to be a numeric expression. Actual: «n»'''
			)
		}
	}
	
}