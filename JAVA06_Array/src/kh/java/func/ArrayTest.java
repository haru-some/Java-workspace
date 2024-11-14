package kh.java.func;

import java.util.Scanner;

public class ArrayTest {
	public void test1() {
		//1,2,3,4,5 라는 데이터를 각각 저장하고 출력
		//1) 변수를 이용해서 처리
		int num0 = 1;
		int num1 = 2;
		int num2 = 3;
		int num3 = 4;
		int num4 = 5;
		System.out.println("변수를 이용한 값 출력");
		System.out.println(num0);
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
		//2) 배열을 이용해서 처리
		//배열 선언 방법
		//자료형[] 변수이름 = new 자료형[배열길이];
		int[] arr = new int[5];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;
		System.out.println("배열을 이용한 값 출력");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);
		System.out.println("for문을 이용한 값 출력");
		for(int i=0;i<5;i++) {
			System.out.println(arr[i]);
		}
		
	}
	public void test2() {
		//길이가 5인 정수배열을 선언해서 순서대로 1,2,3,4,5 저장 한 후 출력
		int[] arr1;
		arr1 = new int[5];//배열에 길이를 지정하는 행위 -> 할당
		//배열은 할당하면 기본값으로 데이터가 초기화 되어 있음
		//기본값 : 정수(0), 실수(0.0),문자(' '), 논리형(false), 참조형(null -> 주소값이 비어있어)
		for(int i=0;i<5;i++) {
			System.out.println(i + " : " + arr1[i]);
		}
		for(int i=0;i<5;i++) {
			arr1[i] = i+1;
		}
		/*
		arr1[0] = 1;
		arr1[1] = 2;
		arr1[2] = 3;
		arr1[3] = 4;
		arr1[4] = 5;
		*/
		System.out.println("---------------------------------");
		for(int i=0;i<5;i++) {
			System.out.println(i + " : " + arr1[i]);
		}
		System.out.println("---------------------------------");
		//길이가 5인 정수배열을 선언해서 순서대로 1,2,3,4,5 저장 한 후 출력
		int[] arr2 = {1,2,3,4,5};//배열 선언하면서 바로 값을 대입
		for(int i=0;i<5;i++) {
			System.out.println(i + " : " + arr2[i]);
		}
		System.out.println("---------------------------------");
		String[] arr3 = new String[3];
		arr3[0] = "hello";
		arr3[1] = "hi";
		arr3[2] = "bye";
		for(int i=0;i<3;i++) {
			System.out.println(i + " : " + arr3[i]);
		}
	}
	public void exam1() {
		String[] fruit = new String[5];
		fruit[0] = "딸기";
		fruit[1] = "복숭아";
		fruit[2] = "키위";
		fruit[3] = "사과";
		fruit[4] = "바나나";
		System.out.println("1-1");
		System.out.println(fruit[4]);
		System.out.println("1-2");
		System.out.println(fruit[0]);
		System.out.println(fruit[1]);
		System.out.println(fruit[2]);
		System.out.println(fruit[3]);
		System.out.println(fruit[4]);
		System.out.println("1-3");
		for(int i=0;i<5;i++) {
			System.out.println(fruit[i]);
		}
	}
	public void exam2() {
		int[] num = new int[100];
		for(int i=0;i<100;i++) {
			num[i] = i+1;
			System.out.println(num[i]);
		}
	}
	public void exam3() {
		int[] num = new int[4];
		String[] str = new String[5];
		Scanner sc = new Scanner(System.in);
		System.out.print("국어점수 입력 : ");
		int kor = sc.nextInt();
		num[0] = kor;
		str[0] = "국어 점수";
		System.out.print("영어점수 입력 : ");
		int eng = sc.nextInt();
		num[1] = eng;
		str[1] = "영어 점수";
		System.out.print("수학점수 입력 : ");
		int math = sc.nextInt();
		num[2] = math;
		str[2] = "수학 점수";
		num[3] = kor+eng+math;
		str[3] = "합계";
		str[4] = "평균";
		for(int i=0;i<4;i++) {
			System.out.println(str[i]+" : "+num[i]);
			if(i == 3) {
				System.out.printf(str[4]+" : %.2f",num[i]/(double)i);
			}
		}
		
	}
}
















