package algorithms;

public class Permutation {

	/**
	 * @param str
	 * @param ans prints all the posiible permutations of a string using recursion
	 */
	static void printPermutation(String str, String ans) {

		// checking if string is empty
		if (str.length() == 0) {
			System.out.print(ans + " ");
			return;
		}
		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			// string without ith character
			String ros = str.substring(0, i) + str.substring(i + 1);

			// Recurvise call
			printPermutation(ros, ans + ch);
		}
	}

	public static void main(String[] args) {
		String s = "abc";
		System.out.println("The permutations of " + s + " are:");
		printPermutation(s, "");
	}
}
