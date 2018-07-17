package duc.uminijava.typing

import org.tetrabox.minijava.xtext.miniJava.TypeDeclaration
import org.tetrabox.minijava.xtext.MiniJavaModelUtil

import static duc.uminijava.typing.UMiniJavaTypeComputer.*
import com.google.inject.Inject

class UMiniJavaTypeConformance {
	
	@Inject extension MiniJavaModelUtil
	
	def isConformant(TypeDeclaration t1, TypeDeclaration t2) {
		t1 === NULL_TYPE ||
		t2 === NULL_TYPE ||
		(t1 === t2) ||
		(t1 === BOOLEAN_TYPE && t2 === BERNOULLI_TYPE) ||
		(t1 === BERNOULLI_TYPE && t2 === BOOLEAN_TYPE) ||
		t1.classHierarchy.contains(t2)
	}
}