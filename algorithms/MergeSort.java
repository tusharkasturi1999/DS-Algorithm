package algorithms;

import java.util.Scanner;
import java.util.Arrays;

public class MergeSort {

	static Scanner r = new Scanner(System.in);

	public static void readArray() {

		System.out.println("Enter the size of array");
		int n = r.nextInt();
		String values[] = new String[n];
		System.out.println("Enter the array");
		for (int i = 0; i < n; i++) {
			values[i] = r.next();
		}

		mergeSort(values, 0, values.length - 1);
		System.out.println("The sorted array is:\n" + Arrays.toString(values));
	}

	public static void mergeSort(String[] a, int from, int to) {
		if (from == to) {
			return;
		}
		int mid = (from + to) / 2;

		mergeSort(a, from, mid);
		mergeSort(a, mid + 1, to);
		merge(a, from, mid, to);
	}

	public static void merge(String[] a, int from, int mid, int to) {
		int n = to - from + 1;
		String[] b = new String[n];
		int i1 = from;
		int i2 = mid + 1;
		int j = 0;

		while (i1 <= mid && i2 <= to) {
			if (a[i1].compareTo(a[i2]) < 0) {
				b[j] = a[i1];
				i1++;
			} else {
				b[j] = a[i2];
				i2++;
			}
			j++;
		}

		while (i1 <= mid) {
			b[j] = a[i1];
			i1++;
			j++;
		}

		while (i2 <= to) {
			b[j] = a[i2];
			i2++;
			j++;
		}

		for (j = 0; j < n; j++) {
			a[from + j] = b[j];
		}
	}

	public static void main(String[] args) {
		MergeSort.readArray();
	}

}
