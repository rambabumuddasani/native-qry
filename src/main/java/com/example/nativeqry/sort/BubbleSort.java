package com.example.nativeqry.sort;

import java.util.Arrays;

/*
 * In the bubble sort, as elements are sorted they gradually "bubble" (or rise) to their proper location in the array,
 *  like bubbles rising in a glass of soda. The bubble sort repeatedly compares adjacent elements of an array. The first
 *  and second elements are compared and swapped if out of order.  Then the second and third elements are compared and
 *  swapped if out of order.  This sorting process continues until the last two elements of the array are compared and
 *  swapped if out of order.

Bubble sort has worst-case and average complexity both О(n2)
Performance of bubble sort over an already-sorted list (best-case) is O(n).
 */
public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		System.out.println("Before sorting "+Arrays.toString(input));
		sort(input);
		System.out.println("After sorting "+Arrays.toString(input));
	}

	public static void sort(int[] ar){
		if(ar == null || ar.length == 0){
			return ;
		}
		bubboleSort(ar);
	}

	private static void bubboleSort(int[]  ar){
		for(int n=(ar.length-1);n >= 0;n--){
			for(int i = 0;i<(n);i++){
				if(ar[i] > ar[i+1]){
					//swap the numbers
					int temp = ar[i];
					ar[i] = ar[i+1];
					ar[i+1] = temp;
				}
			}
		}
	}

}
