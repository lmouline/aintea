package duc.uscript.execution.interpreter.tests

import org.junit.jupiter.api.^extension.ExtendWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.InjectWith
import duc.uscript.tests.UScriptInjectorProvider
import com.google.inject.Inject
import org.eclipse.xtext.testing.util.ParseHelper
import duc.uscript.uScript.Script
import org.junit.jupiter.api.Test
import java.io.OutputStream
import duc.uscript.execution.State

import static extension duc.uscript.execution.interpreter.ScriptAspect.*
import static org.junit.jupiter.api.Assertions.assertArrayEquals


@ExtendWith(InjectionExtension)
@InjectWith(UScriptInjectorProvider)
class TestArthExpression {
	
	@Inject extension ParseHelper<Script>
	
	val OutputStream DEFAULT_OUT = new MockOutputStream()
	
	val String[] EXPECTED_ADD = #["8", "9", "10", "11", "12.0", "13.0", 
									"8", "9", "10", "11", "12.0", "13.0"]
	val String[] EXPECTED_MINUS = #["6", "5", "4", "3", "2.0", "1.0", 
									"-6", "-5", "-4", "-3", "-2.0", "-1.0"]
	val String[] EXPECTED_MULT = #["7", "14", "21", "28", "35.0", "42.0", 
									"7", "14", "21", "28", "35.0", "42.0"]
	val String[] EXPECTED_DIV = #["7", "3", "2", "1", "1.4", "1.1666666666666667", 
									"0", "0", "0", "0", "0.7142857142857143", "0.8571428571428571"]
	
	private def void genericTest(String type, String op, String[] expected) {
		val script = '''
		package test
		
		void main() {
			byte b = 1;
		    short s = 2;
		    int i = 3;
		    long l = 4L;
		    float f = 5.0;
		    double d = 6.0;
		    
		    «type» b1 = 7;
		
			byte add_1 = b1 «op» b;
			short add_2 = b1 «op» s;
			int add_3 = b1 «op» i;
			long add_4 = b1 «op» l;
			float add_5 = b1 «op» f;
			double add_6 = b1 «op» d;
		
			byte add_7 = b «op» b1;
			short add_8 = s «op» b1;
			int add_9 = i «op» b1;
			long add_10 = l «op» b1;
			float add_11 = f «op» b1;
			double add_12 = d «op» b1;
			
			print(add_1);
			print(add_2);
			print(add_3);
			print(add_4);
			print(add_5);
			print(add_6);
			print(add_7);
			print(add_8);
			print(add_9);
			print(add_10);
			print(add_11);
			print(add_12);
		} 
		'''.parse
				
		script.initialize(DEFAULT_OUT)
		val State state = script.execute
		assertArrayEquals(expected, state.outputStream.stream.toArray)
	}
	
	@Test
	def void testByte() {
		genericTest("byte", "+", EXPECTED_ADD)
		genericTest("byte", "-", EXPECTED_MINUS)
		genericTest("byte", "*", EXPECTED_MULT)
		genericTest("byte", "/", EXPECTED_DIV)
	}
	
	@Test
	def void testShort() {
		genericTest("short", "+", EXPECTED_ADD)
		genericTest("short", "-", EXPECTED_MINUS)
		genericTest("short", "*", EXPECTED_MULT)
		genericTest("short", "/", EXPECTED_DIV)
	}
	
	@Test
	def void testInt() {
		genericTest("int", "+", EXPECTED_ADD)
		genericTest("int", "-", EXPECTED_MINUS)
		genericTest("int", "*", EXPECTED_MULT)
		genericTest("int", "/", EXPECTED_DIV)
	}
	
	@Test
	def void testLong() {
		genericTest("long", "+", EXPECTED_ADD)
		genericTest("long", "-", EXPECTED_MINUS)
		genericTest("long", "*", EXPECTED_MULT)
		genericTest("long", "/", EXPECTED_DIV)
	}
	
	@Test
	def void testFoat() {
		genericTest("float", "+", EXPECTED_ADD)
		genericTest("float", "-", EXPECTED_MINUS)
		genericTest("float", "*", EXPECTED_MULT)
		genericTest("float", "/", EXPECTED_DIV)
	}
	
	@Test
	def void testDouble() {
		genericTest("double", "+", EXPECTED_ADD)
		genericTest("double", "-", EXPECTED_MINUS)
		genericTest("double", "*", EXPECTED_MULT)
		genericTest("double", "/", EXPECTED_DIV)
	}
	
	private def void genericStringTest(String type, String value) {
		val script = '''
		package test
		
		void main() {
			byte b = 1;
		    short s = 2;
		    int i = 3;
		    long l = 4L;
		    float f = 5.0;
		    double d = 6.0;
		    char c = 'c';
		    string str = "...";
		    bool bo = true;
		    
		    «type» b1 = «value»;
		    
		    string add_1 = b1 + b;
		    string add_2 = b1 + s;
		    string add_3 = b1 + i;
		    string add_4 = b1 + l;
		    string add_5 = b1 + f;
		    string add_6 = b1 + d;
		    string add_7 = b1 + c;
		    string add_8 = b1 + str;
		    string add_9 = b1 + bo;
		    
		    string add_10 = b + b1;
		    string add_11 = s + b1;
		    string add_12 = i + b1;
		    string add_13 = l + b1;
		    string add_14 = f + b1;
		    string add_15 = d + b1;
		    string add_16 = c + b1;
		    string add_17 = str + b1;
		    string add_18 = bo + b1;
		    
		    print(add_1);
		    print(add_2);
			print(add_3);
			print(add_4);
			print(add_5);
			print(add_6);
			print(add_7);
			print(add_8);
			print(add_9);
			
			print(add_10);
			print(add_11);
			print(add_12);
			print(add_13);
			print(add_14);
			print(add_15);
			print(add_16);
			print(add_17);
			print(add_18);
		} 
		'''.parse
				
		script.initialize(DEFAULT_OUT)
		val State state = script.execute
		assertArrayEquals(
			#["s1", "s2", "s3", "s4", "s5.0", "s6.0", "sc", "s...", "strue", 
				"1s", "2s", "3s", "4s", "5.0s", "6.0s", "cs", "...s", "trues"
			], 
			state.outputStream.stream.toArray
		)
	}
	
	@Test
	def void testAddString() {
		genericStringTest("string", "\"s\"")
	}
	
	@Test
	def void testAddChar() {
		genericStringTest("char", "'s'")
	}
	
}