package kh.java.run;
//다른 클래스에 있는 메소드를 실행하는 방법
//1. import : 실행하고싶은 클래스의 위치를 알려줌
//import 패키지경로.클래스이름;
import kh.java.function.FunctionClass;

//실행클래스 : 실행메소드를 포함하고 있는 클래스
//실행클래스는 한개의 프로젝트에 반드시 하나만 생성!
public class Start {

	//실행메소드(메인메소드)
	// : 프로젝트를 실행하고 싶을 때 여러 메소드 중 실행되는 단 1개의 메소드
	public static void main(String[] args) {
		//2. 해당클래스의 별명 지정
		//클래스이름 별명 = new 클래스이름();
		FunctionClass fc = new FunctionClass();
		//3. 메소드 실행 방법 : 별명.메소드이름();
		fc.test5();
	}

}
