package kh.java.func;

//기존 배열보다 조금 더 편리한 배열
public class NewArray<T> {
	private Object[] arr; //모든 데이터를 관리할 배열
	private int index; //arr배열에 다음에 들어갈 위치를 저장하는 변수/현재 저장된 데이터 수
	
	public NewArray() {
		super();
		arr = new Object[10]; //최초 객체 생성하면 길이 10짜리 배열을 사용
		index = 0; //처음에 배열에 들어있는 데이터 수는 0개
	}
	//index변수에 있는 값을 리턴 / 현재 사용중인 배열의 길이를 되돌려주는 메소드
	public int size() {
		return index;
	}
	//데이터를 배열에 맨 뒤에 추가하는 메소드
	public void add(T data) {
		//현재 배열이 꽉차있으면 배열의 크기를 2배로 증가시키고 추가
		if(index == arr.length) {
			//현재 배열 길이의 2배인 배열을 새로 생성
			Object[] newArr = new Object[arr.length*2];
			//기존배열의 데이터를 새로운 배열에 복사
			System.arraycopy(arr, 0, newArr, 0, arr.length);
			//전역변수로 있는 배열을 새로만든 배열로 변경
			arr = newArr;
		}
		arr[index] = data;
		index++;
	}
	//데이터를 배열에 지정한 위치에 추가하는 메소드
	public void add(int i, T data) {
		//현재 배열이 꽉차있으면 배열의 크기를 2배로 증가시키고 추가
		if(index == arr.length) {
			//현재 배열 길이의 2배인 배열을 새로 생성
			Object[] newArr = new Object[arr.length*2];
			//기존배열의 데이터를 새로운 배열에 복사
			System.arraycopy(arr, 0, newArr, 0, arr.length);
			//전역변수로 있는 배열을 새로만든 배열로 변경
			arr = newArr;
		}
		for(int j=index-1;j>=i;j--) {
			arr[j+1] = arr[j];
		}
		arr[i] = data;
		index++;
	}
	
	
	public T get(int i) {
		if(i >= index) {
			//예외객체를 생성해서 throw하면 해당코드 동작 시 에러를 발생시킬 수 있음
			throw new IndexOutOfBoundsException("배열 인덱스 범위를 벗어났습니다. 현재 최대 길이는 "+(index-1)+"까지 입니다.");
			//return null;
		}
		return (T)arr[i];
	}
	//배열에서 지정한 위치의 데이터를 수정하는 메소드
	public void modify(int i, T data) {
		arr[i] = data;
	}
	//배열에서 지정한 위치의 데이터를 삭제하는 메소드
	public void delete(int i) {
		for(int j=i;j<index-1;j++) {
			arr[j] = arr[j+1];
		}
		//arr[--index] = null;
		arr[index-1] = null;
		index--;
	}
	
	
	//배열에 들어있는 모든값을 한번에 출력할 수 있게 오버라이딩
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for(int i=0;i<index;i++) {
			sb.append(arr[i]);
			if(i != index-1) {
				sb.append(", ");
			}
		}
		sb.append("}");
		return sb.toString();
	}
	
	
}
