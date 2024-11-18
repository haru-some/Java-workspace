package kh.java.exam;

import java.util.Scanner;

public class ExamClass {
	public void exam() {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		int sum = 0;
		for(int i=0;i<arr.length;i++) {
			System.out.print((i+1)+"번째 정수를 입력 : ");
			arr[i] = sc.nextInt();
			if(arr[i]%2 == 0) {
				sum += arr[i];
			}
		}
		
		System.out.println("배열 첫번째 값 : " + arr[0]);
		System.out.println("입력한 정수 중 짝수의 총 합 : " + sum);		
		
	}
}









