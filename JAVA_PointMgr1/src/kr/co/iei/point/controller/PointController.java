package kr.co.iei.point.controller;

import java.util.Scanner;

import kr.co.iei.point.vo.Silver;

public class PointController {
	Silver[] memberarr;
	Scanner sc;
	int index;
	
	public PointController() {
		memberarr = new Silver[10];
		sc = new Scanner(System.in);
		index = 0;
	}//생성자 종료
	
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
		
		Silver s = new Silver(grade,name,point,point*0.02);
		memberarr[index] = s;
		index++;
		System.out.println("회원 등록 완료!");
	}//insertMember() 종료
	
	public void printAllMember() {
		System.out.println("\n---------- 전체 회원 정보 출력 ----------\n");
		System.out.println("등급\t이름\t포인트\t보너스");
		System.out.println("---------------------------------");
		for(int i=0;i<index;i++) {
			Silver s = memberarr[i];
			System.out.println(s.getGrade()+"\t"+s.getName()+"\t"+s.getPoint()+"\t"+s.getBonusPoint());
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
			Silver s = memberarr[searchIndex];
			System.out.println("등급 : "+s.getGrade());
			System.out.println("이름 : "+s.getName());
			System.out.println("포인트 : "+s.getPoint());
			System.out.printf("보너스 : %.1f",s.getBonusPoint());
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
			Silver s = memberarr[searchIndex];
			s.setGrade(grade);
			s.setPoint(point);
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
				memberarr[i] = memberarr[i+1];
			}
			index--;
			memberarr[index] = null;
			System.out.println("회원 정보 삭제 완료");
		}
	}//deleteMember() 종료
	
	
	public int searchMember(String name) {
		int searchIndex = -1;
		for(int i=0;i<index;i++) {
			Silver s = memberarr[i];
			if(name.equals(s.getName())) {
				searchIndex = i;
				break;
			}
		}
		return searchIndex;
	}//searchMember() 종료
	
}//PointController() 종료
