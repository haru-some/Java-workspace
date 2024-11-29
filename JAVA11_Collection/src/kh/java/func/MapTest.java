package kh.java.func;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapTest {
	public void test1() {
		//인덱스번호를 이용해서 문자열을 관리하는 ArrayList
		ArrayList<String> list = new ArrayList<String>();
		list.add("hi");
		list.add("hello");
		list.add("hi");
		System.out.println(list);
		//리스트와 유사하게 번호를 통해서 문자열을 관리하는 HashMap
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "hi");
		map.put(1, "hello");
		map.put(2, "hi");
		System.out.println(map);
		System.out.println(map.get(1));
	}
	public void test2() {
		//문자열을 통해서 문자열을 관리
		HashMap<String, String> map = new HashMap<String, String>();
		//put(key,value) : map에 데이터를 추가
		map.put("one", "hi");
		map.put("two", "hello");
		map.put("three", "bye");
		System.out.println(map);
		//get(key) : map에서 매개변수로 받은 key에 해당하는 value를 리턴
		String data = map.get("three");
		System.out.println(data);
		String data2 = map.get("four");//get으로 요청 시 없는 key를 요청하면 null을 리턴
		System.out.println(data2);
		//put메소드 사용 시 이미 사용중인 key인 경우 나중에 put되는 데이터로 덮어쓰기 -> 기존 데이터가 사라짐
		map.put("three", "byebye");
		System.out.println(map);
		//put메소드 사용 시 이미 들어있는 value를 다시 넣는건 아무 상관 없음(key만 안겹치면 가능)
		map.put("four", "hi");
		System.out.println(map);
		//containsKey(param) : 매개변수로 전달한 데이터를 키로 사용중이면 true / 사용중이지 않으면 false
		boolean bool1 = map.containsKey("one");
		boolean bool2 = map.containsKey("zero");
		System.out.println("bool1 : "+bool1);
		System.out.println("bool2 : "+bool2);
		//containsValue(param) : 매개변수로 전달한 데이터가 value에 존재하면 true / 아니면 false
		boolean bool3 = map.containsValue("hello");
		boolean bool4 = map.containsValue("bye");
		System.out.println("bool3 : "+bool3);
		System.out.println("bool4 : "+bool4);
		//remove(key) : 키값에 해당하는 데이터를 삭제하고 삭제된 value를 리턴
		String str = map.remove("two");
		System.out.println(map);
		System.out.println(str);
		//map에 있는 데이터를 가져올때는 key를 사용해야 함
		//map에 있는 모든 데이터를 가져오고 싶으면? -> 모든 key를 알고있어야 함
		//keySet() : map에있는 모든 key값을 Set(HashSet)형태로 반환
		Set<String> keySet = map.keySet();
		for(String key : keySet) {
			System.out.println(map.get(key));
		}
		
	}
}
