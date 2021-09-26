package DataStructures;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author tushar.kasturi_ymedi this class implements a ordered linkedlist in
 *         which nodes are sorted in ascending order
 * @param <T> type of data of the node
 */
public class OrderedList<T> {

	Node head;
	static Scanner r = new Scanner(System.in);

	private class Node<T extends Comparable<T>> {
		T data;
		Node next;

		Node(T data) {
			this.data = data;
			next = null;
		}
	}

	/**
	 * @param <T>
	 * @return the size of LIST
	 */
	public <T extends Comparable<T>> int getSize() {
		int count = 0;
		if (head == null) {
			return 0;
		} else {

			Node<T> temp = head;
			while (temp != null) {
				count++;
				temp = temp.next;
			}
		}
		return count;
	}

	/**
	 * @param <T>
	 * @param index is the index of the node required
	 * @return the value of the node at the index
	 */
	public <T extends Comparable<T>> T get(int index) {
		Node<T> temp = head;
		Node<T> prev = null;

		for (int i = 0; i <= index; i++) {
			prev = temp;
			temp = temp.next;
		}
		return (T) prev.data;
	}

	/**
	 * @param <T>
	 * @param input is the data of the node adds a new node to the list
	 */
	private <T extends Comparable<T>> void addNormal(T input) {
		Node newNode = new Node(input);

		if (head == null)
			head = newNode;
		else {
			Node temp;
			temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}

	}

	/**
	 * @param <T>
	 * @param data is the data of the node adds a new node to list by using
	 *             compareto method
	 */
	public <T extends Comparable<T>> void add(T data) {
		Node<T> newNode = new Node<T>(data);
		if (head == null || head.data.compareTo(data) > 0) {
			newNode.next = head;
			head = newNode;
		} else {
			Node<T> temp = head;
			while (temp.next != null && temp.next.data.compareTo(data) < 0) {
				temp = temp.next;

			}
			newNode.next = temp.next;
			temp.next = newNode;
		}

	}

	/**
	 * @param <T>
	 * @param input pops the input node from the list
	 */
	public <T extends Comparable<T>> void pop(T input) {

		if (input.equals(head.data)) { // Removing the first element
			head = head.next;
			return;
		}
		Node temp = head.next;
		Node q = head;
		while (temp != null) {

			if (temp.data.equals(input)) {
				// System.out.println(temp.data);
				if (temp.next == null) {
					temp = temp.next;
					q.next = null;
				} else {
					q.next = temp.next;

					temp = temp.next;
				}
			} else {
				q = temp;
				temp = temp.next;
			}
		}

	}

	/**
	 * @param <T>
	 * @return
	 */
	public static <T extends Comparable<T>> T userInput() {
		T key = (T) r.next();
		return key;
	}

	/**
	 * @param <T>
	 * @param input is the node to be searched
	 * @return true if input node not found false if found
	 */
	public <T extends Comparable<T>> boolean search(T input) {
		boolean flag = true;
		Node temp;
		temp = head;
		while (temp != null) {
			if (temp.data.equals(input)) {

				flag = false;
				pop(input);
				System.out.println(input + " is found and popped from the list");
				break;
			} else {
				temp = temp.next;
			}
		}
		if (flag) {
			System.out.println(input + " not found, adding it to the list");
		}
		return flag;

	}

	/**
	 * @param <T> displays all the node in the list
	 */
	public <T extends Comparable<T>> void display() {
		Node temp = head;
		while (temp.next != null) {
			System.out.print(temp.data + "-->");
			temp = temp.next;
		}
		System.out.println(temp.data);
	}

	/**
	 * @param <T>
	 * @param a
	 * @return
	 */
	public <T extends Comparable<T>> T[] bubbleSort(T[] a) {

		int len = a.length;
		T temp;

		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - 1 - i; j++) {
				if (a[j].compareTo(a[j + 1]) > 0) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		for (T t : a) {
			addNormal(t);

		}

		System.out.println("Sorted list:");
		printArray(a);

		return a;
	}

	public static <T extends Comparable<T>> void printArray(T[] a) {
		for (T t : a) {
			System.out.print(t + " ");

		}
		System.out.println();
	}

	public void write() {
		try {

			FileWriter fWriter = new FileWriter(
					"C:\\Users\\adithya.shenoy_ymedi\\eclipse-workspace\\DSandAlgorithm\\src\\OutputData\\OrderedList.txt");
			String text = "";
			Node temp;
			temp = head;
			while (temp.next != null) {
				text = text + temp.data + "----->";
				temp = temp.next;
			}
			text = text + temp.data;
			fWriter.write(text);

			fWriter.close();

			System.out.println("The list is written to the file");
		}

		// Catch block to handle if exception occurs
		catch (IOException e) {
			// Print the exception
			System.out.print(e.getMessage());
		}

	}

	/**
	 * @throws Exception reads the input file and creates the array
	 */
	private void userinput() throws Exception {
		Scanner r = new Scanner(System.in);
		File file = new File(
				"C:\\Users\\adithya.shenoy_ymedi\\eclipse-workspace\\DSandAlgorithm\\src\\Data\\OrderedList.txt");
		Scanner sc;
		sc = new Scanner(file);
		String str;
		String s = "";
		while (sc.hasNextLine()) {
			str = sc.nextLine();
			s = s + str;
		}
		sc.close();

		String[] arr = s.split(" ");// to split the string array
		Integer[] array = new Integer[arr.length];
		for (int i = 0; i < arr.length; i++) {
			array[i] = Integer.parseInt(arr[i]);
		}
		System.out.println(array.getClass());
		bubbleSort(array);

		System.out.println("Enter the element to be searched:");
		Integer user = r.nextInt();
		boolean b = search(user);
		if (b) {
			add(user);
		}
		write();
	}

	public static void main(String[] args) {
		OrderedList<Integer> orderedList = new OrderedList<>();
		try {
			orderedList.userinput();
		} catch (Exception e) {
			System.out.println(e);
		}
		orderedList.display();
	}

}
