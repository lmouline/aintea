package duc.uscript

import duc.uscript.uScript.Class
import duc.uscript.uScript.Program

class UScriptModelHelper {
	
	def static getFullQualifiedNamed(Class uClass) {
		val script = uClass.eContainer as Program
		if(script === null) {
			return uClass.name
		}
		return script.name + "." + uClass.name
	}
}