package stacks;

/**
 * A singly linked list-based implementation of Stack ADT.
 * The code is modified from the code of Prof. Galles. 
 */
public class ListStack implements Stack {
	private Node top; // the top of the stack

	public ListStack() {
		top = null;
	}

	/** Push the new element on top of the stack */
	public void push(Object elem) {
		top = new Node(elem, top);
		// By passing top as the value of the "next" pointer,
		// we connect the new node to the rest of the list
	}

	/** Check if the stack is empty */
	public boolean empty() {
		return top == null;
	}

	/** Pop the element at the top of the stack and return its value */
	public Object pop() {
		Object poppedValue;

		if (top == null)
			return null;
		poppedValue = top.element();
		top = top.next();
		return poppedValue;
	}

	/** Print elements of the stack, starting at the top */
	public String toString() {
		Node stackPtr = top;
		String result = "[";
		if (stackPtr != null) {
			result = result + top.element();
			for (stackPtr = stackPtr.next; stackPtr != null; stackPtr = stackPtr.next) {
				result = result + "," + stackPtr.element();
			}

		}
		result = result + "]";
		return result;
	}

	//--------------------- Inner class Node -------------------------
	/** Inner class Node that defines a single node in the LinkedList */
	private class Node {
		private Object element; 
		private Node next;

		public Node(Object newElement) {
			element = newElement;
			next = null;
		}

		/**
		 * Create a new linked list node, where the data in the node is
		 * newElement, and the "next" points at newNext
		 * 
		 * @param newElement element
		 * @param newNext pointer to the next node
		 */
		public Node(Object newElement, Node newNext) {
			element = newElement;
			next = newNext;
		}

		/**
		 * Return the next node
		 * @return next node
		 */
		public Node next() {
			return next;
		}

		/**
		 * Return the element stored in the node
		 * @return element
		 */
		public Object element() {
			return element;
		}

	}
}
