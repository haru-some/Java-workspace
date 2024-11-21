package kr.co.iei.point.controller;

import java.util.Scanner;

import kr.co.iei.point.vo.Gold;
import kr.co.iei.point.vo.SearchResult;
import kr.co.iei.point.vo.Silver;
import kr.co.iei.point.vo.Vip;

public class PointController {
	Silver[] silvers;
	Gold[] golds;
	Vip[] vips;
	Scanner sc;
	int silverIndex;
	int goldIndex;
	int vipIndex;
	String searchGrade;
	
	public PointController() {
		silvers = new Silver[10];
		golds = new Gold[10];
		vips = new Vip[10];
		sc = new Scanner(System.in);
		silverIndex = 0;
		goldIndex = 0;
		vipIndex = 0;
		searchGrade = null;
		
		silvers[silverIndex++] = new Silver("silver","회원1", 1000);
		silvers[silverIndex++] = new Silver("silver","회원2", 2000);
		golds[goldIndex++] = new Gold("gold","회원3", 1000);
		golds[goldIndex++] = new Gold("gold","회원4", 2000);
		vips[vipIndex++] = new Vip("vip","회원5", 1000);
		vips[vipIndex++] = new Vip("vip","회원6", 2000);
		
	}
	
	public void main() {
		while(true) {
			System.out.println("\n---------- 포인트 관리 프로그램v2 ----------\n");
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
	
	public void insertMember() {
		System.out.println("\n---------- 회원 정보 등록 ----------\n");
		System.out.print("회원 등급 입력[silver/gold/vip] : ");
		String grade = sc.next();
		System.out.print("이름 입력 : ");
		String name = sc.next();
		System.out.print("포인트 입력 : ");
		int point = sc.nextInt();
		/*
		switch(grade) {
		case "silver":
			Silver s = new Silver(grade,name,point);
			silvers[silverIndex] = s;
			silverIndex++;
			break;
		case "gold":
			golds[goldIndex] = new Gold(grade,name,point);
			goldIndex++;
			break;
		case "vip":
			vips[vipIndex++] = new Vip(grade,name,point);
			break;
		}
		*/
		if(grade.equals("silver")){
			Silver s = new Silver(grade,name,point);
			silvers[silverIndex] = s;
			silverIndex++;
			System.out.println("회원 등록 완료!");
		}else if(grade.equals("gold")) {
			Gold g = new Gold(grade,name,point);
			golds[goldIndex] = g;
			goldIndex++;
			System.out.println("회원 등록 완료!");
		}else if(grade.equals("vip")) {
			Vip v = new Vip(grade,name,point);
			vips[vipIndex] = v;
			vipIndex++;
			System.out.println("회원 등록 완료!");
		}
	}//insertMember() 종료
	
	public void printAllMember() {
		System.out.println("\n---------- 전체 회원 정보 출력 ----------\n");
		System.out.println("등급\t이름\t포인트\t보너스");
		System.out.println("---------------------------------");
		for(int i=0;i<silverIndex;i++) {
			Silver s = silvers[i];
			System.out.printf(s.getGrade()+"\t"+s.getName()+"\t"+s.getPoint()+"\t"+"%.1f\n",s.getBonus());	
		}
		for(int i=0;i<goldIndex;i++) {
			Gold g = golds[i];
			System.out.printf(g.getGrade()+"\t"+g.getName()+"\t"+g.getPoint()+"\t"+"%.1f\n",g.getBonus());	
		}
		for(int i=0;i<vipIndex;i++) {
			Vip v = vips[i];
			System.out.printf(v.getGrade()+"\t"+v.getName()+"\t"+v.getPoint()+"\t"+"%.1f\n",v.getBonus());	
		}
	}//printAllMember() 종료
	
	
	
	public void printOneMember() {
		System.out.println("\n---------- 회원 정보 출력 ----------\n");
		System.out.print("조회 할 회원 이름 입력 : ");
		String name = sc.next();
		SearchResult result = searchMember3(name);
		if(result == null) {
			System.out.println("회원 정보를 찾을 수 없습니다.");
		}else {
			String type = result.getType();
			if(type.equals("silver")) {
				int index = result.getIndex();
				Silver s = silvers[index];
				System.out.println("등급 : "+s.getGrade());
				System.out.println("이름 : "+s.getName());
				System.out.println("포인트 : "+s.getPoint());
				System.out.printf("보너스 : %.1f",s.getBonus());
			}else if(result.getType().equals("gold")){
				Gold g = golds[result.getIndex()];
				System.out.println("등급 : "+g.getGrade());
				System.out.println("이름 : "+g.getName());
				System.out.println("포인트 : "+g.getPoint());
				System.out.printf("보너스 : %.1f",g.getBonus());
			}else if(result.getType().equals("vip")) {
				Vip v = vips[result.getIndex()];
				System.out.println("등급 : "+v.getGrade());
				System.out.println("이름 : "+v.getName());
				System.out.println("포인트 : "+v.getPoint());
				System.out.printf("보너스 : %.1f",v.getBonus());
			}
		}
		
		/*
		
		전역변수를 이용하는 방법
		
		int searchIndex = searchMember2(name);
		if(searchIndex == -1) {
			System.out.println("회원 정보를 찾을 수 없습니다.");
		}else {
			switch(searchGrade) {
			case "silver":
				Silver s = silvers[searchIndex];
				System.out.println("등급 : "+s.getGrade());
				System.out.println("이름 : "+s.getName());
				System.out.println("포인트 : "+s.getPoint());
				System.out.printf("보너스 : %.1f",s.getBonus());
				break;
			case "gold":
				Gold g = golds[searchIndex];
				System.out.println("등급 : "+g.getGrade());
				System.out.println("이름 : "+g.getName());
				System.out.println("포인트 : "+g.getPoint());
				System.out.printf("보너스 : %.1f",g.getBonus());
				break;
			case "vip":
				Vip v = vips[searchIndex];
				System.out.println("등급 : "+v.getGrade());
				System.out.println("이름 : "+v.getName());
				System.out.println("포인트 : "+v.getPoint());
				System.out.printf("보너스 : %.1f",v.getBonus());
				break;
			}
		}
		
		//searchIndex를 보정하여 사용하는 방법
		
		int searchIndex = searchMember1(name);
		
		if(searchIndex == -1) {
			System.out.println("회원 정보를 찾을 수 없습니다.");
		
		}else {
			if(0<= searchIndex && searchIndex <=9) {
				Silver s = silvers[searchIndex];
				System.out.println("등급 : "+s.getGrade());
				System.out.println("이름 : "+s.getName());
				System.out.println("포인트 : "+s.getPoint());
				System.out.printf("보너스 : %.1f",s.getBonus());
			}else if(searchIndex/10 == 1) {
				Gold g = golds[searchIndex-10];
				System.out.println("등급 : "+g.getGrade());
				System.out.println("이름 : "+g.getName());
				System.out.println("포인트 : "+g.getPoint());
				System.out.printf("보너스 : %.1f",g.getBonus());
			}else if(searchIndex/20 == 1) {
				Vip v = vips[searchIndex-20];
				System.out.println("등급 : "+v.getGrade());
				System.out.println("이름 : "+v.getName());
				System.out.println("포인트 : "+v.getPoint());
				System.out.printf("보너스 : %.1f",v.getBonus());
			}
		
			//내가 시도해본 방법
		
			 if(name.equals(silvers[searchIndex].getName())){
				Silver s = silvers[searchIndex];
				System.out.println("등급 : "+s.getGrade());
				System.out.println("이름 : "+s.getName());
				System.out.println("포인트 : "+s.getPoint());
				System.out.printf("보너스 : %.1f",s.getBonus());
			}else if(name.equals(golds[searchIndex].getName())) {
				Gold g = golds[searchIndex];
				System.out.println("등급 : "+g.getGrade());
				System.out.println("이름 : "+g.getName());
				System.out.println("포인트 : "+g.getPoint());
				System.out.printf("보너스 : %.1f",g.getBonus());
			}else if(name.equals(vips[searchIndex].getName())) {
				Vip v = vips[searchIndex];
				System.out.println("등급 : "+v.getGrade());
				System.out.println("이름 : "+v.getName());
				System.out.println("포인트 : "+v.getPoint());
				System.out.printf("보너스 : %.1f",v.getBonus());
			}
			
		}
		*/
	}//printOneMember() 종료
	
	public void updateMember() {
		System.out.println("\n---------- 회원 정보 수정 ----------\n");
		System.out.print("수정할 회원 이름 입력 : ");
		String name = sc.next();
		SearchResult result = searchMember3(name);
		if(result == null) {
			System.out.println("회원 정보를 찾을 수 없습니다.");
		}else {
			System.out.print("수정 할 회원 등급 입력[silver/gold/vip] : ");
			String grade = sc.next();
			System.out.print("수정 할 회원 포인트 입력 : ");
			int point = sc.nextInt();
			
			//setter를 이용한 방법은 grade변수의 데이터는 변경할 수 있는데, 객체가 안바뀌므로 보너스가 적용X
			/*
			switch(type) {
			case "silver":
				Silver s = sMembers[index];
				s.setGrade(grade);
				s.setPoint(point);
				break;
			case "gold":
				Gold g = gMembers[index];
				g.setGrade(grade);
				g.setPoint(point);
				break;
			case "vip":
				Vip v = vMembers[index];
				v.setGrade(grade);
				v.setPoint(point);
				break;
			}
			*/
			
			switch(result.getType()){
			case "silver":
				for(int i=result.getIndex();i<silverIndex-1;i++) {
					silvers[i] = silvers[i+1];
				}
				silverIndex--;
				silvers[silverIndex] = null;
				break;
			case "gold":
				for(int i=result.getIndex();i<goldIndex-1;i++) {
					golds[i] = golds[i+1];
				}
				goldIndex--;
				golds[goldIndex] = null;
				break;
			case "vip":
				for(int i=result.getIndex();i<vipIndex-1;i++) {
					vips[i] = vips[i+1];
				}
				vipIndex--;
				vips[vipIndex] = null;
				break;
			}
			if(grade.equals("silver")){
				Silver s = new Silver(grade,name,point);
				silvers[silverIndex] = s;
				silverIndex++;
			}else if(grade.equals("gold")) {
				Gold g = new Gold(grade,name,point);
				golds[goldIndex] = g;
				goldIndex++;
			}else if(grade.equals("vip")) {
				Vip v = new Vip(grade,name,point);
				vips[vipIndex] = v;
				vipIndex++;
			}
			System.out.println("회원 정보 수정 완료!");
		}
		
	}//updateMember() 종료
	
	public void deleteMember() {
		System.out.println("\n---------- 회원 정보 삭제 ----------\n");
		System.out.println("삭제 할 회원 이름 입력 : ");
		String name = sc.next();
		SearchResult result = searchMember3(name);
		if(result == null) {
			System.out.println("회원 정보를 찾을 수 없습니다.");
		}else {
			switch(result.getType()){
			case "silver":
				for(int i=result.getIndex();i<silverIndex-1;i++) {
					silvers[i] = silvers[i+1];
				}
				silverIndex--;
				silvers[silverIndex] = null;
				break;
			case "gold":
				for(int i=result.getIndex();i<goldIndex-1;i++) {
					golds[i] = golds[i+1];
				}
				goldIndex--;
				golds[goldIndex] = null;
				break;
			case "vip":
				for(int i=result.getIndex();i<vipIndex-1;i++) {
					vips[i] = vips[i+1];
				}
				vipIndex--;
				vips[vipIndex] = null;
				break;
			}
			
			System.out.println("회원 정보 삭제 완료");
		}
	}//deleteMember() 종료
	
	public int searchMember(String name) {
		int searchIndex = -1;
		for(int i=0;i<silverIndex;i++) {
			Silver s = silvers[i];
			if(name.equals(s.getName())) {
				searchIndex = i;
				break;
			}
		}
		for(int i=0;i<goldIndex;i++) {
			Gold g = golds[i];
			if(name.equals(g.getName())) {
				searchIndex = i;
				break;
			}
		}
		for(int i=0;i<vipIndex;i++) {
			Vip v = vips[i];
			if(name.equals(v.getName())) {
				searchIndex = i;
				break;
			}
		}
		return searchIndex;
	}//searchMember() 종료
	
	//searchIndex를 보정하여 사용하는 방법
	//스케일링 이슈 발생
	public int searchMember1(String name) {
		for(int i=0;i<silverIndex;i++) {
			Silver s = silvers[i];
			if(name.equals(s.getName())) {
				return i;
			}	
		}
		for(int i=0;i<goldIndex;i++) {
			Gold g = golds[i];
			if(name.equals(g.getName())) {
				return i+10;
			}	
		}
		for(int i=0;i<vipIndex;i++) {
			Vip v = vips[i];
			if(name.equals(v.getName())) {
				return i+20;
			}	
		}
		return -1;
	}//searchMember1() 종료
	
	//전역변수를 이용하는 방법
	public int searchMember2(String name) {
		for(int i=0;i<silverIndex;i++) {
			Silver s = silvers[i];
			if(name.equals(s.getName())) {
				searchGrade = "silver";
				return i;
			}	
		}
		for(int i=0;i<goldIndex;i++) {
			Gold g = golds[i];
			if(name.equals(g.getName())) {
				searchGrade = "gold";
				return i;
			}	
		}
		for(int i=0;i<vipIndex;i++) {
			Vip v = vips[i];
			if(name.equals(v.getName())) {
				searchGrade = "vip";
				return i;
			}	
		}
		return -1;
	}//searchMember2() 종료
	
	
	//객체를 이용
	public SearchResult searchMember3(String name) {
		
		//검색결과로 되돌려주고싶은 데이터 -> 어느배열인지 구분할 값(String), 해당배열의 인덱스번호(int)
		//되돌려주고싶은 데이터가 여러개인 경우 -> 여러개 데이터의 데이터타입이 모두 같으면 -> 배열
		//                         -> 여러개 데이터의 데이터타입이 다르면 -> 객체
		
		for(int i=0;i<silverIndex;i++) {
			Silver s = silvers[i];
			if(name.equals(s.getName())) {
				SearchResult result = new SearchResult();
				result.setType("silver");
				result.setIndex(i);
				return result;
			}	
		}
		for(int i=0;i<goldIndex;i++) {
			Gold g = golds[i];
			if(name.equals(g.getName())) {
				SearchResult result = new SearchResult();
				result.setType("gold");
				result.setIndex(i);
				return result;
			}	
		}
		for(int i=0;i<vipIndex;i++) {
			Vip v = vips[i];
			if(name.equals(v.getName())) {
				SearchResult result = new SearchResult("vip",i);
				return result;
			}	
		}
		return null;
	}//searchMember3() 종료
	
}
