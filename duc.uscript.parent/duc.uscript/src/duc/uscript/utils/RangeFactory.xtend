package duc.uscript.utils

class RangeFactory {
		
	static def Range createFullRange() {
		return new SimpleRange(Range.MIN_INFITITY, false, Range.MAX_INFITITY, false)
	}
	
	static def Range createRangeWithUpper(double upper, boolean includeUpper) {
		return new SimpleRange(Range.MIN_INFITITY, false, upper, includeUpper)
	}
	
	static def Range createRangeWithLower(double lower, boolean includeLower) {
		return new SimpleRange(lower, includeLower, Range.MAX_INFITITY, false)
	}
	
	def static createEmptyRange() {
		return new SimpleRange()
	}
	
	
}