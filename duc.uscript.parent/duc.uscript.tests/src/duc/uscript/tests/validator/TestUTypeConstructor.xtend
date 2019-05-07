package duc.uscript.tests.validator
import org.junit.jupiter.api.^extension.ExtendWith
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import duc.uscript.tests.UScriptInjectorProvider
import com.google.inject.Inject
import org.eclipse.xtext.testing.util.ParseHelper
import duc.uscript.uScript.Script
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.jupiter.api.Test
import duc.uscript.validation.UTypeValidator
import duc.uscript.uScript.UScriptPackage
import static duc.uscript.UScriptLang.loadLib
import org.eclipse.emf.ecore.resource.ResourceSet
import com.google.inject.Provider
import static duc.uscript.UScriptLang.loadLib

@ExtendWith(InjectionExtension)
@InjectWith(UScriptInjectorProvider)
class TestUTypeConstructor {
	@Inject extension ParseHelper<Script>
	@Inject extension ValidationTestHelper
	@Inject Provider<ResourceSet> rsp
	
	// Bernoulli 
	@Test
	def void checkNoErrorNewBernoulli() {
		val script = '''
			package myPack
			void m() {
				Bernoulli<bool> b = new Bernoulli<bool>(true, 0.1);
			}
		'''.parse
		script.assertNoErrors
	}
	
	@Test
	def void checkErrorsNbArgsNewBernoulli() {
		val args = #["", "true", "true, 0.1, true"]
		val length = #[0, 1, 3];
		
		for(var i=0; i<args.length; i++) {
			val a = args.get(i)
			val l = length.get(i)
			val script = '''
				package myPack
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
		val typeName = #["string", "byte", "float", "long", "null", "A"]
		
		for(var i=0; i<args.length; i++) {
			val resourceSet = rsp.get 
			loadLib(resourceSet) 
		
			val a = args.get(i)
			val n = typeName.get(i)
			val script = '''
				package myPack
				
				import aintea.lang.*
				
				class A {}
				
				void m() {
					Bernoulli<bool> b = new Bernoulli<bool>(«a», 0.1);
				}
				'''.parse(resourceSet)
							
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
		val typeName = #["string", "null", "A", "bool"]
		
		for(var i=0; i<args.length; i++) {
			val resourceSet = rsp.get 
			loadLib(resourceSet) 
			
			val a = args.get(i)
			val n = typeName.get(i)
			val script = '''
				package myPack
				
				import aintea.lang.*
				
				class A {}
				
				void m() {
					Bernoulli<bool> b = new Bernoulli<bool>(true, «a»);
				}
				'''.parse(resourceSet)
							
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
			package myPack
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
				package myPack
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
		val typeName = #["string", "null", "A", "bool"]
		
		for(var i=0; i<args.length; i++) {
			val resourceSet = rsp.get 
			loadLib(resourceSet) 
			
			val a = args.get(i)
			val n = typeName.get(i)
			val script = '''
				package myPack
				
				import aintea.lang.*
				
				class A {}
				
				void m() {
					Gaussian<double> b = new Gaussian<double>(«a», 0.1);
				}
				'''.parse(resourceSet)
							
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
		val typeName = #["string", "null", "A", "bool"]
		
		for(var i=0; i<args.length; i++) {
			val resourceSet = rsp.get 
			loadLib(resourceSet)
			
			val a = args.get(i)
			val n = typeName.get(i)
			val script = '''
				package myPack
				
				import aintea.lang.*
				
				class A {}
				
				void m() {
					Gaussian<double> b = new Gaussian<double>(0.1, «a»);
				}
				'''.parse(resourceSet)
							
			script.assertError(
				UScriptPackage.eINSTANCE.newUObject, 
				UTypeValidator.WRONG_UTYPE_CONSTRUCTOR, 
				'''Second argument of the Gaussian constructor needs to be a numeric expression. Actual: «n»'''
			)
		}
	}
	
	//Binomial
	@Test
	def void checkNoErrorNewBinomial() {
		val script = '''
			package myPack
			void m() {
				Binomial<short> g = new Binomial<short>(0, 0.1);
			}
		'''.parse
		script.assertNoError(UTypeValidator.WRONG_UTYPE_CONSTRUCTOR)
	}
	
	@Test
	def void checkErrorsNbArgsNewBinomial() {
		val args = #["", "0", "0, 0.1, 0"]
		val length = #[0, 1, 3];
		
		for(var i=0; i<args.length; i++) {
			val a = args.get(i)
			val l = length.get(i)
			val script = '''
				package myPack
				void m() {
					Binomial<short> b = new Binomial<short>(«a»);
				}
				'''.parse
			
			script.assertError(
				UScriptPackage.eINSTANCE.newUObject, 
				UTypeValidator.WRONG_UTYPE_CONSTRUCTOR, 
				'''Binomial constructor needs exactly 2 arguments. Actual: «l»'''
			)
		}
	}
	
	@Test
	def void checkErrorsTypeArg1NewBinomial() {
		val args = #["\"aString\"", "null", "new A()", "true", "0.1"]
		val typeName = #["String", "null", "A", "bool", "Float"]
		
		for(var i=0; i<args.length; i++) {
			val resourceSet = rsp.get 
			loadLib(resourceSet)
			
			val a = args.get(i)
			val n = typeName.get(i)
			val script = '''
				package myPack
				
				import aintea.lang.*
				
				class A {}
				
				void m() {
					Binomial<short> b = new Binomial<short>(«a», 0.1);
				}
				'''.parse(resourceSet)
							
			script.assertError(
				UScriptPackage.eINSTANCE.newUObject, 
				UTypeValidator.WRONG_UTYPE_CONSTRUCTOR, 
				'''First argument of the Binomial constructor needs to be a numeric expression. Actual: «n»'''
			)
		}
	}
	
	@Test
	def void checkErrorsTypeArg2NewBinomial() {
		val args = #["\"aString\"", "null", "new A()", "true"]
		val typeName = #["string", "null", "A", "bool"]
		
		for(var i=0; i<args.length; i++) {
			val resourceSet = rsp.get 
			loadLib(resourceSet)
			
			val a = args.get(i)
			val n = typeName.get(i)
			val script = '''
				package myPack
				
				import aintea.lang.*
				
				class A {}
				
				void m() {
					Binomial<byte> b = new Binomial<byte>(1, «a»);
				}
				'''.parse(resourceSet)
							
			script.assertError(
				UScriptPackage.eINSTANCE.newUObject, 
				UTypeValidator.WRONG_UTYPE_CONSTRUCTOR, 
				'''Second argument of the Binomial constructor needs to be a numeric expression. Actual: «n»'''
			)
		}
	}
	
	// Dirac
	@Test
	def void checkNoErrorNewDirac() {
		val script = '''
			package myPack
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
				package myPack
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
		val typeName = #["string", "null", "A", "bool"]
		
		for(var i=0; i<args.length; i++) {
			val resourceSet = rsp.get 
			loadLib(resourceSet)
			
			val a = args.get(i)
			val n = typeName.get(i)
			val script = '''
				package myPack
				
				import aintea.lang.*
				
				class A {}
				
				void m() {
					DiracDeltaFct<double> b = new DiracDeltaFct<double>(«a», 0.1);
				}
				'''.parse(resourceSet)
							
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
		val typeName = #["string", "null", "A", "bool"]
		
		for(var i=0; i<args.length; i++) {
			val resourceSet = rsp.get 
			loadLib(resourceSet)
			
			val a = args.get(i)
			val n = typeName.get(i)
			val script = '''
				package myPack
				
				import aintea.lang.*
				
				class A {}
				
				void m() {
					DiracDeltaFct<double> b = new DiracDeltaFct<double>(0.1, «a»);
				}
				'''.parse(resourceSet)
							
			script.assertError(
				UScriptPackage.eINSTANCE.newUObject, 
				UTypeValidator.WRONG_UTYPE_CONSTRUCTOR, 
				'''Second argument of the Dirac constructor needs to be a numeric expression. Actual: «n»'''
			)
		}
	}
}