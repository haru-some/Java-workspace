package kh.java.test.function;

import java.util.Scanner;

public class Example {
	public void exam1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 점수 입력 : ");
		int kor = sc.nextInt();
		System.out.print("영어 점수 입력 : ");
		int eng = sc.nextInt();
		System.out.print("수학 점수 입력 : ");
		int math = sc.nextInt();
		int sum = kor + eng + math;
		double avg = (double)sum/3;
		System.out.println("합계 : "+sum);
		System.out.printf("평균 : %.2f \n",avg);
		String result1 = (kor >= 40) && (eng >= 40) && (math >= 40) && (avg >= 60) ? "합격" : "불합격";
		System.out.println(result1);
	}
	public void exam2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num1 = sc.nextInt();
		int num2 = num1%2;
		String result = num2 == 0 ? "짝수!" : "홀수!";
		System.out.println(result);
		
	}
	

}
