package kh.co.iei.student.controller;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import kh.co.iei.student.vo.Student;

public class StudentController {
	Scanner sc;
	//학생정보를 HashMap으로 관리
	//-> 관리하고 싶은 학생정보 이름/나이/주소 -> Student -> HashMap의 value가 Student
	//-> 학생을 관리하고 싶은 key는 절대 중복되면 안됨 -> 학생이름을 key -> String
	HashMap<String, Student> students;
	
	public StudentController() {
		super();
		sc = new Scanner(System.in);
		students = new HashMap<String, Student>();
		
		Student s1 = new Student("학생1", 20, "서울");
		Student s2 = new Student("학생2", 30, "경기도");
		students.put(s1.getName(), s1);
		students.put(s2.getName(), s2);
	}
	
	public void main() {
		while(true) {
			System.out.println("\n------------ 학생 관리 프로그램v4 ------------\n");
			System.out.println("1. 학생 정보 등록");
			System.out.println("2. 전체 학생 출력");
			System.out.println("3. 학생 1명 출력");
			System.out.println("4. 학생 정보 수정");
			System.out.println("5. 학생 정보 삭제");
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
				System.out.println("시스템을 종료합니다");
				return;
			}
		}
	}//main() 종료

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
		//map에 추가 -> put
		students.put(name, s); //입력받은 학생 이름을 key값으로해서 학생객체를 map에 추가
		System.out.println("학생 등록 완료!");
		
	}//insertStudent() 종료
	
	public void printAllStudent() {
		System.out.println("\n------------ 전체 학생 출력 ------------\n");
		System.out.println("이름\t나이\t주소");
		System.out.println("-------------------------------------");
		//map에있는 모든 데이터를 출력하고 싶으면 -> 모든 키값을 알아야함 -> keySet();
		Set<String> names = students.keySet();
		for(String name : names) {
			Student s = students.get(name);
			System.out.println(s.getName()+"\t"+s.getAge()+"\t"+s.getAddr());
		}
		
	}//printAllStudent() 종료
	
	public void printOneStudent() {
		System.out.println("\n------------ 학생 1명 출력 ------------\n");
		System.out.print("조회 할 학생 이름 입력 : ");
		String name = sc.next();
		//Students s = students.get(name);
		boolean result = students.containsKey(name);
		if(result) {
			Student s = students.get(name);
			System.out.println("이름 : "+s.getName());
			System.out.println("나이 : "+s.getAge());
			System.out.println("주소 : "+s.getAddr());
		}else {
			System.out.println("학생 정보를 조회 할 수 없습니다.");
		}
	}//printOneStudent() 종료

	public void updateStudent() {
		System.out.println("\n------------ 학생 정보 수정 ------------\n");
		System.out.print("수정 할 학생 이름 입력 : ");
		String name = sc.next();
		Student s = students.get(name);
		if(s == null) {
			System.out.println("학생 정보를 조회할 수 없습니다.");
		}else {
			System.out.print("수정 이름 입력 : ");
			String newName = sc.next();
			System.out.print("수정 할 학생 나이 입력 : ");
			int age = sc.nextInt();
			System.out.print("수정 할 학생 주소 입력 : ");
			sc.nextLine();
			String addr = sc.nextLine();
			/*
			1) 해당객체의 값을 수정 - key값 문제 발생
			s.setName(newName);
			s.setAge(age);
			s.setAddr(addr);
			System.out.println("정보 수정 완료");
			*/
			//2) 새로운 객체를 생성해서 해당객체로 교체
			Student newStudent = new Student(newName, age, addr);
			/*
			students.remove(name);
			students.put(newName, newStudent);
			*/
			students.put(newName, newStudent);
			if(!name.equals(newName)) {
				students.remove(name);
			}
			System.out.println("정보 수정 완료");
		}
		
	}//updateStudent() 종료
	
	public void deleteStudent() {
		System.out.println("\n------------ 학생 정보 삭제 ------------\n");
		System.out.print("삭제 할 회원 이름 입력 : ");
		String name = sc.next();
		boolean result = students.containsKey(name);
		if(result) {
			students.remove(name);
			System.out.println("삭제 완료");
		}else {
			System.out.println("학생 정보를 조회할 수 없습니다.");
		}
		
	}//deleteStudent() 종료
}
