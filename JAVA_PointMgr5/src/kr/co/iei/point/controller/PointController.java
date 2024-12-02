package kr.co.iei.point.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import kr.co.iei.point.vo.Gold;
import kr.co.iei.point.vo.Grade;
import kr.co.iei.point.vo.Silver;
import kr.co.iei.point.vo.Vip;

public class PointController {

	HashMap<String, Grade> members;
	Scanner sc;
	//등급 판별 셋
	HashSet<String> gradeSets;

	public PointController() {
		super();
		members = new HashMap<String, Grade>();
		gradeSets = new HashSet<String>();
		sc = new Scanner(System.in);
		
		gradeSets.add("silver");
		gradeSets.add("gold");
		gradeSets.add("vip");

		members.put("회원1", new Silver("silver", "회원1", 1000));
		members.put("회원2", new Vip("vip", "회원2", 10000));
		members.put("회원3", new Silver("silver", "회원3", 5000));
		members.put("회원4", new Gold("gold", "회원4", 7000));

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
		while (true) {
			System.out.print("등록 할 회원 등급 입력[silver/gold/vip] :  ");
			String grade = sc.next();
			if(!gradeSets.contains(grade)) {
				System.out.println("올바른 등급을 입력해주세요.");
				continue;
			}else {
				System.out.print("등록 할 회원 이름 입력 : ");
				String name = sc.next();
				System.out.print("등록 할 회원 포인트 입력 : ");
				int point = sc.nextInt();
				
				switch (grade) {
				case "silver":
					Grade g = new Silver(grade, name, point);
					members.put(name, g);
					break;
				case "gold":
					members.put(name, new Gold(grade, name, point));
					break;
				case "vip":
					members.put(name, new Vip(grade, name, point));
					break;
				}
				System.out.println("회원 등록 완료");
				break;
			}
		}
	}

	public void printAllMember() {
		System.out.println("\n------------ 전체 회원 정보 출력 ------------\n");
		System.out.println("등급\t이름\t포인트\t보너스");
		System.out.println("------------------------------------------");
		Set<String> keysets = members.keySet();
		for (String name : keysets) {
			Grade g = members.get(name);
			System.out.println(g.getGrade() + "\t" + g.getName() + "\t" + g.getPoint() + "\t" + g.getBonus());
		}
	}

	public void printOneMember() {
		System.out.println("\n------------ 회원 1명 정보 출력 ------------\n");
		System.out.print("조회할 회원의 이름을 입력하세요 : ");
		String name = sc.next();
		Grade g = members.get(name);
		if (g == null) {
			System.out.println("회원 정보를 찾을 수 없습니다.");
		} else {
			System.out.println("등급\t이름\t포인트\t보너스");
			System.out.println("------------------------------------------");
			System.out.println(g.getGrade() + "\t" + g.getName() + "\t" + g.getPoint() + "\t" + g.getBonus());
		}
	}

	public void updateMember() {
		System.out.println("\n---------- 회원 정보 수정 ----------\n");
		System.out.print("수정 할 회원 이름 입력 : ");
		String name = sc.next();
		Grade g = members.get(name);
		if (g == null) {
			System.out.println("회원 정보를 찾을 수 없습니다.");
		} else {
			while (true) {
				System.out.print("수정 할 회원 등급 입력[silver/gold/vip] :  ");
				String grade = sc.next();
				System.out.print("수정 할 회원 포인트 입력 : ");
				int point = sc.nextInt();

				members.remove(name);
				switch (grade) {
				case "silver":
					members.put(name, new Silver(grade, name, point));
					System.out.println("회원 정보 수정 완료");
					return;
				case "gold":
					members.put(name, new Gold(grade, name, point));
					System.out.println("회원 정보 수정 완료");
					return;
				case "vip":
					members.put(name, new Vip(grade, name, point));
					System.out.println("회원 정보 수정 완료");
					return;
				default:
					System.out.println("올바른 등급을 입력해주세요.");
					continue;
				}
			}
		}
	}

	public void deleteMember() {
		System.out.println("\n---------- 회원 정보 삭제 ----------\n");
		System.out.print("삭제 할 회원 이름 입력 : ");
		String name = sc.next();
		Grade g = members.get(name);
		if (g == null) {
			System.out.println("회원 정보를 찾을 수 없습니다.");
		} else {
			members.remove(name);
			System.out.println("회원 정보 삭제 완료");
		}
	}
}
