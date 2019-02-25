package duc.uscript.execution.interpreter

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import duc.uscript.uScript.Program
import duc.uscript.execution.State
import duc.uscript.uScript.Method

import static extension duc.uscript.execution.interpreter.statement.BlockAspect.*
import java.io.OutputStream
import duc.uscript.execution.ExecutionFactory
import duc.uscript.execution.interpreter.utils.OutputStreamListener

@Aspect(className=Program)
class ProgramAspect {
	public State state
	
	def void main() {
		_self.execute
	}
	
	private def Method getMainMethod() {
		return _self.elements
				.filter(Method)
				.findFirst[it.name == "main"]
	}
	
	def void initialize(OutputStream out) {
		val main = getMainMethod(_self)
		
		if(main === null) {
			throw new RuntimeException('''No main method found''')
		}
		
		val rootCtx = ExecutionFactory::eINSTANCE.createContext
		val state = ExecutionFactory::eINSTANCE.createState => [
			outputStream = ExecutionFactory::eINSTANCE.createOutputStream
			rootFrame = ExecutionFactory::eINSTANCE.createFrame => [
				rootContext = rootCtx
			]
			
			outputStream.eAdapters.add(new OutputStreamListener(out))
			
		]
		
		_self.state = state
	}
		
	def State execute() {
		val main = getMainMethod(_self)
				
		main.body.evaluateStatement(_self.state)
		return _self.state
	}
	
}