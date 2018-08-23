package duc.uminijava.minirunner

import com.google.inject.Injector
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.validation.IResourceValidator
import java.util.List
import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.diagnostics.Severity
import duc.uminijava.UMiniJavaStandaloneSetup
import java.util.ArrayList
import duc.uminijava.uMiniJava.UProgram

import static extension duc.uminijava.semantics.UProgramAspect.execute
import static extension duc.uminijava.semantics.UProgramAspect.initialize
import java.io.OutputStream
import java.io.PrintStream

class StandaloneExecutor {
	
	static Injector injector = new UMiniJavaStandaloneSetup().createInjectorAndDoEMFRegistration()
	static ResourceSet rs = injector.getInstance(ResourceSet)
	
	private static def UProgram parse(String filePath, OutputStream out) {
		val Resource resource = rs.getResource(URI.createFileURI(filePath), true)
		resource.load(null)
		val IResourceValidator validator = injector.getInstance(IResourceValidator)
		val List<Issue> issues = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl)
		var parsingError = false
		for (Issue i : issues) {
			switch i.severity {
				case Severity.ERROR: {
					val String s = '''ERROR: «i.message»\n'''
					out.write(s.bytes)
					parsingError = true
				}
				case Severity.WARNING: out.write(('''WARNING: «i.message»\n''').toString.bytes)
				default: out.write((i.message + "\n").bytes)
			}
		}
		
		if(parsingError) {
			return null
		}
		return resource.contents.get(0) as UProgram
	}
	
	
	def static execute(String filePath, OutputStream out) {
		val UProgram prog = parse(filePath, out)
		if(prog !== null) {
			try {
				prog.initialize(new ArrayList(), out)
				prog.execute
			} catch(Exception e) {
				val PrintStream printStream = new PrintStream(out)
				e.printStackTrace(printStream)
				printStream.flush
			}
		}
	}
	
}