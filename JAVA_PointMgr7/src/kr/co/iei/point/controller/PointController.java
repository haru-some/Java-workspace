package kr.co.iei.point.controller;

import java.util.ArrayList;

import kr.co.iei.point.dao.PointDao;
import kr.co.iei.point.view.PointView;
import kr.co.iei.point.vo.Grade;

public class PointController {
	PointView view;
	PointDao dao;
	public PointController() {
		super();
		view = new PointView();
		dao = new PointDao();
	}
	
	public void main() {
		while(true) {
			int select = view.mainMenu();
			switch(select) {
			case 1:
				insertMember();
				break;
			case 2:
				printAllMember();
				break;
			case 3:
				printOneMember();
				break;
			case 4:
				updateMember();
				break;
			case 5:
				deleteMember();
				break;
			case 0:
				return;
			}
		}
	}//main();

	public void insertMember() {
		Grade g = view.insertMember();
		if(g != null) {
			dao.insertMember(g);
		}
	}//insertMember();
	
	public void printAllMember() {
		ArrayList<Grade> members = dao.printAllMember();
		view.printAllMember(members);
	}
	
	public void printOneMember() {
		String name = view.printOneMember();
		int searchIndex = dao.searchMember(name);
		if(searchIndex == -1) {
			view.noSearchMember();
		}else {
			Grade g = dao.getMember(searchIndex);
			view.printMember(g);
		}
	}
	
	public void updateMember() {
		String name = view.updateMember();
		int searchIndex = dao.searchMember(name);
		if(searchIndex == -1) {
			view.noSearchMember();
		}else {
			Grade g = view.getModifyInfo(name);
			if(g != null) {
				dao.updateStudent(searchIndex, g);
				view.updateMsg();
			}
		}
	}
	
	public void deleteMember() {
		String name = view.deleteMember();
		int searchIndex = dao.searchMember(name);
		if(searchIndex == -1) {
			view.noSearchMember();
		}else {
			dao.deleteMember(searchIndex);
			view.deleteMsg();
		}
	}
	
}
