package kh.java.func;

public class ObjectTest {
	public void test1() {
		TestClass1 tc1 = new TestClass1(100,"hi");
		System.out.println("hashcode " + tc1.hashCode());
		TestClass1 tc2 = new TestClass1(200,"hello");
		System.out.println("hashcode " + tc2.hashCode());
		TestClass1 tc3 = tc1;
		System.out.println("hashcode " + tc3.hashCode());
		
		//toString() : 해당 인스턴스의 정보를 문자열로 리턴
		System.out.println(tc1.toString());
		System.out.println(tc2.toString());
		System.out.println(tc3.toString());
		System.out.println(tc1);//출력 시 인스턴스 주소를 출력하면 자동으로 toString()메소드가 호출
		
		try {
			Object obj = tc1.clone();
			TestClass1 tc4 = (TestClass1)obj; //다운캐스팅해서 사용
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void test2() {
		TestClass1 tc1 = new TestClass1();
		TestClass1 tc2 = new TestClass1();
		TestClass1 tc3 = tc2;
		//객체1.equals(객체2) -> 두 객체가 같은 객체인지 체크하는 메소드
		boolean result1 = tc1.equals(tc2);
		boolean result2 = tc1.equals(tc3);
		boolean result3 = tc2.equals(tc3);
		System.out.println("result1 : "+result1);
		System.out.println("result2 : "+result2);
		System.out.println("result3 : "+result3);
		
		String str1 = "hi";
		String str2 = "hi";
		boolean result4 = (str1 == str2);
		System.out.println("result4 : "+result4);
		String str3 = new String("hi");
		String str4 = new String("hi");
		boolean result5 = (str3 == str4);
		System.out.println("result5 : "+result5);
		boolean result6 = str3.equals(str4);
		System.out.println("result6 : "+result6);
	}
	
}
