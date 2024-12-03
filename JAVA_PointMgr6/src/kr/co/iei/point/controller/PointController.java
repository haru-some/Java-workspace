package kr.co.iei.point.controller;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import kr.co.iei.point.dao.PointDao;
import kr.co.iei.point.vo.Grade;

public class PointController {
	Scanner sc;
	PointDao dao;
	
	public PointController() {
		super();
		sc= new Scanner(System.in);
		dao = new PointDao();
	}
	
	public void main() {
		while (true) {
			System.out.println("\n--------- 포인트 관리 프로그램 v5 ---------\n");
			System.out.println("1. 회원 정보 등록");
			System.out.println("2. 회원 정보 전체 조회");
			System.out.println("3. 회원 1명 정보 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 회원 정보 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			switch (select) {
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
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못입력하였습니다.");
				break;
			}
		}
	}
	
	public void insertMember() {
		while(true) {
			System.out.print("등록 할 회원 등급 입력[silver/gold/vip] :  ");
			String grade = sc.next();
			if(!dao.gradeSetContains(grade)) {
				System.out.println("올바른 등급을 입력해주세요.");
				continue;
			}else {
				System.out.print("등록 할 회원 이름 입력 : ");
				String name = sc.next();
				System.out.print("등록 할 회원 포인트 입력 : ");
				int point = sc.nextInt();
				dao.insertMember(grade, name, point);
				System.out.println("회원 등록 완료");
				break;
			}
		}	
	}//insertMember() 종료
	
	public void printAllMember() {
		System.out.println("\n------------ 전체 회원 정보 출력 ------------\n");
		System.out.println("등급\t이름\t포인트\t보너스");
		System.out.println("------------------------------------------");
		
		for(String name : dao.getMemberList()) {
			
		}
	}
	
}
