package kh.java.func;

import java.util.Scanner;

public class LoopTest {
	public void test1() {
		//for로 무한반복
		for(;;) {
			System.out.println("무한히 반복 될 실행코드");
		}
	}
	public void test2() {
		//while로 무한반복
		while(true) {
			System.out.println("무한히 반복 될 실행코드");
		}
	}
	public void test3() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("정수를 입력하세요 : ");
			int num = sc.nextInt();
			if(num == 1) {
				break;//즉시 반복문을 빠져나감 break;이후 코드는 수행하지 않음
				//break이후에는 코드 작성이 불가능(->도달할 수 없는 코드)
			}else if(num == 2) {
				continue;//즉시 다음 반복회차로 이동(while은 조건검사, for은 증감식)
				//continue이후에는 코드 작성이 불가능(->도달할 수 없는 코드)
			}else {
				System.out.println("입력한 숫자는 : "+num);
			}
			System.out.println("반복문 마지막에 있는 구문");
		}
		System.out.println("반복문 끝나면 나오는 구문");
	}
	public void test4() {
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<10;i++) {
			System.out.print(i+"_정수입력 : ");
			int num = sc.nextInt();
			if(num == 1) {
				break;
			}else if(num == 2) {
				continue;
			}else {
				System.out.println("입력한 숫자는 : "+num);
			}
			System.out.println("반복문 마지막 구문");
		}
		System.out.println("반복문 외부 구문");
	}
	public void test5() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("-------------- 카카오톡 --------------");
			System.out.println("1. 친구목록");
			System.out.println("2. 채팅");
			System.out.println("3. 오픈채팅");
			System.out.println("4. 쇼핑");
			System.out.println("5. 종료");
			System.out.print("선택 > ");
			int select = sc.nextInt();
			if(select == 1) {
				System.out.println("여기는 내 친구목록이 나올 예정");
			}else if(select == 2) {
				System.out.println("여기는 내 대화목록이 나올 예정");
			}else if(select == 3) {
				System.out.println("여기는 내가 참여한 오픈채팅 목록이 나올 예정");
			}else if(select == 4) {
				System.out.println("여기는 쇼핑목록이 나올 예정");
			}else if(select == 5) {
				System.out.println("시스템을 종료합니다.");
				break;
			}
		}
	}
	public void test6() {
		Scanner sc = new Scanner(System.in);
		boolean power = true;
		while(power) {
			System.out.println("-------------- 카카오톡 --------------");
			System.out.println("1. 친구목록");
			System.out.println("2. 채팅");
			System.out.println("3. 오픈채팅");
			System.out.println("4. 쇼핑");
			System.out.println("5. 종료");
			System.out.print("선택 > ");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				System.out.println("여기는 내 친구목록이 나올 예정");
				break;
			case 2:
				System.out.println("여기는 내 대화목록이 나올 예정");
				break;
			case 3:
				System.out.println("여기는 내가 참여한 오픈채팅 목록이 나올 예정");
				break;
			case 4:
				System.out.println("여기는 쇼핑목록이 나올 예정");
				break;
			case 5:
				System.out.println("시스템을 종료합니다.");
				power = false;
				break;//break가 반복문 종료가아닌 switch-case 종료하는 break임
			}
		}
	}
	public void test7() {
		//중첩for문
		for(int i=0;i<3;i++) {
			System.out.println(i+"_반복문 1");
			for(int j=0;j<5;j++) {
				System.out.println(j+"_반복문 2");
			}
		}
		
	}
	public void test8() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.println("i : "+i+" / j : "+j);
			}
		}
	}
	public void test9() {
		for(int i=2;i<10;i++) {
			for(int j=1;j<10;j++) {
				System.out.printf("%d * %d = %d\t",i,j,i*j);
			}
			System.out.println();
		}
	}
	public void test10() {
		for(int i=1;i<10;i++) {
			for(int j=2;j<10;j++) {
				System.out.printf("%d * %d = %d\t",j,i,j*i);
			}
			System.out.println();
		
		}
	}
	public void star1() {
		for(int i=0;i<5;i++){
			System.out.print("*");
		}
	}
	public void star2() {
		for(int i=0;i<5;i++){
			System.out.println("*");
		}
	}
	public void star3() {
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				System.out.println("*");
			}
		}
		System.out.println();
	}
	public void star4() {
		for(int i=1;i<6;i++) {
			for(int j=0;j<5;j++) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
	public void star5() {
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				System.out.print(j+1);
			}
			System.out.println();
		}
	}
	public void star6() {
		for(int i=1;i<6;i++) {
			for(int j=0;j<5;j++) {
				System.out.print(j+i);
			}
			System.out.println();
		}
	}
	public void star7() {
		for(int i=5;i>0;i--) {
			for(int j=0;j<5;j++) {
				System.out.print(i+j);
			}
			System.out.println();
		}
	}
	public void star8() {
		for(int i=1;i<=5;i++) {
			for(int j=0;j<i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void star9() {
		for(int i=5;i>0;i--) {
			for(int j=0;j<i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void star10() {
		for(int i=5;i>0;i--) {
			for(int k=5;k>i;k--) {
				System.out.print(" ");
			}
			for(int j=0;j<i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void star11() {
		for(int i=1;i<=5;i++) {
			for(int j=4;j>=i;j--) {
				System.out.print(" ");
			}
			for(int k=0;k<i;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void star12() {
		for(int i=1;i<=5;i++) {
			for(int j=0;j<i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=4;i>0;i--) {
			for(int j=0;j<i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void star13() {
		for(int i=5;i>0;i--) {
			for(int j=0;j<i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=2;i<=5;i++) {
			for(int j=0;j<i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
