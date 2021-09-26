package DataStructures;

/**
 * @author tushar.kasturi_ymedi this class implements stack data structure
 * @param <T>
 */
class Stack<T> {
	Node<T> head;
	int count = 0;

	@SuppressWarnings("hiding")
	class Node<T> {
		public T data;
		Node<T> next;

		Node(T data) {
			this.data = data;
		}
	}

	/**
	 * initialising stack with null
	 */
	public Stack() {
		this.head = null;
	}

	/**
	 * Adds the new node to stack top.
	 * 
	 */
	public void push(T data) {
		Node<T> node = new Node<T>(data);
		node.next = head;
		head = node;
		count++;
	}

	/*
	 * Removes the top most node from the stack
	 */
	public T pop() {
		if (head == null) {
			System.out.println("Stack UnderFlow");
			return null;
		}
		Node<T> temp = head;
		T topData = temp.data;
		head = temp.next;
		temp = null;
		count--;
		return topData;
	}

	/*
	 * returns the value at the top without removing it
	 */
	public T peek() {
		if (head == null) {
			System.out.println("Stack UnderFlow");
		}
		T temp = head.data;
		return temp;
	}

	/**
	 * @return true if stack is empty, false otherwise
	 */
	public boolean isEmpty() {
		return count == 0 ? true : false;
	}

	/**
	 * @return the number of elements in stack
	 */
	public int size() {
		return count;
	}

	/**
	 * Prints the stack content
	 */
	public void display() {
		if (head == null) {
			System.out.println("underflow");
			return;
		}
		Node<T> temp = head;

		while (temp.next != null) {
			System.out.print(temp.data + "--->");
			temp = temp.next;
		}
		System.out.println(temp.data);

	}

}