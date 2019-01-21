package duc.uscript.tests.typing

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions

//import org.eclipse.xtext.testing.extensions.InjectionExtension
//import duc.uscript.tests.UScriptInjectorProvider
//import org.eclipse.xtext.testing.InjectWith
//import org.junit.jupiter.api.^extension.ExtendWith

import static duc.uscript.typing.InternalTypeDcl.*
import static duc.uscript.typing.TypeConcordance.*

class TestTypeConcordance {
	
	@Test
	def void checkCertainNumericConcordance() {
		Assertions.assertTrue(isCertainNumber(NUMERIC_TYPE))
		Assertions.assertTrue(isCertainNumber(LONG_TYPE))
		Assertions.assertTrue(isCertainNumber(INT_TYPE))
		Assertions.assertTrue(isCertainNumber(SHORT_TYPE))
		Assertions.assertTrue(isCertainNumber(BYTE_TYPE))
		Assertions.assertTrue(isCertainNumber(DOUBLE_TYPE))
		Assertions.assertTrue(isCertainNumber(FLOAT_TYPE))
		Assertions.assertFalse(isCertainNumber(CHAR_TYPE))
		Assertions.assertFalse(isCertainNumber(STRING_TYPE))
		Assertions.assertFalse(isCertainNumber(BOOLEAN_TYPE))
	}
	
	@Test
	def void checkNumericConcordance() {
		Assertions.assertTrue(isNumber(NUMERIC_TYPE))
		Assertions.assertTrue(isNumber(LONG_TYPE))
		Assertions.assertTrue(isNumber(INT_TYPE))
		Assertions.assertTrue(isNumber(SHORT_TYPE))
		Assertions.assertTrue(isNumber(BYTE_TYPE))
		Assertions.assertTrue(isNumber(DOUBLE_TYPE))
		Assertions.assertTrue(isNumber(FLOAT_TYPE))
		Assertions.assertTrue(isNumber(GAUSSIAN_TYPE))
		Assertions.assertTrue(isNumber(RAYLEIGH_TYPE))
		Assertions.assertTrue(isNumber(DIRAC_TYPE))
		Assertions.assertTrue(isNumber(BINOMIAL_TYPE))
		Assertions.assertFalse(isNumber(CHAR_TYPE))
		Assertions.assertFalse(isNumber(STRING_TYPE))
		Assertions.assertFalse(isNumber(BOOLEAN_TYPE))
	}
	
	@Test
	def void checkUncertainConcordance() {
		Assertions.assertTrue(isUncertain(UNCERTAIN_TYPE),'''Eror for «UNCERTAIN_TYPE»''')
		Assertions.assertTrue(isUncertain(GAUSSIAN_TYPE),'''Eror for «GAUSSIAN_TYPE»''')
		Assertions.assertTrue(isUncertain(GAUSSIAN_DOUBLE_TYPE),'''Eror for «GAUSSIAN_DOUBLE_TYPE»''')
		Assertions.assertTrue(isUncertain(GAUSSIAN_FLOAT_TYPE),'''Eror for «GAUSSIAN_FLOAT_TYPE»''')
		Assertions.assertTrue(isUncertain(RAYLEIGH_TYPE),'''Eror for «RAYLEIGH_TYPE»''')
		Assertions.assertTrue(isUncertain(RAYLEIGH_DOUBLE_TYPE),'''Eror for «RAYLEIGH_DOUBLE_TYPE»''')
		Assertions.assertTrue(isUncertain(RAYLEIGH_FLOAT_TYPE),'''Eror for «RAYLEIGH_FLOAT_TYPE»''')
		Assertions.assertTrue(isUncertain(DIRAC_TYPE),'''Eror for «DIRAC_TYPE»''')
		Assertions.assertTrue(isUncertain(DIRAC_BYTE_TYPE),'''Eror for «DIRAC_BYTE_TYPE»''')
		Assertions.assertTrue(isUncertain(DIRAC_SHORT_TYPE),'''Eror for «DIRAC_SHORT_TYPE»''')
		Assertions.assertTrue(isUncertain(DIRAC_INT_TYPE),'''Eror for «DIRAC_INT_TYPE»''')
		Assertions.assertTrue(isUncertain(DIRAC_LONG_TYPE),'''Eror for «DIRAC_LONG_TYPE»''')
		Assertions.assertTrue(isUncertain(DIRAC_FLOAT_TYPE),'''Eror for «DIRAC_FLOAT_TYPE»''')
		Assertions.assertTrue(isUncertain(DIRAC_DOUBLE_TYPE),'''Eror for «DIRAC_DOUBLE_TYPE»''')
		Assertions.assertTrue(isUncertain(BINOMIAL_TYPE),'''Eror for «BINOMIAL_TYPE»''')
		Assertions.assertTrue(isUncertain(BINOMIAL_BYTE_TYPE),'''Eror for «BINOMIAL_BYTE_TYPE»''')
		Assertions.assertTrue(isUncertain(BINOMIAL_SHORT_TYPE),'''Eror for «BINOMIAL_SHORT_TYPE»''')
		Assertions.assertTrue(isUncertain(BINOMIAL_INT_TYPE),'''Eror for «BINOMIAL_INT_TYPE»''')
		Assertions.assertTrue(isUncertain(BINOMIAL_LONG_TYPE),'''Eror for «BINOMIAL_LONG_TYPE»''')
		
		
		Assertions.assertFalse(isUncertain(CHAR_TYPE), '''Eror for «CHAR_TYPE»''')
		Assertions.assertFalse(isUncertain(INT_TYPE),'''Eror for «INT_TYPE»''')
		Assertions.assertFalse(isUncertain(BOOLEAN_TYPE),'''Eror for «BOOLEAN_TYPE»''')
	}
}