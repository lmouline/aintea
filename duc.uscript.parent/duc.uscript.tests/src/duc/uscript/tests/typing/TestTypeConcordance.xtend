package duc.uscript.tests.typing

import org.junit.jupiter.api.Test
import static org.junit.jupiter.api.Assertions.assertTrue
import static org.junit.jupiter.api.Assertions.assertFalse
import static duc.uscript.typing.InternalTypeDcl.*
import static duc.uscript.typing.TypeConcordance.*
import com.google.inject.Inject
import org.eclipse.xtext.testing.util.ParseHelper
import duc.uscript.UScriptLang
import org.eclipse.emf.ecore.resource.ResourceSet
import com.google.inject.Provider
import duc.uscript.uScript.Program
import duc.uscript.typing.InternalTypeDcl
import org.junit.jupiter.api.^extension.ExtendWith
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import duc.uscript.tests.UScriptInjectorProvider
import duc.uscript.uScript.Class
import org.junit.jupiter.api.BeforeEach

@ExtendWith(InjectionExtension)
@InjectWith(UScriptInjectorProvider)
class TestTypeConcordance {
	@Inject extension ParseHelper<Program>
	@Inject	extension UScriptLang
	@Inject Provider<ResourceSet> rsp
	@Inject InternalTypeDcl internalType
	
	Class aClass
	
	@BeforeEach
	def void initClass() {
		val resourceSet = rsp.get 
		loadLib(resourceSet) 
		
		val emptyScript = '''
			package a
			
			import uscript.lang.*
			
			class A {}
		'''.parse(resourceSet)
		
		aClass = emptyScript.elements.get(0) as Class
	}
		
	@Test
	def void checkCertainNumericConcordance() {		
		assertTrue(isCertainNumber(internalType.getNumericClass(aClass)))
		assertTrue(isCertainNumber(internalType.getLongClass(aClass)))
		assertTrue(isCertainNumber(internalType.getIntClass(aClass)))
		assertTrue(isCertainNumber(internalType.getShortClass(aClass)))
		assertTrue(isCertainNumber(internalType.getByteClass(aClass)))
		assertTrue(isCertainNumber(internalType.getDoubleClass(aClass)))
		assertTrue(isCertainNumber(internalType.getFloatClass(aClass)))
		assertFalse(isCertainNumber(internalType.getCharClass(aClass)))
		assertFalse(isCertainNumber(internalType.getStringClass(aClass)))
		assertFalse(isCertainNumber(internalType.getBoolClass(aClass)))
	}
	
	@Test
	def void checkNumericConcordance() {
		assertTrue(isNumber(internalType.getNumericClass(aClass)))
		assertTrue(isNumber(internalType.getLongClass(aClass)))
		assertTrue(isNumber(internalType.getIntClass(aClass)))
		assertTrue(isNumber(internalType.getShortClass(aClass)))
		assertTrue(isNumber(internalType.getByteClass(aClass)))
		assertTrue(isNumber(internalType.getDoubleClass(aClass)))
		assertTrue(isNumber(internalType.getFloatClass(aClass)))
		assertTrue(isNumber(internalType.getGaussianClass(aClass)))
		assertTrue(isNumber(internalType.getRayleighClass(aClass)))
		assertTrue(isNumber(internalType.getDiracClass(aClass)))
		assertTrue(isNumber(internalType.getBinomialClass(aClass)))
		assertFalse(isNumber(internalType.getCharClass(aClass)))
		assertFalse(isNumber(internalType.getStringClass(aClass)))
		assertFalse(isNumber(internalType.getBoolClass(aClass)))
	}
	
	@Test
	def void checkUncertainConcordance() {
		assertTrue(isUncertain(internalType.getUncertainClass(aClass)),'''Eror for «UNCERTAIN_TYPE»''')
		assertTrue(isUncertain(internalType.getGaussianClass(aClass)),'''Eror for «GAUSSIAN_TYPE»''')
		assertTrue(isUncertain(internalType.getGaussianDoubleClass(aClass)),'''Eror for «GAUSSIAN_DOUBLE_TYPE»''')
		assertTrue(isUncertain(internalType.getGaussianFloatClass(aClass)),'''Eror for «GAUSSIAN_FLOAT_TYPE»''')
		assertTrue(isUncertain(internalType.getRayleighClass(aClass)),'''Eror for «RAYLEIGH_TYPE»''')
		assertTrue(isUncertain(internalType.getRayleighDoubleClass(aClass)),'''Eror for «RAYLEIGH_DOUBLE_TYPE»''')
		assertTrue(isUncertain(internalType.getRayleighFloatClass(aClass)),'''Eror for «RAYLEIGH_FLOAT_TYPE»''')
		assertTrue(isUncertain(internalType.getDiracClass(aClass)),'''Eror for «DIRAC_TYPE»''')
		assertTrue(isUncertain(internalType.getDiracByteClass(aClass)),'''Eror for «DIRAC_BYTE_TYPE»''')
		assertTrue(isUncertain(internalType.getDiracShortClass(aClass)),'''Eror for «DIRAC_SHORT_TYPE»''')
		assertTrue(isUncertain(internalType.getDiracIntClass(aClass)),'''Eror for «DIRAC_INT_TYPE»''')
		assertTrue(isUncertain(internalType.getDiracLongClass(aClass)),'''Eror for «DIRAC_LONG_TYPE»''')
		assertTrue(isUncertain(internalType.getDiracFloatClass(aClass)),'''Eror for «DIRAC_FLOAT_TYPE»''')
		assertTrue(isUncertain(internalType.getDiracDoubleClass(aClass)),'''Eror for «DIRAC_DOUBLE_TYPE»''')
		assertTrue(isUncertain(internalType.getBinomialClass(aClass)),'''Eror for «BINOMIAL_TYPE»''')
		assertTrue(isUncertain(internalType.getBinomialByteClass(aClass)),'''Eror for «BINOMIAL_BYTE_TYPE»''')
		assertTrue(isUncertain(internalType.getBinomialShortClass(aClass)),'''Eror for «BINOMIAL_SHORT_TYPE»''')
		assertTrue(isUncertain(internalType.getBinomialIntClass(aClass)),'''Eror for «BINOMIAL_INT_TYPE»''')
		assertTrue(isUncertain(internalType.getBinomialLongClass(aClass)),'''Eror for «BINOMIAL_LONG_TYPE»''')
		
		
		assertFalse(isUncertain(internalType.getCharClass(aClass)), '''Eror for «CHAR_TYPE»''')
		assertFalse(isUncertain(internalType.getIntClass(aClass)),'''Eror for «INT_TYPE»''')
		assertFalse(isUncertain(internalType.getBoolClass(aClass)),'''Eror for «BOOL_TYPE»''')
	}
}