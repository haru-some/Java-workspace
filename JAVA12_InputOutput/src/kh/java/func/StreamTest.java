package kh.java.func;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class StreamTest {
	//quiz.txt파일을 읽어서 quiz.gif로 내보내기
	public void test1() {
		//보조스트림을 사용하는 버전
		//quiz.txt파일을 읽어옴
		//읽어온다 -> InputStream, Reader -> 읽어올 데이터가 긴 문자열 -> Reader 사용
		//0. 파일에서 읽어올 보조스트림 선언
		BufferedReader br = null;
		//quiz.gif로 파일을 내보냄
		//내보냄 -> OutputStream, Writer -> 내보낼 데이터가 이미지 -> OutputStream 사용
		//0. 파일을 내보낼 보조스트림 선언
		BufferedOutputStream bos = null;
		
		try {
			//1. 파일 내용을 읽어오기위한 주스트림 생성
			FileReader fr = new FileReader("quiz.txt");
			br = new BufferedReader(fr);
			//quiz.txt는 1줄짜리 긴 문자열 -> 1줄만 읽어오면 전체파일을 다읽어옴
			System.out.println("파일 읽어오기 전");
			String str = br.readLine();
			System.out.println("파일 읽어오기 끝");
			//읽어온 문자열 형태 -> 10진수공백10진수공백10진수공백..............
			//공백을 제거한 문자열을 byte타입의 형태로 변경
			//데이터를 ArrayList<Byte>타입으로 저장
			ArrayList<Byte> list = new ArrayList<Byte>();
			//문자열에서 공백을 기준으로 잘라줄 객체 사용
			StringTokenizer sT = new StringTokenizer(str," ");
			while(sT.hasMoreTokens()) {
				String num = sT.nextToken();
				int iNum = Integer.parseInt(num);
				list.add((byte)iNum);
			}
			System.out.println(list.size());
			
			//파일내보내기
			//2. 파일을 내보내기위한 주스트림 생성
			FileOutputStream fos = new FileOutputStream("quiz.gif");
			//생성된 주스트림을 이용해서 보조스트림 생성
			bos = new BufferedOutputStream(fos);
			
			//보조스트림 통해서 파일 내보내기
			System.out.println("파일 내보내기 시작");
			for(byte b : list) {
				bos.write(b); //2. 메소드를 통한 파일 쓰기
			}
			System.out.println("파일 내보내기 끝");
			
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
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	public void test2() {
		//동일한 프로그램이지만 보조스트림을 사용하지 않는 버전
		//quiz.txt에서 읽어오기위한 주스트림 선언
		FileReader fr = null;
		//quiz1.gif로 내보내기위한 주스트림 선언
		FileOutputStream fos = null;
		
		try {
			//1. 파일을 읽어오기 위한 주스트림 생성
			fr = new FileReader("quiz.txt");
			StringBuilder sb = new StringBuilder();
			System.out.println("파일 읽어오기 시작");
			while(true) {
				//read() : 문자 1개를 읽어옴
				//read()는 더이상 읽어올 문자가 없으면 -1을 리턴
				int data = fr.read();
				if(data == -1) {
					break;
				}
				char ch = (char)data;
				sb.append(ch);
			}
			System.out.println("파일 읽어오기 끝");
			
			ArrayList<Byte> list = new ArrayList<Byte>();
			//문자열에서 공백을 기준으로 잘라줄 객체 사용
			StringTokenizer sT = new StringTokenizer(sb.toString()," ");
			while(sT.hasMoreTokens()) {
				String num = sT.nextToken();
				int iNum = Integer.parseInt(num);
				list.add((byte)iNum);
			}
			System.out.println(list.size());
			//내보내기 시작
			//1. 파일내보내기위한 주스트림 생성
			fos = new FileOutputStream("quiz1.gif");
			System.out.println("내보내기 시작");
			for(byte b : list) {
				fos.write(b);
			}
			System.out.println("내보내기 끝");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				//3. 자원반환
				fr.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
