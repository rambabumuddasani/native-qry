package com.example.nativeqry.sort;

import java.util.Arrays;


public class MergeSort {

	
	public static void sort(int[] ar){
		if(ar == null || ar.length == 0){
			return ;
		}
		mergeSort(ar);
	}
	
	private static void mergeSort(int[] ar){
		if(ar.length <= 1){
			return;
		}
		int[] firstHalf = new int[ar.length/2];
		int[] secondHalf = new int[ar.length - firstHalf.length];
		for(int i = 0;i<firstHalf.length;i++)
			firstHalf[i] = ar[i];
		for(int i=firstHalf.length, j=0 ;i<ar.length;i++,j++)
			secondHalf[j] = ar[i];
		mergeSort(firstHalf	);
		mergeSort(secondHalf);
		merge(firstHalf,secondHalf,ar);
	}
	
	private static void merge(int[] fistHalf, int[] secondHalf,int[] orgArr){
		int fIndex = 0;
		int sIndex = 0;
		int orgArIndex = 0;
		while(fIndex < fistHalf.length && sIndex < secondHalf.length){
			if(fistHalf[fIndex] < secondHalf[sIndex]){
				orgArr[orgArIndex] = fistHalf[fIndex];
				fIndex++;
				orgArIndex++;
			}else {
				orgArr[orgArIndex] = secondHalf[sIndex];
				sIndex++;
				orgArIndex++;				
			}
		}
		
		//copy what ever remaining left in fistArray into orgArray.
		while(fIndex < fistHalf.length){
			orgArr[orgArIndex] = fistHalf[fIndex];
			fIndex++;
			orgArIndex++;			
		}
		//copy what ever remaining left in secondArray into orgArray.
		while(sIndex < secondHalf.length){
			orgArr[orgArIndex] = secondHalf[sIndex];
			sIndex++;
			orgArIndex++;				
		}	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = {45, 1, 34,74, 32, 12, 2, 4};
		//int[] ar = {1 ,12 , 5, 26,  7, 14,  3,  7,  2};
		//int[] ar = {24,2,45,20,56,75,2,56,99,53,12};
		System.out.println("Before sorting "+Arrays.toString(ar));
		
		sort(ar);
		System.out.println("After sorting "+Arrays.toString(ar));
	}

}
