package duc.uscript

import duc.uscript.uScript.Class
import duc.uscript.uScript.Script

class UScriptModelHelper {
	
	def static getFullQualifiedNamed(Class uClass) {
		val script = uClass.eContainer as Script
		if(script === null) {
			return uClass.name
		}
		return script.name + "." + uClass.name
	}
}