package listADT;
/** A Driver for the ArrayList class */
public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList alist = new ArrayList();
		alist.add(5);
		alist.add(15);
		alist.add(6);
		alist.add(24);		
		alist.add(58);
		
		alist.print();
		System.out.println("Appending 47");
		alist.add(47);
		System.out.println("Adding 99 at index 3.");
		alist.add(3, 99);
		System.out.println("Printing alist:");
		alist.print();
		ListIterator it = alist.listIterator();
		System.out.println("Calling it.next():" + it.next());
		System.out.println("Calling it.next():" + it.next());
		it.remove();
		System.out.println("After calling it.remove(): ");
		alist.print();
		System.out.println("Calling it.prev() " + it.previous());
		System.out.println("Calling it.next():" + it.next());

		System.out.println("After calling it.add(85)");
		it.add(85);
		System.out.println("Calling it.next():" + it.next());

		alist.print();
		
		

		
	}
}
