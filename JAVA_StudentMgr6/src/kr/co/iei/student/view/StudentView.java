package kr.co.iei.student.view;

import java.util.ArrayList;
import java.util.Scanner;

import kr.co.iei.student.vo.Student;

//사용자에게 보여줄 화면 작성
//사용자가 입력한 데이터 입력받는 역할

public class StudentView {
	Scanner sc;

	public StudentView() {
		super();
		sc = new Scanner(System.in);
	}
	
	public int mainMenu() {
		System.out.println("\n------------ 학생 관리 프로그램v6 ------------\n");
		System.out.println("1. 학생 정보 등록");
		System.out.println("2. 전체 학생 출력");
		System.out.println("3. 학생 1명 출력");
		System.out.println("4. 학생 정보 수정");
		System.out.println("5. 학생 정보 삭제");
		System.out.println("0. 프로그램 종료");
		System.out.print("선택 >> ");
		int select = sc.nextInt();
		return select;
	}
	
	public Student insertStudent() {
		System.out.println("\n------------ 학생 정보 등록 ------------\n");
		System.out.print("등록 할 학생 이름 입력 : ");
		String name = sc.next();
		System.out.print("등록 할 학생 나이 입력 : ");
		int age = sc.nextInt();
		System.out.print("등록 할 학생 주소 입력 : ");
		sc.nextLine();
		String addr = sc.nextLine();
		Student s = new Student(name, age, addr);
		return s;
	}
	
	public void insertMsg() {
		System.out.println("학생 정보 등록 완료");
	}
	
	public void printAllStudent(ArrayList<Student> students) {
		System.out.println("\n------------ 전체 학생 출력 ------------\n");
		System.out.println("이름\t나이\t주소");
		System.out.println("-------------------------------------");
		for(Student s : students) {
			System.out.println(s.getName()+"\t"+s.getAge()+"\t"+s.getAddr());
		}
	}
	
	public String printOneStudent() {
		System.out.println("\n------------ 학생 1명 출력 ------------\n");
		System.out.print("조회 할 학생 이름 입력 : ");
		String name = sc.next();
		return name;
	}

	public void noSearchStudent() {
		System.out.println("학생 정보를 조회할 수 없습니다.");
	}
	
	public void printStudent(Student s) {
		System.out.println("이름 : "+s.getName());
		System.out.println("나이 : "+s.getAge());
		System.out.println("주소 : "+s.getAddr());
	}
	
	public String updateStudent() {
		System.out.println("\n------------ 학생 정보 수정 ------------\n");
		System.out.print("수정 할 학생 이름 입력 : ");
		String name = sc.next();
		return name;
	}
	
	public Student getModifyInfo(String name) {
		System.out.print("수정 할 학생 나이 입력 : ");
		int age = sc.nextInt();
		System.out.print("수정 할 학생 주소 입력 : ");
		sc.nextLine();
		String addr = sc.nextLine();
		Student s = new Student(name, age, addr);
		return s;
	}
	
	public void updateMsg() {
		System.out.println("정보 수정 완료");
	}
	
	public String deleteStudent() {
		System.out.println("\n------------ 학생 정보 삭제 ------------\n");
		System.out.println("삭제 할 학생 이름 : ");
		String name = sc.next();
		return name;
	}
	
	public void deleteMsg() {
		System.out.println("삭제 완료!");
	}
}
