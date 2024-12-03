package kh.java.func;

import java.io.Serializable;

//Serializable 마커인터페이스로 해당 객체는 직렬화가 가능함을 표시
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	//transient가 붙은 변수는 직렬화, 역직렬화에서 제외
	//private transient String pw;
	private String pw;
	private String name;
	private int age;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String id, String pw, String name, int age) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
