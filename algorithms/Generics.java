package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Generics {
	static Scanner r = new Scanner(System.in);

	public static <T extends Comparable<T>> T[] bubbleSort(T[] a) {

		int len = a.length;
		T temp;

		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - 1 - i; j++) {
				if (a[j].compareTo(a[j + 1]) > 0) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		System.out.println("Sorted array:");
		printArray(a);
		return a;

	}

	public static <T extends Comparable<T>> T[] insertionSort(T[] a) {
		T item;
		for (int i = 1; i < a.length; i++) {
			item = a[i];
			int j = i - 1;
			while (j >= 0 && a[j].compareTo(item) > 0) {
				a[j + 1] = a[j];
				j = j - 1;
			}
			a[j + 1] = item;
		}
		System.out.println("Sorted array:");
		printArray(a);
		return a;
	}

	public static <T extends Comparable<T>> void binarySearch(T[] b, T key) {

		System.out.println("Input for binary search is");
		printArray(b);

		T[] a = bubbleSort(b);
		int l = 0, r = a.length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (a[mid].compareTo(key) == 0) {
				System.out.println(key + " found at position " + (mid + 1));
				return;
			}
			if (a[mid].compareTo(key) > 0)
				r = mid - 1;
			else
				l = mid + 1;
		}
		System.out.println(key + " not found");
	}

	private static <T> Integer[] getInput() {
		Scanner x;
		try {
			x = new Scanner(new File(
					"C:\\Users\\adithya.shenoy_ymedi\\eclipse-workspace\\DSandAlgorithm\\src\\Data\\BinarySearch.txt"));

			String whole = "";
			while (x.hasNext()) {
				whole = whole + x.next() + " ";
			}
			String[] array = whole.split(" ");
			Integer[] a = new Integer[array.length];
			for (int i = 0; i < array.length; i++) {
				a[i] = Integer.parseInt(array[i]);
			}
			x.close();
			return a;

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		return null;

	}

	public static <T> void printArray(T[] a) {
		for (T t : a) {
			System.out.print(t + " ");

		}
		System.out.println();
	}

	private static <T> T getKey() {

		System.out.println("Enter the key to search");
		T key = (T) r.next();

		return key;

	}

	public static void main(String[] args) {
		String[] arr1 = { "the", "end", "is", "near" };
		Integer[] arr2 = { 43, 2, 11, 9, -42, 0, 105, 99 };
		Float[] arr3 = { 12.33f, 23.6f, 22f, 43.5f, 33.2f, 2.3f, 134.4f };

		Generics.bubbleSort(arr1);
		Generics.insertionSort(arr2);
		Generics.bubbleSort(arr3);
		Scanner r = new Scanner(System.in);
		System.out.println("Enter the key to search");
		Integer key = r.nextInt();
		Integer b[] = Generics.getInput();
		Generics.binarySearch(b, key);
	}

}
