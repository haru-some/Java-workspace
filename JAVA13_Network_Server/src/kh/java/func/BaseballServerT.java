package kh.java.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

public class BaseballServerT {
	public void server() {
		Random r = new Random();
		int port = 8989;

		ServerSocket server = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;

		try {
			server = new ServerSocket(port);
			System.out.println("<<<<< Baseball Game >>>>>");

			System.out.println("클라이언트 접속 대기중...");
			Socket socket = server.accept();
			System.out.println("클라이언트가 접속했습니다.");
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			dis = new DataInputStream(in);
			dos = new DataOutputStream(out);
			// 정답번호 생성 : 0~9사이의 랜덤수를 중복되지않게 3개 -> 순서가 중요하므로 ArrayList

			ArrayList<Integer> serverNum = new ArrayList<Integer>();
			while (serverNum.size() < 3) {
				int randomNum = r.nextInt(10);
				if (!serverNum.contains(randomNum)) {
					serverNum.add(randomNum);
				}
			}
			System.out.print("서버 숫자 : ");
			for (int num : serverNum) {
				System.out.print(num + " ");
			}
			System.out.println();
			// 서버가 준비가 끝 -> 이제 게임시작해도 된다는걸 클라이언트에게 알림
			dos.writeInt(1);
			System.out.println("<<<<< Game Start >>>>>");

			int count = 0;
			while (true) {
				ArrayList<Integer> clientNum = new ArrayList<Integer>();
				for (int i = 0; i < 3; i++) {
					int num = dis.readInt();
					clientNum.add(num);
				}
				System.out.print("클라이언트가 입력한 수 : ");
				for (int num : clientNum) {
					System.out.print(num + " ");
				}
				System.out.println();
				// strike, ball 체크
				int strike = 0;
				int ball = 0;
				for (int i = 0; i < clientNum.size(); i++) {
					int num = clientNum.get(i);
					if (serverNum.contains(num)) {
						if (serverNum.get(i) == num) {
							strike++;
						} else {
							ball++;
						}
					}
				}
				count++;
				if(strike == 3) {
					String str = "3스트라이크"; 
					dos.writeUTF(str);
					System.out.println("3 스트라이크. 접속을 종료합니다.");
					break;
				}else {
					String str = strike + "스트라이크" + ball + "볼";
					if(count == 10) {
						str += "기회를 모두 사용하셨습니다. 정답은 "+serverNum.toString();
						dos.writeUTF(str);
						System.out.println("시도횟수 10회로 종료합니다.");
						break;
					}
					dos.writeUTF(str);					
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
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
