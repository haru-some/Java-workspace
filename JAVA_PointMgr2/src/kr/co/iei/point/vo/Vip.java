package kr.co.iei.point.vo;

public class Vip extends Silver{

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
		return 0.05*getPoint();
	}
}
