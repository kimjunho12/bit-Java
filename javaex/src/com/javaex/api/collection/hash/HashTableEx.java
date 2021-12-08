package com.javaex.api.collection.hash;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class HashTableEx {

	public static void main(String[] args) {
		Map<String, Integer> map = new Hashtable<String, Integer>();
//		Hashtable<String, Integer> map = new Hashtable<String, Integer>();
//		Map<String, Integer> map = new HashMap<String, Integer>();
		
		// 키-값 쌍으로 저장
		// 맵에 데이터 넣기
		map.put("SOCCER", 11);
		map.put("BASEBALL", 9);
		map.put("VOLLEYBALL", 6);
		
		System.out.println(map);	// 키는 HashSet : 중복 될 수 없고, 순서가 없다.
		map.put("VOLLEYBALL", 12);
		System.out.println(map);
		
		// 키 포함 여부
		System.out.println("SOCCER 키가 있는가? " + map.containsKey("SOCCER"));
		// 값 포함 여부
		System.out.println("값에 9가 있는가? " + map.containsValue(9));
		
		// Iterator
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.printf("Key %s => value %d%n",  key, map.get(key));
		}
		
		// 맵 비우기
		map.clear();
		System.out.println(map);
	}

}
