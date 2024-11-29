package kh.java.func;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class SetTest {
	public void test1() {
		HashSet<Integer> set = new HashSet<Integer>();
		System.out.println("Set 내부의 데이터 수 : "+set.size());
		//add(param1) : 파라미터로 받은 데이터를 set에 추가하고 그 결과를 반환 (순서가 없고 중복 불가)
		boolean b1 = set.add(10);
		System.out.println(b1);
		System.out.println("Set 내부의 데이터 수 : "+set.size());
		System.out.println(set);
		b1 = set.add(20);
		System.out.println(b1);
		System.out.println(set);
		set.add(30);
		System.out.println(set);
		b1 = set.add(20);
		System.out.println(b1);
		System.out.println(set);
		//remove(param1) : 파라미터로 받은 데이터를 set에서 삭제하고 그 결과를 반환
		b1 = set.remove(100);
		System.out.println(b1);
		System.out.println(set);
		b1 = set.remove(30);
		System.out.println(b1);
		System.out.println(set);
		//set은 여러데이터를 index관리하지 않음
		// -> 여러 데이터 중 특정 데이터에 접근할 방법이 없음 -> 수정이라는 개념이 없음
		// -> 수정이 필요하면 기존데이터를 삭제 -> 새데이터를 추가
		// -> 특정데이터 하나만 꺼내올 방법이 없음
		//1) 반복자(iterator)를 이용한 방법
		Iterator<Integer> iter = set.iterator();
		//set이랑 다른 객체 -> set을 Iterator화한 데이터
		
		
		//next() : 값 한개를 꺼내옴
		//hasNext() : 꺼내올 값이 남아있으면 true / 없으면 false를 리턴하는 메소드
		while(iter.hasNext()) {
			int num = iter.next();
			System.out.println(num);
		}
		System.out.println(set);
		System.out.println("-------------------------------");
		/*
		int num = iter.next();
		System.out.println(num);
		num = iter.next();
		System.out.println(num);
		*/
		//2) foreach 사용
		for(int num : set) {
			System.out.println(num);
		}
		
		//3) HashSet을 ArrayList로 변환
		ArrayList<Integer> list = new ArrayList<Integer>(set);
		System.out.println(list);
		/*
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int num : set) {
			list.add(num);
		}
		System.out.println(list.get(0));
		*/
	}
	public void test2() {
		HashSet<TestData> set = new HashSet<TestData>();
		TestData td1 = new TestData(10,"hi");
		set.add(td1);
		System.out.println(set);
		TestData td2 = new TestData(20,"bye");
		set.add(td2);
		System.out.println(set);
		TestData td3 = new TestData(10,"hi");
		set.add(td3);
		System.out.println(set);
		TestData td4 = td2;
		set.add(td4);
		System.out.println(set);
		
	}
}
