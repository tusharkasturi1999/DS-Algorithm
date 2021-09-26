package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Scanner;

/**
 * @author tushar.kasturi_ymedi This class reads a input txt file, store the
 *         words in the file to array,then sorts that array and then searches
 *         the user key in that sorted array using binary search metod.
 */
public class BinarySearch {
	static Scanner r = new Scanner(System.in);

	/**
	 * Reads the txt file and then stores each word in an array with space being the
	 * delimiter
	 */
	public static void readFile() {
		String key = getKey();
		Scanner x;
		try {
			x = new Scanner(new File(
					"C:\\Users\\adithya.shenoy_ymedi\\eclipse-workspace\\DSandAlgorithm\\src\\Data\\BinarySearch.txt"));
			String whole = "";
			while (x.hasNext()) {
				whole = whole + x.next() + " ";
			}
			String[] array = whole.split(" ");
			sort(array, key);

			x.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

	/**
	 * @return a String which user want to search
	 */
	private static String getKey() {

		System.out.println("Enter the key to search");
		String key = r.nextLine();

		return key;
	}

	/**
	 * @param unsorted array
	 * @param key      user input
	 * 
	 *                 This method sorts the array in ascending order
	 *
	 */
	private static void sort(String[] a, String key) {

		System.out.println("Unsorted array");

		for (String string : a) {
			System.out.print(string + " ");

		}
		System.out.println();
		int len = a.length;
		String temp;

		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - i - 1; j++) {
				if (a[j].compareTo(a[j + 1]) > 0) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;

				}
			}
		}

		System.out.println("Sorted array");

		for (String string : a) {
			System.out.print(string + " ");

		}
		System.out.println();
		binarysearch(a, key);
	}

	/**
	 * @param a   sorted array
	 * @param key user search key
	 * 
	 *            this method searches the key in sorted array a
	 */
	private static void binarysearch(String[] a, String key) {
		int left = 0, right = a.length - 1;
		int mid;
		while (left <= right) {
			mid = (left + right) / 2;

			if (key.compareTo(a[mid]) == 0) {
				System.out.println(key + " found at position " + (mid + 1));
				System.exit(0);
			}
			if (key.compareTo(a[mid]) > 0) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(key + " not found");
	}

	public static void main(String[] args) {
		BinarySearch.readFile();
	}

}
