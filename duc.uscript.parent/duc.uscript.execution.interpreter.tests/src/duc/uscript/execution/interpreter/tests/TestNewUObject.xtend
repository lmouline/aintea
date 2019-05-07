package duc.uscript.execution.interpreter.tests

import org.junit.jupiter.api.^extension.ExtendWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.InjectWith
import duc.uscript.tests.UScriptInjectorProvider
import com.google.inject.Inject
import org.eclipse.xtext.testing.util.ParseHelper
import duc.uscript.uScript.Script
import org.junit.jupiter.api.Test
import java.io.OutputStream
import static extension duc.uscript.execution.interpreter.ScriptAspect.*
import static org.junit.jupiter.api.Assertions.assertArrayEquals
import org.eclipse.emf.ecore.resource.ResourceSet
import com.google.inject.Provider
import static duc.uscript.UScriptLang.loadLib
import static extension org.eclipse.xtext.util.Strings.toFirstUpper

@ExtendWith(InjectionExtension)
@InjectWith(UScriptInjectorProvider)
class TestNewUObject {
	@Inject extension ParseHelper<Script>
	@Inject Provider<ResourceSet> rsp
	
	static val OutputStream MOCK_OUT = new MockOutputStream
	
	def void genericTest(String distDcl, String distName, String distTypeName, String type,
							String paramName1, String paramName2) {
		val resourceSet = rsp.get 
		loadLib(resourceSet) 
		
		val script = '''
			package test
			
			import aintea.lang.*
			
			void main() {
				«distDcl»<«type»> g = new «distDcl»<«type»>(5, 0.5);
				print(g);
			}
		'''.parse(resourceSet)
		
		script.initialize(MOCK_OUT)
		val state = script.execute
		val expected = '''«distTypeName»«type.toFirstUpper»(confidence:«distName»(«paramName1»:5, «paramName2»:0.5), value:5)'''
		assertArrayEquals(#[expected],state.outputStream.stream.toArray)
	}
	
	@Test
	def void testNewGaussian() {
		genericTest("Gaussian","GaussianDist","Gaussian",  "double", "mean", "variance")
		genericTest("Gaussian","GaussianDist", "Gaussian", "float", "mean", "variance")
	}
	
	@Test
	def void testNewRayleigh() {
		genericTest("Rayleigh","RayleighDist", "Rayleigh", "double", "mean", "variance")
		genericTest("Rayleigh","RayleighDist", "Rayleigh", "float", "mean", "variance")
	}
	
	@Test
	def void testNewBinomial() {
		genericTest("Binomial","BinomialDist", "Binomial", "byte", "mean", "variance")
		genericTest("Binomial","BinomialDist", "Binomial", "short", "mean", "variance")
		genericTest("Binomial","BinomialDist", "Binomial", "int", "mean", "variance")
		genericTest("Binomial","BinomialDist", "Binomial", "long", "mean", "variance")
	}
	
	@Test
	def void testNewDirac() {
		genericTest("DiracDeltaFct","DiracDeltaFunction", "DiracDeltaFunction", "byte", "shift", "confidence")
		genericTest("DiracDeltaFct","DiracDeltaFunction", "DiracDeltaFunction", "short", "shift", "confidence")
		genericTest("DiracDeltaFct","DiracDeltaFunction", "DiracDeltaFunction", "int", "shift", "confidence")
		genericTest("DiracDeltaFct","DiracDeltaFunction", "DiracDeltaFunction", "long", "shift", "confidence")
		genericTest("DiracDeltaFct","DiracDeltaFunction", "DiracDeltaFunction", "double", "shift", "confidence")
		genericTest("DiracDeltaFct","DiracDeltaFunction", "DiracDeltaFunction", "float", "shift", "confidence")
	}
	
	@Test
	def void testNewBernoulli() {
		val resourceSet = rsp.get 
		loadLib(resourceSet) 
		
		val script = '''
			package test
			
			import aintea.lang.*
			
			void main() {
				Bernoulli<bool> g = new Bernoulli<bool>(true, 0.6);
				Bernoulli<bool> g1 = new Bernoulli<bool>(false, 0.6);
				print(g);
				print(g1);
			}
		'''.parse(resourceSet)
		
		script.initialize(MOCK_OUT)
		val state = script.execute
		val expected1 = '''BernoulliBool(confidence:BernoulliDist(probability:0.6), value:true)'''
		val expected2 = '''BernoulliBool(confidence:BernoulliDist(probability:0.4), value:false)'''
		assertArrayEquals(#[expected1, expected2],state.outputStream.stream.toArray)
	}
}