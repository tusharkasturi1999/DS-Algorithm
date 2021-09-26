package DataStructures;

/**
 * @author tushar.kasturi_ymedi this class implements queue data structure
 * @param <T>
 */
class Queue<T> {
	Node<T> front;
	Node<T> rear;
	int count = 0;

	@SuppressWarnings("hiding")
	class Node<T> {
		T data;
		Node<T> next;

		Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	/*
	 * Queue constructor
	 */
	public Queue() {
		this.front = null;
		this.rear = null;
	}

	/*
	 * Adds a new element to the rear end of thq queue
	 */
	public void enqueue(T item) {
		Node<T> temp = new Node<T>(item);
		if (rear == null) {
			front = temp;
			rear = temp;
			count++;
			return;
		}
		rear.next = temp;
		rear = temp;
		count++;
	}

	/**
	 * Removes the element at the front of the queue
	 */
	public void dequeue() {
		if (front == null) {
			System.out.println("Queue is empty");
			return;
		}
		front = front.next;
		if (front == null) {
			rear = null;
		}
		count--;
	}

	/**
	 * @return number of elements in queue
	 */
	public int size() {
		return count;
	}

	/**
	 * @return true if queue is empty else returns false
	 */
	public boolean isEmpty() {
		if (front == null) {
			return true;
		}
		return false;
	}

	/*
	 * Display the content of Queue
	 */
	public void display() {
		if (isEmpty()) {
			System.out.println("Queue is emepty");
			return;
		} else {
			Node<T> temp = this.front;
			while (temp.next != null) {
				System.out.print(temp.data + "---->");
				temp = temp.next;
			}
			System.out.println(temp.data);
		}
	}
}
