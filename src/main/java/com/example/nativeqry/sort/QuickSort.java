package com.example.nativeqry.sort;

public class QuickSort {

	
	public static void sort(int[] ar){
		if(ar == null || ar.length == 0)
			return;
		quickSort(ar, 0, ar.length - 1);
	}
	
	private static void quickSort(int[] ar, int startIndex, int endIndex){
		//if(startIndex >= endIndex) return;
		
		int i = startIndex;
		int j = endIndex;
		// find the pivot, which sould me middel of the startIndex and endIndex
		int pivot = ar[startIndex+(endIndex - startIndex)/2];
		//int pivot = ar[(endIndex - startIndex)/2];
		while(i <= j){
			while(ar[i] < pivot){
				i++;
			}
			while(ar[j] > pivot){
				j--;
			}
			if(i <= j){
				// do swap, and move the i, j position to next.
				swap(ar,i,j);
				i++;
				j--;
			}
		}
		if(startIndex < j){
			quickSort(ar, startIndex, j);
		}
		if(i < endIndex){
			quickSort(ar, i, endIndex);
		}

		
	}
	private static void swap(int[] ar, int i, int j){
		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = {45, 1, 34,74, 32, 12, 2, 4};
		//int[] ar = {1 ,12 , 5, 26,  7, 14,  3,  7,  2};
		//int[] ar = {24,2,45,20,56,75,2,56,99,53,12};
		System.out.println("Before sorting ");
		printData(ar);
		sort(ar);
		System.out.println("After sorting ");
		printData(ar);
	}
	
	public static void printData(int[] arr){
		for(int i : arr){
			System.out.print(" "+i);
		}
		System.out.println();
	}


}
