package duc.uminijava.minirunner

import com.google.inject.Inject
import org.eclipse.xtext.parser.IParser
import com.google.inject.Injector
import duc.uminijava.UMiniJavaStandaloneSetup
import java.io.Reader
import java.io.IOException
import org.eclipse.xtext.parser.IParseResult
import org.eclipse.xtext.parser.ParseException
import org.eclipse.emf.ecore.xmi.impl.RootXMLContentHandlerImpl.Describer
import duc.uminijava.uMiniJava.UProgram
import java.io.BufferedReader
import java.io.FileReader

import static extension duc.uminijava.semantics.UProgramAspect.initialize
import static extension duc.uminijava.semantics.UProgramAspect.execute

class UMiniRunner {
	
	@Inject IParser parser;
	
	new() {
		val Injector injector = new UMiniJavaStandaloneSetup().createInjectorAndDoEMFRegistration();
		injector.injectMembers(this);
	}
	
	def UProgram parse(Reader reader) throws IOException {
		val IParseResult result = parser.parse(reader);
		if(result.hasSyntaxErrors) {
			throw new ParseException("Provided input contains syntax errors.")
		}
		return result.rootASTElement as UProgram
	}
	
	def static void main(String[] args) {
		val UMiniRunner runner = new UMiniRunner();
		try {
			val BufferedReader br = new BufferedReader(new FileReader("/Users/ludovicmouline/runtime-EclipseXtext/Test/src/Test.minijava"));
			val UProgram uProg = runner.parse(br);
			uProg.initialize(args)
			val state = uProg.execute
		} catch(Exception e) {
			e.printStackTrace
		}
	}
	
}