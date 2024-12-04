package kr.co.iei.student.controller;

import java.util.ArrayList;

import kr.co.iei.student.dao.StudentDao;
import kr.co.iei.student.view.StudentView;
import kr.co.iei.student.vo.Student;

public class StudentController {
	StudentView view;
	StudentDao dao;
	public StudentController() {
		super();
		view = new StudentView();
		dao = new StudentDao();
	}
	public void main() {
		while(true) {
			int select = view.mainMenu();
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
				return;
			}
		}
	}//main();
	
	public void insertStudent() {
		//학생정보를 입력받아서 데이터 저장 후 결과출력
		Student s = view.insertStudent();
		dao.insertStudent(s);
		view.insertMsg();
	}//insertStudent();
	
	public void printAllStudent() {
		//전체학생정보를 출력
		//전체학생정보 요청
		ArrayList<Student> students = dao.printAllStudent();
		//출력
		view.printAllStudent(students);
	}// printAllStudent();
	
	public void printOneStudent() {
		//학생이름을 입력받아서 조회한 후 있으면 학생정보 출력, 없으면 조회할 수 없습니다 출력
		String name = view.printOneStudent();
		int searchIndex = dao.searchStudent(name);
		if(searchIndex == -1) {
			view.noSearchStudent();
		}else {
			Student s = dao.getStudent(searchIndex);
			view.printStudent(s);
		}
	}//printOneStudent();
	
	public void updateStudent() {
		//이름을 입력받아서 조회한 후
		//조회되지 않으면 "학생정보를 찾을 수 없습니다." 출력
		//조회가 되면 나이와 주소를 새로 입력받아서 입력받은 데이터로 수정
		String name = view.updateStudent();
		int searchIndex = dao.searchStudent(name);
		if(searchIndex == -1) {
			view.noSearchStudent();
		}else {
			Student s = view.getModifyInfo(name);
			dao.updateStudent(searchIndex, s);
			view.updateMsg();
		}
	}//updateStudent();
	
	public void deleteStudent() {
		//이름을 입력받아서 조회한 후
		//존재하면 -> 삭제
		//존재하지 않으면 -> "학생정보를 찾을 수 없습니다." 출력
		String name = view.deleteStudent();
		int searchIndex = dao.searchStudent(name);
		if(searchIndex == -1) {
			view.noSearchStudent();
		}else {
			dao.deleteStudent(searchIndex);
			view.deleteMsg();
		}
	}//deleteStudent();
	
}
