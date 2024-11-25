package kh.java.func;

public class TestClass1 implements Cloneable {
	private int num;
	private String str;
	
	public TestClass1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TestClass1(int num, String str) {
		super();
		this.num = num;
		this.str = str;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	@Override
	public String toString() {
		//일반적으로 VO타입의 클래스인경우 전역변수에 어떤값이 있는지 출력하는 형태로 작성
		String result = "TestClass1(num : "+num+", str : "+str+")";
		return result;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
}
