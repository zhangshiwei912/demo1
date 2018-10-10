package com.test.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetForEach {
	
	
	public static void main(String[] args) {
		Set<String> set=new HashSet<String>();
		set.add("a");
		set.add("b");
		set.add("c");
		set.add("d");
		set.add("e");
		
		/**
		 * 1.使用增强for循环遍历
		 */
		for (String string : set) {
			System.out.println(string);
		}
		System.out.println("__________________");
		/**
		 * 2.使用set.iterator()遍历
		 */
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
}
