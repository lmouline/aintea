package duc.uscript.tests.parser

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.junit.jupiter.api.^extension.ExtendWith
import duc.uscript.tests.UScriptInjectorProvider
import com.google.inject.Inject

import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.jupiter.api.Test
import duc.uscript.uScript.Program
import duc.uscript.uScript.Method

import static org.junit.jupiter.api.Assertions.assertEquals
import static org.junit.jupiter.api.Assertions.assertNull
import static org.junit.jupiter.api.Assertions.assertTrue
import duc.uscript.uScript.BooleanTypeRef
import duc.uscript.uScript.ShortTypeRef
import duc.uscript.uScript.CharTypeRef

@ExtendWith(InjectionExtension)
@InjectWith(UScriptInjectorProvider)
class TestFunctionParsing {
	
	@Inject extension ParseHelper<Program>
	
	@Test
	def void oneFunctionScript() {
		val script = '''
			package a
			void main(bool param1, short param2, char param3);
		'''.parse
		
		val elements = script.elements
		assertEquals(1, elements.size)
		
		val main = elements.get(0) as Method
		assertEquals("main", main.name)
		assertNull(main.body)
		
		val params = main.params
		assertEquals(3, params.size)
		
		val p_1 = params.get(0)
		assertEquals("param1", p_1.name)
		assertTrue(p_1.typeRef instanceof BooleanTypeRef, '''Expected: «BooleanTypeRef», Actual: «p_1.typeRef»''')
		
		val p_2 = params.get(1)
		assertEquals("param2", p_2.name)
		assertTrue(p_2.typeRef instanceof ShortTypeRef, '''Expected: «ShortTypeRef», Actual: «p_2.typeRef»''')
		
		val p_3 = params.get(2)
		assertEquals("param3", p_3.name)
		assertTrue(p_3.typeRef instanceof CharTypeRef, '''Expected: «CharTypeRef», Actual: «p_3.typeRef»''')
		
	}
}