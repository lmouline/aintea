package duc.uscript.tests.typing


import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.^extension.ExtendWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.InjectWith
import duc.uscript.tests.UScriptInjectorProvider
import com.google.inject.Inject
import org.eclipse.xtext.testing.util.ParseHelper
import duc.uscript.uScript.Script
import duc.uscript.uScript.Method
import duc.uscript.uScript.IfStatement
import duc.uscript.typing.TypeResolver
import duc.uscript.typing.InternalTypeDcl
import duc.uscript.uScript.Assignment
import static duc.uscript.UScriptLang.loadLib
import org.eclipse.emf.ecore.resource.ResourceSet
import com.google.inject.Provider
import static extension duc.uscript.UScriptModelHelper.getFullQualifiedNamed

@ExtendWith(InjectionExtension)
@InjectWith(UScriptInjectorProvider)
class TestTypeExpressions {
	@Inject extension ParseHelper<Script>
	@Inject extension TypeResolver
	@Inject Provider<ResourceSet> rsp
	
	@Test
	def void testCertainInequality() {
		val scriptText = '''
			package myPack
			
			import aintea.lang.*
			
			class A {}
			
			void m() {
				A[] array;
				int i = array.length;
				if(array.length > 0){}
			}
		'''
		
		val resourceSet = rsp.get 
		loadLib(resourceSet) 
		val script = scriptText.parse(resourceSet)
		
		val method = script.elements.get(1) as Method
		
		val iSttmt = method.body.statements.get(1) as Assignment
		val typeValue = type(iSttmt.value).fullQualifiedNamed
		Assertions.assertEquals(InternalTypeDcl.INT_TYPE, typeValue)
		
		val ifSttmt = method.body.statements.get(2) as IfStatement
		val type = type(ifSttmt.condition).fullQualifiedNamed
		Assertions.assertEquals(InternalTypeDcl.BOOL_TYPE, type)
		
	}
	
}