/*
 * generated by Xtext 2.16.0
 */
package duc.uscript.validation

import org.eclipse.xtext.validation.Check
import duc.uscript.uScript.Program
import duc.uscript.uScript.Class
import duc.uscript.uScript.Method
import java.util.HashSet
import duc.uscript.uScript.UScriptPackage
import org.eclipse.xtext.validation.ComposedChecks

/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
 @ComposedChecks(validators=#[UTypeValidator, ArthTypeValidator])
class UScriptValidator extends AbstractUScriptValidator {
	
	public static val DUPLICATE_NAME = "duplicateName"
	
	@Check
	def checkUniqueness(Program program) {
		val HashSet<String> classNames = new HashSet()
		val HashSet<String> functionNames = new HashSet()
		
		program.elements.forEach[ elm |
			switch elm {
				Class: {
					val notExist = classNames.add(elm.name)
					if(!notExist) {
						error('''A class named «elm.name» already exists.''', elm, UScriptPackage.Literals.CLASS__NAME, DUPLICATE_NAME)
					}
				}
				
				Method: {
					val notExist = functionNames.add(elm.name)
					if(!notExist) {
						error('''A function named «elm.name» already exists.''', elm, UScriptPackage.Literals.METHOD__NAME, DUPLICATE_NAME)
					}
				}
			}
		]
	}
		
}
