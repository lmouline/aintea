package duc.uscript.runner.standalone

import static duc.uscript.runner.standalone.Interpreter.*

class Runner {
	def static void main(String[] args) {
		execute("../../sample/tutorial/basics/types/arthimeticOperators.uscript", System.out)
	}
}