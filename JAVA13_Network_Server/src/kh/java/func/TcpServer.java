package kh.java.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpServer {
	public void server() {
		Scanner sc = new Scanner(System.in);
		//1. 서버에서 사용할 포트번호 지정
		//사용 할 수 있는 포트번호 범위 : 0 ~ 65535 중 1개를 사용
		//0~1000 사이의 번호는 잘 알려진포트로 일반적으로 사용하지 않음
		int port = 7777;
		
		//반환할 객체 미리 선언
		//서버에서 포트를 열고 접속을 기다리는 객체
		ServerSocket server = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		try {
			//2. 서버소켓객체
			//생성자로 전달한 포트번호로 서비스를 제공할 객체 생성 완료
			server = new ServerSocket(port);
			System.out.println("[서버 준비 완료]");
			System.out.println("클라이언트 접속 기다리는 중.........");
			//3. server.accept() : 클라이언트 접속을 기다리는 코드
			//4. 클라이언트 접속 요청이 들어오면 수락해서 통신하기위한 소켓객체를 전달받음
			Socket socket = server.accept();
			System.out.println("클라이언트 접속 완료");
			//5. 데이터를 주고받기위한 스트림 추출(소켓내부에 양방향 스트림이 이미 존재)
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			//6. 보조스트림으로 성능/기능 개선
			dis = new DataInputStream(in);
			dos = new DataOutputStream(out);
			//데이터 송/수신 준비 끝
			while(true) {	
				//서버가 데이터 전송
				System.out.print("TO.Client : ");
				String msg = sc.nextLine();
				dos.writeUTF(msg);
				if(msg.equals("exit")) {
					break;
				}
				String clientMsg = dis.readUTF();
				if(clientMsg.equals("exit")) {
					break;
				}
				System.out.println(clientMsg);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				//7. 자원반환
				server.close();
				dis.close();
				dos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}