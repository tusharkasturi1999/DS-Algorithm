package DataStructures;

public class Deque<T> {

	Node<T> front, rear;
	int count = 0;

	class Node<T> {
		Node<T> next;
		T data;

		Node(T data) {
			this.data = data;
			next = null;
		}
	}

	public Deque() {
		front = rear = null;
	}

	/**
	 * @param item = value of new node to be added. this method adds a new Node at
	 *             the front
	 */
	public void addFront(T item) {
		Node<T> newNode = new Node(item);
		if (rear == null) {
			rear = newNode;
			front = newNode;
			count++;
		} else {
			newNode.next = front;
			front = newNode;
			count++;
		}

	}

	/**
	 * @param item=value of new node to be added. Adds a new node at rear end.
	 */
	public void addRear(T item) {
		Node<T> newNode = new Node(item);
		if (rear == null) {
			front = newNode;
			rear = newNode;
			count++;
		} else {
			rear.next = newNode;
			rear = newNode;
			count++;
		}
	}

	/**
	 * @return the first element from front side.
	 */
	public T removeFront() {
		Node<T> temp = front;
		front = front.next;
		count--;
		return temp.data;

	}

	/**
	 * @return the first element from rear side removes the rear element
	 */
	public Node<T> removeRear() {
		Node<T> temp = front;
		Node<T> prev = null;
		while (temp.next != null) {
			prev = temp;
			temp = temp.next;
		}
		prev.next = null;
		count--;
		return temp;
	}

	/**
	 * @return true if Dequeue is empty else false.
	 */
	public boolean isEmpty() {
		if (front == null)
			return true;
		else
			return false;
	}

	/**
	 * @return number of elements in dequeue
	 */
	public int size() {
		return count;
	}

	/**
	 * prints the content of Dequeue
	 */
	public void display() {
		Node<T> temp = front;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

}
