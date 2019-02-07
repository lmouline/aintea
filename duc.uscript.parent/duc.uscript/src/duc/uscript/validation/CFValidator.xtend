package duc.uscript.validation

import org.eclipse.xtext.validation.Check
import duc.uscript.uScript.IfStatement
import static duc.uscript.typing.InternalTypeDcl.BOOL_TYPE
import duc.uscript.uScript.UScriptPackage
import duc.uscript.typing.TypeResolver
import com.google.inject.Inject
import duc.uscript.uScript.Class
import static extension duc.uscript.UScriptModelHelper.getFullQualifiedNamed

class CFValidator extends AbstractUScriptValidator {
	@Inject extension TypeResolver
	
	public static val WRONG_COND_TYPE = "wrongConditionnalType"
	
	@Check
	def checkIfCondition(IfStatement ifSttmnt) {
		if(ifSttmnt.condition !== null) {
			val Class condType = type(ifSttmnt.condition)
			
			if(condType.getFullQualifiedNamed != BOOL_TYPE) {
				error(
					'''If statement requires a bool expression for the condition. Actual: «condType.fullQualifiedNamed»''',
					ifSttmnt,
					UScriptPackage.Literals.IF_STATEMENT__CONDITION,
					WRONG_COND_TYPE
				)
			}
		}
	}
	
}