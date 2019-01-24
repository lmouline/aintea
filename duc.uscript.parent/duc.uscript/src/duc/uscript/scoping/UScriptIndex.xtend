package duc.uscript.scoping

import com.google.inject.Inject
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider
import org.eclipse.emf.ecore.EObject
import duc.uscript.uScript.UScriptPackage
import duc.uscript.uScript.Program

class UScriptIndex {
	@Inject ResourceDescriptionsProvider rdp
	
	def getResourceDescription(EObject o) {
		val index = rdp.getResourceDescriptions(o.eResource)
		index.getResourceDescription(o.eResource.URI)
	}
	
	def getExportedEObjectDescriptions(EObject o) {
		o.resourceDescription.exportedObjects
	}
	
	def getExportedClassesEObjectDescriptions(EObject o) {
		o.resourceDescription.getExportedObjectsByType(UScriptPackage.eINSTANCE.class_)
	}
	
	def getExportedMethodsEObjectDescriptions(EObject o) {
		o.resourceDescription.getExportedObjectsByType(UScriptPackage.eINSTANCE.method).filter[ obDes |
			obDes.EObjectOrProxy.eContainer instanceof Program
		]
	}
		
}