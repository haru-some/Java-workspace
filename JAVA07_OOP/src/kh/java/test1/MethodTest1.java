package kh.java.test1;

import java.util.Scanner;

public class MethodTest1 {
	
	public void test1() {
		System.out.println("메소드 테스트1");
		test2();
	}
	protected void test2() {
		System.out.println("메소드 테스트2");
		test3();
	}
	private void test3() {
		System.out.println("메소드 테스트3");
		test1();
	}
	public void test4() {
		System.out.println("메소드 테스트4");
		int num = test5();
		System.out.println("num : "+num);
		String str = test6();
		System.out.println("str : "+str);
		int num2 = test7();
		System.out.println("num2 : "+num2);
		int[] arr = test8();
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		return;//해당값을 반환하고 메소드를 즉시 종료
	}
	public int test5() {
		System.out.println("메소드 테스트5");
		return 100;
	}
	public String test6() {
		System.out.println("메소드 테스트6");
		return "문자열";
	}
	public int test7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		if(num%2 == 0) {
			return num;
		}
		return 0;
		/*
		if(num%2 == 0) {
			return num;
		}else {
			return 0;
		}
		*/
	}
	public int[] test8() {
		int[] arr = {1,2,3,4,5};
		return arr;
	}
	public void test9() {
		System.out.println("메소드 테스트9");
		test10(100);
		test11(10,"hi",3.14);//메소드에 매개변수를 전달할때 이름이 아닌 자료형, 순서가 중요
		test12(10,11);
	}
	public void test10(int num) {
		System.out.println("매개변수로 전달받은 수는 : "+num);
	}
	public void test11(int num, String str, double data) {
		System.out.println("num : "+num);
		System.out.println("str : "+str);
		System.out.println("data : "+data);
	}
	public void test12(int num1, int num2) {
		System.out.println("num1 : "+num1);
		System.out.println("num2 : "+num2);
	}
	public void test13() {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수 입력 : ");
		int num2 = sc.nextInt();
		test12(num2,num1);
	}
	public void test14() {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수 입력 : ");
		int num2 = sc.nextInt();
		
		//int sum = num1 + num2; //BigData도 활용해야하고, AI분석도 해야하는 10000줄짜리 코드라면
		int sum = sum(num1, num2);
		
		System.out.println("두 수의 합은 : "+sum);
		System.out.print("세번째 정수 입력 : ");
		int num3 = sc.nextInt();
		System.out.print("네번째 정수 입력 : ");
		int num4 = sc.nextInt();
		
		//int sum2 = num3 + num4;
		int sum2 = sum(num3, num4);
		System.out.println("두 수의 합은 : "+sum2);
	}
	public int sum(int su1, int su2) {
		int result = su1 + su2;
		return result;
	}
	public void sum2(int su1, int su2) {
		int result = su1 + su2;
		System.out.println("두 수의 합은 : "+result);
	}
	public void test15() {
		Scanner sc = new Scanner(System.in);
		//사용자한테 숫자를 입력받음
		System.out.print("첫번째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수 입력 : ");
		int num2 = sc.nextInt();
		System.out.print("세번째 정수 입력 : ");
		int num3 = sc.nextInt();
		//입력받은 숫자를 add 메소드를 통해서 합침
		int result1 = add(num1,num2,num3);
		int result2 = add(num2,num3);
		//리턴받은 데이터를 화면에 다시 출력
	}
	public int add(int num1, int num2) {
		int result = num1 + num2;
		return result;
	}
	public int add(int num1, int num2, int num3) {
		int result = num1 + num2 + num3;
		return result;
	}
	public void test16() {
		int num1 = 100;
		System.out.println("test16 - num1 : "+num1);//100
		test17(num1);
		System.out.println("test16 - num1 : "+num1);//100
		
		int[] arr = {1,2,3,4,5};
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
		test18(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
	}
	public void test17(int num1) {
		System.out.println("test17 - num1 : "+num1);//100
		num1++;
		System.out.println("test17 - num1 : "+num1);//101
	}
	public void test18(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
		System.out.println("--------------------");
		arr[2] = 100;
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
	}
}











