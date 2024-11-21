package kr.co.iei.point.vo;

public class SearchResult {
	private String type;
	private int index;
	
	public SearchResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SearchResult(String type, int index) {
		super();
		this.type = type;
		this.index = index;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	
}
