package com.example.nativeqry.sort;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		System.out.println("Before sorting "+Arrays.toString(input));
		sort(input);
		System.out.println("After sorting "+Arrays.toString(input));

	}

	public static void sort(int[] ar){
		insertionSort(ar);
	}

	private static void swap(int[] ar,int i, int j){
		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
	}


	private static void insertionSort(int[] ar){
		for(int i=1;i<ar.length;i++){
			int key = ar[i];
			int j = i-1;
			while(j >= 0 && key < ar[j]){
				swap(ar,j,j+1);
				j--;
			}
		}
	}
}