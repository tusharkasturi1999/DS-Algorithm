package DataStructures;

import java.util.Arrays;

public class PrimeAnagram<T> {
	int array[][] = new int[10][100];
	int prime[][] = new int[10][100];
	int anagram[][] = new int[10][100];
	int nonanagram[][] = new int[10][100];

	/**
	 * For every 100 values checks all the prime numbers in that range .
	 */
	public void primeArray() {

		int temp = 1;

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {
				array[i][j] = temp;
				temp++;
			}
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {

				if (checkPrime(array[i][j])) {
					prime[i][j] = array[i][j];
				} else {
					prime[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {
				if (prime[i][j] != 0) {

				}
			}

		}
	}

	/**
	 * Checks if a 2 prime numbers are anagram or not. If yes store them in 2d array
	 * if not store them in nonanagram 2d array
	 */
	public void isAnagram() {

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {
				if (prime[i][j] != 0) {
					for (int k = j + 1; k < 100; k++) {
						if (anagram(String.valueOf(prime[i][j]), String.valueOf(prime[i][k]))) {
							anagram[i][j] = prime[i][j];
							anagram[i][k] = prime[i][k];

						}
					}
				}
			}
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {

				if (prime[i][j] != anagram[i][j]) {
					nonanagram[i][j] = prime[i][j];
				}
			}
		}
	}

	/**
	 * Prints all the anagram primes between 0 to 1000
	 */
	public void printAnagrams() {
		System.out.println("Anangrams are");
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {
				if (anagram[i][j] != 0) {
					System.out.print(anagram[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	/**
	 * Prints the non anagram prime numbers
	 */
	public void printnonAnagram() {
		System.out.println("Non Anangrams are");
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {
				if (nonanagram[i][j] != 0) {
					System.out.print(nonanagram[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	/**
	 * @param num=number bewteen 0 to 1000
	 * @return true if its a prime else false
	 */
	private boolean checkPrime(int num) {

		boolean flag = true;
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				flag = false;
				break;
			}
		}
		return flag;
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
		PrimeAnagram primeAnagram = new PrimeAnagram();
		primeAnagram.primeArray();
		primeAnagram.isAnagram();
		primeAnagram.printAnagrams();
		primeAnagram.printnonAnagram();
	}
}