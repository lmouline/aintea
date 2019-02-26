package duc.uscript.execution.interpreter.tests

import org.junit.jupiter.api.^extension.ExtendWith
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import duc.uscript.tests.UScriptInjectorProvider
import com.google.inject.Inject
import org.eclipse.xtext.testing.util.ParseHelper
import duc.uscript.uScript.Program
import org.junit.jupiter.api.Test
import duc.uscript.execution.State

import static org.junit.jupiter.api.Assertions.assertArrayEquals

import static extension duc.uscript.execution.interpreter.ProgramAspect.*

@ExtendWith(InjectionExtension)
@InjectWith(UScriptInjectorProvider)
class TestAssignmentStatement {
	
	@Inject extension ParseHelper<Program>
	
	private def genericTest(String type, Object value, String expected) {
		val script = '''
			package a
					
			void main() {
				«type» a = «value»;
				print(a);
				
				«type» b;
				b = «value»;
				print(b);
			}
		'''.parse
		
		script.initialize(System.out)
		val State state = script.execute
		assertArrayEquals(#[expected, expected], state.outputStream.stream.toArray)
	}
	
	@Test
	def void testBoolConstAssgnmt() {
		genericTest("bool", true, "true")
		genericTest("bool", false, "false")
	}
	
	@Test
	def void testIntConstAssgnmt() {
		genericTest("int", 5, "5")
	}
	
	@Test
	def void testDoubleConstAssgnmt() {
		genericTest("double", 0.5, "0.5")
	}
	
	@Test
	def void testLongConstAssgnmt() {
		genericTest("long", "5l", "5")
	}
	
	@Test
	def void testStringConstAssgnmt() {
		genericTest("string", "\"A string\"", "A string")
	}
	
}