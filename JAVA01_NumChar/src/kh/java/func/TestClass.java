package kh.java.func;

public class TestClass {

	public void test1() {
		System.out.println(1);//정수 1 출력
		System.out.println(1.0);//실수 1 출력
		System.out.println('1');//문자 1 출력
		System.out.println("1");//문자열 1 출력
	}
	public void test2() {
		System.out.println(1+1);
		System.out.println(1.0+1.0);
		System.out.println('1'+'1');
		System.out.println("1"+"1");
		//문자열은 자바에서 제공하는 특수한 형태의 데이터
		//문자열 더하기는 숫자 연산이아니라 두 문자열을 이어서 붙임
		System.out.println(1-1);
		System.out.println(1.0-1.0);
		System.out.println('1'-'1');
		//System.out.println("1"-"1");
		//문자열은 숫자연산을 하지 않으므로 연산이 불가능
		//다만, + 연산은 많이 사용되기 때문에 처리하게 만들어 준 것
	}
	public void test3() {
		//자바는 서로 다른 자료형끼리 연산이 불가능
		//만약 서로 다른 자료형을 연산하는 경우
		//-> 범위가 더 큰 자료형으로 통일한 다음 연산
		//정수 + 실수 = 실수 + 실수 => 연산
		//1+1.1 => 1.0 + 1.1 = 2.1
		System.out.println(1+1.1);
		//정수+문자 => 정수 + 정수 => 연산
		//1 + '1' => 1 + 49 = 50
		System.out.println(1+'1');
		//문자+실수 => 정수+실수 => 실수+실수
		//'1'+1.0 => 49+1.0 => 49.0+1.0 = 50.0
		System.out.println('1'+1.0);
	}
	public void test4() {
		//문자열은 다른 자료형과도 +연산만 가능
		//서로다른 자료형 변환 시 문자열이 우선순위가 가장 높음
		//문자열로 모두 변환해서 더하기
		//문자열 + 정수 => 문자열 + 문자열
		//"1"+1 => "1"+"1" = "11"
		System.out.println("1"+1);
		//실수+문자열 => 문자열 + 문자열
		//1.1 + "1" => "1.1"+"1"="1.11"
		System.out.println(1.1+"1");
		//문자+문자열 => 문자열 + 문자열
		//'1'+"1" => "1" + "1" = "11"
		System.out.println('1'+"1");
	}
	public void test5() {
		System.out.println(10+20+"A");
		System.out.println("A"+10+20);
	}
}
