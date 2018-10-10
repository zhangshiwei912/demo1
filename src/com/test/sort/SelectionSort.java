package com.test.sort;

import java.util.Arrays;
/**
 * —°‘Ò≈≈–Ú
 */
public class SelectionSort {
	
	public static void main(String[] args) {
		int []a = {49,38,65,97,76,13,27,14,10};
		sort(a);
		System.out.println(Arrays.toString(a));
	}
	
	public static void sort(int [] a){
		for(int i=0;i<a.length;i++) {
			int temp=i;
			for(int j=i+1;j<a.length;j++) {
				if(a[temp]>a[j]) {
					temp=j;
				}
			}
			if(i!=temp)
				swap(a,i,temp);
		}
	}

	public static int[] swap(int[] a, int i, int j) {
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
		System.out.println(Arrays.toString(a));
		return a;
	}
}
