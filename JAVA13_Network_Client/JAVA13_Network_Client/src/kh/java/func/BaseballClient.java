package kh.java.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class BaseballClient {
	public void client() {
		Scanner sc = new Scanner(System.in);
		String serverIp = "192.168.10.61";
		int serverPort = 7777;
		
		Socket socket = null;
		DataOutputStream dos = null;
		DataInputStream dis = null;
		
		
		try {
			socket = new Socket(serverIp, serverPort);
			System.out.println("<<<<< Baseball Game >>>>>");
			System.out.println("<<<<< Game Start >>>>>");
			
			OutputStream out = socket.getOutputStream();
			InputStream in = socket.getInputStream();
			
			dos = new DataOutputStream(out);
			dis = new DataInputStream(in);
			int game = 0;
			while(true) {
				int count = 0;
				ArrayList<Integer> clientNums = new ArrayList<Integer>();
				for(int i=0;i<3;i++) {
					System.out.print(count+1+"번째 숫자 입력 : ");
					int clientNum = sc.nextInt();
					clientNums.add(clientNum);			
					count++;
					}
				for(int i=0;i<3;i++) {
					dos.writeInt(clientNums.get(i));
				}
				game++;
				String serverMsg = dis.readUTF();
				System.out.println(serverMsg);
				
				if(serverMsg.equals("you Win!")) {
					break;
				}
				if(game == 9) {
					break;
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
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