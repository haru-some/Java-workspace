package kr.co.iei.point.view;

import java.util.ArrayList;
import java.util.Scanner;

import kr.co.iei.point.vo.Gold;
import kr.co.iei.point.vo.Grade;
import kr.co.iei.point.vo.Silver;
import kr.co.iei.point.vo.Vip;

public class PointView {
	Scanner sc;

	public PointView() {
		super();
		sc = new Scanner(System.in);
	}
	
	public int mainMenu() {
		System.out.println("\n--------- 포인트 관리 프로그램 v6 ---------\n");
		System.out.println("1. 회원 정보 등록");
		System.out.println("2. 회원 정보 전체 조회");
		System.out.println("3. 회원 1명 정보 조회");
		System.out.println("4. 회원 정보 수정");
		System.out.println("5. 회원 정보 삭제");
		System.out.println("0. 프로그램 종료");
		System.out.print("선택 >> ");
		int select = sc.nextInt();
		return select;
	}
	
	public Grade insertMember() {
		System.out.println("\n---------- 회원 정보 등록 ----------\n");
		System.out.print("등록 할 회원 등급 입력[silver/gold/vip/vvip] : ");
		String grade = sc.next();
		System.out.print("등록 할 회원 이름 입력 : ");
		String name = sc.next();
		System.out.print("등록 할 회원 포인트 입력 : ");
		int point = sc.nextInt();
		switch(grade) {
		case "silver":
			Silver s = new Silver(grade, name, point);
			return s;
		case "gold":
			Gold g = new Gold(grade, name, point);
			return g;
		case "vip":
			Vip v = new Vip(grade, name, point);
			return v;
		default :
			System.out.println("회원 등급을 잘못 입력하셨습니다.");
			return null;
		}
	}
	
	public void printAllMember(ArrayList<Grade> members) {
		System.out.println("\n------------ 전체 회원 정보 출력 ------------\n");
		System.out.println("등급\t이름\t포인트\t보너스");
		System.out.println("------------------------------------------");
		for(Grade g : members) {
			System.out.println(g.getGrade()+"\t"+g.getName()+"\t"+g.getPoint()+"\t"+g.getBonus());
		}
	}
	
	public String printOneMember() {
		System.out.println("\n---------- 회원 1명 출력 ----------\n");
		System.out.print("조회 할 회원 이름 입력 : ");
		String name = sc.next();
		return name;
	}
	
	public void noSearchMember() {
		System.out.println("회원 정보를 조회할 수 없습니다.");
	}
	
	public void printMember(Grade g) {
		System.out.println("등급 : "+g.getGrade());
		System.out.println("이름 : "+g.getName());
		System.out.println("포인트 : "+g.getPoint());
		System.out.println("보너스 : "+g.getBonus());
	}
	
	public String updateMember() {
		System.out.println("\n---------- 회원 정보 수정 ----------\n");
		System.out.print("수정 할 회원 이름 입력 : ");
		String name = sc.next();
		return name;
	}
	
	public Grade getModifyInfo(String name) {
		System.out.println("수정 할 회원 등급 입력[silver/gold/vip] : ");
		String grade = sc.next();
		System.out.println("수정 할 회원 포인트 입력 : ");
		int point = sc.nextInt();
		switch(grade) {
		case "silver":
			Silver s = new Silver(grade, name, point);
			return s;
		case "gold":
			Gold g = new Gold(grade, name, point);
			return g;
		case "vip":
			Vip v = new Vip(grade, name, point);
			return v;
		default :
			System.out.println("회원 등급을 잘못 입력하셨습니다.");
			return null;
		}
	}
	
	public void updateMsg() {
		System.out.println("회원정보 수정 완료");
	}
	
	public String deleteMember() {
		System.out.println("\n---------- 회원 정보 삭제 ----------\n");
		System.out.print("삭제 할 회원 이름 입력 : ");
		String name = sc.next();
		return name;
	}
	
	public void deleteMsg() {
		System.out.println("회원정보 삭제 완료");
	}
}
