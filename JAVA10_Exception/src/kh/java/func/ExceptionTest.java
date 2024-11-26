package kh.java.func;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest {
	Scanner sc;
	
	public ExceptionTest() {
		super();
		sc = new Scanner(System.in);
	}
	public void test1() {
		while(true) {
			try {
				System.out.print("정수를 입력하세요 : ");
				int num1 = sc.nextInt();
				System.out.print("정수를 입력하세요 : ");
				int num2 = sc.nextInt();
				int result = num1/num2;
				System.out.println("결과 : "+result);
				break;
			}catch(InputMismatchException e) {
				//입력도중에 에러가 발생해서 버퍼가 비정상인상태로 바로 catch로 들어오니까 버퍼를 catch 정리
				sc.nextLine();
				System.out.println("잘못입력하셨습니다.");
				continue;
			}//catch종료
			//System.out.println("try/catch 바깥쪽");
		}//while종료
	}//test1()메소드 종료
	
	public void test2() {
		try {
			System.out.print("정수를 입력하세요 : ");
			int num1 = sc.nextInt();
			System.out.print("정수를 입력하세요 : ");
			int num2 = sc.nextInt();
			try {
				int result = num1/num2;
				System.out.println("결과 : "+result);
			}catch(ArithmeticException e) {
				System.out.println("0으로 나눌 수 없습니다.");
			}
		}catch(InputMismatchException e) {
			//입력도중에 에러가 발생해서 버퍼가 비정상인상태로 바로 catch로 들어오니까 버퍼를 catch 정리
			System.out.println("잘못입력하셨습니다.");
		}//catch종료
		System.out.println("try/catch 바깥쪽");
	}//test2()메소드 종료
	
	public void test3() {
		try {
			System.out.print("정수를 입력하세요 : ");
			int num1 = sc.nextInt();
			System.out.print("정수를 입력하세요 : ");
			int num2 = sc.nextInt();
			int result = num1/num2;
			System.out.println("결과 : "+result);
		}catch(Exception e) {
			System.out.println("에러 발생!!");
		}	
	}
	
	public void test4() {
		try {
			System.out.print("정수를 입력하세요 : ");
			int num1 = sc.nextInt();
			System.out.print("정수를 입력하세요 : ");
			int num2 = sc.nextInt();
			int result = num1/num2;
			System.out.println("결과 : "+result);
		}catch(InputMismatchException e) {
			System.out.println("잘못입력하셨습니다.");
		}catch(ArithmeticException e) {
			System.out.println("0으로는 나눌 수 없습니다.");
		}catch(Exception e) {
			System.out.println("에러발생");
		}
		
	}
	
	public void test5() {
		try {
			FileInputStream fis = new FileInputStream("test.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void test6() throws FileNotFoundException {
		//checked Exception을 처리하지 않고 throws를 사용해서 던지면
		//해당 메소드를 사용쪽에서 처리해야함
		FileInputStream fis = new FileInputStream("test.txt");
	}
	
	public void test7() {
		//checked exception이 throws되어있으면 해당 메소드를 사용하는 쪽에서라도 처리
		// -> 만약 여기서도 처리안하면???????? -> test7()사용하는 쪽에서 다시처리
		try {
			test6();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void test8() {
		try {
			System.out.print("정수를 입력하세요 : ");
			int num1 = sc.nextInt();
			System.out.print("정수를 입력하세요 : ");
			int num2 = sc.nextInt();
			int result = num1/num2;
			System.out.println("결과 : "+result);
			return;
		}catch(InputMismatchException e) {
			System.out.println("잘못입력하셨습니다.");
		}catch(ArithmeticException e) {
			System.out.println("0으로는 나눌 수 없습니다.");
		}finally {
			System.out.println("try가 정상적으로 실행되던지, 에러 발생해서 catch가 동작하던 무조건 실행되는 코드");
		}
	}
}












