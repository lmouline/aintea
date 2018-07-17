package duc.uminijava.typing

import org.tetrabox.minijava.xtext.miniJava.TypeDeclaration

import static duc.uminijava.typing.UMiniJavaTypeComputer.*
import org.tetrabox.minijava.xtext.typing.MiniJavaTypeConformance

class UMiniJavaTypeConformance extends MiniJavaTypeConformance{
		
	override isConformant(TypeDeclaration t1, TypeDeclaration t2) {
		(t1 === BOOLEAN_TYPE && t2 === BERNOULLI_TYPE) ||
		(t1 === BERNOULLI_TYPE && t2 === BOOLEAN_TYPE) ||
		super.isConformant(t1,t2)
	}
}