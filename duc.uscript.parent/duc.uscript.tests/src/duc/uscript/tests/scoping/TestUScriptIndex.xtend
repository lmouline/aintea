package duc.uscript.tests.scoping

import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.junit.jupiter.api.^extension.ExtendWith
import org.eclipse.xtext.testing.InjectWith
import duc.uscript.tests.UScriptInjectorProvider
import org.eclipse.xtext.testing.util.ParseHelper
import duc.uscript.uScript.Script
import com.google.inject.Inject
import duc.uscript.scoping.UScriptIndex
import org.junit.jupiter.api.Test
import static org.junit.jupiter.api.Assertions.assertEquals

@ExtendWith(InjectionExtension)
@InjectWith(UScriptInjectorProvider)
class TestUScriptIndex {
	
	@Inject extension ParseHelper<Script>
	@Inject extension UScriptIndex
	
	@Test
	def void testExportedEObjectDescriptions() {
		val script = '''
		package myPack
		
		class A {}
		
		class B {
			A a;
			A f(A p) {
				A v;
				return null;	
		 	}
		}
		
		void C(A p){
			A a;
		}
		'''.parse
		
		val expectedEODec = "myPack, myPack.A, myPack.B, myPack.B.a, myPack.B.f, myPack.B.f.p, myPack.B.f.v, myPack.C, myPack.C.p, myPack.C.a"
		val actual = script.exportedEObjectDescriptions.map[qualifiedName].join(", ")
		assertEquals(expectedEODec, actual)
		
		val expectedClasses = "myPack.A, myPack.B"
		val actualClasses = script.exportedClassesEObjectDescriptions.map[qualifiedName].join(", ")
		assertEquals(expectedClasses, actualClasses)
		
		val expectedMethods = "myPack.C"
		val actualMethods = script.exportedMethodsEObjectDescriptions.map[qualifiedName].join(", ")
		assertEquals(expectedMethods, actualMethods)
	}
	
	@Test
	def void testMultiFilesVisibility() {
		val firstScript = '''
			package my.pack.a
			
			class A1{
				void a1(){}
			}
			class A2{}
			
			void m1(){}
			void m1_1(){}
		'''.parse
		
		val secondScript = '''
			package my.pack.b
			
			class B1{}
			class B2{
				void b2(){}
			}
			
			void m2(){}
		'''.parse(firstScript.eResource.resourceSet)
		
		val thirdScript = '''
			package my.pack.c
			
			import my.pack.a.A2
			import my.pack.a.m1
			import my.pack.b.*
			
			class C1 extends my.pack.a.A1 {
				A2 a2;
				B1 b1;
				B2 b2;
			}
			
			void m3(){}
		'''.parse(firstScript.eResource.resourceSet)
		
		val expectedVisibleClassesFirst = "my.pack.a.A1, my.pack.a.A2"
		val expectedVisibleMethodFirst = "my.pack.a.m1, my.pack.a.m1_1"
		val actualClassesFirst = firstScript.visibleClassesDescriptions.map[qualifiedName].join(", ")
		val actualMethodsFirst = firstScript.visibleMethodsDescriptions.map[qualifiedName].join(", ")
		assertEquals(expectedVisibleClassesFirst, actualClassesFirst)
		assertEquals(expectedVisibleMethodFirst, actualMethodsFirst)
		
		val expectedVisibleClassesSecond = "my.pack.b.B1, my.pack.b.B2"
		val expectedVisibleMethodSecond = "my.pack.b.m2"
		val actualClassesSecond = secondScript.visibleClassesDescriptions.map[qualifiedName].join(", ")
		val actualMethodsSecond = secondScript.visibleMethodsDescriptions.map[qualifiedName].join(", ")
		assertEquals(expectedVisibleClassesSecond, actualClassesSecond)
		assertEquals(expectedVisibleMethodSecond, actualMethodsSecond)
		
		val expectedVisibleClassesThird = "my.pack.a.A2, my.pack.b.B1, my.pack.b.B2, my.pack.c.C1"
		val expectedVisibleMethodThird = "my.pack.a.m1, my.pack.b.m2, my.pack.c.m3"
		val actualClassesThird = thirdScript.visibleClassesDescriptions.map[qualifiedName].join(", ")
		val actualMethodsThird = thirdScript.visibleMethodsDescriptions.map[qualifiedName].join(", ")
		assertEquals(expectedVisibleClassesThird, actualClassesThird)
		assertEquals(expectedVisibleMethodThird, actualMethodsThird)
	}
	
}