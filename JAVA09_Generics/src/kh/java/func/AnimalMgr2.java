package kh.java.func;

public class AnimalMgr2 {
	//data변수에는 Tiger도 들어갈 수 있고, Rabbit도 들어갈 수 있음 -> 공통부모 -> Animal
	private Animal data;

	public AnimalMgr2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnimalMgr2(Animal data) {
		super();
		this.data = data;
	}

	public Animal getData() {
		return data;
	}

	public void setData(Animal data) {
		this.data = data;
	}
	
}
