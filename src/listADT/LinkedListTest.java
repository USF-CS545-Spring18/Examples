package listADT;
/** A Driver for the LinkedList class */
public class LinkedListTest {
	public static void main(String[] args) {
		LinkedList llist = new LinkedList();
		llist.add(5);
		llist.add(15);
		llist.add(6);
		llist.add(24);		
		llist.add(58);
		
		llist.print();
		System.out.println("Appending 47");
		llist.add(47);
		System.out.println("Inserting 99 at index 3");
		llist.add(3, 99);
		llist.print();
		
		ListIterator it = llist.listIterator();
		System.out.println("Calling it.next(): " + it.next());
		System.out.println("Calling it.next(): " + it.next());
		llist.print();
		
	}
}
