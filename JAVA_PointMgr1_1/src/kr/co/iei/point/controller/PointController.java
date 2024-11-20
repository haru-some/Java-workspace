package kr.co.iei.point.controller;

import java.util.Scanner;

import kr.co.iei.point.vo.Silver;

public class PointController {
	Silver[] silvers;
	int index;
	Scanner sc;
	
	public PointController() {
		silvers = new Silver[10];
		index = 0;
		sc = new Scanner(System.in);
	}
	
	public void main() {
		while(true) {
			System.out.println("\n---------- 포인트 관리 프로그램v1 ----------\n");
			System.out.println("1. 회원 정보 등록");
			System.out.println("2. 전체 회원 조회");
			System.out.println("3. 회원 1명 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 회원 정보 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				insertMember();
				break;
			case 2:
				printAllMember();
				break;
			case 3:
				printOneMember();
				break;
			case 4:
				updateMember();
				break;
			case 5:
				deleteMember();
				break;
			case 0:
				System.out.println("시스템을 종료합니다.");
				return;
			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}//switch 종료
		}//while 종료
	}//main() 종료
	
	public void insertMember() {
		System.out.println("\n---------- 회원 정보 등록 ----------\n");
		System.out.print("등급 입력 : ");
		String grade = sc.next();
		System.out.print("이름 입력 : ");
		String name = sc.next();
		System.out.print("포인트 입력 : ");
		int point = sc.nextInt();
		
		//1) 기본생성자로 객체를 생성 후 setter 값을 대입
		/*
		Silver s = new Silver();
		s.setGrade(grade);
		s.setName(name);
		s.setPoint(point);
		*/
		//2) 매개변수 있는 생성자로 객체를 생성하면서 값을 대입
		Silver s = new Silver(grade,name,point);
		silvers[index] = s;
		index++;
		System.out.println("회원 등록 완료!");
		
	}//insertMember() 종료
	
	public void printAllMember() {
		System.out.println("\n---------- 전체 회원 정보 출력 ----------\n");
		System.out.println("등급\t이름\t포인트\t보너스");
		System.out.println("---------------------------------");
		for(int i=0;i<index;i++) {
			Silver s = silvers[i];
			System.out.println(s.getGrade()+"\t"+s.getName()+"\t"+s.getPoint()+"\t"+s.getBonus());
			
		}
	}//printAllMember() 종료
	
	public void printOneMember() {
		System.out.println("\n---------- 회원 정보 출력 ----------\n");
		System.out.print("조회 할 회원 이름 입력 : ");
		String name = sc.next();
		int searchIndex = searchMember(name);
		if(searchIndex == -1) {
			System.out.println("회원 정보를 찾을 수 없습니다.");
		}else {
			Silver s = silvers[searchIndex];
			System.out.println("등급 : "+s.getGrade());
			System.out.println("이름 : "+s.getName());
			System.out.println("포인트 : "+s.getPoint());
			System.out.printf("보너스 : %.1f",s.getBonus());
		}
	}//printOneMember() 종료
	
	public void updateMember() {
		System.out.println("\n---------- 회원 정보 수정 ----------\n");
		System.out.print("수정할 회원 이름 입력 : ");
		String name = sc.next();
		int searchIndex = searchMember(name);
		if(searchIndex == -1) {
			System.out.println("회원 정보를 찾을 수 없습니다.");
		}else {
			System.out.print("수정 할 회원 등급 입력 : ");
			String grade = sc.next();
			System.out.print("수정 할 회원 포인트 입력 : ");
			int point = sc.nextInt();
			//1) setter로 해당 객체의 데이터를 수정
			//Silver s = silvers[searchIndex];
			//s.setGrade(grade);
			//s.setPoint(point);
			
			//2) 새로운 객체를 만들어서 해당 위치에 대입
			Silver newSilver = new Silver(grade, name, point);
			silvers[searchIndex] = newSilver;
			System.out.println("정보 수정 완료");
		}
	}//updateMember() 종료
	
	public void deleteMember() {
		System.out.println("\n---------- 회원 정보 삭제 ----------\n");
		System.out.println("삭제 할 회원 이름 입력 : ");
		String name = sc.next();
		int searchIndex = searchMember(name);
		if(searchIndex == -1) {
			System.out.println("회원 정보를 찾을 수 없습니다.");
		}else {
			for(int i=searchIndex;i<index-1;i++) {
				silvers[i] = silvers[i+1];
			}
			index--;
			silvers[index] = null;
			System.out.println("회원 정보 삭제 완료");
		}
	}//deleteMember() 종료
	
	public int searchMember(String name) {
		int searchIndex = -1;
		for(int i=0;i<index;i++) {
			Silver s = silvers[i];
			if(name.equals(s.getName())) {
				searchIndex = i;
				break;
			}
		}
		return searchIndex;
	}//searchMember() 종료
	
	/*
	public Silver searchMember(String name) {
		Silver searchSilver = null;
		for(int i=0;i<index;i++) {
			Silver s = silvers[i];
			String searchName = s.getName();
			if(name.equals(searchName)) {
				searchSilver = s;
				break;
			}
		}
		return searchSilver;
	}//searchMember() 종료
	*/
}
