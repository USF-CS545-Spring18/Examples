package queues;

public class Driver {
	public static void main(String[] args) {

		// Create a ListQueue
		ListQueue queue1  = new ListQueue();
		queue1.enqueue(15);
		queue1.enqueue(27);
		queue1.enqueue(99);
		System.out.println(queue1);
		System.out.println("Dequeue elem:" + queue1.dequeue());
		System.out.println("Dequeue elem:" + queue1.dequeue());
		System.out.println("Dequeue elem:" + queue1.dequeue());
		System.out.println(queue1);


		/*// Create an ArrayQueue
		ArrayQueue queue2 = new ArrayQueue(4);
		queue2.enqueue(5);
		queue2.enqueue(1);
		queue2.enqueue(2);
		// there should always be one empty spot; this is considered "full"
		*/
		
	}
}
