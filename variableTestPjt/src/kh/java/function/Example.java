package kh.java.function;

import java.util.Scanner;

public class Example {
	public void exam1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번 째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두번 째 정수 입력 : ");
		int num2 = sc.nextInt();
		System.out.println("========== 결과 ========== ");
		int num3 = num1+num2;
		System.out.println("더하기 결과 : "+num3);
		int num4 = num1-num2;
		System.out.println("빼기 결과 : "+num4);
		int num5 = num1*num2;
		System.out.println("곱하기 결과 : "+num5);
		int num6 = num1/num2;
		System.out.println("나누기 몫 : "+num6);
		int num7 = num1%num2;
		System.out.println("나누기 나머지 : "+num7);
		
	}
	public void exam2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("가로 길이 입력 : ");
		double width = sc.nextDouble();
		System.out.print("세로 길이 입력 : ");
		double length = sc.nextDouble();
		System.out.println("========== 결과 ========== ");
		double area = width*length;
		System.out.printf("면적 : %.2f\n",area);
		double cf = 2*(width+length);
		System.out.printf("둘레 : %.2f ",cf);
	}
	public void exam3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("영어단어 입력 : ");
		//char word = sc.next().charAt(0);
		//System.out.println("첫번째 문자 : "+word);
		String wordstr = sc.next();
		char word = wordstr.charAt(0);
		char word2 = wordstr.charAt(1);
		char word3 = wordstr.charAt(2);
		System.out.println("첫번째 문자 : "+word);
		System.out.println("두번째 문자 : "+word2);
		System.out.println("세번째 문자 : "+word3);
	}
}
