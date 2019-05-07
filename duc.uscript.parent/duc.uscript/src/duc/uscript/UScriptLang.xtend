package duc.uscript

import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.common.util.URI

class UScriptLang {
	public val static LANG_LIB = "uscript/lang/aintea-lang.aintea"
	
	def static loadLib(ResourceSet resourceSet) {		
		val url = UScriptLang.classLoader.getResource(LANG_LIB)
		val stream = url.openStream
		val resource = resourceSet.createResource(URI.createFileURI(url.path))
		resource.load(stream, resourceSet.loadOptions)
	}
}