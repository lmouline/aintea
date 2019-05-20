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
import static org.junit.jupiter.api.Assertions.assertThrows
import com.google.inject.Provider
import org.eclipse.emf.ecore.resource.ResourceSet

@ExtendWith(InjectionExtension)
@InjectWith(UScriptInjectorProvider)
class TestConfidenceOperator {
	@Inject extension ParseHelper<Script>
	@Inject Provider<ResourceSet> rsp
	
	val OutputStream DEFAULT_OUT = new MockOutputStream()
	
	def void genericConfidenceOpBoolWorking(String expected, String value, double confValue, double threshold) {
		val resourceSet = rsp.get
		loadLib(resourceSet)
		
		val script = '''
		package test
		
		import aintea.lang.*
		
		void main() {
			 Bernoulli<bool> true1 = new Bernoulli<bool>(«value», «confValue»);
			 bool b = true1[«threshold»]; 
			 print(b);
		}
		'''.parse(resourceSet)
		
		script.initialize(DEFAULT_OUT)
		val State state = script.execute
		
		assertArrayEquals(
				#[expected], 
				state.outputStream.stream.toArray
		)
	}
	
	def void genericConfidenceOpBoolError(String value, double confValue, double threshold) {
		val resourceSet = rsp.get
		loadLib(resourceSet)
		
		val script = '''
		package test
		
		import aintea.lang.*
		
		void main() {
			 Bernoulli<bool> true1 = new Bernoulli<bool>(«value», «confValue»);
			 bool b = true1[«threshold»]; 
		}
		'''.parse(resourceSet)
		
		script.initialize(DEFAULT_OUT)
		assertThrows(RuntimeException, [script.execute])
	}
	
	@Test
	def void testConfidenceOpBoolWorking() {
		// true: 0.3, false: 0.7
		genericConfidenceOpBoolWorking("false", "true", 0.3, 0)
		genericConfidenceOpBoolWorking("false", "true", 0.3, 0.2)
		genericConfidenceOpBoolWorking("false", "true", 0.3, 0.6)
		
		genericConfidenceOpBoolWorking("false", "false", 0.7, 0)
		genericConfidenceOpBoolWorking("false", "false", 0.7, 0.2)
		genericConfidenceOpBoolWorking("false", "false", 0.7, 0.6)
		
		//true: 0.6, false: 0.4
		genericConfidenceOpBoolWorking("true", "true", 0.6, 0)
		genericConfidenceOpBoolWorking("true", "true", 0.6, 0.2)
		genericConfidenceOpBoolWorking("true", "true", 0.6, 0.6)
		
		genericConfidenceOpBoolWorking("true", "false", 0.4, 0)
		genericConfidenceOpBoolWorking("true", "false", 0.4, 0.2)
		genericConfidenceOpBoolWorking("true", "false", 0.4, 0.6)
	}
	
	@Test
	def void testConfidenceOpBoolError() {
		// true: 0.3, false: 0.7
		genericConfidenceOpBoolError("true", 0.3, 0.8)
		genericConfidenceOpBoolError("false", 0.7, 0.8)
		
		//true: 0.6, false: 0.4
		genericConfidenceOpBoolError("true", 0.6, 0.8)
		genericConfidenceOpBoolError("false", 0.4, 0.8)
		
		// true: 0.5, false: 0.5
		genericConfidenceOpBoolError("true", 0.5, 0)
		genericConfidenceOpBoolError("true", 0.5, 0.2)
		genericConfidenceOpBoolError("true", 0.5, 0.5)
		genericConfidenceOpBoolError("true", 0.5, 0.9)
		
		genericConfidenceOpBoolError("false", 0.5, 0)
		genericConfidenceOpBoolError("false", 0.5, 0.2)
		genericConfidenceOpBoolError("false", 0.5, 0.5)
		genericConfidenceOpBoolError("false", 0.5, 0.9)
	}
	
}