package kh.java.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient {
	public void client() {
		Scanner sc = new Scanner(System.in);
		//1. 서버의 아이피주소,포트번호 지정
		String serverIp = "192.168.10.96";	//서버아이피주소
		int serverPort = 7777;				//서버 포트번호
		//자원 반환할 코드 미리 선언
		Socket socket = null;
		DataOutputStream dos = null;
		DataInputStream dis = null;
		try {
			//2. 지정한 아이피주소와 포트번호로 소켓객체를 생성
			//서버에 접속요청을 보냄
			socket = new Socket(serverIp, serverPort);
			System.out.println("서버 접속 완료");
			//3. 데이터를 주고받기위한 스트림 추출(소켓 내부에 양방향 스트림이 이미 존재)
			OutputStream out = socket.getOutputStream();
			InputStream in = socket.getInputStream();
			//4. 보조스트림으로 성능/기능 개선
			dos = new DataOutputStream(out);
			dis = new DataInputStream(in);
			while(true) {
				//데이터 송/수신 준비 끝
				String serverMsg = dis.readUTF();
				if(serverMsg.equals("exit")) {
					break;
				}
				System.out.println(serverMsg);
				
				System.out.print("서버에게 : ");
				String msg = sc.nextLine();
				dos.writeUTF(msg);
				if(msg.equals("exit")) {
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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