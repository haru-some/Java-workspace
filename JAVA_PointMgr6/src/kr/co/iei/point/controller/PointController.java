package kr.co.iei.point.controller;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import kr.co.iei.point.dao.PointDao;
import kr.co.iei.point.vo.Gold;
import kr.co.iei.point.vo.Grade;
import kr.co.iei.point.vo.Silver;
import kr.co.iei.point.vo.Vip;

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
			System.out.println("\n--------- 포인트 관리 프로그램 v6 ---------\n");
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
			System.out.println("\n---------- 회원 정보 등록 ----------\n");
			System.out.print("등록 할 회원 등급 입력[silver/gold/vip/vvip] : ");
			String grade = sc.next();
			System.out.print("등록 할 회원 이름 입력 : ");
			String name = sc.next();
			System.out.print("등록 할 회원 포인트 입력 : ");
			int point = sc.nextInt();
			
			dao.insertMember(grade, name, point);
			System.out.println("회원 등록 완료!");
			break;
			
			/*
			switch(grade) {
			case "silver":
				Silver s = new Silver(grade, name, point);
				//Grade g1 = (Grade)s;
				dao.insertMember(g1);
				break;
			case "gold":
				Gold g = new Gold(grade, name, point);
				//Grade g2 = g;
				dao.insertMember(s);
				break;
			case "vip":
				Vip v = new Vip(grade, name, point);
				dao.insertMember(s);
				break;
			}
			*/
		}	
	}//insertMember();
	
	public void printAllMember() {
		System.out.println("\n------------ 전체 회원 정보 출력 ------------\n");
		System.out.println("등급\t이름\t포인트\t보너스");
		System.out.println("------------------------------------------");
		ArrayList<Grade> members = dao.printAllMember();
		for(Grade g : members) {
			System.out.println(g.getGrade()+"\t"+g.getName()+"\t"+g.getPoint()+"\t"+g.getBonus());
		}
	}//printAllMember();

	public void printOneMember() {
		System.out.println("\n---------- 회원 1명 출력 ----------\n");
		System.out.print("조회 할 회원 이름 입력 : ");
		String name = sc.next();
		
		int searchIndex = dao.searchMember(name);
		
		if(searchIndex == -1) {
			System.out.println("회원 정보를 찾을 수 없습니다.");
		}else {
			Grade g = dao.getMember(searchIndex);
			System.out.println("등급 : "+g.getGrade());
			System.out.println("이름 : "+g.getName());
			System.out.println("포인트 : "+g.getPoint());
			System.out.println("보너스 : "+g.getBonus());
		}
	}//printOneMember();
	
	public void updateMember() {
		System.out.println("\n---------- 회원 정보 수정 ----------\n");
		System.out.print("수정 할 회원 이름 입력 : ");
		String name = sc.next();
		int searchIndex = dao.searchMember(name);
		if(searchIndex == -1) {
			System.out.println("회원 정보를 조회할 수 없습니다.");
		}else {
			System.out.println("수정 할 회원 등급 입력[silver/gold/vip] : ");
			String grade = sc.next();
			System.out.println("수정 할 회원 포인트 입력 : ");
			int point = sc.nextInt();
			dao.updateMember(searchIndex, grade, name, point);
			System.out.println("수정 완료!");
		}
	}//updateMember();
	
	public void deleteMember() {
		System.out.println("\n---------- 회원 정보 삭제 ----------\n");
		System.out.print("삭제 할 회원 이름 입력 : ");
		String name = sc.next();
		
		boolean result = dao.deleteMember(name);
		if(result) {
			System.out.println("삭제 완료!");
		}else {
			System.out.println("회원 정보를 찾을 수 없습니다.");
		}
		
		/*
		int searchIndex = dao.searchMember(name);
		if(searchIndex == -1) {
			System.out.println("회원 정보를 찾을 수 없습니다.");
		}else {
			dao.deleteMember(searchIndex);
			System.out.println("삭제 완료!");
		}
		*/
	}//deleteMember();
}
