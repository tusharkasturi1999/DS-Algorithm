package algorithms;

import java.util.Scanner;

public class FindYourNumber {

	static int num;
	static Scanner r = new Scanner(System.in);

	public static void getInput(int N) {
		System.out.println("Think of a number between 0 and " + (N - 1));
		num = r.nextInt();
		find(0, N - 1);
	}

	private static void find(int low, int high) {
		if (low == high) {
			System.out.println("Your number is " + low);
			System.out.println("Intermediary numbers is " + (low - 1) + " and " + (low + 1));
			return;
		}

		int mid = (low + high) / 2;
		String ch;
		System.out.println("Is your number between " + low + " and " + mid);
		ch = r.next();
		if (ch.equalsIgnoreCase("yes")) {
			find(low, mid);
		} else {
			find(mid + 1, high);
		}

	}

	public static void main(String[] args) {

		FindYourNumber.getInput(Integer.parseInt(args[0]));

	}
}
