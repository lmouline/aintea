package duc.uscript.validation

import org.eclipse.xtext.validation.Check
import duc.uscript.uScript.IfStatement
import static duc.uscript.typing.TypeResolver.type
import static duc.uscript.typing.InternalTypeDcl.*
import duc.uscript.uScript.UScriptPackage

class CFValidator extends AbstractUScriptValidator {
	
	public static val WRONG_COND_TYPE = "wrongConditionnalType"
	
	@Check
	def checkIfCOndition(IfStatement ifSttmnt) {
		val condType = type(ifSttmnt.condition)
		
		if(condType !== BOOLEAN_TYPE) {
			error(
				'''If statement requires a bool expression for the condition. Actual: «condType.name»''',
				ifSttmnt,
				UScriptPackage.Literals.IF_STATEMENT__CONDITION,
				WRONG_COND_TYPE
			)
		}
	}
	
}