package kh.java.func;

public class TestData {
	private int num;
	private String str;
	
	public TestData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TestData(int num, String str) {
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
		return "TestData [num=" + num + ", str=" + str + "]";
	}
}
