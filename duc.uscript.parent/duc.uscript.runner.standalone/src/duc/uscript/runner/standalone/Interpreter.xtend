package duc.uscript.runner.standalone

import java.io.OutputStream
import duc.uscript.uScript.Script
import com.google.inject.Injector
import duc.uscript.UScriptStandaloneSetupGenerated
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.validation.IResourceValidator
import java.util.List
import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.diagnostics.Severity

import static extension duc.uscript.execution.interpreter.ScriptAspect.*
import java.io.PrintStream

class Interpreter {
	
	private static def Script parse(String filePath, OutputStream out) {
		val Injector injector = new UScriptStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		val ResourceSet rs = injector.getInstance(ResourceSet)
		
		val Resource resource = rs.createResource(URI.createFileURI(filePath))
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
		
		return resource.contents.get(0) as Script
	}
	
	def static execute(String filePath, OutputStream out) {
		var Script script = parse(filePath, out);
		if(script !== null) {
			try {
				script.initialize(out)
				script.execute
			} catch (Exception e) {
				val PrintStream printStream = new PrintStream(out)
				e.printStackTrace(printStream)
				printStream.flush
			}
		}
	}
}