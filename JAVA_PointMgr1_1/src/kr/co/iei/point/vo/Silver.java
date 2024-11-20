package kr.co.iei.point.vo;

public class Silver {
	//등급,이름,포인트,보너스 -> 포인트2%
	private String grade;
	private String name;
	private int point;
	
	public Silver() {
		
	}
	
	public Silver(String grade, String name, int point) {
		this.grade = grade;
		this.name = name;
		this.point = point;
	}
	
	public String getGrade() {
		return grade;
	}
	public String getName() {
		return name;
	}
	public int getPoint() {
		return point;
	}
	public double getBonus() {
		return point*0.02;
	}
	
	public void setGrade(String grade) {
		this.grade=grade;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setPoint(int point) {
		this.point=point;
	}
}
