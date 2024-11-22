package kh.java.test5;

public abstract class TestClass3 {
	//추상(abstract)메소드가 없어도 객체생성을 막기위해서 추상클래스로 선언 가능
	private int num;

	public TestClass3() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestClass3(int num) {
		super();
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public void test1() {
		System.out.println("test-11");
	}
	
}
