package algorithms;

import java.util.Scanner;

public class InsertionSort {

	static String arr[];
	static int n;
	static Scanner r = new Scanner(System.in);

	public static void inputArray() {
		System.out.println("Enter the number of elements in the array");
		n = r.nextInt();
		arr = new String[n];
		System.out.println("Enter the  elements of array");
		for (int i = 0; i < n; i++) {
			arr[i] = r.next();
		}

		System.out.println("Before Sorting");
		print();
	}

	public static void insertionSort() {

		for (int i = 1; i < n; i++) {
			String item = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j].compareTo(item) > 0) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = item;
		}
		System.out.println("After Sorting");
		print();
	}

	private static void print() {
		for (String string : arr) {
			System.out.print(string + " ");

		}
		System.out.println();

	}

	public static void main(String[] args) {
		InsertionSort.inputArray();
		InsertionSort.insertionSort();
	}

}