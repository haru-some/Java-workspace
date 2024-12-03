package kh.java.func;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class UserMgr2 {
	//ArrayList, User 모두 Serializable을 구현한 상태여야 내보내기가 가능
	ArrayList<User> members;
	Scanner sc;
	
	public UserMgr2() {
		super();
		//members = new ArrayList<User>();
		importData();
		sc = new Scanner(System.in);	
	}
	public void main() {
		while(true) {
			System.out.println("1. 유저 정보 등록");
			System.out.println("2. 유저 전체 출력");
			//System.out.println("3. 데이터 내보내기");//backup2.txt파일로 내보내기
			//System.out.println("4. 데이터 불러오기");//backup2.txt파일에서 불러오기
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				insertUser();
				break;
			case 2:
				printAllUser();
				break;
			case 3:
				exportData();
				System.out.println("내보내기 완료");
				break;
			case 4:
				importData();
				System.out.println("불러오기 완료");
				break;
			}
		}
	}
	public void insertUser() {
		System.out.print("아이디 입력 : ");
		String id = sc.next();
		System.out.print("비밀번호 입력 : ");
		String pw = sc.next();
		System.out.print("이름 입력 : ");
		String name = sc.next();
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		User u = new User(id, pw, name, age);
		members.add(u);
		System.out.println("회원 등록 완료");
		exportData();
	}
	public void insertUserTeacher() {
		User u = new User();
		System.out.print("아이디 입력 : ");
		u.setId(sc.next());
		System.out.print("비밀번호 입력 : ");
		u.setPw(sc.next());
		System.out.print("이름 입력 : ");
		u.setName(sc.next());
		System.out.print("나이 입력 : ");
		u.setAge(sc.nextInt());
		members.add(u);
		System.out.println("회원 등록 완료");
	}
	public void printAllUser() {
		System.out.println("아이디\t비밀번호\t이름\t나이");
		for(User u : members) {
			System.out.println(u.getId()+"\t"+u.getPw()+"\t"+u.getName()+"\t"+u.getAge());
		}
	}
	public void exportData() {
		if(members.size() == 0) {
			System.out.println("내보낼 데이터가 없습니다.");
		}else {
			//1. 데이터를 내보낼 주스트림 생성
			ObjectOutputStream oos = null;
			try {
				//주스트림 이용해서 보조스트림 생성
				FileOutputStream fos = new FileOutputStream("backup2.txt");
				oos = new ObjectOutputStream(fos);
				//2. 메소드를 통해서 객체 내보내기
				oos.writeObject(members);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					//3. 자원반환
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	public void importData() {
		File file = new File("backup2.txt");
		if(!file.exists()) {
			System.out.println("불러올 데이터가 없습니다.");
			return;
		}
		ObjectInputStream ois = null;
		
		try {
			//1. 주스트림 생성
			FileInputStream fis = new FileInputStream(file);
			//주스트림 이용해서 보조스트림 생성
			ois = new ObjectInputStream(fis);
			//2. 메소드 이용해서 데이터 불러오기
			Object obj = ois.readObject();
			members = (ArrayList<User>)obj;
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				//3. 자원반환
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
