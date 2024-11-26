package kh.java.func;

public class TestClass {
	public void test1() {
		GenericEx1 ge1 = new GenericEx1();
		ge1.setData1(100);
		ge1.setData2("문자열");
		//ge1.setData1("str");
		//만약 GenericEx1과 나머지는 모두 같은데 data1의 변수 타입만 String으로 쓰고싶은경우
		//-> String으로 data1을 선언한 클래스를 하나 새로 생성 -> GenericEx2 새로생성
		GenericEx2 ge2 = new GenericEx2();
		ge2.setData1("문자열");
		//GenericEx3클래스의 data1변수의 자료형을 String으로 지정하면서 객체 생성
		GenericEx3<String> ge3 = new GenericEx3<String>();
		ge3.setData1("문자열");
		//GenericEx3클래스의 data1변수의 자료형을 int로 지정하면서 객체 생성
		//Generic으로 내부에서 사용할 자료형을 설정할때는 반드시 참조자료형으로 설정(기본형 사용 불가능)
		//그럼에도 기본형을 사용하고 싶으면? -> 기본형을 참조형으로 변경해서 사용 -> Wrapper클래스
		GenericEx3<Integer> ge4 = new GenericEx3<Integer>();
		ge4.setData1(100);
		int num = ge4.getData1();
		//GenericEx4 객체 생성 -> Generice이 2개 적용 -> 2개 자료형 모두 기입
		GenericEx4<String, Integer> ge5 = new GenericEx4<String, Integer>();
		GenericEx4<String, String> ge6 = new GenericEx4<String, String>();
		ge5.getData1();
	}
	
	public void test2() {
		Tiger t = new Tiger();
		Object o1 = (Object)t;
		//AnimalMgr1의 data변수는 Object타입 -> 만든 Tiger객체를 넣을때 upcasting해서 데이터를 입력
		AnimalMgr1 am1 = new AnimalMgr1(o1); 
		Rabbit r = new Rabbit();
		AnimalMgr1 am2 = new AnimalMgr1(r);
		
		//AnimalMgr1에서 꺼낸 data는 실제로는 Tiger객체지만 지금은 업캐스팅 되어서 -> Object형식
		Object o2 = am1.getData();
		//Tiger객체에만 작성된 고유기능을 사용하려면 -> 다운캐스팅 후 사용
		Tiger t2 = (Tiger)o2;
		t2.tigerFunction();
		t2.getHp();
		
		Object o3 = am2.getData();
		//Rabbit객체에 작성된 고유기능을 사용하려면 -> 다운캐스팅 후 사용
		Rabbit r2 = (Rabbit)o3;
		r2.rabbitFunction();
		r2.getHp();
		
	}
	
	public void test3() {
		Tiger t1 = new Tiger();
		Rabbit r1 = new Rabbit();
		//AnimalMgr2의 data변수는 자료형이 Animal타입으로 Tiger, Rabbit을 업캐스팅해서 대입
		AnimalMgr2 am1 = new AnimalMgr2(t1);
		AnimalMgr2 am2 = new AnimalMgr2(r1);
		//am1의 data에 변수에는 실제로는 Tiger객체가 들어있지만, 업캐스팅되어서 Animal타입인척
		Animal a1 = am1.getData();
		a1.getHp(); //Animal객체가 갖고있는 메소드는 바로 사용 가능
		//a1.tigerFunction();//Tiger만 가지고있는 고유기능은 사용 불가능 -> 다운캐스팅 후 사용
		Tiger t2 = (Tiger)a1;
		t2.tigerFunction();
		
		Animal a2 = am2.getData();
		a2.getHp();
		//rabbitFunction()을 사용하고싶으면 -> 다운캐스팅
		Rabbit r2 = (Rabbit)a2;
		r2.rabbitFunction();
	}
	
	public void test4() {
		Tiger t1 = new Tiger();
		Rabbit r1 = new Rabbit();
		
		AnimalMgr3<Tiger> am1 = new AnimalMgr3<Tiger>(t1);
		
		AnimalMgr3<Rabbit> am2 = new AnimalMgr3<Rabbit>(r1);
		
		Tiger t2 = am1.getData();
		t2.getHp();
		t2.tigerFunction();
		
		Rabbit r2 = am2.getData();
		r2.getHp();
		r2.rabbitFunction();
		
		
	}
}
