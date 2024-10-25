// import java.util.Scanner;
// import java.util.ArrayList;
// import java.util.HashMap;

public class RecursiveSearch {

	/**
	 * Search a number in a array using linear search
	 * 
	 * @param numArray array to be searched
	 * @param numberToBeSearched number to be searched
	 * @return int index of numberToBeSearched
	 */
	public int linearSearch(int numArray[], int numberToBeSearched) {
		int index = 0;
		return linearSearch(numArray, numberToBeSearched, index);
	}
	private int linearSearch(int numArray[], int numberToBeSearched, int index) {
		if ((index == numArray.length - 1) && numArray[index] != numberToBeSearched)
			return -1;

		if (numArray[index] == numberToBeSearched) {
			return index;
		}

		index++;

		return linearSearch(numArray, numberToBeSearched, index);
	}

	/**
	 * Search a number in a array using binary search
	 * 
	 * @param numArray array to be searched
	 * @param numberToBeSearched number to be searched
	 * @return int index of numberToBeSearched
	 */
	public int binarySearch(int numArray[], int numberToBeSearched) {
		if(numArray.length == 0) return -1;
		if(numArray.length == 1 && numArray[0] != numberToBeSearched) return -1;

		int start = 0;
		int end = numArray.length - 1;

		int mid = (start + end)/2;
		if(numArray[mid] == numberToBeSearched){
			return mid;
		}

		if(numArray[mid] > numberToBeSearched){
			return binarySearch(numArray, numberToBeSearched, start, mid);
		}else{
			return binarySearch(numArray, numberToBeSearched, mid, end);
		}
	}
	private int binarySearch(int numArray[], int numberToBeSearched, int start, int end) {
		if(start > end) return -1;

		int mid = (start + end)/2;
		if(numArray[mid] == numberToBeSearched){
			return mid;
		}

		if(numArray[mid] > numberToBeSearched){
			return binarySearch(numArray, numberToBeSearched, start, mid);
		}else{
			return binarySearch(numArray, numberToBeSearched, mid, end);
		}
	}
}

class Assignment {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		RecursiveSearch rs = new RecursiveSearch();
		int linearResult = rs.linearSearch(arr, 7);
		int binaryResult = rs.binarySearch(arr, 7);

		System.out.println(
			"L : " + linearResult + "\n" +
			"B : " + binaryResult
		);
	}
}
