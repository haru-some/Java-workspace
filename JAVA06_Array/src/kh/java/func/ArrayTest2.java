package kh.java.func;

public class ArrayTest2 {
	public void test1() {
		int num1 = 100;
		System.out.println("num1 : "+num1); //100
		int num2 = num1;
		System.out.println("num2 : "+num2); //100
		
		System.out.println("num1 : "+num2); //100
		num2 = 200;
		System.out.println("num2 : "+num2); //200
		System.out.println("num1 : "+num1); //100
		
		int[] arr1 = {1,2,3,4,5};
		System.out.println("arr1 출력");
		for(int i=0;i<arr1.length;i++) {
			System.out.print(arr1[i]+"\t");
		}
		System.out.println();
		int[] arr2 = arr1;
		System.out.println("arr2 출력");
		for(int i=0;i<arr2.length;i++) {
			System.out.print(arr2[i]+"\t");
		}
		System.out.println();
		arr1[2] = 300;
		System.out.println("arr1 출력");
		for(int i=0;i<arr1.length;i++) {
			System.out.print(arr1[i]+"\t");
		}
		System.out.println();
		System.out.println("arr2 출력");
		for(int i=0;i<arr2.length;i++) {
			System.out.print(arr2[i]+"\t");
		}
		System.out.println();
		arr2[3] = 400;
		System.out.println("arr2 출력");
		for(int i=0;i<arr2.length;i++) {
			System.out.print(arr2[i]+"\t");
		}
		System.out.println();
		System.out.println("arr1 출력");
		for(int i=0;i<arr1.length;i++) {
			System.out.print(arr1[i]+"\t");
		}
	}
	public void test2() {
		int[] arr1 = {1,2,3,4,5};
		//배열 깊은복사
		//1) 직접 복사하는 방법
		int[] arr2 = new int[arr1.length]; //원본배열과 같은 길이 & 같은 자료형의 배열을 새로 생성
		for(int i=0;i<arr1.length;i++) {
			arr2[i] = arr1[i];
		}
		System.out.println("arr1 출력");
		for(int i=0;i<arr1.length;i++) {
			System.out.print(arr1[i]+"\t");
		}
		System.out.println();
		System.out.println("arr2 출력");
		for(int i=0;i<arr2.length;i++) {
			System.out.print(arr2[i]+"\t");
		}
		System.out.println();
		arr1[2] = 300;
		arr2[3] = 400;
		
		System.out.println("arr1 출력");
		for(int i=0;i<arr1.length;i++) {
			System.out.print(arr1[i]+"\t");
		}
		System.out.println();
		System.out.println("arr2 출력");
		for(int i=0;i<arr2.length;i++) {
			System.out.print(arr2[i]+"\t");
		}
		System.out.println();
	}
	public void test3() {
		int[] arr1 = {1,2,3,4,5};
		//2) System.arraycopy사용(배열의 일부만 복사하고싶을때)
		int[] arr2 = new int[arr1.length];
		//System.arraycopy(5개 값 전달);
		/*
		 1. 복사될 원본배열 주소
		 2. 원본 배열 중 복사를 시작하고싶은 인덱스번호
		 3. 깊은복사될 배열 주소
		 4. 데이터가 복사될 배열의 시작 인덱스번호
		 5. 복사할 데이터의 길이
		 */
		System.arraycopy(arr1, 0, arr2, 1, 3);
		
		System.out.println("arr1 출력");
		for(int i=0;i<arr1.length;i++) {
			System.out.print(arr1[i]+"\t");
		}
		System.out.println();
		System.out.println("arr2 출력");
		for(int i=0;i<arr2.length;i++) {
			System.out.print(arr2[i]+"\t");
		}
		System.out.println();
		//3) clone() : 복제 -> 같은길이와 데이터로 전체를 복사
		int[] arr3 = arr1.clone();
		System.out.println();
		System.out.println("arr3 출력");
		for(int i=0;i<arr3.length;i++) {
			System.out.print(arr3[i]+"\t");
		}
		System.out.println();
	}
	public void test4() {
		//2차원 배열 -> 배열의 내부자료형이 배열인 형태
		int[][] arr = new int[2][3];
		arr[0][0] = 100;
		arr[0][1] = 200;
		arr[0][2] = 300;
		arr[1][0] = 400;
		arr[1][1] = 500;
		arr[1][2] = 600;
		for(int i=0;i<arr.length;i++) {   //2
			for(int j=0;j<arr[i].length;j++) { //3
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
		
	}
	public void test5() {
		int[][] arr = { {100,200,300} , {400,500,600} };
		for(int i=0;i<arr.length;i++) {   //2
			for(int j=0;j<arr[i].length;j++) { //3
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}
}





















