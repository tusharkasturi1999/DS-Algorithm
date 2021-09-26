package DataStructures;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author tushar.kasturi_ymedi This class will implement a hash table for the
 *         input data given as a file
 * @param <T>
 */
public class Hashing<T> {

	Node<T>[] array = new Node[11];
	Node<T> next;

	class Node<T> {
		T data;

		Node next;

		Node(T data) {
			this.data = data;

			next = null;
		}
	}

	/**
	 * @param data=new data to be added to hash table this method calculates the
	 *                 hash index using modulus and then the data is added to that
	 *                 index
	 * 
	 */
	public void add(int data) {
		Node<T> new_Node = new Node(data);
		int index = data % 11;
		if (array[index] == null) {
			array[index] = new_Node;
		} else {
			Node<T> temp = array[index];
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new_Node;
		}
	}

	/**
	 * Prints the hash table -----> at the end means it points to null
	 */
	public void display() {

		System.out.println("Remainder " + "values:-");
		for (int i = 0; i < array.length; i++) {
			Node<T> temp = array[i];
			if (temp != null) {
				System.out.print(" [" + i + "] ----->{");
				while (temp != null) {
					System.out.print(temp.data + "  ");
					temp = temp.next;
				}
				System.out.println("}");
			}

			else {
				System.out.println(" [" + i + "]----->");
			}
		}
	}

	/**
	 * Writes the hash table to file.
	 */
	public void write() {
		try {

			FileWriter fWriter = new FileWriter(
					"C:\\Users\\adithya.shenoy_ymedi\\eclipse-workspace\\DSandAlgorithm\\src\\OutputData\\Hashing.txt");

			String text = "";
			text = "Remainder " + "values:-\n";
			fWriter.write(text);

			for (int i = 0; i < array.length; i++) {
				text = "";
				Node<T> temp = array[i];
				if (temp != null) {

					text = " [" + i + "] ------->";
					while (temp != null) {
						text = text + temp.data + "------>";
						// System.out.print(temp.data + " ");
						temp = temp.next;
					}
					text = text + "\n";
					fWriter.write(text);
				} else if (temp == null) {
					text = " [" + i + "] ------->\n";
					fWriter.write(text);
				}

			}

			fWriter.close();

			System.out.println("The hash table is written to the file");
		}

		// Catch block to handle if exception occurs
		catch (IOException e) {
			// Print the exception
			System.out.print(e.getMessage());
		}

	}

	public static void main(String[] args) {
		try {
			Hashing<Integer> hash = new Hashing<Integer>();

			File file = new File(
					"C:\\Users\\adithya.shenoy_ymedi\\eclipse-workspace\\DSandAlgorithm\\src\\Data\\Hashing.txt");
			Scanner sc = new Scanner(file);
			String str;
			String s = "";
			while (sc.hasNextLine()) {
				str = sc.nextLine();
				s = s + str;
			}
			System.out.println(s);
			sc.close();
			String[] arr = s.split(" ");// to split the string array
			int[] arr2 = new int[arr.length];

			// for converting any String type in file to integer type
			for (int i = 0; i < arr.length; i++) {
				arr2[i] = Integer.parseInt(arr[i]);
			}

			for (int i : arr2) {
				hash.add(i);

			}

			hash.write();
			hash.display();
		} catch (Exception e) {

		}
	}

}
