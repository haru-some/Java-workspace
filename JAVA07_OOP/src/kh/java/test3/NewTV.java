package kh.java.test3;

public class NewTV {
	//속성 : 크기, 전원, 채널, 볼륨
	private int inch;
	private boolean power;
	private int channel;
	private int volume;
	
	//생성자 : 객체를 생성할때만 호출하는 메소드
	//생성자 만드는 방법
	//1. 접근제어지시자 public
	//2. 리턴타입은 없음(void가아니라 그냥없음)
	//3. 메소드이름 : 클래스명과 동일
	//4. 매개변수는 생성자의 역할에 따라 다름
	
	//만약 클래스 생성할 때 생성자를 1개도작성하지 않으면 JVM이 실행할 때 기본생성자를 자동으로 생성
	//단, 생성자를 한개라도 작성하면 JVM은 기본생성자를 작성하지 않음
	//생성자는 필요에 따라서 오버로딩을 통해서 여러개 만드는 것이 가능
	
	//기본생성자 : 생성자에 매개변수가 없고, 값을 초기화하지않고 객체를 생성하는 역할만 하는 생성자
	public NewTV() {
	
	}
	//모든 전역변수를 초기화하는 생성자
	public NewTV(int inch, boolean power, int channel, int volume) {
		this.inch = inch;
		this.power = power;
		this.channel = channel;
		this.volume = volume;
	}
	//기본생성자, 모든 매개변수를 초기화하는 생성자는 무조건 만들고 그외 추가로 필요한걸 더 생성
	public NewTV(int inch) {
		this.inch = inch;
	}
	
	//보통 (변수 -> 생성자 -> 메소드 순)
	
	//변수에 private이 붙으면 외부클래스에서는 해당 변수에 값을 가져가거나, 값을 대입하는 행동이 불가능
	//변수를 만들어놓고 사용할 수 없으면 변수를 만든 목적이 사라짐
	//-> 변수에 데이터를 가져오거나(getter), 변수에 데이터를 대입(setter)하는 메소드를 생성
	
	//getter 생성(외부에서 이 메소드를 이용해서 전역변수의 데이터를 가져오기 위한 메소드)
	//1. 접근제어지시자 : public
	//2. 리턴타입을 되돌려줄 자료형과 동일
	//3. 메소드이름 -> get변수명 -> 카멜표기법
	//4. 매개변수는 없음
	//5. 소스코드는 해당 전역변수 값을 리턴
	public int getInch() {
		return inch;
	}
	//boolean형 데이터의 getter 생성 시 메소드 이름을 get변수명 -> is변수명
	public boolean isPower() {
		return power;
	}
	public int getChannel() {
		return channel;
	}
	public int getVolume() {
		return volume;
	}
	
	//setter 생성(외부에서 이 메소드를 이용해서 전역변수의 데이터를 수정하기위한 메소드)
	//1. 접근제어지시자 : public
	//2. 리턴타입 : void
	//3. 메소드이름 : set변수명 -> 카멜표기법
	//4. 매개변수 : 전역변수와 동일한 자료형으로 1개
	//5. 소스코드 : 매개변수로 받은 데이터를 전역변수에 대입
	/*
	public void setInch(int inch) {
		//this.변수 -> 해당 클래스의 전역변수를 지칭하는 키워드
		this.inch = inch;
	}
	*/
	public void setPower(boolean power) {
		this.power = power;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
}















