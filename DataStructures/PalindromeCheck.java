package DataStructures;

import java.util.Scanner;

public class PalindromeCheck {

	static Scanner scanner = new Scanner(System.in);

	static Deque<Character> deque = new Deque<>();

	/**
	 * this method checks if given string is palindrome
	 */
	public static void checkPalindrome() {
		System.out.println("Enter the string");
		String string = scanner.next();
		string = string.toLowerCase();
		char[] charArray = string.toCharArray();
		String reversedString = "";
		for (int i = 0; i < charArray.length; i++) {
			deque.addFront(charArray[i]);
		}

		for (int i = 0; i < charArray.length; i++) {
			reversedString += deque.removeFront();
		}

		if (string.equals(reversedString)) {
			System.out.println(string + " is a palindrome");
		} else {
			System.out.println(string + " is not a palindrome");
		}

	}

	public static void main(String[] args) {
		PalindromeCheck.checkPalindrome();
	}

}
