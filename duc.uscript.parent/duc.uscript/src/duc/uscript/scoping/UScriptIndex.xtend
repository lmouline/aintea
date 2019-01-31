package duc.uscript.scoping

import com.google.inject.Inject
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider
import org.eclipse.emf.ecore.EObject
import duc.uscript.uScript.UScriptPackage
import duc.uscript.uScript.Program
import java.io.InvalidObjectException
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.emf.ecore.EClass
import org.eclipse.xtext.resource.IContainer
import java.util.Arrays
import duc.uscript.uScript.Import
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.emf.common.util.EList

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
		val parentProg = o.parentProgram
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
		val parentProg = o.parentProgram
		val imported = parentProg.getImports
		val progMethods = parentProg.exportedMethodsEObjectDescriptions
		
		o.getVisibleEObjectDescriptions(UScriptPackage.eINSTANCE.method)
			.filter[m | 
				if(!(m.EObjectOrProxy.eContainer instanceof Program)) {
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
			obDes.EObjectOrProxy.eContainer instanceof Program
		]
	}
	
	def getVisibleContainers(EObject o) {
		val idx = rdp.getResourceDescriptions(o.eResource)
		val rd = idx.getResourceDescription(o.eResource.URI)
		cm.getVisibleContainers(rd, idx)
	}
	
	private def Program getParentProgram(EObject o) {
		if(o instanceof Program) {
			return o
		}
		
		if(o.eContainer instanceof Program) {
			return o.eContainer as Program
		}
		
		return getParentProgram(o.eContainer)
	}
		
}