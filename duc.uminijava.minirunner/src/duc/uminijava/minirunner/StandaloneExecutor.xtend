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


class StandaloneExecutor {
	
	static Injector injector = new UMiniJavaStandaloneSetup().createInjectorAndDoEMFRegistration()
	static ResourceSet rs = injector.getInstance(ResourceSet)
	
	private static def UProgram parse(String filePath) {
		val Resource resource = rs.getResource(URI.createFileURI(filePath), true)
		resource.load(null)
		val IResourceValidator validator = injector.getInstance(IResourceValidator)
		val List<Issue> issues = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl)
		var parsingError = false
		for (Issue i : issues) {
			switch i.severity {
				case Severity.ERROR: {
					println('''ERROR: «i.message»''')
					parsingError = true
				}
				case Severity.WARNING: println('''WARNING: «i.message»''')
				default: println(i.message)
			}
		}
		
		if(parsingError) {
			return null
		}
		return resource.contents.get(0) as UProgram
	}
	
	
	def static execute(String filePath) {
		val UProgram prog = parse(filePath)
		if(prog !== null) {
			prog.initialize(new ArrayList())
			prog.execute
		}
	}
	
}