package kr.co.iei.point.vo;

public class Vip extends Grade {

	
	public Vip() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vip(String grade, String name, int point) {
		super(grade, name, point);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getBonus() {
		
		return Math.floor(getPoint()*0.07);
		
	}
	
}
