package kr.co.iei.point.controller;

public interface PointController {
	public void main();
	public void insertMember();
	public void printAllMember();
	public void printOneMember();
	public void updateMember();
	public void deleteMember();
	public int searchMember(String name);
}
