package queues;
/** A class that implements a Queue ADT using a circular array
 *  The code is modified from Prof. Galles's code.
 */
public class ArrayQueue implements Queue {

	static final int defaultsize = 100;

	private Object data[]; // the array that will store the queue
	private int head;
	private int tail;
	private int size; // the maximum # of elements it can hold

	ArrayQueue(int maxsize) {
		data = new Object[maxsize];
		head = 0;
		tail = 0;
		size = maxsize;
	}

	ArrayQueue() {
		data = new Object[defaultsize];
		head = 0;
		tail = 0;
		size = defaultsize;
	}

	/** Add an element to the end of the queue, if it's not full */
	public void enqueue(Object elem) {
		// Before adding, check if the queue is full
		if ((tail + 1) % size == head) {
			System.out.println("Queue is full: Can't add an element");
			return;
		}
		data[tail] = elem;
		tail = (tail + 1) % size;
	}

	public Object dequeue() {
		Object retval;

		if (head == tail)
			return null;
		retval = data[head];
		head = (head + 1) % size;
		return retval;
	}

	public boolean empty() {
		return head == tail;
	}

	public String toString() {
		String result = "[";
		int tmpHead = head;
		if (tmpHead != tail) {
			result = result + data[tmpHead];
			tmpHead = (tmpHead + 1) % size;
			while (tmpHead != tail) {
				result = result + "," + data[tmpHead];
				tmpHead = (tmpHead + 1) % size;
			}
		}
		result = result + "]";
		return result;
	}

}
