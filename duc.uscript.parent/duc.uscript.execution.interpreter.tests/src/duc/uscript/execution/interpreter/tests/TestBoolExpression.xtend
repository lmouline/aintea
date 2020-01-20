package duc.uscript.execution.interpreter.tests


import org.junit.jupiter.api.^extension.ExtendWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.InjectWith
import duc.uscript.tests.UScriptInjectorProvider
import com.google.inject.Inject
import org.eclipse.xtext.testing.util.ParseHelper
import duc.uscript.uScript.Script
import org.junit.jupiter.api.Test
import java.io.OutputStream
import duc.uscript.execution.State
import static duc.uscript.UScriptLang.loadLib

import static extension duc.uscript.execution.interpreter.ScriptAspect.*
import static org.junit.jupiter.api.Assertions.assertArrayEquals
import com.google.inject.Provider
import org.eclipse.emf.ecore.resource.ResourceSet

@ExtendWith(InjectionExtension)
@InjectWith(UScriptInjectorProvider)
class TestBoolExpression {
	@Inject extension ParseHelper<Script>
	@Inject Provider<ResourceSet> rsp
	
	val OutputStream DEFAULT_OUT = new MockOutputStream()
	
	private def void genericTest(String op, String[] expected) {
		val script = '''
		package test
		
		void main() {
			bool trueBool = true;
			bool falseBool = false;
			
			bool trueTrue = trueBool «op» trueBool;
			bool trueFalse = trueBool «op» falseBool;
			bool FalseTrue = falseBool «op» trueBool;
			bool falseFalse = falseBool «op» falseBool;
			
			print(trueTrue);
			print(trueFalse);
			print(FalseTrue);
			print(falseFalse);
		}
		'''.parse
		
		script.initialize(DEFAULT_OUT)
		val State state = script.execute
		assertArrayEquals(expected, state.outputStream.stream.toArray)
	}
	
	@Test
	def void testAnd() {
		genericTest("&&", #["true", "false", "false", "false"])
	}
	
	@Test
	def void testOr() {
		genericTest("||", #["true", "true", "true", "false"])
	}
	
	@Test
	def void testNot() {
		val script = '''
		package test
		
		void main() {
			bool trueBool = true;
			bool falseBool = false;
			
			bool notTrue = !trueBool;
			bool notFalse = !falseBool;
			
			print(notTrue);
			print(notFalse);
		}
		'''.parse
		
		script.initialize(DEFAULT_OUT)
		val State state = script.execute
		assertArrayEquals(#["false", "true"], state.outputStream.stream.toArray)
	}
	
	def void genericUOp(String op, double[] coeff, double[] expected1, double[] expected2, boolean[] expectedBool) {
		val resourceSet = rsp.get 
		loadLib(resourceSet) 
		
		val script = '''
		package test
		
		import aintea.lang.*
		
		void main() {
			  Bernoulli<bool> true1 = new Bernoulli<bool>(true, «coeff.get(0)»);
			  Bernoulli<bool> true2 = new Bernoulli<bool>(true, «coeff.get(1)»);
			  Bernoulli<bool> false1 = new Bernoulli<bool>(false, «coeff.get(2)»);
			  Bernoulli<bool> false2 = new Bernoulli<bool>(false, «coeff.get(3)»);
			
			  Bernoulli<bool> trueTrue = true1 «op» true2;
			  Bernoulli<bool> trueFalse = true1 «op» false1;
			  Bernoulli<bool> falseTrue = false1 «op» true1;
			  Bernoulli<bool> falseFalse = false1 «op» false2;
			  
			  Bernoulli<bool> trueTrue1 = true1 «op» true;
			  Bernoulli<bool> trueFalse1 = true1 «op» false;
			  Bernoulli<bool> falseTrue1 = false1 «op» true;
			  Bernoulli<bool> falseFalse1 = false1 «op» false;
			  
			  Bernoulli<bool> trueTrue2 = true «op» true1;
			  Bernoulli<bool> trueFalse2 = false «op» true1;
			  Bernoulli<bool> falseTrue2 = true «op» false1;
			  Bernoulli<bool> falseFalse2 = false «op» false1;
			 			  			
			  print(trueTrue);
			  print(trueFalse);
			  print(falseTrue);
			  print(falseFalse);
			  
			  print(trueTrue1);
			  print(trueFalse1);
			  print(falseTrue1);
			  print(falseFalse1);
			  
			  print(trueTrue2);
			  print(trueFalse2);
			  print(falseTrue2);
			  print(falseFalse2);
		}
		'''.parse(resourceSet)
		
		script.initialize(DEFAULT_OUT)
		val State state = script.execute
		
		val String trueTrue = '''BernoulliBool(confidence:BernoulliDist, value:«expectedBool.get(0)»)'''
		val String trueFalse = '''BernoulliBool(confidence:BernoulliDist, value:«expectedBool.get(1)»)'''
		val String falseTrue = '''BernoulliBool(confidence:BernoulliDist, value:«expectedBool.get(2)»)'''
		val String falseFalse = '''BernoulliBool(confidence:BernoulliDist, value:«expectedBool.get(3)»)'''
		
		val String trueTrue1 = '''BernoulliBool(confidence:BernoulliDist, value:«expectedBool.get(0)»)'''
		val String trueFalse1 = '''BernoulliBool(confidence:BernoulliDist, value:«expectedBool.get(1)»)'''
		val String falseTrue1 = '''BernoulliBool(confidence:BernoulliDist, value:«expectedBool.get(2)»)'''
		val String falseFalse1 = '''BernoulliBool(confidence:BernoulliDist, value:«expectedBool.get(3)»)'''
		
		assertArrayEquals(#[trueTrue, trueFalse, falseTrue, falseFalse,
							trueTrue1, trueFalse1, falseTrue1, falseFalse1,
							trueTrue1, trueFalse1, falseTrue1, falseFalse1],
						  state.outputStream.stream.toArray)
	}
	
	@Test
	def void testuAnd() {
		val expectedBool = #[true, false, false, false]
		genericUOp("&&", 
				   #[0.6, 0.7, 0.4, 0.5], 
				   #[0.42, 0.36, 0.36, 0.3], 
				   #[0.6, 0.0, 0.6, 0.0],
				   expectedBool
		)
	}
	
	@Test
	def void testuOr() {
		val expectedBool = #[true, true, true, false]
		genericUOp("||", 
				   #[0.6, 0.7, 0.4, 0.5], 
				   #[0.8799999999999999, 0.84, 0.84, 0.8], 
				   #[1, 0.6, 1.0, 0.6], 
				   expectedBool
		)
	}
	
	@Test
	def void testUNot() {
		val resourceSet = rsp.get 
		loadLib(resourceSet)
		
		val script = '''
		package test
		
		import aintea.lang.*
		
		void main() {
			Bernoulli<bool> trueBool = new Bernoulli<bool>(true, 0.4);
			Bernoulli<bool> falseBool = new Bernoulli<bool>(false, 0.8);
			
			Bernoulli<bool> notTrue = !trueBool;
			Bernoulli<bool> notFalse = !falseBool;
			
			print(notTrue);
			print(notFalse);
		}
		'''.parse(resourceSet)
		
		script.initialize(DEFAULT_OUT)
		val State state = script.execute
		assertArrayEquals(
			#["BernoulliBool(confidence:BernoulliDist, value:false)", 
				"BernoulliBool(confidence:BernoulliDist, value:true)"], 
			state.outputStream.stream.toArray
		)
	}
}