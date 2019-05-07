package duc.uscript.runner.standalone

import static duc.uscript.runner.standalone.Interpreter.*

class Runner {
	def static void main(String[] args) {
//		execute("../../sample/tutorial/basics/types/ubool/indepNonDisjoint.uscript", System.out)

		execute("../../sample/tutorial/creos/situation1/runner.aintea", 
				System.out,
				"../../sample/tutorial/creos/situation1")
				
				
	}
}