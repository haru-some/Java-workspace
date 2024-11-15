package kh.java.func;

import java.util.Random;
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
		//String[] fruit = {"딸기","복숭아","키위","사과","바나나"};
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
			System.out.println(i+"_"+num[i]);
		}
	}
	public void exam3() {
		int[] num = new int[4];
		String[] str = {"국어","영어","수학"};
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<3;i++) {
			System.out.print(str[i]+" 점수 입력 : ");
			num[i] = sc.nextInt();
		}
		num[3] = num[0]+num[1]+num[2];
		System.out.println("국어점수 : "+num[0]);
		System.out.println("영어점수 : "+num[1]);
		System.out.println("수학점수 : "+num[2]);
		System.out.println("합계 : "+num[3]);
		System.out.printf("평균 : %.2f",num[3]/(double)3);
		
		/*
		for(int i=0;i<4;i++) {
			System.out.println(str[i]+" : "+num[i]);
			if(i == 3) {
				System.out.printf(str[4]+" : %.2f",num[i]/(double)i);
			}
		}
		*/
	}
	public void exam4() {
		Scanner sc = new Scanner(System.in);
		//방을 관리할 배열 -> 방은 총 10개
		//배열 내부의 데이터가 0이면 빈방 / 1이면 손님이 있는 방
		int[] rooms = new int[10];//배열을 할당하면 기본값으로 세팅(정수 -> 0 -> 최초에 모두 빈 방 상태)
		//boolean[] rooms = new boolean[10];//기본값 false, true 손님있는방
		boolean power = true;
		while(power) {
			System.out.println("\n---------- 모텔 관리 프로그램 ----------\n");
			System.out.println("1. 입실"); // 2
			System.out.println("2. 퇴실"); // 3
			System.out.println("3. 방보기"); // 1
			System.out.println("4. 종료");
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				System.out.print("몇번방에 입실하시겠습니까? ");
				int roomnum = sc.nextInt();
				if(rooms[roomnum-1]==0) {
					System.out.println(roomnum+"번방에 입실했습니다.");
					rooms[roomnum-1] = 1;
				}else if(rooms[roomnum-1]!=0) {
					System.out.println(roomnum+"번방에는 손님이 있습니다.");
				}
				break;
			case 2:
				System.out.print("몇번방에서 퇴실하시겠습니까? ");
				int roomnum2 = sc.nextInt();
				if(rooms[roomnum2-1]==1) {
					System.out.println(roomnum2+"번방에서 퇴실했습니다.");
					rooms[roomnum2-1] = 0;
				}else if(rooms[roomnum2-1]!=1) {
					System.out.println(roomnum2+"번방은 빈방입니다.");
				}
				break;
			case 3:
				for(int i=0;i<rooms.length;i++) {
					if(rooms[i]==0) {
						System.out.println((i+1)+"번방은 빈방입니다.");
					}else {
						System.out.println((i+1)+"번방에는 손님이 있습니다.");
					}
				}
				break;
			case 4:
				power = false;
				break;
			}
			
		}
		
		
	}
	public void exam5() {
		Scanner sc = new Scanner(System.in);
		boolean[] rooms = new boolean[10];
		boolean power = true;
		while(power) {
			System.out.println("\n---------- 모텔 관리 프로그램 ----------\n");
			System.out.println("1. 입실"); // 2
			System.out.println("2. 퇴실"); // 3
			System.out.println("3. 방보기"); // 1
			System.out.println("4. 종료");
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				System.out.print("몇번방에 입실하시겠습니까? ");
				int roomnum = sc.nextInt();
				if(!rooms[roomnum-1]) {
					System.out.println(roomnum+"번방에 입실했습니다.");
					rooms[roomnum-1] = true;
				}else { //if(rooms[roomnum-1]!=false) {
					System.out.println(roomnum+"번방에는 손님이 있습니다.");
				}
				break;
			case 2:
				System.out.print("몇번방에서 퇴실하시겠습니까? ");
				int roomnum2 = sc.nextInt();
				if(rooms[roomnum2-1]) {
					System.out.println(roomnum2+"번방에서 퇴실했습니다.");
					rooms[roomnum2-1] = false;
				}else { // if(rooms[roomnum2-1]!=true) {
					System.out.println(roomnum2+"번방은 빈방입니다.");
				}
				break;
			case 3:
				for(int i=0;i<10;i++) {
					if(!rooms[i]) {
						System.out.println((i+1)+"번방은 빈방입니다.");
					}else {
						System.out.println((i+1)+"번방에는 손님이 있습니다.");
					}
				}
				break;
			case 4:
				power = false;
				break;
			}
		}
	}
	public void exam6() {
		Scanner sc = new Scanner(System.in);
		int[] num = new int[5];
		for(int i=0;i<num.length;i++) {
			System.out.print((i+1)+"번째 숫자 입력 : ");
			num[i] = sc.nextInt();
		}
		//배열의 0번째 칸이랑 배열의 1번째 칸의 데이터를 비교해서 0번째 칸이 더크면
		int l = num.length;
		
		for(int i=0;i<l-1;i++) {
			for(int j=0;j<l-1-i;j++) {
				if(num[j] > num[j+1]) {
					int tmp = num[j];
					num[j] = num[j+1];
					num[j+1] = tmp;
				}
			}
		}
		/*
		for(int i=0;i<l-1;i++) {
			if(num[i] > num[i+1]) {
				int tmp = num[i];
				num[i] = num[i+1];
				num[i+1] = tmp;
			}
		}
		for(int i=0;i<l-2;i++) {
			if(num[i] > num[i+1]) {
				int tmp = num[i];
				num[i] = num[i+1];
				num[i+1] = tmp;
			}	
		}
		for(int i=0;i<l-3;i++) {
			if(num[i] > num[i+1]) {
				int tmp = num[i];
				num[i] = num[i+1];
				num[i+1] = tmp;
			}	
		}
		for(int i=0;i<l-4;i++) {
			if(num[i] > num[i+1]) {
				int tmp = num[i];
				num[i] = num[i+1];
				num[i+1] = tmp;
			}	
		}
		*/
		/*
		if(num[0] > num[1]) {
			int tmp = num[0];
			num[0] = num[1];
			num[1] = tmp;
		}
		if(num[1] > num[2]) {
			int tmp = num[1];
			num[1] = num[2];
			num[2] = tmp;
		}
		if(num[2] > num[3]) {
			int tmp = num[2];
			num[2] = num[3];
			num[3] = tmp;
		}
		*/
		//출력
		for(int i=0;i<l;i++) {
			System.out.print(num[i]+"\t");
		}
		//System.out.printf("%d %d %d %d %d",num[0],num[1],num[2],num[3],num[4]);
		
	}//exam6 클래스 종료
	
	public void lotto() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		System.out.println("========== 로또 프로그램 ==========");
		int[] userNum = new int[6];
		//사용자 번호를 입력받기
		for(int i=0;i<userNum.length;i++) {
			System.out.print((i+1)+"번째 번호 입력 : ");
			int num = sc.nextInt();
			//로또번호는 입력값에 제약
			//1) 입력한 숫자가 1~45의 숫자여야 함
			//2) 입력한 숫자가 중복되면 안됨
			//위 두 조건을 만족하면 배열에 데이터를 삽입
			//두 조건은 순서가 존재(정상범위 숫자여야 중복가능성이 생기므로)
			if(num <= 45 && num >= 1) {
				//1) 제약사항 통과
				//2) 제약검사
				boolean check = true;
				for(int j=0;j<i;j++) {
					if(num == userNum[j]) {
						check = false;
						System.out.println("이미 중복된 번호입니다.");
						i--;
						break;//중복숫자를 찾으면 그 이후 검사는 의미가 없으므로 중복체크 반복문을 종료
					}
				}
				if(check) {
					userNum[i] = num;
				}
			}else {
				//1) 제약사항에 위배
				System.out.println("1~45 범위의 숫자를 입력하세요.");
				i--;
			}	
		}
		int[] comNum = new int[6]; // 로또 당첨번호 배열 생성
		for(int i=0;i<comNum.length;i++) {
			int num = r.nextInt(45) + 1;
			boolean check = true;
			for(int j=0;j<i;j++) {
				if(num == comNum[j]) {
					check = false;
					i--;
					break;
				}
			}
			if(check) {
				comNum[i] = num;
			}
		}	
		//사람 숫자 정렬
		int un = userNum.length;
		for(int i=0;i<un-1;i++) {
			for(int j=0;j<un-1-i;j++) {
				if(userNum[j] > userNum[j+1]) {
					int tmp = userNum[j];
					userNum[j] = userNum[j+1];
					userNum[j+1] = tmp;
				}
			}
		}
		//컴퓨터 번호 정렬
		int cn = comNum.length;
		for(int i=0;i<cn-1;i++) {
			for(int j=0;j<cn-1-i;j++) {
				if(comNum[j] > comNum[j+1]) {
					int tmp = comNum[j];
					comNum[j] = comNum[j+1];
					comNum[j+1] = tmp;
				}
			}
		}
		//최종출력
		System.out.println("최종 결과");
		System.out.print("사용자 번호 : ");
		for(int i=0;i<userNum.length;i++) {
			System.out.print(userNum[i]+" ");
		}
		System.out.println();
		System.out.print("당첨 번호 : ");
		for(int i=0;i<comNum.length;i++) {
			System.out.print(comNum[i]+" ");
		}
		System.out.println();
		//맞은 번호 수 체크
		int count = 0;
		for(int i=0;i<userNum.length;i++) {
			for(int j=0;j<comNum.length;j++) {
				if(userNum[i] == comNum[j]) {
					count++;
					break;
				}
			}
		}
		System.out.println("맞은 갯수 : "+count);
		switch(count) {
		case 6:
			System.out.println("1등!");
			break;
		case 5:
			System.out.println("2등!!");
			break;
		case 4:
			System.out.println("3등!!!!");
			break;
		default:
			System.out.println("꽝!!!!!!!!!!!!!!!!!");
			break;
			
		}
	}
}
















