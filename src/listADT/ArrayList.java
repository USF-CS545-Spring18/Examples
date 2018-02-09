package listADT;

/** An array-based implementation of List ADT.
 *  Code modified from the code of Prof. Galles.
 *  */
public class ArrayList implements List {

	/*----------------------------------------------------- */
	/* Private Data Members -- ArrayList */
	/*----------------------------------------------------- */

	private static final int DEFAULT_MAX_SIZE = 10;
	private int maxsize;
	private int currentSize;
	private Object data[];

	/*----------------------------------------------------- */
	/* Constructors -- ArrayList */
	/*----------------------------------------------------- */

	/** Default constructor */
	ArrayList() {
		maxsize = DEFAULT_MAX_SIZE;
		currentSize = 0;
		data = new Object[maxsize];
	}

	/**
	 * Constructor
	 * @param maximumSize max size of the list
	 */
	ArrayList(int maximumSize) {
		maxsize = maximumSize;
		currentSize = 0;
		data = new Object[maxsize];
	}

	/*----------------------------------------------------- */
	/* Public Methods -- ArrayList */
	/*----------------------------------------------------- */

	public void clear() {
		currentSize = 0;
	}

	/**
	 * Return the current size of the list
	 * @return number of elements in the list
	 */
	public int size() {
		return currentSize;
	}

	/**
	 * Append the element to the list
	 * @param elem element to append to the list
	 */
	public void add(Object elem) {
		if (currentSize >= maxsize) {
			System.out.println("List is full");
			return;
		}
		data[currentSize] = elem;
		currentSize++;
	}

	/**
	 * Insert an element at a given index
	 * @param index index in the list
	 * @param elem element to insert
	 */
	public void add(int index, Object elem) {
		// is index valid?
		if ((index >= currentSize) || (index < 0)) {
			System.out.println("Index out of bounds");
			// Would be better to throw an exception
			return;
		}
		// is there space in the list?
		else if (currentSize >= maxsize) {
			System.out.println("List is full");
			// Would be better to throw an exception
			return;
		}
		// shift all elements starting at index to the right
		for (int i = currentSize; i > index; i--) {
			data[i] = data[i - 1];
		}
		data[index] = elem;
		currentSize++;
	}

	/**
	 * Return the element of the list at the given index
	 * @param index index in the list
	 * @return the element at that index
	 */
	public Object get(int index) {
		if (index < 0 || index < currentSize) {
			System.out.println("Index out of bounds");
			return null;
		}
		return data[index];
	}

	/**
	 * Remove the element of the list at the given index
	 * @param index index in the list
	 */
	public void remove(int index) {
		if (index < 0 || index < currentSize) {
			System.out.println("Index out of bounds");
			return;
		}
		// shift all elements starting at index + 1 to the left
		for (int i = index + 1; i < currentSize; i++) {
			data[i - 1] = data[i];
		}
		currentSize--;
	}

	/**
	 * Remove the first occurrence of a given element.
	 * @param elem element to remove
	 */
	public void remove(Object elem) {
		int removeIndex;
		// first find the index of the first occurrence of the element
		for (removeIndex = 0; removeIndex < currentSize && !elem.equals(data[removeIndex]); removeIndex++)
			;
		if (removeIndex < currentSize) {
			remove(removeIndex);
		}
	}

	/**
	 * Print the elements of the list.
	 */
	public void print() {
		ListIterator it = listIterator();
		while (it.hasNext()) {
			System.out.print(it.next() + "  ");
		}
		System.out.println();
	}
	
	/**
	 * Return an iterator for the list. Iterator starts from the beginning of
	 * the list.
	 */
	public ListIterator listIterator() {
		return new InnerIterator(0);
	}

	/**
	 * * Return an iterator for the list. Iterator starts from a given position.
	 * @param index index where to start the iterator
	 * @return iterator at a given index
	 */
	public ListIterator listIterator(int index) {

		return new InnerIterator(index);
	}

	/*----------------------------------------------------- */
	/* Nested class -- InnerIterator */
	/*----------------------------------------------------- */
	private class InnerIterator implements ListIterator {

		/*----------------------------------------------------- */
		/* Private Data Members -- InnerIterator */
		/*----------------------------------------------------- */

		private int nextIndex; // the index of the "next" element

		/*----------------------------------------------------- */
		/* Constructor -- InnerIterator */
		/*----------------------------------------------------- */

		public InnerIterator(int startingIndex) {
			nextIndex = startingIndex;
		}

		/*----------------------------------------------------- */
		/* Public Methods -- InnerIterator */
		/*----------------------------------------------------- */

		public Object next() {
			if (nextIndex >= currentSize) {
				System.out.println("No next element");
				// Would be better to throw an exception
				return null;
			}
			Object objectToReturn = data[nextIndex]; // the "next" element
			nextIndex++;
			return objectToReturn;
		}

		/**
		 * hasNext
		 * @return true or false depending on whether
		 * there is next element in the list
		 */
		public boolean hasNext() {
			return (nextIndex < currentSize && nextIndex >= 0);
		}

		/** Return the "previous" element */
		public Object previous() {
			if (nextIndex <= 0) {
				System.out.println("No previous element");
				return null;
			}
			nextIndex = nextIndex - 1;
			return data[nextIndex];

		}

		/**
		 * Return true if there is a previous element (on the left of the
		 * iterator)
		 */
		public boolean hasPrevious() {
			return nextIndex > 0;
		}

		/**
		 * Change the value of the element
		 * at the current position
		 * @param value Change the value of the element at
		 *              the position given by the iterator
		 */
		public void set(Object value) {
			if (nextIndex < 0) { // =
				System.out.println("No current element to set");
				return;
			}
			data[nextIndex] = value;
		}

		/**
		 * Insert the element right before "next"
		 * @param elem
		 */
		public void add(Object elem) {
			int i;
			if (currentSize >= maxsize)  {
				System.out.println("List is full");
				return;
			}
			else if (nextIndex < 0 || nextIndex > currentSize) {
				System.out.println("Iterator not in the list");
				return;
			}
			// shift elements starting at index nextIndex to the right
			for (i = currentSize; i > nextIndex; i--)
				data[i] = data[i - 1];
			// insert a new element at nextIndex
			data[nextIndex] = elem;
			nextIndex++; // move to the next element
			currentSize++;
		}

		/** Remove the element to the left of
		 *  the iterator */
		public void remove() {
			if (currentSize <= 0) {
				System.out.println("List is empty");
				return;
			}
			if (nextIndex <= 0 || nextIndex > currentSize) {
				System.out.println("No current element to delete");
				return;
			}
			// shift all the elements starting at nextIndex to the left
			for (int i = nextIndex; i < currentSize; i++)
				data[i - 1] = data[i];
			currentSize--;
			nextIndex--;
		}

	}


}
