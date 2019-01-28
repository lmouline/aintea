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
class TestUTypeConstructor {
	@Inject extension ParseHelper<Program>
	@Inject extension ValidationTestHelper
	
	// Bernoulli 
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
				'''Bernoulli constructor needs exactly 2 arguments. Actual: «l»'''
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
	
	// Gaussian
	@Test
	def void checkNoErrorNewGaussian() {
		val script = '''
			void m() {
				Gaussian<double> g = new Gaussian<double>(0, 0.1);
			}
		'''.parse
		script.assertNoError(UTypeValidator.WRONG_UTYPE_CONSTRUCTOR)
	}
	
	@Test
	def void checkErrorsNbArgsNewGaussian() {
		val args = #["", "0", "0, 0.1, 0"]
		val length = #[0, 1, 3];
		
		for(var i=0; i<args.length; i++) {
			val a = args.get(i)
			val l = length.get(i)
			val script = '''
				void m() {
					Gaussian<double> b = new Gaussian<double>(«a»);
				}
				'''.parse
			
			script.assertError(
				UScriptPackage.eINSTANCE.newUObject, 
				UTypeValidator.WRONG_UTYPE_CONSTRUCTOR, 
				'''Gaussian constructor needs exactly 2 arguments. Actual: «l»'''
			)
		}
	}
	
	@Test
	def void checkErrorsTypeArg1NewGaussian() {
		val args = #["\"aString\"", "null", "new A()", "true"]
		val typeName = #[STRING_TYPE.name, NULL_TYPE.name, "A", BOOLEAN_TYPE.name]
		
		for(var i=0; i<args.length; i++) {
			val a = args.get(i)
			val n = typeName.get(i)
			val script = '''
				class A {}
				
				void m() {
					Gaussian<double> b = new Gaussian<double>(«a», 0.1);
				}
				'''.parse
							
			script.assertError(
				UScriptPackage.eINSTANCE.newUObject, 
				UTypeValidator.WRONG_UTYPE_CONSTRUCTOR, 
				'''First argument of the Gaussian constructor needs to be a numeric expression. Actual: «n»'''
			)
		}
	}
	
	@Test
	def void checkErrorsTypeArg2NewGaussian() {
		val args = #["\"aString\"", "null", "new A()", "true"]
		val typeName = #[STRING_TYPE.name, NULL_TYPE.name, "A", BOOLEAN_TYPE.name]
		
		for(var i=0; i<args.length; i++) {
			val a = args.get(i)
			val n = typeName.get(i)
			val script = '''
				class A {}
				
				void m() {
					Gaussian<double> b = new Gaussian<double>(0.1, «a»);
				}
				'''.parse
							
			script.assertError(
				UScriptPackage.eINSTANCE.newUObject, 
				UTypeValidator.WRONG_UTYPE_CONSTRUCTOR, 
				'''Second argument of the Gaussian constructor needs to be a numeric expression. Actual: «n»'''
			)
		}
	}
	
	// Dirac
	@Test
	def void checkNoErrorNewDirac() {
		val script = '''
			void m() {
				DiracDeltaFct<double> g = new DiracDeltaFct<double>(0, 0.1);
			}
		'''.parse
		script.assertNoError(UTypeValidator.WRONG_UTYPE_CONSTRUCTOR)
	}
	
	@Test
	def void checkErrorsNbArgsNewDirac() {
		val args = #["", "0", "0, 0.1, 0"]
		val length = #[0, 1, 3];
		
		for(var i=0; i<args.length; i++) {
			val a = args.get(i)
			val l = length.get(i)
			val script = '''
				void m() {
					DiracDeltaFct<double> b = new DiracDeltaFct<double>(«a»);
				}
				'''.parse
			
			script.assertError(
				UScriptPackage.eINSTANCE.newUObject, 
				UTypeValidator.WRONG_UTYPE_CONSTRUCTOR, 
				'''Dirac constructor needs exactly 2 arguments. Actual: «l»'''
			)
		}
	}
	
	@Test
	def void checkErrorsTypeArg1NewDirac() {
		val args = #["\"aString\"", "null", "new A()", "true"]
		val typeName = #[STRING_TYPE.name, NULL_TYPE.name, "A", BOOLEAN_TYPE.name]
		
		for(var i=0; i<args.length; i++) {
			val a = args.get(i)
			val n = typeName.get(i)
			val script = '''
				class A {}
				
				void m() {
					DiracDeltaFct<double> b = new DiracDeltaFct<double>(«a», 0.1);
				}
				'''.parse
							
			script.assertError(
				UScriptPackage.eINSTANCE.newUObject, 
				UTypeValidator.WRONG_UTYPE_CONSTRUCTOR, 
				'''First argument of the Dirac constructor needs to be a numeric expression. Actual: «n»'''
			)
		}
	}
	
	@Test
	def void checkErrorsTypeArg2NewDirac() {
		val args = #["\"aString\"", "null", "new A()", "true"]
		val typeName = #[STRING_TYPE.name, NULL_TYPE.name, "A", BOOLEAN_TYPE.name]
		
		for(var i=0; i<args.length; i++) {
			val a = args.get(i)
			val n = typeName.get(i)
			val script = '''
				class A {}
				
				void m() {
					DiracDeltaFct<double> b = new DiracDeltaFct<double>(0.1, «a»);
				}
				'''.parse
							
			script.assertError(
				UScriptPackage.eINSTANCE.newUObject, 
				UTypeValidator.WRONG_UTYPE_CONSTRUCTOR, 
				'''Second argument of the Dirac constructor needs to be a numeric expression. Actual: «n»'''
			)
		}
	}
}