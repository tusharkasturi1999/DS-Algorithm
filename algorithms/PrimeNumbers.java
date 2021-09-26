package algorithms;

public class PrimeNumbers {

	/**
	 * finds all the prime numbers in the range
	 */
	public static void primeNumber() {

		System.out.println("Prime numbers between 0 and 1000 are:");

		for (int i = 2; i <= 1000; i++) {
			boolean flag = true;
			for (int j = 2; j <= i / 2; j++) {
				if (i % j == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.print(i + " ");
			}
		}

	}

	public static void main(String[] args) {

		PrimeNumbers.primeNumber();
	}

}
