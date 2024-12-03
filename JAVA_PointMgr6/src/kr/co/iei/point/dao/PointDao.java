package kr.co.iei.point.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import kr.co.iei.point.vo.Gold;
import kr.co.iei.point.vo.Grade;
import kr.co.iei.point.vo.Silver;
import kr.co.iei.point.vo.Vip;

public class PointDao {
	HashMap<String, Grade> members;
	HashSet<String> gradeSets;

	public PointDao() {
		super();
		gradeSets.add("silver");
		gradeSets.add("gold");
		gradeSets.add("vip");
		importMembers();
		
	}
	
	public boolean gradeSetContains(String g) {
		return gradeSets.contains(g);
	}
	
	public void insertMember(String grade, String name, int point) {
		switch(grade) {
		case "silver":
			members.put(name, new Silver(grade, name, point));
			break;
		case "gold":
			members.put(name, new Gold(grade, name, point));
			break;
		case "vip":
			members.put(name, new Vip(grade, name, point));
			break;
		}
	}
	
	public Set<String> getMemberList(){
		Set<String> keySet = members.keySet();
		return keySet;
	}
	
	public void exportMembers() {
		
		
	}
	
	public void importMembers() {
		
	}
	
}
