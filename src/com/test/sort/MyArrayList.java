package com.test.sort;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<AnyType> implements Iterable {

	// ��ʼ����
	private static final int DEFAULT_CAPACITY = 10;
	// ������ݵ�����
	private AnyType[] theItems;
	// ��ǰԪ�ظ���
	private int theSize;

	/**
	 *  ʵ����ArrayListʱ���г�ʼ��
	 */
	public MyArrayList() {
		init();
	}

	/**
	 *  ��ʼ��һ��ArrayList
	 */
	private void init() {
		theItems = (AnyType[]) new Object[DEFAULT_CAPACITY];
		theSize = 0;
	}

	/**
	 *  ��ArrayListĩβ���Ԫ��
	 */
	public boolean add(AnyType element) {
		add(theSize, element);
		return true;
	}

	/**
	 *  ��ָ��λ�����Ԫ��
	 */
	public boolean add(int idx, AnyType element) {
		// ��������������������������
		if (theSize == theItems.length) {
			AnyType[] theOldItems = theItems;
			theItems = (AnyType[]) new Object[theSize * 2];
			// ��ԭ�������е�Ԫ�ط��뵽���ݺ����������
			for (int i = 0; i < theSize; i++) {
				theItems[i] = theOldItems[i];
			}
		}

		// ָ��λ�����Ԫ��,������λ�ü�����Ԫ�ض������ƶ�һλ
		for (int i = theSize; i > idx; i--) {
			theItems[i] = theItems[i - 1];
		}
		// ��Ԫ�ز��뵽idx��λ��
		theItems[idx] = element;
		//��ǰԪ�ظ�����1
		theSize++;
		
		return true;
	}
	
	/**
	 * ��ȡָ��λ�õ�Ԫ��
	 */
	public AnyType get(int idx) {
		if(idx>=theSize||idx<0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return theItems[idx];
	}
	
	/**
	 * �Ƴ�ָ��λ�õ�Ԫ��
	 */
	public AnyType remove(int idx){
		if(idx>=theItems.length||idx<0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		AnyType removeElemnet=theItems[idx];
		//��ɾ��λ�ú����Ԫ����ǰ�ƶ�һλ
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