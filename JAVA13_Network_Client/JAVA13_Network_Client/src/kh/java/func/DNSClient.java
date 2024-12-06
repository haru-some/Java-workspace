package kh.java.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class DNSClient {
	public void client() {
		Scanner sc = new Scanner(System.in);
		//1. 서버 아이피, 서버 포트번호 지정
		String serverIp = "192.168.10.96";
		int serverPort = 8888;
		//자원반환에 필요한 객체 미리 선언
		Socket socket = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		try {
			//2. 지정한 아이피와 포트로 소켓객체 생성 -> 서버에 요청을 보냄
			socket = new Socket(serverIp, serverPort);
			//3. 데이터 전송을 위한 스트림을 소켓에서 추출
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			//4. 보조스트림으로 기능/성능 개선
			dis = new DataInputStream(in);
			dos = new DataOutputStream(out);
			System.out.print("알고싶은 도메인 주소를 입력하세요 : ");
			String domain = sc.nextLine();
			dos.writeUTF(domain);
			String result = dis.readUTF();
			System.out.println(result);
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