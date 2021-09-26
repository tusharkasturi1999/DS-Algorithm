package algorithms;

import java.util.Scanner;

public class BubbleSort {
	static int arr[];
	static int n;
	static Scanner r = new Scanner(System.in);

	/**
	 * prompts the user for input data
	 */
	public static void readArray() {
		System.out.println("Enter the number of elements in the array");
		n = r.nextInt();
		arr = new int[n];
		System.out.println("Enter the  elements of array");
		for (int i = 0; i < n; i++) {
			arr[i] = r.nextInt();
		}

		System.out.println("Before Sorting, the array is:");
		print();
	}

	/**
	 * sorts the array in ascending order
	 */
	public static void bubbleSort() {
		int len = arr.length;
		int temp;

		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

				}
			}
		}
		System.out.println("After Sorting, the array is:");
		print();

	}

	/**
	 * prints all elements of array
	 */
	private static void print() {
		for (int i : arr) {
			System.out.print(i + " ");

		}
		System.out.println();

	}

	public static void main(String[] args) {
		BubbleSort.readArray();
		BubbleSort.bubbleSort();
	}
}
