package kh.java.test4;

public class Aclass {
	private int num;
	private String str;
	
	public Aclass() {
		//super(): 부모생성자를 지칭
		super();
		// TODO Auto-generated constructor stub
	}
	public Aclass(int num, String str) {
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
	
	
	public void print() {
		System.out.println("나는 AClass야!!!!");
	}
	
	
}
