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
import java.util.Scanner;

public class BaseballServer {
	public void server() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		ArrayList<Integer> serverNums = new ArrayList<Integer>();
		int count = 0;
		int port = 7777;
		
		ServerSocket server = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		try {
			server = new ServerSocket(port);
			System.out.println("<<<<< Baseball Game >>>>>");
			System.out.println("클라이언트 접속을 기다립니다.....");
			Socket socket = server.accept();
			System.out.println("클라이언트 접속했습니다.");
			
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			dis = new DataInputStream(in);
			dos = new DataOutputStream(out);
			
			int game = 0;
			
			for(int i=0;i<3;i++) {
				int rNum = r.nextInt(10);
				if(!serverNums.contains(rNum)) {
					serverNums.add(rNum);
				}else {
					i--;
				}	
			}
			
			while(true) {
				ArrayList<Integer> clientNums = new ArrayList<Integer>();
				int strike = 0;
				int ball = 0;
				
				if(game == 0) {
					System.out.println("<<<<< Game Start >>>>>");
					System.out.print("서버숫자 : ");
					for(int i=0;i<3;i++) {
						System.out.print(serverNums.get(i)+" ");					
					}
				}
				System.out.println();
				System.out.print("클라이언트가 입력한 수 -> ");
				for(int i=0;i<3;i++) {
					int clientNum = dis.readInt();
					
					
					clientNums.add(clientNum);
				}
				for(int i=0;i<3;i++) {
					System.out.print(clientNums.get(i)+" ");
				}
				for(int i=0;i<3;i++) {
					if(serverNums.get(i)==clientNums.get(i)) {
						strike++;
					}else if(serverNums.contains(clientNums.get(i))) {
						ball++;
					}
				}
				
				if(strike == 3) {
					String msg = "축하합니다!!";
					dos.writeUTF(msg);
					System.out.println();
					System.out.println("3스트라이크. 현재 클라이언트 접속을 종료합니다.");
					break;
				}else if(game == 9){
					String msg = game+1+"회 ----->"+strike+"스트라이크"+ball+"볼"+" 기회를 모두 사용하셨습니다. 정답은 "
									+serverNums.get(0)+" "+serverNums.get(1)+" "+serverNums.get(2);
					dos.writeUTF(msg);
					System.out.println();
					System.out.println("시도횟수 10회로 클라이언트 접속을 종료합니다.");
					break;
				}else {
					String msg = game+1+"회 ----->"+strike+"스트라이크"+ball+"볼";
					dos.writeUTF(msg);
				}
				
				game++;
				
				/*
				System.out.println("<<<<< Baseball Game >>>>>");
				System.out.println("<<<<< Game Start >>>>>");
				System.out.print(count+1+"번째 숫자 입력 : ");
				*/
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
