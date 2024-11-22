package kh.java.test5;

//abstract 메소드를 포함한 클래스는 abstract 클래스
public abstract class TestClass1 {
	private int num;

	public TestClass1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestClass1(int num) {
		super();
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public void testMethod1() {
		System.out.println("test - 1");
	}
	//메소드에 코드 실행부분이 없음 -> 추상메소드 -> 코드실행부분을 의도적으로 만들지 않았으면 abstract 키워드 사용
	public abstract void testMethod2();
	
}
