package kh.java.test6;

import java.util.Scanner;

public class CalcFront {
	public void view() {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		for(int i=0;i<arr.length;i++) {
			System.out.print("정수 입력 : ");
			arr[i] = sc.nextInt();
		}
		Calc calc = new CalcBack();
		//CalcBack calc = new CalcBack();
		
		int result = calc.sum(arr);
		System.out.println("결과 : "+result);
	}	
		
		/*
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("정수 입력 : ");
		int num2 = sc.nextInt();
		System.out.print("정수 입력 : ");
		int num3 = sc.nextInt();
		//백엔드가 잘 만들어주겠지 뭐
		//나는 정수 3개 주고 결과 받아서 출력해야지
		//int result = 메소드명(num1,num2,num3);
		CalcBack calc = new CalcBack();
		int result = calc.sum(num1,num2,num3);
		System.out.println("정수 더한 결과는 : "+result);
		*/
}
