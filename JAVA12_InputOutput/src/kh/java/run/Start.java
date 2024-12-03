package kh.java.run;

import kh.java.func.ByteStreamTest;
import kh.java.func.CharStream;
import kh.java.func.FileTest;
import kh.java.func.StreamTest;
import kh.java.func.UserMgr;
import kh.java.func.UserMgr2;

public class Start {

	public static void main(String[] args) {
		//ByteStreamTest bt = new ByteStreamTest();
		//bt.primaryStream();
		//CharStream cs = new CharStream();
		//cs.readerTest();
		//StreamTest st = new StreamTest();
		//st.test2();
		//FileTest ft = new FileTest();
		//ft.test3();
		UserMgr2 um = new UserMgr2();
		um.main();
	}

}
