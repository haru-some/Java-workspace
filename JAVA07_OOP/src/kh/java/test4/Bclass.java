package kh.java.test4;

public class Bclass extends Aclass{
	
	private int data;
	
	//Bclass의 생성자에는 super()가 모두 존재(작성하지 않아도 기본적으로 동작)
	//-> Bclass는 Aclass를 상속했고 삭속되면 Aclass가 생성된 후 Bclass가 만들어져야함
	//부모객체가 생성되기전에 다른코드가 동작할 수 없음
	//super()로 부모생성자 호출 전에 다른 코드가 올 수 없음

	public Bclass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bclass(int num, String str) {
		super(num, str);
		// TODO Auto-generated constructor stub
	}

	public Bclass(int data) {
		super();
		this.data = data;
	}
	
	public Bclass(int num, String str, int data) {
		super(num, str);
		//setNum(num);
		//setStr(str);
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
	public void testMethod() {
		data = 1;
		//상속받은 변수도 private인경우 자식에서 접근 불가능
		//상속받은 private 변수를 사용하려면 자식에서도 getter/setter
		setNum(100);
		setStr("data");
	}
	
	@Override
	public void print() {
		System.out.println("나는 BClass야!!!!");
	}
}
