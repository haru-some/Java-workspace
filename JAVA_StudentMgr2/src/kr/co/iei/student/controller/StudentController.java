package kr.co.iei.student.controller;

import java.util.Scanner;

import kr.co.iei.student.vo.Student;

public class StudentController {
	//동명이인이 없는 조건에서 학생 10명을 관리할 배열
	//학생 1명의 정보를 저장할때
	//기존 String, int, String 3개의 변수에 저장
	// -> 각 자료형별로 배열을 따로 생성
	//수정 -> 학생1명정보를 Student라는 객체 타입으로 저장
	// -> 학생 10명을 저장하려면 Student가 10개 -> 같은자료형 10개이므로 Student[]로 관리
	Student[] students;
	Scanner sc;
	int index;
	
	public StudentController() {
		students = new Student[10];
		sc = new Scanner(System.in);
		index = 0;
	}
	//메인메뉴를 진행하는 메소드
	public void main() {
		while(true) {
			System.out.println("\n------------ 학생 관리 프로그램v2 ------------\n");
			System.out.println("1. 학생 정보 등록");
			System.out.println("2. 학생 정보 출력(전체)");
			System.out.println("3. 학생 정보 출력(이름 입력받아서 일치하는 1명)");
			System.out.println("4. 학생 정보 수정");
			System.out.println("5. 학생 정보 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				insertStudent();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
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
	
	//이름, 나이, 주소를 입력받아서 Student객체로 묶어서 배열에 저장하는 메소드
	public void insertStudent() {
		System.out.println("\n------------ 학생 정보 등록 ------------\n");
		System.out.print("등록 할 학생 이름 입력 : ");
		String name = sc.next();
		System.out.print("등록 할 학생 나이 입력 : ");
		int age = sc.nextInt();
		System.out.print("등록 할 학생 주소 입력: ");
		sc.nextLine();
		String addr = sc.nextLine();
		//입력받은 정보를 Student 객체로 생성
		//객체를 생성하는 방법의 수 -> 해당 클래스의 생성자의 수와 동일
		/*
		//1) 기본생성자로 Student객체를 생성하고 값을 저장
		Student s = new Student();//Student객체
		//해당 객체에 name 전역변수에 입력받은 이름을 대입 하고 싶은데
		//아래코드는 변수의 접근제한 범위가 private 설정되어있어서 직접 대입 불가능
		// -> 직접대입을 못하는 대신에 대입을 대신 수행해주는 메소드가 존재 -> setter
		//s.name = name; 
		s.setName(name);
		s.setAge(age);
		s.setAddr(addr);
		*/
		//2) 모든 전역변수를 초기화하는 생성자로 객체를 생성
		Student s = new Student(name,age,addr);
		
		
		//Student객체를 생성하고 값까지 대입완료 되었으면
		//해당 Student객체를 배열에 저장
		students[index] = s;
		//배열에 데이터를 넣었으면, index변수값을 1 증가(다음위치를 알기위해서)
		index++;
		System.out.println("학생정보 등록 완료!");
		
		
	}//insertStudent() 종료
}












