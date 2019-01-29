package duc.uscript.validation

import org.eclipse.xtext.validation.Check
import duc.uscript.uScript.Plus
import duc.uscript.uScript.Class
import static duc.uscript.typing.TypeResolver.type
import static duc.uscript.typing.TypeConcordance.isNumber
import static duc.uscript.typing.TypeConcordance.is
import duc.uscript.uScript.UScriptPackage
import static duc.uscript.typing.InternalTypeDcl.STRING_TYPE
import static duc.uscript.typing.InternalTypeDcl.RAYLEIGH_TYPE
import static duc.uscript.typing.InternalTypeDcl.GAUSSIAN_TYPE
import static duc.uscript.typing.InternalTypeDcl.BINOMIAL_TYPE
import duc.uscript.uScript.Expression
import org.eclipse.emf.ecore.EReference
import duc.uscript.uScript.Minus
import duc.uscript.uScript.Multiplication
import duc.uscript.uScript.Division
import duc.uscript.typing.InternalTypeDcl

class ArthTypeValidator extends AbstractUScriptValidator {
	
	public static val INCOMPATIBLE_TYPES = "incompatibleTypes"
	
	@Check
	def checkType(Minus minus) {
		InternalTypeDcl.init(minus.eResource)
		checkRayleigh(type(minus.left), type(minus.right), minus, UScriptPackage.Literals.MINUS__LEFT, UScriptPackage.Literals.MINUS__RIGHT)
	}
	
	@Check
	def checkType(Multiplication mult) {
		InternalTypeDcl.init(mult.eResource)
		checkRayleigh(type(mult.left), type(mult.right), mult, UScriptPackage.Literals.MULTIPLICATION__LEFT, UScriptPackage.Literals.MULTIPLICATION__RIGHT)
	}
	
	@Check
	def checkType(Division division) {
		InternalTypeDcl.init(division.eResource)
		checkRayleigh(type(division.left), type(division.right), division, UScriptPackage.Literals.DIVISION__LEFT, UScriptPackage.Literals.DIVISION__RIGHT)
	}
		
	@Check
	def checkType(Plus plus) {
		InternalTypeDcl.init(plus.eResource)
		val leftType = type(plus.left)
		val rightType = type(plus.right)
		
		if(!isNumber(leftType) && leftType != STRING_TYPE) {
			error(
				'''Plus operation is only allowed between two numerical or string elements.«leftType.name»''', 
				plus, 
				UScriptPackage.Literals.PLUS__LEFT, INCOMPATIBLE_TYPES
			)
		}
		
		if(!isNumber(rightType) && rightType != STRING_TYPE ) {
			error(
				'''Plus operation is only allowed between two numerical or string elements.«rightType.name»''', 
				plus, 
				UScriptPackage.Literals.PLUS__RIGHT, INCOMPATIBLE_TYPES
			)
		}
		
		checkRayleigh(leftType, rightType, plus, UScriptPackage.Literals.PLUS__LEFT, UScriptPackage.Literals.PLUS__RIGHT)
	}
	
	private def checkRayleigh(Class leftType, Class rightType, Expression expr, EReference leftRef, EReference rightRef) {
		if(is(leftType, RAYLEIGH_TYPE)) {
			if(is(rightType, GAUSSIAN_TYPE) || is(rightType, BINOMIAL_TYPE)) {
				error(
				'''Uncertain numbers with a Rayleigh distribution as uncertainty representation can only be combined with one using a Rayleigh or a Dirac distribution, or a certain number.''', 
				expr, 
				rightRef, INCOMPATIBLE_TYPES
			)
			}
		}
		
		if(is(rightType, RAYLEIGH_TYPE)) {
			if(is(leftType, GAUSSIAN_TYPE) || is(leftType, BINOMIAL_TYPE)) {
				error(
				'''Uncertain numbers with a Rayleigh distribution as uncertainty representation can only be combined with one using a Rayleigh or a Dirac distribution, or a certain number.''', 
				expr, 
				leftRef, INCOMPATIBLE_TYPES
			)
			}
		}
	}
	
}