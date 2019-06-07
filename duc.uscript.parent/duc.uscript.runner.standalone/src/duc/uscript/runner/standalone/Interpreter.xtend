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

import duc.uscript.UScriptLang
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.FileVisitor
import java.io.IOException
import java.nio.file.attribute.BasicFileAttributes
import java.nio.file.FileVisitResult

class Interpreter {
	
	private static def void loadClassPath(String[] classPaths, ResourceSet rs) {
		if(classPaths !== null) {
			for (String classPath : classPaths) {
				val File file = new File(classPath)
				if(file.exists) {
					if(file.isDirectory) {
						Files.walkFileTree(Paths.get(file.absolutePath), new FileVisitor<Path>() {
							
							override postVisitDirectory(Path dir, IOException exc) throws IOException {
								FileVisitResult.CONTINUE;
							}
							
							override preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
								FileVisitResult.CONTINUE;
							}
							
							override visitFile(Path file, BasicFileAttributes attrs) throws IOException {
								val Resource resource = rs.createResource(URI.createFileURI(file.toAbsolutePath.toString))
								resource.load(null)
								FileVisitResult.CONTINUE
							}
							
							override visitFileFailed(Path file, IOException exc) throws IOException {
								System.err.print("Visit failed for " + file)
								FileVisitResult.CONTINUE
							}
							
						})
					} else {
						val Resource resource = rs.createResource(URI.createFileURI(file.absolutePath))
						resource.load(null)
					}
				}
			}
		}
	}
	
	private static def Script parse(String filePath, String[] classPath, OutputStream out) {
		val Injector injector = new UScriptStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		val ResourceSet rs = injector.getInstance(ResourceSet)
		
		UScriptLang.loadLib(rs)
		
		loadClassPath(classPath, rs)
		
		
		val URI uriScript = URI.createFileURI(new File(filePath).absolutePath)
		var Resource resource;
		
//		try { 
//			resource = rs.getResource(uriScript, true)
//		} catch (RuntimeException re) {
//			resource = rs.createResource(uriScript)
//			resource.load(null)
//		}
		
//		if(resource === null) {
			resource = rs.createResource(uriScript)
			resource.load(null)
//		}

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
		execute(filePath, out, #[]);
	}
	
	def static execute(String filePath, OutputStream out, String... classPath) {
		var Script script = parse(filePath, classPath, out);
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