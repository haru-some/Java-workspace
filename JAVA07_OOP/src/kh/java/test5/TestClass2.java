package kh.java.test5;

public class TestClass2 extends TestClass1{
	
	//추상클래스를 상속하면 바로 에러발생 -> 내부의 미완성된 메소드가 존재 -> 오버라이딩 강제화
	//상속받은 메소드 중 추상메소드를 구현해야 해당 클래스 사용 가능
	
	@Override
	public void testMethod2() {
		System.out.println("test - 2");
	}
	
	public void main() {
		//TestClass1은 추상클래스(미완성클래스)이므로 객체 생성 불가능
		//TestClass1 tc1 = new TestClass1();
		
	}
	
}
