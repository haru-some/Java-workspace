package kr.co.iei.point.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import kr.co.iei.point.vo.Gold;
import kr.co.iei.point.vo.Grade;
import kr.co.iei.point.vo.Silver;
import kr.co.iei.point.vo.Vip;

public class PointDao {
	ArrayList<Grade> members;

	public PointDao() {
		super();
		importMembers();
		/*
		members = new ArrayList<Grade>();
		
		members.add(new Silver("silver", "멤버1", 1000));
		members.add(new Gold("gold", "멤버2", 2000));
		members.add(new Vip("vip", "멤버3", 3000));
		*/
	}
	
	public void insertMember(Grade g) {
		members.add(g);
		exportMembers();
	}
	
	public ArrayList<Grade> printAllMember() {
		return members;
	}
	
	public int searchMember(String name) {
		for(int i=0;i<members.size();i++) {
			Grade g = members.get(i);
			if(name.equals(g.getName())) {
				return i;
			}
		}
		return -1;
	}
	
	public Grade getMember(int searchIndex) {
		Grade g = members.get(searchIndex);
		return g;
	}
	
	public void updateStudent(int searchIndex, Grade g) {
		members.set(searchIndex, g);
		exportMembers();
	}
	
	public void deleteMember(int searchIndex) {
		members.remove(searchIndex);
		exportMembers();
	}
	
	public void exportMembers() {
		ObjectOutputStream oos = null;
		
		try {
			FileOutputStream fos = new FileOutputStream("backup.txt");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(members);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void importMembers() {
		ObjectInputStream ois = null;
		
		try {
			FileInputStream fis = new FileInputStream("backup.txt");
			ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			members = (ArrayList<Grade>)obj;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ArrayList<Grade> members = new ArrayList<Grade>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
