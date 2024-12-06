package kh.java.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class QuizClient {
	public void client() {
		Scanner sc = new Scanner(System.in);
		//1. 서버 아이피,포트 지정
		String serverIp = "1.220.236.74";
		int serverPort = 18080;
		//반환할 객체 미리 선언
		Socket socket = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		try {
			//2. 서버에 접속
			socket = new Socket(serverIp, serverPort);
			//3. 데이터 주고받을 스트림 추출
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			//4. 보조스트림으로 기능/성능 개선
			dis = new DataInputStream(in);
			dos = new DataOutputStream(out);
			
			while(true) {				
				String serverMsg = dis.readUTF();
				System.out.println(serverMsg);
				String lastLetter = serverMsg.substring(serverMsg.length()-1);
				if(lastLetter.equals("?")) {
					System.out.print("답변 입력 : ");
					String an = sc.nextLine();
					dos.writeUTF(an);
				}else if(lastLetter.equals("끝")) {
					break;
				}
				/*
				char lastLetter = serverMsg.charAt(serverMsg.length()-1);
				if(lastLetter == '?') {
					System.out.print("답변 입력 : ");
					String an = sc.nextLine();
					dos.writeUTF(an);
				}else if(lastLetter == '끝') {
					break;
				}
				*/
				/*
				boolean check1 = serverMsg.endsWith("?");
				//boolean check2 = serverMsg.endsWith("끝");
				System.out.println("check1 : "+check1);
				if(check1) {
					System.out.print("답변 입력 : ");
					String an = sc.nextLine();
					dos.writeUTF(an);
				}else if(serverMsg.endsWith("끝")) {
					break;
				}
				*/
			}
			
		} catch (IOException e) {
			System.out.println("서버가 답 틀렸다고 나 내보냄....");
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}finally {
			try {
				//5. 자원반환
				socket.close();
				dis.close();
				dos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}