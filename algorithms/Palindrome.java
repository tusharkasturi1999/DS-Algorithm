package algorithms;

public class Palindrome {

	/**
	 * This method finds all the primenumbers in the range
	 */
	public static void primeNumber() {

		for (int i = 2; i <= 1000; i++) {
			boolean flag = true;
			for (int j = 2; j <= i / 2; j++) {
				if (i % j == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				palindrome(i);
			}
		}

	}

	/**
	 * @param i primenumber is a palindrome when reverse number is same as the
	 *          number
	 */
	private static void palindrome(int i) {
		int remainder, num, reversedNum = 0;
		num = i;
		int count = 0;
		while (i != 0) {
			remainder = i % 10;
			reversedNum = reversedNum * 10 + remainder;
			i = i / 10;
			count++;

		}
		if (num == reversedNum && count > 1) {
			System.out.print(num + " ");
		}

	}

	public static void main(String[] args) {
		System.out.println("Prime numbers between 0 to 1000 that are palindrome:");
		Palindrome.primeNumber();
	}
}
