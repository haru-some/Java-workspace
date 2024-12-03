package kr.co.iei.point.dao;

import java.util.HashMap;
import java.util.HashSet;

import kr.co.iei.point.vo.Grade;

public class PointDao {
	HashMap<String, Grade> members;
	HashSet<String> gradeSets;

	public PointDao() {
		super();
		importMembers();
		
	}
	
	public void insertMember(Grade g) {
		//members.put(gradeSets, g);
	}
	
	public void exportMembers() {
		
		
	}
	
	public void importMembers() {
		
	}
	
}
