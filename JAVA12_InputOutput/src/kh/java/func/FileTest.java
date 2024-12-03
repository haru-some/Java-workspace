package kh.java.func;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileTest {
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("파일명 입력 : ");
		String filename = sc.nextLine();
		//파일객체
		//파일과 스트림을 연결해서 데이터를 주고받는 객체가 아님
		//FileNotFoundException 처리를 할 필요가 없음
		File file = new File(filename);
		//exists() : 해당파일이 존재하면 true / 존재하지 않으면 false
		if(file.exists()) {
			System.out.println("파일 있음");
			System.out.println("파일 이름 : "+file.getName());
			System.out.println("파일 상대경로 : "+file.getPath());
			System.out.println("파일 절대경로 : "+file.getAbsolutePath());
			System.out.println("파일 크기 : "+file.length()/1024+" KByte");
			System.out.print("해당 파일을 삭제하시겠습니까(1.yes)? : ");
			int select = sc.nextInt();
			if(select == 1) {
				//delete() : 파일을 삭제하고, 삭제 결과를 리턴
				boolean bool = file.delete();
				System.out.println(bool);
			}
		}else {
			System.out.println("파일 없음");
		}
	}
	
	public void test2() {
		Scanner sc = new Scanner(System.in);
		/*
		 텍스트 작성하는 로직이 있다고 가정
		 */
		String filename = null;
		while(true) {
			System.out.print("저장 할 파일명 입력 : ");
			filename = sc.nextLine();
			
			File file = new File("test/"+filename);
			if(file.exists()) {
				System.out.println("이미 사용중인 파일명입니다.");
			}else {
				break;
			}
		}
		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("test/"+filename);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void test3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("저장 할 파일명 입력 : ");
		String filename = sc.nextLine();
		//test.txt라고 입력했다고 가정
		//test        .txt 로 분리
		//원본파일 이름에서 제일 뒤에있는 . 앞까지를 문자열로 가져옴 -> test
		String onlyFilename = filename.substring(0,filename.lastIndexOf("."));
		//원본파일이름에서 제일 뒤에있는 .부터 끝까지를 문자열로 가져옴 -> .txt
		String extention = filename.substring(filename.lastIndexOf("."));
		
		//파일명 중복처리를 위한 변수
		String filepath = null;
		//중복된 파일명이 있으면 뒤에 붙일 숫자 변수
		int count = 0;
		while(true) {
			if(count == 0) {
				//중복검사 첫번째 -> 원본파일명 그대로(숫자붙이지 않은 상태)
				filepath = filename;
			}else {
				//두번째부터는 이미 중복된 파일이름이 있으므로 숫자를 붙인걸로 처리
				filepath = onlyFilename+"_"+count+extention;
			}
			System.out.println(filepath);
			//우리가 설정한 파일이름이 존재하는지 체크
			File file = new File("test/"+filepath);
			if(!file.exists()) {//존재하지 않을경우(중복된 이름이 아닌경우) 반복문 종료
				break;
			}
			count++;
		}
		
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream("test/"+filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
