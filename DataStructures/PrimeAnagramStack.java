package DataStructures;

import java.util.Arrays;

public class PrimeAnagramStack {
	Stack<Integer> stack = new Stack<>();

	/**
	 * Prints the prime anagrams stored in stack in reversed order.
	 */
	public void anagramStack() {
		prime(1000);
		int size = stack.size();
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = stack.pop();

		}
		System.out.println("Prime Anagrams in reverse order is");
		for (int i = 0; i <= size; i++) {
			for (int j = i + 1; j < size; j++) {
				String v1 = String.valueOf(array[i]);
				String v2 = String.valueOf(array[j]);
				if (anagram(v1, v2) && array[i] != 0 && array[j] != 0) {
					System.out.println(array[i] + " \t " + array[j]);
				}
			}
		}
	}

	/**
	 * @param range=maximum value till you wanna search prime numbers;here it is
	 *                      1000 Pushes every prime number to stack.
	 */
	public void prime(int range) {
		for (int i = 2; i <= range; i++) {
			boolean isPrime = true;
			for (int j = 2; j <= i / 2; j++) {
				if ((i % j) == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				stack.push(i);
			}
		}
	}

	/**
	 * @param string1=        prime number converted to string
	 * @param string2=another prime number converted to string
	 * @return true if string1 and string2 are anagram else false.
	 */
	public boolean anagram(String string1, String string2) {
		if (string1.length() != string2.length()) {
			return false;
		}
		char[] array1 = string1.toCharArray();
		Arrays.sort(array1);
		char[] array2 = string2.toCharArray();
		Arrays.sort(array2);

		for (int i = 0; i < array1.length; i++) {
			if (array1[i] != array2[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		PrimeAnagramStack obj = new PrimeAnagramStack();
		obj.anagramStack();
	}
}
