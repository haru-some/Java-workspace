package kh.java.func;

import java.util.Scanner;

public class SwitchTest {
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1~3 사이의 정수를 입력하세요 : ");
		int num = sc.nextInt();
		/*
		 Switch(변수 or 계산식){
		 case 리터럴값 :
		 case 리터럴값 :
		 case 리터럴값 : 
		 }
		 범위 설정, 대소 비교, 여러조건 불가
		*/
		switch(num) {
		case 1 :
			System.out.println("1을 입력하셨군요");
			break;
		case 2 :
			System.out.println("2를 입력하셨군요");
			break;
		case 3 :
			System.out.println("3!!!!!!!!!!");
			break;
		default :
			System.out.println("1~3사이 숫자를 입력하세요.");
			break;
		}
		/*
		if(num == 1) {
			System.out.println("1을 입력하셨군요");
		}else if(num == 2) {
			System.out.println("2를 입력하셨군요");
		}else if(num == 3) {
			System.out.println("3!!!!!!!!!!");
		}else {
			System.out.println("1~3사이 숫자를 입력하세요.");
		}
		*/
	}
	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자를 입력하세요 : ");
		String str = sc.next();
		char ch = str.charAt(0);
		switch(ch) {
		//문자와 숫자는 호환성이 좋다.
		case 97 :
			System.out.println("aaaaaaaaaaa");
			break;
		case 'b' :
			System.out.println("bbbbbbbbbbb");
			break;
		case 'c' :
			System.out.println("ccccccccccc");
			break;
		default :
			System.out.println("a/b/c 중 입력하세요");
			break;
		}
	}
	public void test3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 입력 : ");
		String str = sc.next();
		switch(str) {
		case "aa" :
			System.out.println("aaaaaaaaaaa");
			break;
		case "bb" :
			System.out.println("bbbbbbbbbbb");
			break;
		case "cc" :
			System.out.println("ccccccccccc");
			break;
		default :
			System.out.println("aa/bb/cc 중 입력하세요.");
			break;
		}
	}
	public void test4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		switch(num) {
		case 1 :
			System.out.println("11111");
			break;
		case 2 :
			System.out.println("22222");
			break;
		case 3 :
			System.out.println("33333");
			break;
		default :
			System.out.println("1/2/3 중 입력하세요.");
			break;
		}
	}
	public void test5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("일수를 알고싶은 달을 입력하세요 : ");
		int month = sc.nextInt();
		switch(month) {
		case 1 :
			System.out.printf("%d월달은 31일까지 있습니다.",month);
			break;
		case 2 :
			System.out.println("2월달은 29일까지 있습니다.");
			break;
		case 3 :
			System.out.println("3월달은 31일까지 있습니다.");
			break;
		case 4 :
			System.out.println("4월달은 30일까지 있습니다.");
			break;
		case 5 :
			System.out.println("5월달은 31일까지 있습니다.");
			break;
		case 6 :
			System.out.println("6월달은 30일까지 있습니다.");
			break;
		case 7 :
			System.out.println("7월달은 31일까지 있습니다.");
			break;
		case 8 :
			System.out.println("8월달은 31일까지 있습니다.");
			break;
		case 9 :
			System.out.println("9월달은 30일까지 있습니다.");
			break;
		case 10 :
			System.out.println("10월달은 31일까지 있습니다.");
			break;
		case 11 :
			System.out.println("11월달은 30일까지 있습니다.");
			break;
		case 12 :
			System.out.println("12월달은 31일까지 있습니다.");
			break;
		}
		/*
		switch(month) {
	    case 1:
	    case 3:
	    case 5:
	    case 7:
	    case 8:
	    case 10:
	    case 12:
	        System.out.printf("%d월달은 31일까지 있습니다.\n", month);
	        break;
	    case 2:
	        System.out.printf("%d월달은 29일까지 있습니다.\n", month);
	        break;
	    case 4:
	    case 6:
	    case 9:
	    case 11:
	        System.out.printf("%d월달은 30일까지 있습니다.\n", month);
	        break;
	    }    
	    */
	}
}
