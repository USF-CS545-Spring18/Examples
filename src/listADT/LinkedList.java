package listADT;

/**
 * Uses a singly linked list with a dummy node to implement List ADT
 * Based on the code of Prof. Galles.
 */
public class LinkedList implements List {

	/*----------------------------------------------------- */
	/* Private Data Members -- LinkList */
	/*----------------------------------------------------- */
	private Node head; // dummy node
	private Node tail; // the last node
	private int length; // the number of elements in the list, not counting the
						// dummy node

	/*----------------------------------------------------- */
	/* Constructor -- LinkedList */
	/*----------------------------------------------------- */
	LinkedList() {
		head = tail = new Node(); // a dummy head
		length = 0;
	}

	/*----------------------------------------------------- */
	/* Public Methods -- LinkedList */
	/*----------------------------------------------------- */
	public void clear() {
		head.setNext(null); // only the dummy head will be left
		tail = head;
		length = 0;
	}

	/**
	 * Return the number of elements in the linked list
	 * not including the dummy node
	 * @return length of the list
	 */
	public int size() {
		return length;
	}

	/**
	 * Append a new node with the given element to the list
	 * @param elem new element
	 */
	public void add(Object elem) {
		tail.setNext(new Node(elem, null));
		tail = tail.next();
		length++;
	}

	/**
	 * Insert a new node at a given index
	 * @param index index where to insert a new node
	 * @param elem element to insert
	 */
	public void add(int index, Object elem) {
		if (index < 0 || index >= length) //
			System.out.println("Index not in list");
		// first we need to get to the node before the node with the given index
		Node tmp = head;
		for (int i = 0; i < index; i++) {
			tmp = tmp.next;
		}
		tmp.next = new Node(elem, tmp.next);
		length++;
	}

	/**
	 * Remove the node in a given position
	 * @param index index of the element to remove
	 */
	public void remove(int index) {
		if (index < 0 || index >= length) {
			System.out.println("Index out of bounds");
			return;
		}
		// First, get to the node right before the node in position index
		Node tmp = head;
		for (int i = 0; i < index; i++) {
			tmp = tmp.next;
		}
		tmp.next = tmp.next.next;
		length--;
	}

	/**
	 * Remove the first occurrence of a given element
	 * @param elem element to remove
	 */
	public void remove(Object elem) {
		// find the index of the first occurrence of the element
		Node tmp = head;
		while (tmp.next != null && !tmp.next.element.equals(elem)) {
			tmp = tmp.next;
		}
		// remove the node after it
		if (tmp.next != null) {
			tmp.next = tmp.next.next;
			length--;
		}

	}

	/** Return the object at a given index
	 *
	 * @param index index in the list
	 * @return element in the node at the given index
	 */
	public Object get(int index) {
		if (index < 0 || index >= length) {
			System.out.println("Index out of bounds. ");
			return null;
		}
		Node tmp = head.next; // the first "real" element
		for (int i = 0; i < index; i++) {
			tmp = tmp.next;
		}
		return tmp.element;
	}

	/** Print elements of the list */
	public void print() {
		ListIterator it = listIterator();
		while (it.hasNext()) {
			System.out.print(it.next() + "  ");
		}
		System.out.println();
	}

	/** Get the iterator for the list. Start with index 0.
	 *
	 * @return iterator
	 */
	public ListIterator listIterator() {
		return new InnerIterator(0);
	}

	/** Get the iterator for the list. Start with the given index.
	 *
	 * @param index index in the list
	 * @return iterator that starts at index
	 */
	public ListIterator listIterator(int index) {
		return new InnerIterator(index);
	}

	/*----------------------------------------------------- */
	/* Nested class -- Node */
	/*----------------------------------------------------- */
	private class Node {

		/*----------------------------------------------------- */
		/* Private Data Members -- Node */
		/*----------------------------------------------------- */
		private Object element;
		private Node next;

		/** Constructor in class Node
		 *
		 * @param elem element of the node
		 * @param nextelem next reference
		 */
		Node(Object elem, Node nextelem) {
			element = elem;
			next = nextelem;
		}

		/**
		 * Constructor in class Node. Takes next node as a parameter
		 * @param nextNode next node in the list
		 */
		Node(Node nextNode) {
			next = nextNode;
		}

		Node() {
		}

		/*----------------------------------------------------- */
		/* Access Methods -- Node */
		/*----------------------------------------------------- */

		Node next() {
			return next;
		}

		Object element() {
			return element;
		}

		void setNext(Node nextelem) {
			next = nextelem;
		}

		void setElement(Object elem) {
			element = elem;
		}
	}

	/*----------------------------------------------------- */
	/* Nested class -- InnerIterator */
	/*----------------------------------------------------- */
	private class InnerIterator implements ListIterator {

		/*----------------------------------------------------- */
		/* Private Data Members -- InnerIterator */
		/*----------------------------------------------------- */
		private Node current;  // the node before "next"
		private Node previous; // the node before current

		/*----------------------------------------------------- */
		/* Constructor -- InnerIterator */
		/*----------------------------------------------------- */
		public InnerIterator(int index) {
			previous = null;
			// if index is 0, current will point at a dummy head
			current = head; // current will point at a node at index - 1
			for (int i = 0; i < index; i++) {
				previous = current;
				current = current.next;
			}
		}

		/*----------------------------------------------------- */
		/* Public Methods -- InnerIterator */
		/*----------------------------------------------------- */
		public Object previous() {
			if (!hasPrevious()) {
				System.out.println("No previous element");
				return null;
			}
			Object previousVal = current.element;
			previous = null;
			Node oldCurrent = current;
			current = head;
			while (current.next != oldCurrent) {
				previous = current;
				current = current.next;
			}
			return previousVal;
		}

		public boolean hasPrevious() {
			return current != head && current != null;
		}

		public boolean hasNext() {
			return current != null && current.next != null;
		}
		
		/** Return the value of the node right after current */
		public Object next() {
			if (!hasNext()) {
				System.out.println("No next element");
				return null;
			}
			previous = current;
			current = current.next();
			return current.element; 
		}


		/** Set the value of current (the element before "next")
		 *
		 * @param value new value
		 */
		public void set(Object value) {
			if (current == head || current == null) {
				System.out.println("Iterator not in list");
				return;
			}
			current.setElement(value);
		}

		/** Remove current (the element before "next")  */
		public void remove() {
			if (previous == null || current == null) {
				System.out.println("Iterator not in list");
				return;
			}
			current = previous;
			previous.next = previous.next.next;
			previous = null;
			length--;
		}

		/** Insert the element right before "next"
		 *
		 * @param elem the element to insert
		 */
		public void add(Object elem) {
			if (current == null) {
				System.out.println("Iterator not in list");
				return;
			}
			current.setNext(new Node(elem, current.next()));
			previous = current; //
			current = current.next;
			length++;
		}
	}
}
