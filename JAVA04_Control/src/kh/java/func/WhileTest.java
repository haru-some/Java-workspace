package kh.java.func;

import java.util.Scanner;

public class WhileTest {
	public void test1() {
		//"안녕하세요" 5번 반복해서 출력
		/*
		 while(조건식){
		 	조건식이 true면 실행되는 코드
		 }
		 */
		int i=0;
		while(i<5) {
			System.out.println("안녕하세요");
			i++;
		}
		/*
		 for(int i=0;i<5;i++){
		 	System.out.println("안녕하세요");
		 }
		 */
	}
	public void exam1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇단을 출력하시겠습니까? ");
		int dan = sc.nextInt();
		System.out.printf("%d단 입니다.\n",dan);
		int i = 0;
		while(i<9) {
			System.out.printf("%d * %d = %d\n",dan,i+1,(i+1)*dan);
			i++;
		}
	}
	public void exam2() {
		Scanner sc = new Scanner(System.in);
		int i = 0;
		int sum = 0;
		while(i<5) {
			System.out.print("정수 값을 입력하시오 : ");
			int num = sc.nextInt();
			sum += num;
			i++;
		}
		System.out.printf("입력한 5개의 정수의 합 : %d",sum);
	}
	public void exam3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 수 입력 : ");
		int num2 = sc.nextInt();
		int sum = 0;
		int i = num1;
		while(i<=num2) {
			sum += i;
			i++;
		}
		System.out.printf("%d ~ %d의 정수의 합 : %d",num1,num2,sum);
	}
	public void exam4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력 : ");
		int num = sc.nextInt();
		int i = 0;
		int sum = 0;
		while(i<=num) {
			sum += i;
			i+=2;
		}
		// if문 사용시 i++는 if문 밖에 작성.
		System.out.printf("짝수들의 합은 : %d",sum);
	}
}
