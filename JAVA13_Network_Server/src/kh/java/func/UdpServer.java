package kh.java.func;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpServer {
	public void server() {
		//1. 서버에서 사용할 포트번호 지정
		//UDP 사용 가능 포트번호 : 0 ~ 65535
		int port = 8888;
		//자원반환할 객체 미리 선언
		DatagramSocket socket = null;
		
		try {
			//2. DatagramSocket객체 생성(UDP 서비스 준비 완료)
			socket = new DatagramSocket(port);
			System.out.println("서버 소켓 생성 완료");
			//클라이언트에서 들어오는 메세지를 저장할 공간생성
			byte[] inMsg = new byte[1024];
			DatagramPacket inPacket = new DatagramPacket(inMsg, inMsg.length);
			
			socket.receive(inPacket);//클라이언트의 메세지를 받기위해서 기다리는 코드
			//udp는 DatagramPacket이라는 형태로 데이터를 주고 받음
			//소켓에게 데이터를 받을 수 있는 객체정보를 알려줌
			//클라이언트가 보낸 메세지가 DatagramPacket에 연결되어있는 배열에 저장
			//전달받은 데이터(byte[])를 문자열로 변환
			//String 생성자에 byte[]을 넣으면 byte배열을 문자열 형태로 변환
			//trim() : 사용하지 않는부분을 잘라내는 메소드
			String clientMsg = new String(inMsg).trim();
			System.out.println(clientMsg);
			//UDP는 연결하고 통신하는 구조가 아님
			//클라이언트가 전달해준 패킷에서 클라이언트 아이피/포트를 추출해야함
			InetAddress clientIp = inPacket.getAddress();
			int clientPort = inPacket.getPort();
			String msg = "난 UDP Server다!!";
			byte[] outMsg = msg.getBytes();
			DatagramPacket outPacket = new DatagramPacket(outMsg, outMsg.length, clientIp, clientPort);
			socket.send(outPacket);
			
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			socket.close();
		}
	}
}
