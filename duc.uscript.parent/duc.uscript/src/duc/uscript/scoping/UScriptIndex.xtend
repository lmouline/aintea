package duc.uscript.scoping

import com.google.inject.Inject
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider
import org.eclipse.emf.ecore.EObject
import duc.uscript.uScript.UScriptPackage
import duc.uscript.uScript.Script
import org.eclipse.emf.ecore.EClass
import org.eclipse.xtext.resource.IContainer
import duc.uscript.uScript.Import
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.emf.common.util.EList
import duc.uscript.uScript.Class

class UScriptIndex {
	@Inject ResourceDescriptionsProvider rdp
	@Inject IContainer.Manager cm
	
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
	
	def getVisibleEObjectDescriptions(EObject o, EClass type) {
		o.visibleContainers
			.map[container | container.getExportedObjectsByType(type)]
			.flatten
	}
	
	def getVisibleClassesDescriptions(EObject o) {
		val parentProg = o.parentScript
		val imported = parentProg.getImports
		val progClasses = parentProg.exportedClassesEObjectDescriptions
		
		o.getVisibleEObjectDescriptions(UScriptPackage.eINSTANCE.class_)
			.filter[c |
				val exist = progClasses.findFirst[ pC | pC.qualifiedName === c.qualifiedName] !== null
				if (exist) {
					return true
				}
								
				return existInImport(imported, c.qualifiedName)
			]
			
	}
	
	def getVisibleMethodsDescriptions(EObject o) {
		val parentProg = o.parentScript
		val imported = parentProg.getImports
		val progMethods = parentProg.exportedMethodsEObjectDescriptions
		
		o.getVisibleEObjectDescriptions(UScriptPackage.eINSTANCE.method)
			.filter[m | 
				if(!(m.EObjectOrProxy.eContainer instanceof Script)) {
					return false
				}
				
				val exist = progMethods.findFirst[pM | pM.qualifiedName === m.qualifiedName] !== null
				if(exist) {
					return true
				}
									
				return existInImport(imported, m.qualifiedName)
			]
	}
	
	private def existInImport(EList<Import> imports, QualifiedName qualifiedName) {
		val isEmpty = imports.filter[ imp | 
			val impString = imp.importedNamespace
			if(impString.endsWith("*")) {
				val segments = impString.split("\\.")
				var same = true
				for(var i=0;i<segments.length - 1; i++) {
					same = same && segments.get(i) == qualifiedName.getSegment(i)
				}
				return same
			} else {
				return imp.importedNamespace == qualifiedName.toString
			}
			
		].empty
		return !isEmpty
	}
	
	def getExportedMethodsEObjectDescriptions(EObject o) {
		o.resourceDescription.getExportedObjectsByType(UScriptPackage.eINSTANCE.method).filter[ obDes |
			obDes.EObjectOrProxy.eContainer instanceof Script
		]
	}
	
	def getVisibleContainers(EObject o) {
		val idx = rdp.getResourceDescriptions(o.eResource)
		val rd = idx.getResourceDescription(o.eResource.URI)
		cm.getVisibleContainers(rd, idx)
	}
	
	private def Script getParentScript(EObject o) {
		if(o instanceof Script) {
			return o
		}
		
		if(o.eContainer instanceof Script) {
			return o.eContainer as Script
		}
		
		return getParentScript(o.eContainer)
	}
	
	def Class getClassFromFqn(EObject ctx, String fqn) {
		val des = ctx.visibleClassesDescriptions
					.filter[cDesc | cDesc.qualifiedName.toString == fqn]
					.head
		if (des === null) {
			return null
		}
		
		var rClass = des.EObjectOrProxy
		if(rClass.eIsProxy) {
			rClass = ctx.eResource.resourceSet.getEObject(des.EObjectURI, true)
		}
		
		return rClass as Class
		
	}
			
}