package duc.uscript.utils

import duc.uscript.uScript.LongConstant

class LongConstantUtils {
	
	def static long parseValue(LongConstant longCts) {
		var String value = longCts.value
		value = value.substring(0, value.length - 1)
		Long.parseLong(value)
	}
}