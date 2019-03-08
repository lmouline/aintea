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
	
	@Test
	def void testuAnd() {
		val resourceSet = rsp.get 
		loadLib(resourceSet) 
		
		val script = '''
		package test
		
		import uscript.lang.*
		
		void main() {
			  Bernoulli<bool> b1 = new Bernoulli<bool>(true, 0.6);
			  Bernoulli<bool> b2 = new Bernoulli<bool>(false, 0.7);
			
			  Bernoulli<bool> b3 = b1 && b2;
			  Bernoulli<bool> b4 = b1 || b2;
			  Bernoulli<bool> b5 = !b1;
			  			
			  print(b3);
			  print(b4);
			  print(b5);
		}
		'''.parse(resourceSet)
		
		script.initialize(System.out)
		val State state = script.execute
	}
}