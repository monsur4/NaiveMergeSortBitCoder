// implementing mergesort
import java.lang.*;
import java.util.*;
 
public class MergeSort{
	public static void mergeSort(int[] arr){
		int lo = 0;
		int hi = arr.length;
		mergeSort(arr, lo, hi);
 
	}
 
	private static void mergeSort(int[] arr, int lo, int hi){
		if(hi - lo <= 2){
			// sort it
			sort(arr, lo, hi);
			// return
			return;
		}
 
		// else divide the array into left and right halves, sort them
 
		int mid = (lo + hi)/2;
		mergeSort(arr, lo, mid);
		mergeSort(arr, mid, hi);
 
		// combine both halves
		combine(arr, lo, mid, hi);
	}
 
	private static void sort(int[] arr, int lo, int hi){
		// we are only sorting the base case of size 2 or 1
		if((hi - lo) == 1){
			return;
		}else{
			// section being sorted is of size 2
			hi--;
			int left = arr[lo];
			int right = arr[hi];
 
			// only swap if right is > left
			if(right < left){
				arr[lo] = right;
				arr[hi] = left;
			}
		}
	}
 
	private static void combine(int[] arr, int lo, int mid, int hi){
		// we are combining any length of sorted list
 
		// combine sorted list out-of-place
		int[] tempArr = new int[hi - lo];
		int curr = 0;
 
		// i pointer for the left sub-array
		int i = lo;
		int j = mid;
		while(i < mid && j < hi){
			if(arr[j] < arr[i]){
				tempArr[curr] = arr[j];
				j++;
			}else{
				tempArr[curr] = arr[i];
				i++;
			}
			curr++;
		}
 
		// add the other elements of the arr to the temp
		if(i == mid){
			while(j<hi){
				tempArr[curr] = arr[j]; // tempArr[curr++] = j;
				j++;
				curr++;
			}
		}else if(j == hi){
			while(i < mid){
				tempArr[curr] = arr[i];
				i++;
				curr++;
			}
		}
 
		// put the elements in the temporary array into the original array
 
		for(int el: tempArr){
			arr[lo] = el;
			lo++;
		}
	}
 
	public static void main(String[] args){
		int[] array = new int[]{4,1,3,2,0,-1,7,10,1,9,20};
		mergeSort(array);
		for(int el: array){
			System.out.println(el);
		}
	}
}
