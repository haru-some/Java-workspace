package kr.co.iei.point.dao;

import java.io.File;
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
		importMember();
		/*
		members = new ArrayList<Grade>();
		
		members.add(new Silver("silver", "회원1", 1000));
		members.add(new Silver("silver", "회원2", 2000));
		members.add(new Gold("gold", "회원3", 1000));
		members.add(new Gold("gold", "회원4", 2000));
		members.add(new Vip("vip", "회원5", 1000));
		members.add(new Vip("vip", "회원6", 2000));
		*/
		
		//importMembers();
	}
	
	public void insertMember(String grade, String name, int point) {
		switch(grade) {
		case "silver":
			members.add(new Silver(grade, name, point));
			break;
		case "gold":
			members.add(new Gold(grade, name, point));
			break;
		case "vip":
			members.add(new Vip(grade, name, point));
			break;
		default:
			System.out.println("올바른 회원 등급을 입력해주세요.");
			break;
		}
		exportMember();
	}
	
	/*
	public void insertMember(Grade g) {
		members.add(g);
	}
	
	public void insertMember(Silver s) {
		Grade g = (Grade)s;
		members.add(g);
	}
	
	public void insertMember(Gold g) {
		Grade grade = g;
		members.add(grade);
	}
	
	public void insertMember(Vip v) {
		members.add(v);
	}
	*/
	
	public ArrayList<Grade> printAllMember() {
		return members;
	}
	
	public int searchMember(String name) {
		for(int i=0;i<members.size();i++) {
			Grade g = members.get(i);
			String searchName = g.getName();
			if(name.equals(searchName)) {
				return i;
			}
		}
		return -1;
	}
	
	public Grade getMember(int searchIndex) {
		Grade g = members.get(searchIndex);
		return g;
	}
	
	public void updateMember(int searchIndex, String grade, String name, int point) {
		switch(grade) {
		case "silver":
			Silver s = new Silver(grade, name, point);
			members.set(searchIndex, s);
			break;
		case "gold":
			Gold g = new Gold(grade, name, point);
			members.set(searchIndex, g);
			break;
		case "vip":
			Vip v = new Vip(grade, name, point);
			members.set(searchIndex, v);
			break;
		}
		exportMember();
	}
	
	public void deleteMember(int searchIndex) {
		members.remove(searchIndex);
		exportMember();
	}
	
	public boolean deleteMember(String name) {
		int searchIndex = searchMember(name);
		if(searchIndex == -1) {
			return false;
		}else {
			members.remove(searchIndex);
			exportMember();
			return true;
		}
	}
	
	public void exportMember() {
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
	
	public void importMember() {
		File checkFile = new File("backup.txt");
		if(!checkFile.exists()) {
			members = new ArrayList<Grade>();
			return;
		}
		ObjectInputStream ois = null;
		
		try {
			FileInputStream fis = new FileInputStream("backup.txt");
			ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			members = (ArrayList<Grade>)obj;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//members = new ArrayList<Grade>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}