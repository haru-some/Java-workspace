package kh.java.func;

public class GenericEx4<T,E> {
	private T data1;
	private E data2;
	public GenericEx4() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GenericEx4(T data1, E data2) {
		super();
		this.data1 = data1;
		this.data2 = data2;
	}
	public T getData1() {
		return data1;
	}
	public void setData1(T data1) {
		this.data1 = data1;
	}
	public E getData2() {
		return data2;
	}
	public void setData2(E data2) {
		this.data2 = data2;
	}
}
