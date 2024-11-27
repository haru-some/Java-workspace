package kh.co.iei.student.controller;

import java.util.ArrayList;
import java.util.Scanner;

import kh.co.iei.student.vo.Student;

public class StudentController {
	Scanner sc;
	//list는 데이터가 있는만큼만 사용하기 때문에 index관리용 변수가 필요없음
	ArrayList<Student> students;
	/*
	Student[] students;
	int index;
	*/
	public StudentController() {
		super();
		sc = new Scanner(System.in);
		students = new ArrayList<Student>();
		//students = new Student[10];
		//index = 0;
		Student s1 = new Student("학생1",20,"서울");
		Student s2 = new Student("학생2",30,"부산");
		Student s3 = new Student("학생3",40,"광주");
		/*
		students[index] = s1;
		index++;
		students[index++] = s2;
		students[index++] = s3;
		 */
		students.add(s1);
		students.add(s2);
		students.add(s3);
	}
	
	public void main() {
		while(true) {
			System.out.println("\n------------ 학생 관리 프로그램v3 ------------\n");
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
		//1) 빈 Student만들고 setter로 값 세팅
		/*
		Student s = new Student();
		s.setName(name);
		s.setAge(age);
		s.setAddr(addr);
		*/
		//2) 매개변수 있는 생성자로 Student객체를 만들면서 바로 값 대입
		Student s = new Student(name, age, addr);
		/*
		students[index] = s;  //배열에 학생객체를 저장
		index++;  //다음에 넣을 배열 위치를 조정
		 */
		students.add(s); // 리스트의 가장 뒤에 새로만든 학생객체를 추가
		System.out.println("학생 정보 등록 완료");
		
	}//insertStudent() 종료
	
	public void printAllStudent() {
		System.out.println("\n------------ 전체 학생 출력 ------------\n");
		System.out.println("이름\t나이\t주소");
		System.out.println("-------------------------------------");
		//배열인경우
		/*
		for(int i=0;i<index;i++) {
			Student s = student[i];
			System.out.println(s.getName()+"\t"+s.getAge()+"\t"+s.getAddr());
		}
		*/
		/*
		for(int i=0;i<students.size();i++) {
			Student s = students.get(i);
			System.out.println(s.getName()+"\t"+s.getAge()+"\t"+s.getAddr());
		}
		*/
		for(Student s : students) {
			System.out.println(s.getName()+"\t"+s.getAge()+"\t"+s.getAddr());
		}
		
	}//printAllStudent() 종료
	
	public void printOneStudent() {
		System.out.println("\n------------ 학생 1명 출력 ------------\n");
		System.out.print("조회 할 학생 이름 입력 : ");
		String name = sc.next();
		int searchIndex = searchStudent(name);
		if(searchIndex == -1) {
			System.out.println("학생 정보를 조회 할 수 없습니다.");
		}else {
			//Student s = student[searchIndex];
			Student s = students.get(searchIndex);
			System.out.println("이름 : "+s.getName());
			System.out.println("나이 : "+s.getAge());
			System.out.println("주소 : "+s.getAddr());
		}
			
		
	}//printOneStudents() 종료
	
	public void updateStudent() {
		System.out.println("\n------------ 학생 정보 수정 ------------\n");
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
			//1) 해당 인덱스에 있는 객체 내부의 데이터를 수정
			//Student s = students[searchIndex];
			//Student s = students.get(searchIndex);
			//s.setAddr(addr);
			//s.setAge(age);
			
			//2) 수정 된 정보로 새로 Student객체를 생성해서 해당인덱스의 객체를 대체
			Student s = new Student(name, age, addr);
			//students[searchIndex] = s;
			students.set(searchIndex, s);
			System.out.println("정보 수정 완료");
		}
		
	}//updateStudent() 종료
	
	public void deleteStudent() {
		System.out.println("\n------------ 학생 정보 삭제 ------------\n");
		System.out.print("삭제 할 회원 이름 입력 : ");
		String name = sc.next();
		int searchIndex = searchStudent(name);
		if(searchIndex == -1) {
			System.out.println("회원 정보를 조회할 수 없습니다.");
		}else {
			//배열
			/*
			for(int i=searchIndex;i<index-1;i++) {
				students[i] = students[i+1];
			}
			students[index-1] = null;
			index--;
			*/
			students.remove(searchIndex);
			System.out.println("회원 삭제 완료!");
		}
	}//deleteStudent() 종료
	
	public int searchStudent(String name) {
		/*
		for(int i=0;i<index;i++) {
			Student s = students[i];
			String searchName = s.getName();
			if(name.equals(searchName)) {
				return i;
			}
		}
		*/
		// students.indexOf(name); 사용불가 Object[] != Student[]
		
		for(int i=0;i<students.size();i++) {
			Student s = students.get(i);
			String searchName = s.getName();
			if(name.equals(searchName)) {
				return i;
			}
		}
		/*
		int i = 0;
		for(Student s : students){
			String searchName = s.getName();
			if(name.equals(searchName)){
				return i; //되돌려줄 i가 필요하기 때문에 foreach 사용X 
			}
			i++;
		}
		 */
		
		return -1;
		
	}//searchStudent() 종료
	
	
}
