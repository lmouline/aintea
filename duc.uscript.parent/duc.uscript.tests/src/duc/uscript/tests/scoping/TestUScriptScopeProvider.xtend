package duc.uscript.tests.scoping

import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.junit.jupiter.api.^extension.ExtendWith
import org.eclipse.xtext.testing.InjectWith
import duc.uscript.tests.UScriptInjectorProvider
import com.google.inject.Inject
import org.eclipse.xtext.testing.util.ParseHelper
import duc.uscript.uScript.Program
import org.eclipse.xtext.scoping.IScopeProvider
import org.junit.jupiter.api.Test
import duc.uscript.uScript.Class
import duc.uscript.uScript.Method
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.junit.jupiter.api.Assertions
import duc.uscript.uScript.UScriptPackage
import duc.uscript.uScript.Assignment
import duc.uscript.uScript.ForStatement

@ExtendWith(InjectionExtension)
@InjectWith(UScriptInjectorProvider)
class TestUScriptScopeProvider {
	@Inject extension ParseHelper<Program>
	@Inject extension IScopeProvider
	
	private def assertScope(EObject ctx, EReference ref, String expected) {
		Assertions.assertEquals(expected, ctx.getScope(ref).allElements.map[name].join(", "))
	}
	
	@Test
	def void testScopeProviderForSymbols() {
		val script = '''
			package myPack
			
			class A{}
			
			class B {
				A f;
				A f2;
				
				A m(A p) {
					A v1 = null;
					if (true) {
						A v2 = null;
						A v3 = null;	
					}	
					A v4 = null;
					return null;
				}
			}
		'''.parse
		
		val classB = script.elements.get(1) as Class
		val methodM = classB.members.get(2) as Method
		val body = methodM.body.eAllContents
		val varDcls = body.filter(Assignment)
		
		// scope for A v1 = null;
		assertScope(varDcls.next, UScriptPackage.eINSTANCE.symbolRef_Symbol, "p, f, f2")		
		// scope for A v2 = null;
		assertScope(varDcls.next, UScriptPackage.eINSTANCE.symbolRef_Symbol, "v1, p, f, f2")
		// scope for A v3 = null;
		assertScope(varDcls.next, UScriptPackage.eINSTANCE.symbolRef_Symbol, "v2, v1, p, f, f2")
		// scope for A v4 = null;
		assertScope(varDcls.next, UScriptPackage.eINSTANCE.symbolRef_Symbol, "v1, p, f, f2")	
	}
	
	@Test
	def void testScpProvForSymbField() {
		val script = '''
			package myPack
			
			class A {
				int a;
			}
			
			class B extends A{
				int b;
				
				void f() {
					B bC = new B();
					int i1 = a;
					int i2 = b;
				}
			}
		'''.parse
		
		val classB = script.elements.get(1) as Class
		val f = classB.members.get(1) as Method
		val fSttmts = f.body.statements
		
		//scope for int i1 = a;
		assertScope(fSttmts.get(1), UScriptPackage.eINSTANCE.symbolRef_Symbol, "bC, b, a")
		
		//scope for i2 = b;
		assertScope(fSttmts.get(2), UScriptPackage.eINSTANCE.symbolRef_Symbol, "bC, i1, b, a")
	}
	
	@Test
	def void testScpProvForFieldAcc() {
		val script = '''
			package myPack
			
			class A {
				int a;
			}
			
			class B extends A{
				int b;
			}
			
			class C {
				int c;
			}
			
			void f() {
				A a = new A();
				B b = new B();
				C c = new C();
				int i1 = a.a;
				int i2 = b.b;
				int i3 = b.a;
				int i4 = c.c;
			}
		'''.parse
		
		val f = script.elements.get(3) as Method
		val fSttmts = f.body.statements
		
		
		//scope for int i1 = a.a;
		var assgmt = fSttmts.get(3) as Assignment
		assertScope(assgmt.value,UScriptPackage.eINSTANCE.fieldAccess_Field, "a")
		
		//scope for int i2 = b.b;
		assgmt = fSttmts.get(4) as Assignment
		assertScope(assgmt.value, UScriptPackage.eINSTANCE.fieldAccess_Field, "b, a")
		
		//scope for int i3 = b.a;
		assgmt = fSttmts.get(5) as Assignment
		assertScope(assgmt.value, UScriptPackage.eINSTANCE.fieldAccess_Field, "b, a")
		
		//scope for int i4 = c.c;
		assgmt = fSttmts.get(6) as Assignment
		assertScope(assgmt.value, UScriptPackage.eINSTANCE.fieldAccess_Field, "c")
	}
	
	@Test
	def void testScpProvForMethodAcc() {
		val script = '''
			package myPack
			
			class A {
				int a(){}
			}
			
			class B extends A{
				int b(){}
			}
			
			class C {
				int c(){}
			}
			
			void f() {
				A a = new A();
				B b = new B();
				C c = new C();
				int i1 = a.a();
				int i2 = b.b();
				int i3 = b.a();
				int i4 = c.c();
			}
		'''.parse
		
		val f = script.elements.get(3) as Method
		val fSttmts = f.body.statements
		
		
		//scope for int i1 = a.a();
		var assgmt = fSttmts.get(3) as Assignment
		assertScope(assgmt.value,UScriptPackage.eINSTANCE.methodCall_Method, "a")
		
		//scope for int i2 = b.b();
		assgmt = fSttmts.get(4) as Assignment
		assertScope(assgmt.value, UScriptPackage.eINSTANCE.methodCall_Method, "b, a")
		
		//scope for int i3 = b.a();
		assgmt = fSttmts.get(5) as Assignment
		assertScope(assgmt.value, UScriptPackage.eINSTANCE.methodCall_Method, "b, a")
		
		//scope for int i4 = c.c();
		assgmt = fSttmts.get(6) as Assignment
		assertScope(assgmt.value, UScriptPackage.eINSTANCE.methodCall_Method, "c")
	}
	
	@Test
	def void testScopeProviderForLoop() {
		val script = '''
			package myPack
			
			void m(int a) {
				for(int i=0; i<0; i=i+1) {
					int a = 0;	
				}
			}
		'''.parse
		
		val methodM = script.elements.get(0) as Method
		val forLoop = methodM.body.eAllContents.filter(ForStatement).head
		val asgmt = forLoop.block.statements.get(0)
		
		assertScope(asgmt, UScriptPackage.eINSTANCE.symbolRef_Symbol, "i, a")
	}
	
	@Test
	def void testScopeProviderForUTypes() {
		val script = '''
			package myPack
			
			void m() {
				Bernoulli<bool> b = new Bernoulli<bool>(true, 0.1);
				Gaussian<double> g = new Gaussian<double>(0,0);
				Rayleigh<double> r = new Rayleigh<double>(0,0);
				DiracDeltaFct<double> d = new DiracDeltaFct<double>(0,0);
				Binomial<int> bin = new Binomial<int>(0,0);
				
				bool b_v = b.value;
				double g_v = g.value;
				double r_v = r.value;
				double d_v = d.value;
				double bin_v = bin.value;
			}
		'''.parse
		
		val m = script.elements.get(0) as Method
		val fSttmts = m.body.statements
		
		var Assignment assgmt;
		assgmt = fSttmts.get(5) as Assignment
		assertScope(assgmt.value, UScriptPackage.eINSTANCE.fieldAccess_Field, "value, confidence, probability")
		
		assgmt = fSttmts.get(6) as Assignment
		assertScope(assgmt.value, UScriptPackage.eINSTANCE.fieldAccess_Field, "value, confidence")
		
		assgmt = fSttmts.get(7) as Assignment
		assertScope(assgmt.value, UScriptPackage.eINSTANCE.fieldAccess_Field, "value, confidence")
		
		assgmt = fSttmts.get(8) as Assignment
		assertScope(assgmt.value, UScriptPackage.eINSTANCE.fieldAccess_Field, "value, confidence")
		
		assgmt = fSttmts.get(9) as Assignment
		assertScope(assgmt.value, UScriptPackage.eINSTANCE.fieldAccess_Field, "value, confidence")
	}
	
	@Test
	def void testScopeProviderForUDist() {
		val script = '''
			void m() {
				Bernoulli b;						
				double g_v = b.probability;
			}
		'''.parse
		
		val m = script.elements.get(0) as Method
		val fSttmts = m.body.statements
		
		var Assignment assgmt;
		assgmt = fSttmts.get(1) as Assignment
		assertScope(assgmt.value, UScriptPackage.eINSTANCE.fieldAccess_Field, "probability")
	}
}