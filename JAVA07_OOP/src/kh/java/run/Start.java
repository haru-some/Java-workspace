package kh.java.run;

import kh.java.test1.MethodTest1;
import kh.java.test2.TV;

public class Start {

	public static void main(String[] args) {
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
		
		
	}

}
