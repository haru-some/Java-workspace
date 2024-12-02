package kh.java.func;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ByteStreamTest {
	public void primaryStream() {
		Scanner sc = new Scanner(System.in);
		System.out.print("저장할 파일 이름 입력 : ");
		String filename = sc.nextLine();
		//0. 자원반환을 하기위해서 변수를 미리 선언(try안에서 선언하면 try에서밖에 사용을 못하기 때문에)
		FileOutputStream fos = null;
		//1. 스트림 생성 -> 2. 메소드를 통한 입력 or 출력 -> 3. 자원 반환
		try {
			//스트림이 생성되면서 지정한 위치에 파일명으로 파일이 새로 생성
			//c드라이브부터 경로를 설정해주면 해당 경로에 만들어지고, 파일명만넣으면 프로젝트 폴더에 생성
			fos = new FileOutputStream(filename);//1. 스트림 생성 코드
			System.out.println("종료는 exit를 입력하세요.");
			while(true) {
				System.out.print("내용 입력 : ");
				String str = sc.nextLine()+"\r\n";
				if(str.equals("exit\r\n")) {
					break;
				}
				//FileOutputStream은 byte스트림으로 데이터를 내보낼때 byte단위로 내보내야 함
				//-> 문자열은 byte스트림으로 내보내기에는 너무 큼 -> 문자열을 byte단위로 쪼갬
				byte[] data = str.getBytes();
				fos.write(data);//스트림을 통해서 파일에 데이터를 내보내기 -> 2. 메소드를 통한 출력
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fos.close();//3. 자원반환
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}