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
		
		Student s1 = new Student();
		s1.setName("학생1");
		s1.setAge(20);
		s1.setAddr("서울");
		students[index] = s1;
		index++;
		
		Student s2 = new Student("학생2", 21,"경기도");
		students[index] = s2;
		index++;
		
		students[index] = new Student("학생3", 22, "인천");
		index++;
		
		students[index++] = new Student("학생4", 23, "부천");
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
				printAllStudent();
				break;
			case 3:
				printOneStudent();
				break;
			case 4:
				updateStudent();
				break;
			case 5:
				deleteStudent();
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
	
	//등록된 전체 학생정보를 출력하는 메소드
	public void printAllStudent() {
		System.out.println("\n---------- 전체 학생 정보 출력 ----------\n");
		System.out.println("이름\t나이\t주소");
		System.out.println("---------------------------------");
		//전체 학생정보는 students배열에 순서대로 저장되어 있음
		for(int i=0;i<index;i++) {
			//students배열은 Student타입이 여러개 저장되어있는 배열
			//students배열에서 한개의 데이터를 꺼내오면 -> Student타입
			Student s = students[i];
			//Student타입 객체에는 name, age, addr변수가 존재
			//직접접근은 private로 막혀있어서 데이터를 가져오고 싶을때는 해당 변수의 getter사용
			System.out.println(s.getName()+"\t"+s.getAge()+"\t"+s.getAddr());
		}
	}//printAllStudent() 종료
	
	//학생 이름을 입력받아서 해당 학생 정보를 모두 출력하는 메소드
	//입력받은 이름이 존재하지 않으면 "학생 정보를 조회할 수 없습니다."출력
	public void printOneStudent() {
		System.out.println("\n---------- 학생 정보 조회 ----------\n");
		System.out.print("조회 할 학생 이름 입력 : ");
		String name = sc.next();
		int searchIndex = searchStudent(name);//여러곳에서 공통적으로 사용하는 기능은 메소드로 따로 만들어서 호출
		if(searchIndex == -1) {
			System.out.println("학생 정보를 조회할 수 없습니다.");
		}else {
			Student s = students[searchIndex];
			System.out.println("학생 이름 : "+s.getName());
			System.out.println("학생 나이 : "+s.getAge());
			System.out.println("학생 주소 : "+s.getAddr());
		}
	}//printOneStudent() 종료
	
	//학생이름을 입력받아서 해당학생이 존재하면 나이와 주소를 추가로 입력받아서 수정하는 메소드
	public void updateStudent() {
		System.out.println("\n---------- 학생 정보 수정 ----------\n");
		System.out.print("수정 할 학생 이름 입력 : ");
		String name = sc.next();
		int searchIndex = searchStudent(name);
		if(searchIndex == -1) {
			System.out.println("학생 정보를 조회할 수 없습니다.");
		}else {
			System.out.print("수정 할 학생 나이 입력 : ");
			int age = sc.nextInt();
			System.out.print("수정 할 학생 주소 입력 : ");
			sc.nextLine();
			String addr = sc.nextLine();
			
			//1)setter를 이용해서 객체에 저장되어있는 변수값을 수정
			
			/*
			Student s = students[searchIndex];
			//Student의 각 변수는 모두 private로 변수에 직접접근불가 -> 값을 변경하고싶으면 -> setter메소드 사용	
			//s.age = age;
			s.setAge(age);
			s.setAddr(addr);
			System.out.println("정보 수정 완료");
			*/
			
			//2)새로운 Student객체를 만들어서 배열의 해당위치에 새로 주소를 대입
			Student s = new Student(name,age,addr);
			students[searchIndex] = s;
			System.out.println("정보 수정 완료");
		}
		
	}//updateStudent() 종료
	
	//학생 이름을 입력받아서 해당 학생 정보를 배열에서 삭제
	public void deleteStudent() {
		System.out.println("\n---------- 학생 정보 삭제 ----------\n");
		System.out.println("삭제 할 학생 이름 입력 : ");
		String name = sc.next();
		int searchIndex = searchStudent(name);
		if(searchIndex == -1) {
			System.out.println("학생 정보를 조회 할 수 없습니다.");
		}else {
			for(int i=searchIndex;i<index-1;i++) {
				students[i] = students[i+1];
			}
			students[index-1] = null;
			index--;
			/*
			index--;
			students[index] = null;
			
			students[--index] = null;
			 */
		}
		
	}
	
	//이름을 매개변수로 받아서 해당이름의 학생이 배열의 몇번째에 있는지 되돌려주는 메소드
	//일치하는 이름이 없으면 -1을 리턴
	public int searchStudent(String name) {
		int searchIndex = -1;
		for(int i=0;i<index;i++) {
			Student s = students[i];
			String searchName = s.getName();
			if(name.equals(searchName)) {
				searchIndex = i;
				break;
			}
		}
		return searchIndex;
	}//searchStudent() 종료
}












