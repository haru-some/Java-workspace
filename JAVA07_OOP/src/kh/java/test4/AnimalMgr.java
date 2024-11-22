package kh.java.test4;

public class AnimalMgr {
	public void main() {
		Animal a = new Animal();
		Tiger t = new Tiger();
		a.walk();
		t.walk();
		t.hunt();
		Animal aa = new Tiger();
		aa.walk();
		
		/*
		Animal a1 = new Animal();
		Tiger t1 = new Tiger();
		Rabbit r1 = new Rabbit();
		//다형성 : 부모타입 변수에 자식타입객체를 저장
		Animal a2 = new Tiger(); //자식타입 객체를 부모타입인척하는 상태 -> up casting
		Animal a3 = new Rabbit(); //up casting
		//upcasting을 하게되면 자식타입객체만 가지고있는 메소드나 변수는 사용 할 수 없음
		//-> 저장해준 자료형에 존재하는 기능만 사용 할 수 있음
		t1.walk();
		t1.hunt();
		a2.walk();
		//a2.hunt();//hunt();는 Tiger에만 존재하는 기능이고 Animal에 없으므로 사용 불가능
		//up casting으로 사용못하는 기능을 사용하려면 -> down casting
		Tiger t2 = (Tiger)a2;
		t2.hunt();
		
		r1.walk();
		r1.jump();
		a3.walk();
		//down casting
		Rabbit r2 = (Rabbit)a3;
		r2.jump();
		//다형성 적용 불가능한 경우 자식타입 변수에 부모타입 객체를 저장하려는 경우
		//Tiger t3 = new Animal();
		//Rabbit r3 = new Animal();
		//Tiger t3 = new Rabbit();
		//Rabbit r3 = new Tiger();
		
		Animal a4 = new Tiger();
		Animal a5 = new Rabbit();
		
		Tiger t3 = (Tiger)a5; //주의 필요
		t3.hunt();
		*/
	}
}
