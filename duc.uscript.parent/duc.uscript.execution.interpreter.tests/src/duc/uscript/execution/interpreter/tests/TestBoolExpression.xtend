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
	
	def void genericUOp(String op, double[] coeff, double[] expected, boolean[] expectedBool) {
		val resourceSet = rsp.get 
		loadLib(resourceSet) 
		
		val script = '''
		package test
		
		import uscript.lang.*
		
		void main() {
			  Bernoulli<bool> true1 = new Bernoulli<bool>(true, «coeff.get(0)»);
			  Bernoulli<bool> true2 = new Bernoulli<bool>(true, «coeff.get(1)»);
			  Bernoulli<bool> false1 = new Bernoulli<bool>(false, «coeff.get(2)»);
			  Bernoulli<bool> false2 = new Bernoulli<bool>(false, «coeff.get(3)»);
			
			  Bernoulli<bool> trueTrue = true1 «op» true2;
			  Bernoulli<bool> trueFalse = true1 «op» false1;
			  Bernoulli<bool> falseTrue = false1 «op» true1;
			  Bernoulli<bool> falseFalse = false1 «op» false2;
			 			  			
			  print(trueTrue);
			  print(trueFalse);
			  print(falseTrue);
			  print(falseFalse);
		}
		'''.parse(resourceSet)
		
		script.initialize(System.out)
		val State state = script.execute
		
		val String trueTrue = '''BernoulliBool(confidence:BernoulliDist(probability:«expected.get(0)»), value:«expectedBool.get(0)»)'''
		val String trueFalse = '''BernoulliBool(confidence:BernoulliDist(probability:«expected.get(1)»), value:«expectedBool.get(1)»)'''
		val String falseTrue = '''BernoulliBool(confidence:BernoulliDist(probability:«expected.get(2)»), value:«expectedBool.get(2)»)'''
		val String falseFalse = '''BernoulliBool(confidence:BernoulliDist(probability:«expected.get(3)»), value:«expectedBool.get(3)»)'''
		
		assertArrayEquals(#[trueTrue, trueFalse, falseTrue, falseFalse], state.outputStream.stream.toArray)
	}
	
	@Test
	def void testuAnd() {
		val expectedBool = #[true, false, false, false]
		genericUOp("&&", #[0.6, 0.7, 0.4, 0.5], #[0.42, 0.36, 0.36, 0.3], expectedBool)
	}
	
	@Test
	def void testuOr() {
		val expectedBool = #[true, true, true, false]
		genericUOp("||", #[0.6, 0.7, 0.4, 0.5], #[0.8799999999999999, 0.84, 0.84, 0.8], expectedBool)
	}
	
	@Test
	def void testUNot() {
		val resourceSet = rsp.get 
		loadLib(resourceSet)
		
		val script = '''
		package test
		
		import uscript.lang.*
		
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
			#["BernoulliBool(confidence:BernoulliDist(probability:0.6), value:false)", 
				"BernoulliBool(confidence:BernoulliDist(probability:0.8), value:true)"], 
			state.outputStream.stream.toArray
		)
	}
}