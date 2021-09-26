package DataStructures;

import java.util.Scanner;

/**
 * @author tushar.kasturi_ymedi this class simulates the bank cash counter where
 *         there is a queue
 */
public class BankCashCounter {
	Scanner r = new Scanner(System.in);
	long minimumBalance = 5000;

	Queue<Integer> queue = new Queue<>();

	/**
	 * this method adds people in the queue at the counter
	 */
	public void addPerson() {

		System.out.println("How many people you wanna add");
		int n = r.nextInt();
		for (int i = 0; i < n; i++) {
			queue.enqueue(i);
		}
		getOption(n);

	}

	/**
	 * @param n is the number of at counter queue this method asks the user at the
	 *          queue to either deposit or withdraw
	 */
	private void getOption(int n) {
		int num = 0;

		while (num != n) {
			long cash = minimumBalance;

			int option = 0;
			boolean done = false;
			while (!done) {
				System.out.println("Person " + (num + 1) + " at the counter");
				System.out.println("Available cash " + cash);
				System.out.println("You want to \n1: Withdraw \n2: Deposit");
				option = r.nextInt();
				switch (option) {
				case 1:
					System.out.println("Enter the required amount to withdraw");
					long amount = r.nextInt();
					if (amount > cash) {
						System.out.println("Not enough money to withdraw");
					} else
						cash = cash - amount;
					done = true;
					queue.dequeue();
					num++;
					System.out.println("Person " + (num + 1) + " available cash:" + cash);
					break;
				case 2:
					System.out.println("Enter the required amount to deposit");
					long amount1 = r.nextInt();
					System.out.println("amount deposited successfully");
					queue.dequeue();
					cash = cash + amount1;
					done = true;
					System.out.println("Person " + (num + 1) + " available cash:" + cash);
					num++;
					break;
				default:
					System.out.println("Invalid input");

				}
			}
		}
	}

	public static void main(String[] args) {
		BankCashCounter bankCashCounter = new BankCashCounter();
		bankCashCounter.addPerson();
	}

}
