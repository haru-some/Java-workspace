package kh.java.run;

import kh.java.test1.MethodTest1;
import kh.java.test2.TV;
import kh.java.test3.NewTV;

public class Start {

	public static void main(String[] args) {
		NewTV tv1 = new NewTV(100);
		//현재 볼륨을 출력하고 싶으면
		//System.out.println(tv1.volume);//volume변수가 private이어서 접근 불가능
		//해당 변수 값을 얻어오고싶으면 -> 해당변수의 getter 호출
		int volume = tv1.getVolume();
		System.out.println(volume);
		//볼륨값을 변경하고싶으면
		//tv1.volume = 10;//volume변수가 private이어서 접근 불가능
		//해당 변수의 값을 수정하고싶으면 -> 해당변수의 setter를 호출
		tv1.setVolume(10);
		System.out.println(tv1.getVolume());
		
		int inch = tv1.getInch();
		System.out.println("내 TV의 크기 : "+inch);
		
		/*
		TV tv1 = new TV();
		TV tv2 = new TV();
		TV tv3 = new TV();
		//tv1.volume = -10; // volume변수는 private선언이 되어있음 -> 외부에서는 접근 불가능
		//tv1.channel = 10;
		
		tv1.volume = 20;
		
		tv2.volume = 15;
		
		tv3.volume = 3;
		
		System.out.println("TV1 시작");
		tv1.tvStart();		
		System.out.println("TV2 시작");
		tv2.tvStart();
		System.out.println("TV3 시작");
		tv3.tvStart();
		*/
		
	}

}
