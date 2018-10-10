package com.test.sort;

import java.util.Arrays;
/**
 * ц╟ещеепР
 */
public class BubbleSort {
	public static void main(String[] args) {
		int []a = {49,38,65,97,76,13,27,14,10};
		System.out.println(Arrays.toString(a));
		bubbleSort(a);
		System.out.println(Arrays.toString(a));
	}

	private static void bubbleSort(int[] a) {
		for(int i=0;i<a.length;i++){
			for (int j = 1; j < a.length; j++) {
				if(a[j]<a[j-1]) {
					int temp=a[j];
					a[j]=a[j-1];
					a[j-1]=temp;
				}
			}
		}
	}
}
