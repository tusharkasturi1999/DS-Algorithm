package DataStructures;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author tushar.kasturi_ymedi This class implements a unordered linkedlist
 * @param <T>
 */
class UnorderedList<T> {
	Node head;
	int count = 0;

	public class Node<T> {
		T data;
		Node next;

		Node(T data) {
			this.data = data;
			next = null;
		}
	}

	/**
	 * 
	 * @param data=value of new node. Adds the new node at the end of the linked
	 *                   list
	 */
	public <T> void add(T data) {

		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			count++;
		} else {
			Node temp;
			temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
			count++;
		}

	}

	/**
	 * Prints the linked list content
	 */
	public <T> void display() {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			System.out.print(temp.data + "-->");
			temp = temp.next;
		}
		System.out.println(temp.data);
	}

	/**
	 *
	 * @param input=value of the node to be seached
	 * @return true if node is found else returns false
	 */
	public <T> boolean search(T input) {
		Node temp;
		temp = head;
		boolean flag = false;
		if (head == null) {
			return false;
		}
		while (temp != null) {
			if (temp.data.equals(input)) {

				flag = true;
				break;
			} else {
				temp = temp.next;
			}

		}
		return flag;
	}

	/**
	 * 
	 * @param input=value of the node to be removed removes the input node from LL
	 */
	public <T> void remove(T input) {

		if (input.equals(head.data)) { // Removing the first element
			head = head.next;
			count--;
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
				count--;
			}

			else {
				q = temp;
				temp = temp.next;
			}
		}

	}

	/**
	 * @return the size of LL i.e the number of nodes in the LL
	 */
	public int size() {
		return count;

	}

	/**
	 * @return true if LL is empty else returns false
	 */
	public boolean isEmpty() {
		if (head == null)
			return true;
		return false;
	}

	/**
	 *
	 * @param item=value of node whose index is needed
	 * @return the index of the data item in linked list
	 */
	public <T> int index(T item) {
		boolean flag = search(item);
		if (!flag) {
			System.out.println("Not found");
			return -1;
		} else {
			int index = 0;
			Node temp;
			temp = head;
			while (temp != null) {
				if (temp.data.equals(item)) {
					break;

				} else {
					temp = temp.next;
					index++;
				}

			}
			return index;
		}
	}

	/**
	 * 
	 * @return returns the last node in linked list and deletes it
	 */
	public <T> Node pop() {
		if (head == null) {
			System.out.println("List is empty");
			return null;
		}
		if (head.next == null) {
			Node temp = head;
			head = null;
			return temp;
		}
		Node temp = head;
		Node prev = null;
		while (temp.next != null) {
			prev = temp;
			temp = temp.next;

		}

		prev.next = null;
		return temp;

	}

	/**
	 * 
	 * @param pos=position of the node in linked list
	 * @return a removed node who is at positio=pos
	 */
	public <T> Node pop(int pos) {
		if (head == null) {
			System.out.println("Empty");
			return null;
		}
		if (pos == 1) {
			Node temp = head;
			head = head.next;
			return temp;
		} else {
			int count = 1;
			Node temp = head;
			Node q = temp;
			while (count < pos) {
				q = temp;
				temp = temp.next;
				count++;
			}
			q.next = temp.next;
			return temp;

		}
	}

	/**
	 * 
	 * @param pos=location where we want to insert new node
	 * @param item=value   of new node to be inserted inserts a node to the LL at
	 *                     the given pos
	 */
	public <T> void insert(int pos, T item) {
		Node newNode = new Node(item);
		if (pos == 1) {
			newNode.next = head;
			head = newNode;
		} else {
			int count = 1;
			Node temp = head;
			Node q = temp;
			while (count < pos) {
				q = temp;
				temp = temp.next;
				count++;
			}
			q.next = newNode;
			newNode.next = temp;

		}
	}

	/**
	 * Adds the item to end of the list
	 */
	public <T> void append(T item) {
		add(item);
	}

	/**
	 * @return the entire linked list.
	 */
	public Node getList() {
		return head;
	}

	/**
	 * reads the text file and stores the content in array
	 */
	public <T> void readFile() {
		Scanner x;
		try {
			x = new Scanner(new File(
					"C:\\Users\\adithya.shenoy_ymedi\\eclipse-workspace\\DSandAlgorithm\\src\\Data\\UnorderedList.txt"));

			String whole = "";
			while (x.hasNext()) {
				whole = whole + x.next() + " ";
			}
			T[] array = (T[]) whole.split(" ");
			// add(array);
			for (T t : array) {
				add(t);

			}
			System.out.println("List after reading the file:");
			display();

			x.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Ask user to enter a value.If value is present in list then removes it else
	 * adds to the list.
	 */
	public <T> void getUserInput() {
		Scanner r = new Scanner(System.in);
		System.out.println("Enter word you wanna search");
		T input = (T) r.next();
		boolean flag = search(input);
		if (flag) {
			System.out.println(input + " is found and has been removed from list");
			remove(input);
			display();
		} else {
			System.out.println(input + " not found, has been added to list");
			add(input);
			display();
		}

	}

	/**
	 * Writes the list after taking user choice to new text file.
	 */
	public void writeFile() {
		try {
			FileWriter writer = new FileWriter(
					"C:\\Users\\adithya.shenoy_ymedi\\eclipse-workspace\\DSandAlgorithm\\src\\OutputData\\UnorderedList.txt");
			Node temp;
			temp = getList();
			while (temp.next != null) {
				writer.write(temp.data + " ");
				temp = temp.next;

			}
			writer.write(temp.data + "");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		UnorderedList<String> unorderedList = new UnorderedList<>();
		unorderedList.readFile();
		unorderedList.getUserInput();
		unorderedList.writeFile();
	}

}