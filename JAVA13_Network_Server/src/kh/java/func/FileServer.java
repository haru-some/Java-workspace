package kh.java.func;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
	public void server() {
		//1. 서버에서 사용할 포트번호 지정
		int port = 9999;
		//반환할 객체 미리 선언
		ServerSocket server = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		BufferedInputStream bis = null; //파일을 읽어오기 위한 보조스트림
		
		try {
			//2. 서버소켓 객체 생성
			server = new ServerSocket(port);
			System.out.println("파일 서버 준비 완료");
			System.out.println("클라이언트 접속 대기..........");
			//3. 클라이언트 요청을 수락
			//4. 소켓객체 받아서 저장
			Socket socket = server.accept();
			System.out.println("클라이언트 접속 완료");
			//5. 데이터를 주고받을 스트림 추출
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			//6. 보조스트림으로 기능/성능 개선
			dis = new DataInputStream(in);
			dos = new DataOutputStream(out);
			//파일들이 들어있는 폴더를 파일객체로 생성
			//files 폴더의 정보를 가져옴
			File dir = new File("files");
			//폴더 내부의 파일들을 모두 가져옴(File객체를 배열로 리턴)
			File[] files = dir.listFiles();
			//파일의 수를 클라이언트에게 전송(파일이름을 몇개 받아서 출력 할지 알 수 있도록)
			dos.writeInt(files.length);
			//파일명을 모두 전송
			for(File file : files) {
				String filename = file.getName();
				dos.writeUTF(filename);
			}
			String filename = dis.readUTF();//보내줄 파일이름을 클라이언트에게 받음
			
			File sendFile = new File("files/"+filename);//전송해줄파일 정보를 얻어오기 위한 객체 생성
			int fileSize = (int)sendFile.length();//파일크기를 먼저 가져옴
			//바이트배열을 생성해서 메모리에 공간을 미리 확보
			byte[] fileContent = new byte[fileSize];//파일을 메모리에 저장하기위한 배열
			//전송할 파일을 읽어오기 위한 스트림 새로 생성
			FileInputStream fis = new FileInputStream("files/"+filename);
			bis = new BufferedInputStream(fis);
			//확보된 메모리에 파일정보를 읽어옴
			bis.read(fileContent);//생성해놓은 배열에 데이터를 읽어서 생성해놓은 배열에 저장
			
			//클라이언트에게 파일 크기를 전송(클라이언트도 메모리공간 확보)
			dos.writeInt(fileSize);
			//파일전송
			dos.write(fileContent);
			dos.flush();//버퍼에 남아있을 수 있는 데이터를 강제로 내보내기
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				//자원반환
				server.close();
				dis.close();
				dos.close();
				bis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
