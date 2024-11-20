package kr.co.iei.point.vo;

public class Silver {
	private String grade;
	private String name;
	private int point;
	private double bonuspoint;
	
	public Silver() {
		
	}
	public Silver(String grade, String name, int point, double bonuspoint) {
		this.grade=grade;
		this.name=name;
		this.point=point;
		this.bonuspoint=point*0.02;
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
	public double getBonusPoint() {
		return bonuspoint;
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
	public void setBonusPoint(double bonuspoint) {
		this.bonuspoint=point*0.02;
	}
	
}

