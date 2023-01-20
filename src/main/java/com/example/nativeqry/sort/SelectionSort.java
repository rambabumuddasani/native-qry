package com.example.nativeqry.sort;

import java.util.Arrays;


public class SelectionSort {

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
		selectionSort(ar);
	}

	private static void selectionSort(int[] ar){
		for(int i=0;i<ar.length-1;i++){
			int minPos = i;
			for(int j = i+1;j<ar.length;j++){
				if(ar[j] < ar[minPos]){
					minPos = j;
				}	
			}
			swap(ar,minPos,i);
		}
	}
	private static void swap(int[] ar,int minPos, int j){
		int temp = ar[minPos];
		ar[minPos] = ar[j];
		ar[j] = temp;
	}

}
