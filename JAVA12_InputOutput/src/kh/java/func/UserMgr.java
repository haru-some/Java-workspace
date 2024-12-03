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
import java.util.Scanner;

public class UserMgr {
	User user;
	Scanner sc;
	public UserMgr() {
		super();
		sc = new Scanner(System.in);
		user = null;
	}
	public void main() {
		while(true) {
			System.out.println("1. 회원 정보 등록");
			System.out.println("2. 회원 정보 출력");
			System.out.println("3. 회원 정보 내보내기");
			System.out.println("4. 회원 정보 불러오기");
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				insertUser();
				break;
			case 2:
				printUser();
				break;
			case 3:
				exportUser2();
				break;
			case 4:
				importUser2();
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
		user = u;
		System.out.println("등록 완료");
	}
	public void printUser() {
		if(user == null) {
			System.out.println("회원 정보가 없습니다.");
		}else {
			System.out.println("아이디 : "+user.getId());
			System.out.println("비밀번호 : "+user.getPw());
			System.out.println("이름 : "+user.getName());
			System.out.println("나이 : "+user.getAge());
		}
	}
	public void exportUser() {
		//user에 있는 정보를 id/pw/name/age 형태로 문자열을 만들어서 파일에 저장
		if(user == null) {
			System.out.println("내보낼 정보가 없습니다.");
		}else {
			String exportData = user.getId()+"/"+user.getPw()+"/"+user.getName()+"/"+user.getAge();
			//내보낼 데이터가 문자열 -> Writer
			BufferedWriter bw = null;
			
			try {
				//1. 데이터를 내보낼 주 스트림 생성
				FileWriter fw = new FileWriter("backup.txt");
				//주스트림 이용해서 보조스트림 생성
				bw = new BufferedWriter(fw);
				//2. 메소드로 데이터 내보내기
				bw.write(exportData);
				System.out.println("내보내기 완료!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					//3. 자원 반환
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public void exportUser2() {
		if(user == null) {
			System.out.println("내보낼 정보가 없습니다.");
		}else {
			//직렬화한 객체를 내보내는 보조스트림 선언
			ObjectOutputStream oos = null;
			
			try {
				//1. 데이터를 내보낼 주스트림 생성
				FileOutputStream fos = new FileOutputStream("backup1.txt");
				//주스트림 이용해서 보조스트림 생성
				oos = new ObjectOutputStream(fos);
				//2. 메소드를 통해서 객체 내보내기
				oos.writeObject(user);
				System.out.println("객체 내보내기 완료");
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
	}
	
	public void importUser() {
		//backup.txt파일에서 데이터를 읽어옴
		//읽어온 데이터를 다시 전역변수 user에 저장
		//backup.txt파일이 있는지 체크
		File checkFile = new File("backup.txt");
		if(!checkFile.exists()) {
			System.out.println("읽어 올 파일이 없습니다.");
			return;
		}
		//읽어 올 데이터의 형태도 문자열 -> Reader
		
		//자원반환할 보조스트림 선언
		BufferedReader br = null;
		try {
			//1. 데이터를 읽어 올 주스트림 생성
			FileReader fr = new FileReader("backup.txt");
			//주스트림 이용해서 보조스트림 생성
			br = new BufferedReader(fr);
			String str = br.readLine();
			String[] arr = str.split("/");
			String id = arr[0];
			String pw = arr[1];
			String name = arr[2];
			int age = Integer.parseInt(arr[3]);
			User u = new User(id, pw, name, age);
			user = u;
			System.out.println("불러오기 완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				//3. 자원반환
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void importUser2() {
		File file = new File("backup1.txt");
		if(!file.exists()) {
			System.out.println("불러올 정보가 없습니다.");
			return;
		}
		//직렬화되어 내보내진 객체를 다시 가져오는 보조스트림 선언
		ObjectInputStream ois = null;
		
		try {
			//1. 데이터를 불러올 주스트림 생성
			FileInputStream fis = new FileInputStream("backup1.txt");
			//주스트림 이용해서 보조스트림 생성
			ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			User u = (User)obj;
			user = u;
			System.out.println("가져오기 완료");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
