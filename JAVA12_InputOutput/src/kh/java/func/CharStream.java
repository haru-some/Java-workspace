package kh.java.func;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharStream {
	public void primaryStream() {
		Scanner sc = new Scanner(System.in);
		System.out.print("저장 할 파일명 입력 : ");
		String filename = sc.nextLine();
		//0. 반환할 객체 미리 선언
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(filename); //1. 파일생성하고 스트림 연결
			System.out.println("종료는 exit를 입력하세요.");
			while(true) {
				System.out.print("입력 : ");
				String str = sc.nextLine()+"\r\n";
				if(str.equals("exit\r\n")) {
					break;
				}
				//2. 출력메소드 사용
				//문자스트림은 1문자단위로 전송 -> 문자열을 전송하면 내부에서 처리
				fw.write(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				//3. 자원반환
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}	
	public void subStream() {
		Scanner sc = new Scanner(System.in);
		System.out.print("저장 할 파일명 입력 : ");
		String filename = sc.nextLine();
		
		//0. 반환할 객체 선언(보조스트림을 사용하면 자원반환 시 보조스트림만 반환하면 자동으로 주스트림 반환 완료)
		BufferedWriter bw = null;
		
		try {
			FileWriter fw = new FileWriter(filename);//1. 주스트림 생성
			bw = new BufferedWriter(fw);//보조스트림생성(보조스트림은 주스트림을 이용해서 생성 -> 주스트림에 기능을 추가)
			System.out.println("종료는 exit를 입력하세요.");
			while(true) {
				System.out.print("입력 : ");
				String str = sc.nextLine();
				if(str.equals("exit")) {
					break;
				}
				bw.write(str);//2. 출력메소드
				bw.newLine();//보조스트림에만 있는 개행처리 메소드
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				//3. 자원반환(보조스트림을 close하면 주스트림도 함께 close가 됨)
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void readerTest() {
		Scanner sc = new Scanner(System.in);
		System.out.print("로드 할 파일명 입력 : ");
		String filename = sc.nextLine();
		//0. 데이터를 읽어올 보조스트림 선언
		BufferedReader br = null;
		
		try {
			//1. 파일 내용을 읽어올 주 스트림 생성
			//해당파일이 존재하지 않으면 파일을 생성하지않고 바로 예외로 빠짐
			FileReader fr = new FileReader(filename);
			//생성된 주 스트림을 이용해서 보조스트림 생성
			br = new BufferedReader(fr);
			while(true) {
				//readLine() : 스트림이 연결된 파일에서 1줄 읽어옴
				//readLine()이 한번 호출될 때마다 한줄읽어오고 다음줄로 넘어감
				//더이상 읽어올 데이터가 없으면 null을 리턴
				String str = br.readLine();//2. 읽기 메소드 사용
				if(str == null) {
					break;
				}
				System.out.println(str);
			}
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
	
}
