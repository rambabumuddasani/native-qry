package com.example.nativeqry.sort;

public class MyQuickSort {

	//private int array[];
	private int length;

	public void sort(int[] inputArr) {

		if (inputArr == null || inputArr.length == 0) {
			return;
		}
		//this.array = inputArr;
		length = inputArr.length;
		quickSort(inputArr,0, length - 1);
	}

	private void quickSort(int[] ar, int startIndex, int endIndex) {

		int i = startIndex;
		int j = endIndex;
		// calculate pivot number, I am taking pivot as middle index number
		int pivot = ar[startIndex+(endIndex-startIndex)/2];
		// Divide into two arrays
		while (i <= j) {
			/**
			 * In each iteration, we will identify a number from left side which 
			 * is greater then the pivot value, and also we will identify a number 
			 * from right side which is less then the pivot value. Once the search 
			 * is done, then we exchange both numbers.
			 */
			while (ar[i] < pivot) {
				i++;
			}
			while (ar[j] > pivot) {
				j--;
			}
			if (i <= j) {
				exchangeNumbers(ar,i, j);
				//move index to next position on both sides
				i++;
				j--;
			}
		}
		// call quickSort() method recursively
		if (startIndex < j)
			quickSort(ar,startIndex, j);
		if (i < endIndex)
			quickSort(ar,i, endIndex);
	}

	private void exchangeNumbers(int[] array,int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String a[]){

		MyQuickSort sorter = new MyQuickSort();
		int[] input = {24,2,45,20,56,75,2,56,99,53,12};
		sorter.sort(input);
		for(int i:input){
			System.out.print(i);
			System.out.print(" ");
		}
	}
}