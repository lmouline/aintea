package duc.uscript.execution.interpreter.tests

import org.eclipse.xtext.testing.InjectWith
import duc.uscript.tests.UScriptInjectorProvider
import com.google.inject.Inject
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.jupiter.api.Test
import static extension duc.uscript.execution.interpreter.ProgramAspect.*
import duc.uscript.execution.State
import org.junit.jupiter.api.^extension.ExtendWith
import static org.junit.jupiter.api.Assertions.assertArrayEquals
import org.eclipse.xtext.testing.extensions.InjectionExtension
import duc.uscript.uScript.Program

@ExtendWith(InjectionExtension)
@InjectWith(UScriptInjectorProvider)
class PrintStatementTest {
	
	@Inject extension ParseHelper<Program>
	
	def void genericTest(Object value, String[] expected) {
		val script = '''
			package a
					
			void main() {
				print(«value»);
			}
		'''.parse
		
		script.initialize(System.out)
		val State state = script.execute
		assertArrayEquals(expected, state.outputStream.stream.toArray)
	}
	
	
	@Test
	def void testPrintCtstString() {
		genericTest('''"A String"''', #["A String"])				
	}
	
	@Test
	def void testPrintCtstInt() {
		genericTest(0, #["0"])		
	}
	
	@Test
	def void testPrintCtstLong() {
		genericTest("0l", #["0"])		
	}
	
	@Test
	def void testPrintCtstDouble() {
		genericTest(5.2, #["5.2"])		
	}
	
	@Test
	def void testPrintCtstBool() {
		genericTest(true, #["true"])		
	}
	
}