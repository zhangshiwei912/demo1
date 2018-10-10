package com.test.sort;

import java.util.Arrays;
/**
 * ≤Â»Î≈≈–Ú
 */
public class InsertSort {
	public static void main(String[] args) {
		int []a = {49,38,65,97,76,13,27,14,10};
		System.out.println(Arrays.toString(a));
		sort2(a);
//		insert(a);
		System.out.println(Arrays.toString(a));
	}
	
	private static void sort1(int[] a) {
		for(int i=1;i<a.length;i++) {
			for(int j=i;j>0;j--){
				if(a[j]<a[j-1]) {
					swap(a,j,j-1);
				}else {
					break;
				}
			}
		}
	}
	
	private static int[] swap(int[] a, int j, int i) {
		int temp=a[j];
		a[j]=a[i];
		a[i]=temp;
		System.out.println(Arrays.toString(a));
		return a;
	}
	
	private static void sort2(int[] a) {
		for(int i=1;i<a.length;i++) {
			int element=a[i];
			int j=i;
			for(;j>0&&element<a[j-1];j--){
					a[j]=a[j-1];
			}
			a[j]=element;
		}
	}
	public static void insert(int[] array) {
        int len = array.length;
        for (int a = 1; a < len; a++) {
            int temp = array[a];
            int b = a - 1;
            for (; b >= 0 && temp < array[b]; b--) {
                array[b + 1] = array[b];
            }
            array[b + 1] = temp;
        }
    }
}
