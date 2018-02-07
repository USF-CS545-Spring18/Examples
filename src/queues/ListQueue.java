package queues;
/** Implementation of Queue ADT using a singly linked list. 
 *  This implementation does not use a dummy node. */
public class ListQueue implements Queue {
	private Node head;
	private Node tail;

	ListQueue() {
		head = null;
		tail = null;
	}

	/**
	 * Create a new node with elem and add it to the
	 * end of the linked list
	 * @param elem element to add to the queue
	 */
	public void enqueue(Object elem) {
		if (head == null) {
			head = new Node(elem);
			tail = head;
		} else {
			tail.next = new Node(elem);
			tail = tail.next();
		}
	}

	/**
	 * Remove the first element from the queue
	 * (and return its value)
	 * @return the first element in the queue
	 */
	public Object dequeue() {
		Object dequeued_elem;

		if (head == null)
			return null;
		dequeued_elem = head.element();
		head = head.next;
		if (head == null)
			tail = null;
		return dequeued_elem;
	}

	/** Return true if the queue has no elements */
	public boolean empty() {
		return (head == null);
	}

	/** Return a string represeting a queue */
	public String toString() {
		String result = "[";
		Node tmp = head;
		if (tmp != null) {
			result = result + tmp.element();
			tmp = tmp.next();
			while (tmp != null) {
				result = result + "," + tmp.element();
				tmp = tmp.next();
			}
		}
		result = result + "]";
		return result;
	}

	public class Node {
		private Object element;
		private Node next;

		public Node(Object newelement) {
			element = newelement;
			next = null;
		}

		public Node(Object newelement, Node newnext) {
			element = newelement;
			next = newnext;
		}

		public Node next() {
			return next;
		}

		public Object element() {
			return element;
		}

	}
}
