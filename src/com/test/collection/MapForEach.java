package com.test.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapForEach {
	public static void main(String[] args) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("a", "A");
		map.put("b", "B");
		map.put("c", "C");
		map.put("d", "D");
		map.put("e", "E");
		map.put("f", "F");
		
		/**
		 * 1.ʹ��map.keySet()����key��value
		 */
		for(String key:map.keySet()) {
			System.out.println("key:"+key+", value:"+map.get(key));
		}
		System.out.println("______________________");
		/**
		 * 2.ʹ��map.entrySet()����key��value
		 */
		Set<Entry<String, Object>> entrySet = map.entrySet();
		for(Map.Entry<String, Object> entry:entrySet) {
			System.out.println("key:"+entry.getKey()+", value:"+entry.getKey());
		}
		System.out.println("______________________");
		/**
		 * 3.ͨ��map.entrySet()ʹ��iterator����key��value
		 */
		Iterator<Entry<String, Object>> it = map.entrySet().iterator();
		while(it.hasNext()) {
			Entry<String, Object> entry = it.next();
			System.out.println("key:"+entry.getKey()+", value:"+entry.getValue());
		}
		System.out.println("______________________");
		/**
		 * 4.ʹ��map.values()����value ���ܱ���key
		 */
		Collection<Object> values = map.values();
		for (Object value : values) {
			System.out.println("value:"+value);
		}
	}
	
}
