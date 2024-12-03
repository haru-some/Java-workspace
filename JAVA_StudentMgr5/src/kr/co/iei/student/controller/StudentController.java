package kr.co.iei.student.controller;

import java.util.ArrayList;
import java.util.Scanner;

import kr.co.iei.student.dao.StudentDao;
import kr.co.iei.student.vo.Student;

public class StudentController {
	Scanner sc;
	//컨트롤러가 데이터가 필요하면 dao를 통해서 데이터를 가져오거나 편집
	StudentDao dao;

	public StudentController() {
		super();
		sc = new Scanner(System.in);
		dao = new StudentDao();
	}
	
	public void main() {
		while(true) {
			System.out.println("\n------------ 학생 관리 프로그램v5 ------------\n");
			System.out.println("1. 학생 정보 등록");
			System.out.println("2. 전체 학생 출력");
			System.out.println("3. 학생 1명 출력");
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
				break;
			case 0:
				System.out.println("시스템을 종료합니다");
				return;
			}
		}
	}//main();
	
	public void insertStudent() {
		System.out.println("\n------------ 학생 정보 등록 ------------\n");
		System.out.print("등록 할 학생 이름 입력 : ");
		String name = sc.next();
		System.out.print("등록 할 학생 나이 입력 : ");
		int age = sc.nextInt();
		System.out.print("등록 할 학생 주소 입력 : ");
		sc.nextLine();
		String addr = sc.nextLine();
		Student s = new Student(name, age, addr);
		//리스트에 데이터를 추가하는 코드는 dao에서 작성
		//dao에게 학생정보를 리스트에 추가해줘!
		dao.insertStudent(s);
		System.out.println("학생 정보 등록 완료!");
	}//insertStudent();
	
	public void printAllStudent() {
		System.out.println("\n------------ 전체 학생 출력 ------------\n");
		System.out.println("이름\t나이\t주소");
		System.out.println("-------------------------------------");
		//students리스트에 있는 모든정보를 출력
		//-> Controller는 students를 갖고있지않음 -> dao에게 달라고 요청
		ArrayList<Student> students = dao.getStudentList();
		for(Student s : students) {
			System.out.println(s.getName()+"\t"+s.getAge()+"\t"+s.getAddr());
		}
	}//printAllStudent();
	
	public void printOneStudent() {
		System.out.println("\n------------ 학생 1명 출력 ------------\n");
		System.out.print("조회 할 학생 이름 입력 : ");
		String name = sc.next();
		int searchIndex = dao.searchStudent(name);
		if(searchIndex == -1) {
			System.out.println("학생 정보를 찾을 수 없습니다.");
		}else {
			Student s = dao.getStudent(searchIndex);
			System.out.println("이름 : "+s.getName());
			System.out.println("나이 : "+s.getAge());
			System.out.println("주소 : "+s.getAddr());
		}
	}//printOneStudent();
	
	public void updateStudent() {
		System.out.println("\n------------ 학생 정보 수정 ------------\n");
		System.out.print("수정 할 학생 이름 입력 : ");
		String name = sc.next();
		int searchIndex = dao.searchStudent(name);
		if(searchIndex == -1) {
			System.out.println("학생 정보를 찾을 수 없습니다.");
		}else {
			System.out.print("수정 할 학생 나이 입력 : ");
			int age = sc.nextInt();
			System.out.print("수정 할 학생 주소 입력 : ");
			sc.nextLine();
			String addr = sc.nextLine();
			dao.updateStudent(searchIndex, name, age, addr);
			System.out.println("수정완료");
			
		}
	}
	
	public void deleteStudent() {
		System.out.println("\n------------ 학생 정보 삭제 ------------\n");
		System.out.print("삭제 할 회원 이름 입력 : ");
		String name = sc.next();
		int searchIndex = dao.searchStudent(name);
		if(searchIndex == -1) {
			System.out.println("학생 정보를 조회 할 수 없습니다.");
		}else {
			dao.deleteStudent(searchIndex);
			System.out.println("삭제완료");
		}
	}
}
