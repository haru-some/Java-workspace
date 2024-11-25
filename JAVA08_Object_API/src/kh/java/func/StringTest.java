package kh.java.func;

import java.util.Random;
import java.util.StringTokenizer;

public class StringTest {
	public String test1() {
		//외부 클래스 사용 시 import 생략 가능 조건
		//1. 같은 패키지에 있는 클래스를 사용할 때
		//2. java.lang. 패키지에 있는 클래스들은 import없이 사용 가능
		StringBuilder sb = new StringBuilder(); //""
		System.out.println("문자열 길이 : "+sb.length());
		System.out.println(sb.toString());
		//append(param) : 현재 저장된 문자열에 매개변수로 전달한 값을 뒤로 추가
		sb.append("test");
		System.out.println("문자열 길이 : "+sb.length());
		System.out.println(sb);
		sb.append(1);
		System.out.println(sb);
		sb.append(" 안녕");
		System.out.println(sb);
		System.out.println("문자열 길이 : "+sb.length());
		//insert(정수,데이터) : 첫번째 매개변수 위치에 두번째 데이터를 삽입
		sb.insert(3, " data ");
		System.out.println(sb);
		//replace(정수,정수,데이터) : 첫번째 매개변수 위치부터 두번째 매개변수 앞까지를 세번째 매개변수로 변환
		sb.replace(3, 9, "수정구문");
		//for(int i=3;i<9;i++)
		System.out.println(sb);
		//delete(정수,정수) : 첫번째 매개변수 위치부터 두번째 매개변수 앞까지를 삭제
		sb.delete(3, 9);
		System.out.println(sb);
		//reverse() : 현재 문자열 순서를 뒤집음
		sb.reverse();
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		return sb.toString();
	}
	public void randomCode() {
		//회원가입 또는 본인인증용 랜덤코드 생성
		// -> 영어 대문자 / 영어 소문자 / 숫자 를 조합한 8자리 코드 생성
		Random r = new Random();
		// -> 영어대문자/소문자/숫자 중 하나를 선택 -> 선택된 문자나/숫자 중 랜덤 하나를 추출해서 문자열로 기록
		StringBuilder sb = new StringBuilder();
		//String test = "";
		for(int i=0;i<8;i++) {
			//대문자/소문자/숫자쓸지를 먼저 랜덤으로 결정
			int flag = r.nextInt(3);//0 : 숫자 / 1 : 대문자 / 2 : 소문자
			if(flag == 0) {
				int randomNum = r.nextInt(10);//0~9 중 한개를 추출
				sb.append(randomNum);
				//test += randomNum;
			}else if(flag == 1) {
				int randomNum = r.nextInt(26)+65;
				char ch = (char)randomNum;
				sb.append(ch);
				//test += ch;
			}else if(flag == 2) {
				int randomNum = r.nextInt(26)+97;
				char ch = (char)randomNum;
				sb.append(ch);
				//test += ch;
			}
			
		}
		System.out.println(sb.toString());
		//System.out.println(test);
	}
	
	public void test2() {
		//String 클래스에서 자주 사용하는 메소드
		String str1 = "AbcdEfg";
		//toUpperCase() : 문자열을 모두 대문자로 변환해서 리턴(원본문자열은 영향 없음)
		System.out.println(str1.toUpperCase());
		System.out.println(str1);
		//toLowerCase() : 문자열을 모두 소문자로 변환해서 리턴(원본문자열은 영향 없음)
		System.out.println(str1.toLowerCase());
		System.out.println(str1);
		String str2 = "한글도 섞인 AbcdEfg";
		System.out.println(str2.toLowerCase());
		System.out.println(str2.toUpperCase());
		
		String str3 = "abcdabcd";
		//replace(문자열1,문자열2) : 문자열1을 찾아서 문자열2로 대체
		System.out.println(str3.replace("a","A"));
		System.out.println(str3);
		
		//indexOf(문자열) : 매개변수로 준 문자열을 찾아서 그 위치를 정수로 리턴(앞에서부터 검색)
		int num1 = str3.indexOf("b");
		System.out.println(num1);
		int num2 = str3.indexOf("e");//존재하지 않으면 -1을 리턴
		System.out.println(num2);
		
		//lastIndexOf(문자열) : 매개변수로 준 문자열을 찾아서 그 위치를 정수로 리턴(뒤에서부터 검색)
		int num3 = str3.lastIndexOf("b");
		System.out.println(num3);
		
		String str4 = "abcdefghijk";
		//substring(정수1,정수2) : 문자열 중 첫번째 정수1부터 정수2앞까지를 리턴
		String str5 = str4.substring(3,7);
		System.out.println(str5);
		System.out.println(str4);
		//substring(정수1) : 문자열 중 정수1부터 끝까지
		String str6 = str4.substring(3);
		System.out.println(str6);
		
		String filename = "abcd.txt";
		int num4 = filename.indexOf(".");
		String onlyFilename = filename.substring(0,num4);
		System.out.println(onlyFilename);
		String extention = filename.substring(num4+1);
		System.out.println(extention);
		
		//split(문자열) : 매개변수로 전달한 문자열을 기준으로 대상문자열을 잘라서 배열로 리턴
		String str7 = "이윤수/서울/강사/KH";
		String[] arr = str7.split("/");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
	}
	
	public void test3() {
		String str = "이윤수/서울/강사/KH";
		//첫번째 매개변수 문자열을 두번째 매개변수 문자열(구분자)을 기준으로 잘라서 토큰으로 관리
		StringTokenizer sT = new StringTokenizer(str,"/");
		while(sT.hasMoreTokens()) {//hasMoreTokens() : 꺼내올 토큰이 남아있으면 true / 없으면 false
			String str1 = sT.nextToken();
			System.out.println(str1);
		}
		
		/*
		while(sT.countTokens() != 0) {
			String str1 = sT.nextToken();
			System.out.println(str1);
		}
		
		
		int count = sT.countTokens();
		for(int i=0;i<count;i++) {
			String str1 = sT.nextToken();
			System.out.println(str1);
		}
		
		System.out.println("현재 토큰 수 : "+sT.countTokens());//현재 남아있는 토큰 수를 정수로 리턴
		String str1 = sT.nextToken();//현재 남아있는 토큰 중 가장 앞 토큰을 꺼내옴(문자열)
		System.out.println(str1);
		System.out.println("현재 토큰 수 : "+sT.countTokens());
		str1 = sT.nextToken();
		System.out.println(str1);
		System.out.println("현재 토큰 수 : "+sT.countTokens());
		str1 = sT.nextToken();
		System.out.println(str1);
		System.out.println("현재 토큰 수 : "+sT.countTokens());
		str1 = sT.nextToken();
		System.out.println(str1);
		System.out.println("현재 토큰 수 : "+sT.countTokens());
		*/
	}
}
