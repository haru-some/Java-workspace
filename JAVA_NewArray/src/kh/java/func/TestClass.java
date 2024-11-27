package kh.java.func;

public class TestClass {
	public void test1() {
		//이제 배열이 필요하면 배열대신 우리가 만든 NewArray객체를 사용
		//문자열 배열이 필요한 경우 -> String[] arr -> NewArray arr
		//String[] arr = new String[10]; -> 배열길이를 입력해서 초기화를 한 후 사용
		NewArray<String> arr1 = new NewArray<String>();
		//System.out.println("arr1 데이터 수 : "+arr1.size());
		arr1.add("hi");
		arr1.add("hello");
		arr1.add("bye");
		System.out.println(arr1);
		arr1.modify(1, "bye2");
		System.out.println(arr1);
		arr1.delete(1);
		System.out.println(arr1);
		
		/*
		System.out.println("arr1 데이터 수 : "+arr1.size());
		String str = arr1.get(0);
		System.out.println(str);
		*/
		
		NewArray<Integer> arr2 = new NewArray<Integer>();
		
		//System.out.println("arr2 데이터 수 : "+arr2.size());
		arr2.add(10);
		arr2.add(20);
		arr2.add(30);
		System.out.println(arr2);
		arr2.add(2, 300);
		System.out.println(arr2);
		//int num = arr2.get(5);
		//System.out.println("num : "+num);
		
		/*
		System.out.println(arr2);
		arr2.modify(2, 300);
		System.out.println(arr2);
		arr2.delete(0);
		System.out.println(arr2);
		*/
		
		
		/*
		System.out.println("arr2 데이터 수 : "+arr2.size());
		Integer num = arr2.get(1);
		//int num = arr2.get(1); //AutoBoxing
		System.out.println(num);
		*/
		
	}
}	
