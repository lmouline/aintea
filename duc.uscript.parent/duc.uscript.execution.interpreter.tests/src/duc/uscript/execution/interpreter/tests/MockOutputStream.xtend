package duc.uscript.execution.interpreter.tests

import java.io.OutputStream
import java.io.IOException

class MockOutputStream extends OutputStream {
	
	override write(int b) throws IOException {
		//do nothing
	}
	
}