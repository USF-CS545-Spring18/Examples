package linkedLists;

/**
 * The Driver class for LinkedList. In the main method, we create a LinkedList
 * and perform several operations on it (insertion, printing, removal).
 */
public class Driver {
    public static void main(String[] args) {
        LinkedList list  = new LinkedList();
        list.insertFront(5);
        list.insertFront(10);
        list.insertFront(12);
        list.insertBack(13);
        list.insertBack(25);
        list.insertFront(8);
        list.insert(2, 81);
        list.insert(5, 100);
        list.insert(0, 99);
        System.out.println("After insertions: ");
        list.print();

        System.out.println("Removed element at index 0: " + list.remove(0));
        System.out.println("After removing the node at index 0: ");
        list.print();

        System.out.println("Removed element at index 1: " + list.remove(1));
        System.out.println("After removing element at index 1: ");
        list.print();

    }
}
