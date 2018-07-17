package duc.uminijava.typing

import org.tetrabox.minijava.xtext.miniJava.TypeDeclaration
import org.tetrabox.minijava.xtext.miniJava.TypeRef

import duc.uminijava.uMiniJava.GaussianRef
import duc.uminijava.uMiniJava.BernoulliRef
import duc.uminijava.uMiniJava.NewUObject
import org.tetrabox.minijava.xtext.typing.MiniJavaTypeComputer

class UMiniJavaTypeComputer extends MiniJavaTypeComputer{

	public static val BERNOULLI_TYPE = factory.createClass => [name = 'bernoulliType']
	public static val GAUSSIAN_TYPE = factory.createClass => [name = 'gaussianType']

	override TypeDeclaration getType(TypeRef r) {
		switch r {
			GaussianRef: GAUSSIAN_TYPE
			BernoulliRef: BERNOULLI_TYPE
			default: super.getType(r)
		}
	}

	def dispatch TypeDeclaration typeFor(NewUObject e) {
		getType(e.type)	
	}
		
}