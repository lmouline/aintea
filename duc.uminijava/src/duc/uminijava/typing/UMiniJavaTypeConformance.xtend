package duc.uminijava.typing

import org.tetrabox.minijava.xtext.miniJava.TypeDeclaration

import static duc.uminijava.typing.UMiniJavaTypeComputer.*
import org.tetrabox.minijava.xtext.typing.MiniJavaTypeConformance

class UMiniJavaTypeConformance extends MiniJavaTypeConformance{
		
	// t1: actual
	// t2: expected	
	override isConformant(TypeDeclaration t1, TypeDeclaration t2) {
		(t1 === BOOLEAN_TYPE && t2 === BERNOULLI_TYPE) ||
		(t1 === BERNOULLI_TYPE && t2 === BOOLEAN_TYPE) ||
		
		(t1.conforancePrimivite(BYTE_TYPE) && t2 === GAUSSIAN_BYTE_TYPE) ||
		(t1 === GAUSSIAN_BYTE_TYPE && t2 === BYTE_TYPE) ||
		
		(t1.conforancePrimivite(SHORT_TYPE) && t2 === GAUSSIAN_SHORT_TYPE) ||
		((t1.isSubclassOf(GAUSSIAN_SHORT_TYPE) || t1 === GAUSSIAN_SHORT_TYPE) && t2 === SHORT_TYPE) ||
		
		(t1.conforancePrimivite(INT_TYPE) && t2 === GAUSSIAN_INT_TYPE) ||
		((t1.isSubclassOf(GAUSSIAN_INT_TYPE) || t1 === GAUSSIAN_INT_TYPE) && t2 === INT_TYPE) ||
		
		(t1.conforancePrimivite(LONG_TYPE) && t2 === GAUSSIAN_LONG_TYPE) ||
		((t1.isSubclassOf(GAUSSIAN_LONG_TYPE) || t1 === GAUSSIAN_LONG_TYPE) && t2 === LONG_TYPE) ||
		
		(t1.conforancePrimivite(FLOAT_TYPE) && t2 === GAUSSIAN_FLOAT_TYPE) ||
		((t1.isSubclassOf(GAUSSIAN_FLOAT_TYPE) || t1 === GAUSSIAN_FLOAT_TYPE) && t2 === FLOAT_TYPE) ||
		
		
		(t1.conforancePrimivite(DOUBLE_TYPE) && t2 === GAUSSIAN_DOUBLE_TYPE) ||
		((t1.isSubclassOf(GAUSSIAN_DOUBLE_TYPE) || t1 === GAUSSIAN_DOUBLE_TYPE) && t2 === DOUBLE_TYPE) ||
				
		super.isConformant(t1,t2)
	}

}