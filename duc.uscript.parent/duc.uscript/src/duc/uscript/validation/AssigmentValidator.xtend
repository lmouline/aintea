package duc.uscript.validation

import org.eclipse.xtext.validation.Check
import duc.uscript.uScript.Assignment
import com.google.inject.Inject
import duc.uscript.typing.TypeResolver
import static duc.uscript.typing.TypeConformance.*
import duc.uscript.uScript.UScriptPackage

class AssigmentValidator extends AbstractUScriptValidator {
	
	public static val TYPES_NOT_CONFORM = "typesNotConform"
	
	@Inject extension TypeResolver
	
	@Check
	def checkAssignment(Assignment assgnt) {
		val assignee = assgnt.assignee
		val expr = assgnt.value
		
		if(expr !== null) {
			val typeAss =  assignee.type
			val typeExpr = expr.type
			
			if(!isConformant(typeAss, typeExpr)) {
				error(
					'''«typeExpr.name» is not compatible with «typeAss.name». Compatible types are: «conformType(typeAss)»''',
					assgnt,
					UScriptPackage.Literals.ASSIGNMENT__VALUE,
					TYPES_NOT_CONFORM
				)
			}
		}
		
		
	}
	
}