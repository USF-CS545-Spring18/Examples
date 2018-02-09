package listADT;

/**
 * Uses a singly linked list with a dummy node to implement List ADT
 */
public class LinkedList implements List {

	/*----------------------------------------------------- */
	/* Private Data Members -- LinkedList */
	/*----------------------------------------------------- */
	private Link head; // dummy node
	private Link tail; // the last node
	private int length; // the number of elements in the list, not counting the
						// dummy node

	/*----------------------------------------------------- */
	/* Constructor -- LinkedList */
	/*----------------------------------------------------- */
	LinkedList() {
		head = tail = new Link(); // a dummy head
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

	public int size() {
		return length;
	}

	/** Append a new node at the end of the list */
	public void add(Object elem) {
		tail.setNext(new Link(elem, null));
		tail = tail.next();
		length++;
	}

	/** Insert a new node at a given index */
	public void add(int index, Object elem) {
		if (index < 0 || index >= length) //
			System.out.println("Index not in list");
		// first we need to get to the node before the node with the given index
		Link tmp = head;
		for (int i = 0; i < index; i++) {
			tmp = tmp.next;
		}
		tmp.next = new Link(elem, tmp.next);
		length++;
	}

	/** Remove the node in a given position */
	public void remove(int index) {
		if (index < 0 || index >= length) {
			System.out.println("Index out of bounds");
			return;
		}
		// First, get to the node right before the node in position index
		Link tmp = head;
		for (int i = 0; i < index; i++) {
			tmp = tmp.next;
		}
		tmp.next = tmp.next.next;
		length--;
	}

	/** Remove the first occurrence of a given element */
	public void remove(Object elem) {
		// find the index of the first occurrence of the element
		Link tmp = head;
		while (tmp.next != null && !tmp.next.element.equals(elem)) {
			tmp = tmp.next;
		}
		// remove the node after it
		if (tmp.next != null) {
			tmp.next = tmp.next.next;
			length--;
		}

	}

	/** Return the object at a given index */
	public Object get(int index) {
		if (index < 0 || index >= length) {
			System.out.println("Index out of bounds. ");
			return null;
		}
		Link tmp = head.next; // the first "real" element
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

	/** Get the iterator for the list. Start with index 0. */
	public ListIterator listIterator() {
		return new InnerIterator(0);
	}

	/** Get the iterator for the list. Start with the given index. */
	public ListIterator listIterator(int index) {
		return new InnerIterator(index);
	}

	/*----------------------------------------------------- */
	/* Nested class -- Link */
	/*----------------------------------------------------- */
	private class Link {

		/*----------------------------------------------------- */
		/* Private Data Members -- Link */
		/*----------------------------------------------------- */
		private Object element;
		private Link next;

		/*----------------------------------------------------- */
		/* Constructors -- Link */
		/*----------------------------------------------------- */
		Link(Object elem, Link nextelem) {
			element = elem;
			next = nextelem;
		}

		Link(Link nextelem) {
			next = nextelem;
		}

		Link() {
		}

		/*----------------------------------------------------- */
		/* Access Methods -- Link */
		/*----------------------------------------------------- */

		Link next() {
			return next;
		}

		Object element() {
			return element;
		}

		void setNext(Link nextelem) {
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
		private Link current;  // the node before "next"
		private Link previous;

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
			Link oldCurrent = current;
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


		/** Set the value of current (the element before "next") */
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
		 *  (Right after current) 
		 */
		public void add(Object elem) {
			if (current == null) {
				System.out.println("Iterator not in list");
				return;
			}
			current.setNext(new Link(elem, current.next()));
			previous = current; //
			current = current.next;
			length++;
		}
	}
}
