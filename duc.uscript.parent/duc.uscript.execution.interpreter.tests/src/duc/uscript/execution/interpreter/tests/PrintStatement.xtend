package duc.uscript.execution.interpreter.tests

import org.junit.runner.RunWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.InjectWith
import duc.uscript.tests.UScriptInjectorProvider
import com.google.inject.Inject
import org.eclipse.xtext.testing.util.ParseHelper
import duc.uscript.uScript.Program
import org.junit.Test

import static extension duc.uscript.execution.interpreter.ProgramAspect.*
import duc.uscript.execution.State

@RunWith(XtextRunner)
@InjectWith(UScriptInjectorProvider)
class PrintStatement {
	
	@Inject extension ParseHelper<Program>
	
	@Test
	def void testPrintString() {
		val script = '''
			package a
			
			void main() {
				print("A String");
			}
		'''.parse
		
		script.initialize(System.out)
		val State state = script.execute
		
		print(state.outputStream.stream)
		
	}
	
}