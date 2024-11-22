package kh.java.test5;

public class TestMgr {
	public void main() {
		//TestClass1은 추상클래스(미완성클래스)이므로 객체 생성 불가능
		//TestClass1 tc1 = new TestClass1();
		//TestClass2는 TestClass1을 상속해서 미완성된 메소드를 완성했기때문에 객체 생성 가능
		TestClass2 tc2 = new TestClass2();
		tc2.testMethod1();
		tc2.testMethod2();
		//추상클래스는 미완성클래스이므로 객체생성은 불가능
		//대신 -> 다형성의 부모타입으로는 사용이 가능
		TestClass1 tc1 = new TestClass2();
		tc1.testMethod1();
		tc1.testMethod2();
		
	}
}
