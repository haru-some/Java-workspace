package kh.java.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class DNSServer {
	public void server() {
		Scanner sc = new Scanner(System.in);
		HashMap<String, String> dns = new HashMap<String, String>();
		dns.put("www.naver.com", "125.209.222.142");
		dns.put("www.google.com", "172.217.175.4");
		dns.put("www.iei.co.kr", "99.83.248.72");
		
		//1. 포트번호 지정
		int port = 8888;
		//반환할 객체 선언
		ServerSocket server = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		try {
			//2. 서버 소켓 객체 생성
			server = new ServerSocket(port);
			System.out.println("DNS 서버 준비 완료");
			
			while(true) {				
				System.out.println("클라이언트 요청 대기.....");
				//3. 클라이언트 접속을 기다림
				//4. 접솝하면 요청을 수락해서 소켓객체를 리턴받아서 저장
				Socket socket = server.accept();
				//5. 데이터를 주고받기위한 스트림을 소켓에서 추출
				OutputStream out = socket.getOutputStream();
				InputStream in = socket.getInputStream();
				//6. 보조스트림으로 기능/성능 개선
				dos = new DataOutputStream(out);
				dis = new DataInputStream(in);
				
				String domain = dis.readUTF();
				String ipAddress = dns.get(domain);
				if(ipAddress != null) {				
					String sendMsg = "["+domain+"]의 주소는 "+ipAddress+"입니다.";
					dos.writeUTF(sendMsg);
				}else {
					dos.writeUTF("주소가 없습니다.");
				}
				System.out.print("서버를 종료하시겠습니까[y/n] : ");
				String select = sc.next();
				if(select.equals("y")) {
					break;
				}
				dis.close();
				dos.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
