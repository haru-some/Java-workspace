package kr.co.iei.student.dao;

import java.util.ArrayList;

import kr.co.iei.student.vo.Student;

public class StudentDao {
	ArrayList<Student> students;

	public StudentDao() {
		super();
		students = new ArrayList<Student>();
		
		students.add(new Student("학생1", 21, "서울"));
		students.add(new Student("학생2", 22, "부산"));
		students.add(new Student("학생3", 23, "광주"));
	}
	
	public void insertStudent(Student s) {
		students.add(s);
	}
	
	public ArrayList<Student> printAllStudent() {
		return students;
	}
	
	public int searchStudent(String name) {
		for(int i=0;i<students.size();i++) {
			Student s = students.get(i);
			if(s.getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	public Student getStudent(int searchIndex) {
		Student s = students.get(searchIndex);
		return s;
	}

	public void updateStudent(int searchIndex, Student s) {
		students.set(searchIndex, s);
	}
	
	public void deleteStudent(int searchIndex) {
		students.remove(searchIndex);
	}
}
