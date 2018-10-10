package com.test.sort;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<AnyType> implements Iterable {

	// 初始容量
	private static final int DEFAULT_CAPACITY = 10;
	// 存放数据的数组
	private AnyType[] theItems;
	// 当前元素个数
	private int theSize;

	/**
	 *  实例化ArrayList时进行初始化
	 */
	public MyArrayList() {
		init();
	}

	/**
	 *  初始化一个ArrayList
	 */
	private void init() {
		theItems = (AnyType[]) new Object[DEFAULT_CAPACITY];
		theSize = 0;
	}

	/**
	 *  在ArrayList末尾添加元素
	 */
	public boolean add(AnyType element) {
		add(theSize, element);
		return true;
	}

	/**
	 *  在指定位置添加元素
	 */
	public boolean add(int idx, AnyType element) {
		// 如果容量已满，对数组进行扩容
		if (theSize == theItems.length) {
			AnyType[] theOldItems = theItems;
			theItems = (AnyType[]) new Object[theSize * 2];
			// 将原来数组中的元素放入到扩容后的新数组中
			for (int i = 0; i < theSize; i++) {
				theItems[i] = theOldItems[i];
			}
		}

		// 指定位置添加元素,将插入位置及其后的元素都往后移动一位
		for (int i = theSize; i > idx; i--) {
			theItems[i] = theItems[i - 1];
		}
		// 将元素插入到idx的位置
		theItems[idx] = element;
		//当前元素个数加1
		theSize++;
		
		return true;
	}
	
	/**
	 * 获取指定位置的元素
	 */
	public AnyType get(int idx) {
		if(idx>=theSize||idx<0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return theItems[idx];
	}
	
	/**
	 * 移除指定位置的元素
	 */
	public AnyType remove(int idx){
		if(idx>=theItems.length||idx<0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		AnyType removeElemnet=theItems[idx];
		//将删除位置后面的元素向前移动一位
		for(int i=idx;i<theItems.length-1;i++) {
			theItems[i]=theItems[i+1];
		}
		return removeElemnet;	
	}	
	
	
	@Override
	public Iterator iterator() {
		return null;
	}

	public static void main(String[] args) {
		MyArrayList<Integer> list = new MyArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		System.out.println(list);
	}

}