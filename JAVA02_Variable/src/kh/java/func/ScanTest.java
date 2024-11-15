package kh.java.func;
import java.util.Scanner;

public class ScanTest {
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt(); //사용자가 콘솔에 숫자를 입력하기를 기다림,
		//입력하고 엔터치면 입력한값을 정수타입으로 가져옴
		System.out.println("입력한 정수 값은 : "+num);
		//실수입력을 하고싶으면?
		System.out.print("실수를 입력하세요 : ");
		double num2 = sc.nextDouble();
		System.out.println("입력한 실수 값은 : "+num2);
		//논리형, 문자, 문자열
		System.out.print("문자열 입력 : ");
		String str = sc.next(); //사용자가 콘솔에 문자열을 입력하기 기다림
		System.out.println("입력한 문자열은 : "+str);
		System.out.print("띄어쓰기를 포함한 문자열 입력 : ");
		sc.nextLine();//버퍼에 남은 엔터처리용
		String str2 = sc.nextLine();
		System.out.println("입력한 문자열은 : "+str2);
	}
	public void test2() {
		Scanner sc = new Scanner(System.in);
		//이름(문자열->String) / 나이(정수->int) / 주소(문자열->String) 입력받기
		System.out.print("이름을 입력하세요 : ");
		String name = sc.next();//문자열을 입력받으려면 sc.next(),sc.nextLine()
		//둘 중 띄어쓰기 없는 next() 선택
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		System.out.print("주소를 입력하세요 : ");
		sc.nextLine();
		String address = sc.nextLine();
		//문자 입력받는 방법
		//성별입력(남/여 -> char)
		//Scanner에 문자를 직접 입력받는 방법은 없음 -> 문자열을 입력받고 입력받은 문자열에서 문자 추출
		System.out.print("성별입력(남/여) : ");
		String genderString = sc.next();
		char gender = genderString.charAt(1);//문자열.charAt(n) : 문자열 중 n번째 글자를 문자로 추출
		System.out.println("이름 : "+name);
		System.out.println("나이 : "+age);
		System.out.println("주소 : "+address);
		System.out.println("성별 : "+gender);
		
	}
	public void test3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요 : ");
		String name = sc.next();
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		System.out.print("주소를 입력하세요 : ");
		sc.nextLine();
		String address = sc.nextLine();
		System.out.print("키를 입력하세요 : ");
		int height = (int)sc.nextDouble();
		//double height = sc.nextDouble();
		//System.out.println("키 : "+(int)height);
		System.out.print("몸무게를 입력하세요 : ");
		double weight = sc.nextDouble();
		System.out.print("성별을 입력하세요 : ");
		String genderString = sc.next();
		char gender = genderString.charAt(0);
		
		System.out.println("이름 : "+name);
		System.out.println("나이 : "+age);
		System.out.println("주소 : "+address);
		System.out.println("키 : "+height);
		System.out.printf("몸무게 : %.1f \n",weight);
		//System.out.println();
		System.out.println("성별 : "+gender);
	}
	public void test4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 점수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("수학 점수 입력 : ");
		int num2 = sc.nextInt();
		System.out.print("영어 점수 입력 : ");
		int num3 = sc.nextInt();
		int num4 = num1+num2+num3;
		double num5 = num4/(double)3;
		System.out.printf("당신 성적의 총 합은 "+num4+"점이고 평균은 %.2f 입니다!",num5);
		
	}
}
