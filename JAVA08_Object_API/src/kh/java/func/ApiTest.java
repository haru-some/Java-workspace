package kh.java.func;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class ApiTest {
	public void math() {
		//싱글톤 패턴 : 프로그램이 시작 시 객체를 미리 만들어두고 만들어진 객체를 사용
		//다른클래스에서 작성된 메소드를 사용하려면
		//1. 객체생성
		//TestClass1 tc = new TestClass();
		//2. 생서된 객체에서 메소드 호출
		//tc.test1();
		
		//일부 객체는 객체를 생성하지않고 프로그램 시작 시 미리 만들어져 있음(사용준비가 모두끝난상태)
		// -> 여러 클래스에서 해당 객체를 사용할때 미리 만들어진 1개를 계속 사용하는 개념 -> 싱글톤 패턴
		//싱글톤 패턴으로 메소드를 만드는 방법 -> 메소드를 모두 static으로 생성하면 됨
		// -> 지금부터 사용할 Math 객체가 싱글톤 패턴으로 설계 -> 객체를 만들지않고 바로 사용
		
		//Math m = new Math();
		
		//abs(숫자) : 절대값(양수/음수의 부호를 모두 양수로 변환)
		int num1 = Math.abs(10);
		int num2 = Math.abs(-10);
		System.out.println(num1);
		System.out.println(num2);
		
		//올림,버림,반올림
		System.out.println(Math.ceil(10.1));//소수 첫째자리에서 올림
		System.out.println(Math.floor(10.9));//소수 첫째자리에서 버림
		System.out.println(Math.round(10.4));//소수 첫째자리에서 반올림
		System.out.println(Math.round(10.5));//소수 첫째자리에서 반올림
		//1.3456 -> 반올림해서 소수 2째자리까지 표현 -> 1.35
		//1.3456 -> 134.56
		System.out.println(Math.round(1.3456*100)/(double)100);
		
		//max(숫자1,숫자2) : 매개변수로 준 숫자 중 큰 수를 리턴
		System.out.println(Math.max(100, 200));
		System.out.println(Math.max(200, 100));
		//min(숫자1,숫자2) : 매개변수로 준 숫자 중 작은 수를 리턴
		System.out.println(Math.min(100, 200));
		System.out.println(Math.min(200, 100));
		
		//random() : 0.0 ~ 1.0 사이의 임의의 실수를 1개 리턴
		System.out.println(Math.random());
		
		Random abs = new Random();
		int num10 = abs.nextInt(10); 
	}
	public void test1() {
		//컴퓨터의 날짜 계산 방법 -> 1970년 1월 1일 0시부터 현재까지 몇 ms가 흘렀는지를 저장
		//저장된 데이터를 환산해서 날짜로 표기 -> 저장된 데이터 타입이 long
		Date date1 = new Date();//객체가 만들어지는 시점의 시스템 시간을 가져옴
		System.out.println(date1);
		//Date객체 생성 시 생성자의 파라미터로 정수(long타입)를 주면
		//해당 정수시간만큼 흐른 날짜를 계산해서 Date객체를 생성
		Date date2 = new Date(0);
		System.out.println(date2);
		Date date3 = new Date(24*60*60*1000);
		System.out.println(date3);
		
		//SimpleDateFormat : date타입을 원하는 형식의 문자열로 리턴해주는 객체
		//객체 생성 시 생성자에 원하는 패턴을 문자열로 전달
		/*
		 패턴만드는 방법
		 y(Y) : 년도
		 M : 월
		 d : 일
		 h(H) : 시간
		 m : 분
		 s(S) : 초
		 */
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str1 = sdf1.format(date1);
		System.out.println(str1);
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		String str2 = sdf2.format(date1);
		System.out.println(str2);
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss EEE");
		String str3 = sdf3.format(date1);
		System.out.println(str3);
	}
	public void test2() {
		//시간을 계산할때 사용하는 객체
		//Calendar
		//Calendar 객체 생성하는 방법
		//Calendar 클래스의 생성자는 접근제어 지시자가 protected여서 직접 객체생성이 불가능
		//대신 Calendar.getInstance(); 메소드가 static으로 작성되어 있어서 프로그램 시작시 사용준비가 끝난 상태
		//getInstance() 메소드를 사용하면 현재 메소드 실행시점의 시간을 캘린더객체로 만들어서 리턴
		Calendar today = Calendar.getInstance();//객체가 생성되는 순간의 시간을 캘린더객체로 생성
		//Calendar 객체에서 정보를 가져오는 방법 -> 인스턴스변수.get(알고싶은 정보);
		System.out.println(today.get(Calendar.YEAR));
		System.out.println(today.get(Calendar.MONTH)+1); //월(0~11로 제공) -> 보정작업
		System.out.println(today.get(Calendar.DATE));
		System.out.println(today.get(Calendar.AM_PM)); //AM : 0 / PM : 1
		System.out.println(today.get(Calendar.HOUR)); //시간
		System.out.println(today.get(Calendar.MINUTE)); //분
		System.out.println(today.get(Calendar.SECOND)); //초
		System.out.println(today.get(Calendar.MILLISECOND)); //밀리초
		System.out.println(today.get(Calendar.DAY_OF_WEEK)); //요일(1:일요일 ~ 7:토요일)
		System.out.println("--------------------------------------------------------");
		Calendar day1 = Calendar.getInstance();
		System.out.println(day1.get(Calendar.YEAR));
		System.out.println(day1.get(Calendar.MONTH)+1);
		System.out.println(day1.get(Calendar.DATE));
		System.out.println(day1.get(Calendar.DAY_OF_WEEK));
		//캘린더 객체의 정보를 변경 -> 2025/4/17
		//set(변경하고싶은정보, 변경할데이터)
		day1.set(Calendar.YEAR,2025);
		day1.set(Calendar.MONTH, 3);
		day1.set(Calendar.DATE, 17);
		System.out.println(day1.get(Calendar.YEAR));
		System.out.println(day1.get(Calendar.MONTH)+1);
		System.out.println(day1.get(Calendar.DATE));
		System.out.println(day1.get(Calendar.DAY_OF_WEEK));
		day1.set(2024, 11, 25);
		System.out.println(day1.get(Calendar.YEAR));
		System.out.println(day1.get(Calendar.MONTH)+1);
		System.out.println(day1.get(Calendar.DATE));
		System.out.println(day1.get(Calendar.DAY_OF_WEEK));
		System.out.println("--------------------------------------------------------");
		Calendar day2 = Calendar.getInstance();
		//getTimeInMillis() : 1970년 1월 1일 0시부터 day2까지 몇 ms가 지났는지 long타입으로 리턴
		long time = day2.getTimeInMillis();
		System.out.println("time : "+time);
		long days = time/(24*60*60*1000);
		System.out.println("days : "+days);
		System.out.println("years : "+days/365);
		System.out.println("--------------------------------------------------------");
		Date date1 = new Date(time+86400000);
		System.out.println(date1);
		Date date2 = new Date();
		System.out.println(date2);
		Date date3 = new Date(day1.getTimeInMillis());
		System.out.println(date3);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str1 = sdf.format(date1);
		String str2 = sdf.format(date2);
		String str3 = sdf.format(date3);
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		String str4 = day1.get(Calendar.YEAR)
				+"-"+(day1.get(Calendar.MONTH)+1)
				+"-"+day1.get(Calendar.DATE)
				+" "+day1.get(Calendar.HOUR)
				+":"+day1.get(Calendar.MINUTE)
				+":"+day1.get(Calendar.SECOND);
		System.out.println(str4);
	}
	public void dday() {
		Scanner sc = new Scanner(System.in);
		System.out.println("========== D-DAY 계산기 ==========");
		System.out.print("D-DAY [년도] 입력 : ");
		int year = sc.nextInt();
		System.out.print("D-DAY [월] 입력 : ");
		int month = sc.nextInt();
		System.out.print("D-DAY [일] 입력 : ");
		int date = sc.nextInt();
		
		Date todayDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		String todayString = sdf.format(todayDate);
		System.out.println("오늘 날짜 : "+todayString);
		
		Calendar dday = Calendar.getInstance();
		dday.set(year, month-1, date);
		//dday.set(Calendar.YEAR, year);
		//dday.set(Calendar.MONTH, month-1);
		//dday.set(Calendar.DATE, date);
		
		long ddayMs = dday.getTimeInMillis();
		Date ddayDate = new Date(dday.getTimeInMillis());
		String ddayString = sdf.format(ddayDate);
				
		System.out.println("dday 날짜 : "+ddayString);
		
		Calendar today = Calendar.getInstance();
		long todayMs = today.getTimeInMillis();
		
		long time = ddayMs-todayMs;
		long interDay = time/(24*60*60*1000);
		if(time > 0) {
			System.out.println(interDay+"일 남았습니다.");
		}else if(time < 0) {
			System.out.println(Math.abs(interDay)+"일 지났습니다.");
		}else {
			System.out.println("D-Day 입니다.");
		}
			
	}
	public void ddayTeacher() {
		Scanner sc = new Scanner(System.in);
		System.out.println("========== D-DAY 계산기 ==========");
		System.out.print("D-DAY [년도] 입력 : ");
		int year = sc.nextInt();
		System.out.print("D-DAY [월] 입력 : " );
		int month = sc.nextInt();
		System.out.print("D-DAY [일] 입력 : ");
		int date = sc.nextInt();
		Calendar today = Calendar.getInstance();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		
		long todayMs = today.getTimeInMillis();
		Date todayDate = new Date(todayMs);
		
		String todayString = sdf.format(todayDate);
		//Calendar dday = Calendar.getInstance();
		/*
		dday.set(Calendar.YEAR, year);
		dday.set(Calendar.MONTH, month-1);
		dday.set(Calendar.DATE, date);
		*/
		today.set(year, month-1, date);
		long ddayMs = today.getTimeInMillis();
		Date ddayDate = new Date(ddayMs);
		String ddayString = sdf.format(ddayDate);
		
		System.out.println("todayMs : "+todayMs);
		System.out.println("ddayMs : "+ddayMs);
		
		
		System.out.println("오늘 날짜 : " +todayString);
		System.out.println("dday 날짜 : "+ddayString);
		//두 날짜 사이에 몇 ms가 지났는지 계산
		long time = ddayMs - todayMs;
		long interDay = time/(1000*60*60*24);
		if(time > 0) {
			System.out.println(interDay+"일 남았습니다.");
		}else if(time < 0) {
			System.out.println(Math.abs(interDay)+"일 지났습니다.");
		}else {
			System.out.println("D-Day 입니다.");
		}
		
	}
	
	public void wrap1() {
		//Wrapper클래스 : 기본자료형을 참조형으로 사용할 수 있도록 포장하는 클래스
		//정수형 변수 선언 후 10 대입
		int num1 = 10;
		//Wrapper가 필요한경우 (int -> Integer)
		Integer num2 = new Integer(10);//기본형을 참조형으로 포장 -> boxing
		int num3 = num2.intValue();//wrapper로 감싸진 데이터를 다시 기본형으로 변환 -> unboxing
		
		//실수형 변수 선언 후 3.14 대입
		double d1 = 3.14;
		//Wrapper 사용 (double -> Double)
		Double d2 = new Double(3.14);//boxing
		double d3 = d2.doubleValue();
		
		//auto-boxing, auto-unboxing
		int num11 = 100;
		Integer num12 = 100;
		int num13 = num12;
		
		double d11 = 3.14;
		Double d12 = 3.14;
		double d13 = d12;
	}
	
	public void wrap2() {
		//wrapper 클래스 사용하는 경우     기본형 <-> 문자열 데이터 변환
		//1) 문자열로 되어있는 데이터를 기본자료형으로 변환하고 싶을 때
		String str1 = "100";
		System.out.println(str1+1);
		//변경하고 싶은 기본자료형의 wrapper클래스를 사용
		int num1 = Integer.parseInt(str1);
		System.out.println(num1+1);
		
		String str2 = "3.14";
		double d1 = Double.parseDouble(str2);
		System.out.println(d1+1);
		
		/*
		//정상적으로 변환이 불가능한 문자열값을 변환하려고하면 에러가 발생
		String str3 = "100a";
		int num2 = Integer.parseInt(str3);
		System.out.println(num2);
		*/
		//문자열 -> 문자
		String str4 = "ABCD";
		char ch = str4.charAt(0);
		
		//2) 기본자료형을 문자열로 바꾸는 경우
		int num2 = 100;
		double d2 = 3.14;
		//2-1) wrapper클래스 사용하는 방법
		String str5 = Integer.valueOf(num2).toString();
		String str6 = Double.valueOf(d2).toString();
		System.out.println(str5);
		System.out.println(str6);
		//2-2) String클래스 사용하는 방법
		String str7 = String.valueOf(num2);
		String str8 = String.valueOf(d2);
		
	}

}
