package kh.java.func;

import java.util.Scanner;

public class IfTest {
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 10을 입력하세요 : ");
		int num = sc.nextInt();
		/*
		 if(논리형데이터){
		 	논리형데이터가 true 실행될 코드 작성(false면 실행X)
		 	논리형데이터가 true 실행될 코드 작성(false면 실행X)
		 	논리형데이터가 true 실행될 코드 작성(false면 실행X)
		 	논리형데이터가 true 실행될 코드 작성(false면 실행X)
		 }
		 */
		if(num == 10) {
			System.out.println("참 잘했어요!");
		}
		System.out.println("끝!");
	}
	public void exam1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("========= 숫자 구별 프로그램 =========");
		System.out.print("임의의 정수를 입력 하세요 : ");
		int num = sc.nextInt();
		if(num>0) {
			System.out.printf("당신이 입력한 수 %d은(는) 양수입니다.",num);
		}
		if(num==0) {
			System.out.printf("당신이 입력한 수 %d은(는) 0입니다.",num);
		}
		if(num<0) {
			System.out.printf("당신이 입력한 수 %d은(는) 음수입니다.",num);
		}
	}
	public void exam2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("========= 두수 비교 프로그램 =========");
		System.out.print("첫번째 정수를 입력 하세요 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수를 입력 하세요 : ");
		int num2 = sc.nextInt();
		if(num2>num1) {
			System.out.printf("%d<%d\n",num1,num2);
			System.out.print("두번째 수가 더 큽니다.");
		}
		if(num2==num1) {
			System.out.printf("%d=%d\n",num1,num2);
			System.out.print("두 수가 같습니다.");
		}
		if(num2<num1) {
			System.out.printf("%d>%d\n첫번째 수가 더 큽니다.",num1,num2);
		}
	}
	public void exam3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("========= 계산기 프로그램 =========");
		System.out.print("연산자를 입력하세요(+,-,*,/) : ");
		String signstr = sc.next();
		char sign = signstr.charAt(0);
		System.out.print("첫번째 정수를 입력 하세요 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수를 입력 하세요 : ");
		int num2 = sc.nextInt();
		if(sign=='+') {
			System.out.printf("%d%c%d=%d",num1,sign,num2,num1+num2);
		}
		if(sign=='-') {
			System.out.printf("%d%c%d=%d",num1,sign,num2,num1-num2);
		}
		if(sign=='*') {
			System.out.printf("%d%c%d=%d",num1,sign,num2,num1*num2);
		}
		if(sign=='/') {
			double div = (double)num1/num2;
			System.out.printf("%d%c%d=%f",num1,sign,num2,div);
		}
	}
	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		//입력받은 숫자가 홀수/짝수인지를 출력
		//홀수 : 2로 나눴을 때 나머지가 1인 수
		//짝수 : 2로 나눴을 때 나머지가 0인 수
		if(num%2 == 1) {
			System.out.println("홀수!");
		}else {
			System.out.println("짝수!");
		}
		//if(!(num%2 == 1)) {
		//	System.out.println("짝수!");
		//}
	}
	public void exam4() {
		Scanner sc = new Scanner(System.in);
		int adultPrice = 15000;
		int kidPrice = 5000;
		System.out.println("========= 놀이공원 프로그램 =========");
		System.out.print("입장하실 총 인원은 몇명입니까? : ");
		int num1 = sc.nextInt();
		System.out.print("어른은 몇명입니까?(1인당 "+adultPrice+"원) : ");
		int num2 = sc.nextInt();
		System.out.print("아이는 몇명입니까?(1인당 "+kidPrice+"원) : ");
		int num3 = sc.nextInt();
		if(num1==(num2+num3)) {
			int old = adultPrice*num2;
			int young = kidPrice*num3;
			int sum = old+young;
			System.out.printf("지불하실 총 금액은 %d원 입니다.",sum);
		}else {
			System.out.println("인원수가 맞지 않습니다.");
		}
	}
	public void exam5() {
		Scanner sc = new Scanner(System.in);
		System.out.println("========= 퀴즈 프로그램 =========");
		int count = 0;
		System.out.println("첫번째 퀴즈");
		System.out.print("사과는 영어로 무엇일까요(1.apple,2.스티브 잡스)? : ");
		int q1 = sc.nextInt();
		if(q1==1) {
			count++;
			System.out.println("정답!!!");
		}else {
			System.out.println("땡!!");
		}
		System.out.println("두번째 퀴즈");
		System.out.print("바나는 길어 길으면 기차 기차는 (1.비싸,2.빨라)? : ");
		int q2 = sc.nextInt();
		if(q2==1) {
			System.out.println("땡!!");
		}else {
			count++;
			System.out.println("정답!!!");
		}
		System.out.println("총 "+count+"문제 맞추셨습니다. ");
		//정답을 2개 다 맞춘경우(1번에 1입력/2번에 2입력)
		//정답을 1개만 맞춘경우(1번에 1입력/2번에 1입력, 1번에 2입력/2번에 2입력) ||사용
		//정답을 못맞춘 경우(1번에 2입력/2번에 1입력)
		/*
		if(q1==1){
			if(q2==1){
				System.out.print("총 1문제를 맞췄습니다.");
			}else {
				System.out.print("총 2문제를 맞췄습니다.");
			}
		}else {
			if(q2==1){
				System.out.print("총 0문제를 맞췄습니다.");
			}else {
				System.out.print("총 1문제를 맞췄습니다.");
			}
		}
		 
		if(q1==q2) {
			System.out.print("총 1문제를 맞췄습니다.");
		}
		if(q1<q2) {
			System.out.print("총 2문제를 맞췄습니다.");
		}
		if(q1>q2) {
			System.out.print("총 0문제를 맞췄습니다.");
		}
		*/
	
	}
	public void exam6() {
		Scanner sc = new Scanner(System.in);
		System.out.println("========= 심리테스트 =========");
		System.out.print("당신은 술을 좋아하십니까(1.yes,2.no)? : ");
		int q1 = sc.nextInt();
		if(q1==1) {
			System.out.print("당신은 담배를 피웁니까(1.yes,2.no)? : ");
			int q2 = sc.nextInt();
			if(q2==1) {
				System.out.print("담배는 건강에 좋지 않습니다.");
			}else {
				System.out.print("술은 간에 좋지 않습니다.");
			}
		}else {
			System.out.print("당신은 이성친구가 있습니까(1.yes,2.no)? : ");
			int q3 = sc.nextInt();
			if(q3==1) {
				System.out.print("올..ㅋ");
			}else {
				System.out.print("힘내요ㅠㅠ");
			}
			
		}
	}
	public void test3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1~3 사이의 정수를 입력하세요 : ");
		int num = sc.nextInt();
		if(num == 1) {
			System.out.println("1을 입력하셨군요");
		}else if(num == 2) {
			System.out.println("2를 입력하셨네요");		
		}else if(num == 3) {
			System.out.println("3입니다!");
		}else {
			System.out.println("1~3 사이 정수를 입력하세요.");
		}
	}
	public void test4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num > 1000) {
			System.out.println("1000보다 큰 수 입니다.");
		}else if(num > 100) {
			System.out.println("100보다 큰 수 입니다.");
		}else if(num > 10) {
			System.out.println("10보다 큰 수 입니다.");
		}else {
			//위의 if, else if 조건에 모두 해당되지 않으면(모든 조건식 연산결과가 false가 나오면)
			System.out.println("10 이하의 수 입니다.");
		}
	}
	public void exam7() {
		Scanner sc = new Scanner(System.in);
		System.out.println("========= 대/소문자 변환 프로그램 =========");
		System.out.print("문자입력 : ");
		String eng = sc.next();
		char eng1 = eng.charAt(0);
		//대문자는 65~90 / 소문자는 97~122
		int aski = eng1;
		System.out.println("===== 결 과 =====");
		if(aski > 96 && aski < 123) {
			//소문자 -> 대문자로 변환 : -32
			System.out.println("소문자를 입력 하였습니다.");
			int aski2 = aski - 32;
			char eng2 = (char)aski2;
			//aski -= 32;
			//aski ^= 32;
			System.out.printf("대문자로 변환 : %c",eng2);
		}else if(aski < 97 && aski > 64) {
			// aski를 '영문'으로 변경가능
			// 대문자 -> 소문자로 변환 : +32
			System.out.println("대문자를 입력 하였습니다.");
			int aski2 = aski + 32;
			char eng2 = (char)aski2;
			//char eng2 = (char)(aski + 32);
			System.out.printf("소문자로 변환 : %c",eng2);
		}else {
			System.out.println("잘못입력하셨습니다. 영문자를 입력해주세요.");
		}
	}
	public void exam8() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수입력 : ");
		int num1 = sc.nextInt();
		System.out.println("==== 결 과 ====");
		if(num1%3==0 && num1%4==0 && num1!=0) {
		//if((num1%3!=0 && num1%4!=0) || num1 == 0)	
			System.out.printf("[%d]은(는) 3의 배수면서 4의 배수입니다.",num1);
		}else if(num1%3==0) {
			System.out.printf("[%d]은(는) 3의 배수입니다.",num1);
		}else if(num1%4==0) {
			System.out.printf("[%d]은(는) 4의 배수입니다.",num1);
		}else if(num1%3!=0 && num1%4!=0 || num1 == 0) {
			System.out.printf("[%d]은(는) 3의 배수도 4의 배수도 아닙니다.",num1);
		//}else if(num1 == 0) {
		//	System.out.printf("[%d]은(는) 3의 배수도 4의 배수도 아닙니다.",num1);
		}
	}
}























