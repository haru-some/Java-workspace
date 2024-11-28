package kr.co.iei.point.controller;

import java.util.ArrayList;
import java.util.Scanner;

import kr.co.iei.point.vo.Gold;
import kr.co.iei.point.vo.Grade;
import kr.co.iei.point.vo.Silver;
import kr.co.iei.point.vo.Vip;
import kr.co.iei.point.vo.Vvip;

public class PointControllerImpl implements PointContoller {
	Scanner sc;
	ArrayList<Grade> members;
	
	public PointControllerImpl() {
		super();
		sc = new Scanner(System.in);
		members = new ArrayList<Grade>();
		
		members.add(new Silver("silver", "회원1", 1000));
		members.add(new Gold("gold", "회원2", 1000));
		members.add(new Vip("vip", "회원3", 1000));
	}

	@Override
	public void main() {
		while(true) {
			System.out.println("\n---------- 포인트 관리 프로그램v4 ----------\n");
			System.out.println("1. 회원 정보 등록");
			System.out.println("2. 전체 회원 조회");
			System.out.println("3. 회원 1명 출력");
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
				System.out.println("잘못 입력하셨습니다.");
				break;
			}//switch 종료
		}//while 종료
	}

	@Override
	public void insertMember() {
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
			members.add(s);
			break;
		case "gold":
			Gold g = new Gold(grade, name, point);
			members.add(g);
			break;
		case "vip":
			Vip v = new Vip(grade, name, point);
			members.add(v);
			break;
		case "vvip":
			Vvip vv = new Vvip(grade, name, point);
			members.add(vv);    //오버라이드된 메소드가 실행
			break;
		default:
			System.out.println("회원 등급을 잘못 입력하였습니다.");
			return;
		}
		System.out.println("회원 등록 완료!");
	}

	@Override
	public void printAllMember() {
		System.out.println("\n---------- 전체 회원 정보 출력 ----------\n");
		System.out.println("등급\t이름\t포인트\t보너스");
		System.out.println("---------------------------------");
		for(Grade g : members) {
			System.out.printf(g.getGrade()+"\t"+g.getName()+"\t"+g.getPoint()+"\t%.1f\n",g.getBonus());
		}
		/*
		for(int i=0;i<members.size();i++) {
			Grade g = members.get(i);
			System.out.printf(g.getGrade()+"\t"+g.getName()+"\t"+g.getPoint()+"\t%.1f\n",g.getBonus());
		}
		*/
	}

	@Override
	public void printOneMember() {
		System.out.println("\n---------- 회원 정보 출력 ----------\n");
		System.out.print("조회 할 회원 이름 입력 : ");
		String name = sc.next();
		int searchIndex = searchMember(name);
		if(searchIndex == -1) {
			System.out.println("회원 정보를 찾을 수 없습니다.");
		}else {
			Grade g = members.get(searchIndex);
			System.out.println("등급 : "+g.getGrade());
			System.out.println("이름 : "+g.getName());
			System.out.println("포인트 : "+g.getPoint());
			System.out.printf("보너스 : %.1f",g.getBonus());
		}
		
	}

	@Override
	public void updateMember() {
		System.out.println("\n---------- 회원 정보 수정 ----------\n");
		System.out.print("수정할 회원 이름 입력 : ");
		String name = sc.next();
		int searchIndex = searchMember(name);
		if(searchIndex == -1) {
			System.out.println("회원 정보를 찾을 수 없습니다.");
		}else {
			System.out.print("수정 할 회원 등급 입력[silver/gold/vip/vvip] : ");
			String grade = sc.next();
			System.out.print("수정 할 회원 포인트 입력 : ");
			int point = sc.nextInt();
			
			switch(grade) {
			case "silver":
				Silver s = new Silver(grade, name, point);
				members.set(searchIndex, s);
				break;
			case "gold":
				Gold g = new Gold(grade, name, point);
				members.set(searchIndex, g);
				break;
			case "vip":
				Vip v = new Vip(grade, name, point);
				members.set(searchIndex, v);
				break;
			case "vvip":
				Vvip vv = new Vvip(grade, name, point);
				members.set(searchIndex, vv);
				break;
			}
			
			System.out.println("회원 정보 수정 완료!");
		}
	}

	@Override
	public void deleteMember() {
		System.out.println("\n---------- 회원 정보 삭제 ----------\n");
		System.out.print("삭제 할 회원 이름 입력 : ");
		String name = sc.next();
		int searchIndex = searchMember(name);
		if(searchIndex == -1) {
			System.out.println("회원 정보를 찾을 수 없습니다.");
		}else {
			members.remove(searchIndex);
			System.out.println("회원 정보 삭제 완료");
		}
	}//deleteMember() 종료

	@Override
	public int searchMember(String name) {
		for(int i=0;i<members.size();i++) {
			Grade g = members.get(i);
			String searchName = g.getName();
			if(name.equals(searchName)) {
				return i;
			}
		}
		return -1;
	}
	
	

}
