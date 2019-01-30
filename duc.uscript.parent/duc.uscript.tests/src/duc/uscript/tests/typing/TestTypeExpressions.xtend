package duc.uscript.tests.typing


import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.^extension.ExtendWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.InjectWith
import duc.uscript.tests.UScriptInjectorProvider
import com.google.inject.Inject
import org.eclipse.xtext.testing.util.ParseHelper
import duc.uscript.uScript.Program
import duc.uscript.uScript.Method
import duc.uscript.uScript.IfStatement
import static duc.uscript.typing.TypeResolver.*
import duc.uscript.typing.InternalTypeDcl
import duc.uscript.uScript.Assignee
import duc.uscript.uScript.Assignment

@ExtendWith(InjectionExtension)
@InjectWith(UScriptInjectorProvider)
class TestTypeExpressions {
	@Inject extension ParseHelper<Program>
	
	@Test
	def void testCertainInequality() {
		val script = '''
			package myPack
			
			class A {}
			
			void m() {
				A[] array;
				int i = array.length;
				if(array.length > 0){}
			}
		'''.parse
		
		val method = script.elements.get(1) as Method
		
		val iSttmt = method.body.statements.get(1) as Assignment
		val typeValue = type(iSttmt.value)
		Assertions.assertEquals(InternalTypeDcl.INT_TYPE, typeValue)
		
		val ifSttmt = method.body.statements.get(2) as IfStatement
		val type = type(ifSttmt.condition)
		Assertions.assertEquals(InternalTypeDcl.BOOLEAN_TYPE, type)
		
	}
	
}