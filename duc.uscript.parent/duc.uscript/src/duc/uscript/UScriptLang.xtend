package duc.uscript

import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.common.util.URI

class UScriptLang {
	public val static LANG_LIB = "./uscript/lang/uscript-lang.uscript"
	
	def loadLib(ResourceSet resourceSet) {
		val url = getClass().classLoader.getResource(LANG_LIB)
		val stream = url.openStream
		val resource = resourceSet.createResource(URI.createFileURI(url.path))
		resource.load(stream, resourceSet.loadOptions)
	}
}