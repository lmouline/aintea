package duc.uscript.utils

class SimpleRange implements Range {
	double lowerBound;
	double upperBound;
	
	boolean includeLower;
	boolean includeUpper;
	
	boolean isEmpty;
	
	new(double lower, boolean includeLower, double upper, boolean includeUpper) {
		this.lowerBound = lower
		this.upperBound = upper
		this.includeLower = includeLower
		this.includeUpper = includeUpper
		
		this.isEmpty = false
	}
	
	new() {
		this.isEmpty = true;
	}
	
	def double getLowerBound() {
		return this.lowerBound
	}
	
	def void setLowerBound(double lower) {
		this.lowerBound = lower
		this.isEmpty = false;
	}
	
	def double getUpperBound() {
		return this.upperBound
	}
	
	def void setUpperBound(double upper) {
		this.upperBound = upper
		this.isEmpty = false;
	}
	
	def boolean getIncludeUpperBound() {
		return this.includeUpper
	}
	
	def void setIncludeUpperBound(boolean include) {
		this.includeUpper = include
	}
	
	def boolean getIncludeLowerBound() {
		return this.includeLower
	}
	
	def void setIncludeLowerBound(boolean include) {
		this.includeLower = include
	}
	
	def boolean isEmpty() {
		return this.isEmpty
	}
	
	def void setIsEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty
	}
	
	def SimpleRange getIntersection(SimpleRange other) {
		val rangeMinLower = if(this.lowerBound < other.lowerBound) {
			this
		} else {
			other
		}
		
		val rangeMaxLower = if(rangeMinLower == this) {
			other
		} else {
			this
		}
		
		if(rangeMinLower.upperBound < rangeMaxLower.lowerBound) {
			return RangeFactory.createEmptyRange()
		}
		
		val upperIntersection = if(rangeMinLower.upperBound < rangeMaxLower.upperBound) {
			rangeMinLower.upperBound
		} else {
			rangeMaxLower.upperBound
		}
		
		return new SimpleRange(rangeMaxLower.lowerBound, true, upperIntersection, true)
	}
	
	def boolean intersectionIsNull(SimpleRange other) {
		return getIntersection(other).isEmpty
	}
	
}