package com.test.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListForEach {
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		
		/**
		 * 1.��forѭ������
		 */
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("_______________________");
		/**
		 * 2.��ǿforѭ��
		 */
		for (String string : list) {
			System.out.println(string);
		}
		System.out.println("_______________________");
		/**
		 * 3.Iterator����������
		 */
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("_______________________");
		
		
		
		
		
	}
}
