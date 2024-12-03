package kr.co.iei.student.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import kr.co.iei.student.vo.Student;

public class StudentDao {
	ArrayList<Student> students;

	public StudentDao() {
		super();
		importStudents();
	}
	
	public void insertStudent(Student s) {
		students.add(s);
		exportStudents();
	}
	
	public ArrayList<Student> getStudentList() {
		return students;
	}
	
	public Student getStudent(int searchIndex) {
		Student s = students.get(searchIndex);
		return s;
	}
	
	public void updateStudent(int searchIndex, String name, int age, String addr) {
		//setter
		/*
		Student s = students.get(searchIndex);
		s.setName(name);
		s.setAge(age);
		s.setAddr(addr);
		*/
		//새객체 생성
		Student s = new Student(name, age, addr);
		students.set(searchIndex, s);
		
		exportStudents();
	}
	
	public void deleteStudent(int searchIndex) {
		students.remove(searchIndex);
		exportStudents();
	}
	
	public void exportStudents() {
		//자원반환할 보조스트림 선언
		ObjectOutputStream oos = null;
		
		try {
			//1. 데이터를 내보낼 주스트림 생성
			FileOutputStream fos = new FileOutputStream("backup.txt");
			//생성된 주스트림으로 보조스트림 생성
			oos = new ObjectOutputStream(fos);
			//2. 스트림의 메소드 이용해서 학생목록 내보내기
			oos.writeObject(students);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				//3. 자원반환
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void importStudents() {
		//자원반환 할 보조스트림 선언
		ObjectInputStream ois = null;
		
		try {
			//1. 데이터 읽어 올 주스트림 생성
			FileInputStream fis = new FileInputStream("backup.txt");
			//생성된 주스트림으로 보조스트림 생성
			ois = new ObjectInputStream(fis);
			//2. 메소드를 이용해서 데이터 읽어오기
			Object obj = ois.readObject();
			students = (ArrayList<Student>)obj;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			students = new ArrayList<Student>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				//3. 자원 반환
				if(ois != null) {
					ois.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
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
}
