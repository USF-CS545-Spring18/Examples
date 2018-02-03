package linkedLists;

/** LinkedList class - implementation of a singly linked list.
 * Each node stores an element of type Object,
 * and a reference to the next node. The first element is stored
 * in the head (no dummy head in this implementation).
 * */
public class LinkedList {

    private Node head;
    private Node tail;

    /** Constructor of the class.
     * The list is empty (head and tail are null). */
    LinkedList() {
        head = null;
        tail = null;
    }

    /**
     * Insert a node with the given element in front of the list,
     * before the current head.
     * @param elem
     */
    public void insertFront(Object elem) {
        Node newnode = new Node(elem, head);
        head = newnode;
        if (tail  == null) // list was empty, we inserted the first node
            tail = head;
    }

    /**
     * Add a new node with the given element to end of the list.
     * @param elem
     */
    public void insertBack(Object elem) {
        if (tail == null) { // list is empty
            insertFront(elem);
            return;
        }
        Node newNode = new Node(elem, null);
        tail.next = newNode;
        tail = tail.next();
    }

    /**
     * Return the element of the node at a given index in the list.
     * @param index
     * @return the element of the node at a given index in the list.
     */
    public Object get(int index) {
        if (index < 0)
            throw new IndexOutOfBoundsException("Index is invalid.");

        Node current = head;
        int i = 0;
        while (current != null && i < index) {
            current = current.next;
            i++;
        }
        if (current != null)
            return current.element;
        else
            throw new IndexOutOfBoundsException("Index is invalid.");

    }

    /** Print all the elements of the list */
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.element + "  ");
            current = current.next;
        }
        System.out.println();
    }

    /**
     * Insert a node of the given element at the given index in the list
     * @param index
     * @param elem
     */
    public void insert(int index, Object elem) {
        if (index < 0)
            throw new IndexOutOfBoundsException("Index is invalid.");

        if (index == 0) { //list is empty, inserting at 0
             insertFront(elem);
             return;
        }

        // Find "prev" node - node right before the place
        // where we need to insert
        Node prev = head;
        int i = 0;
        while (prev != null && i < index - 1) {
            prev = prev.next;
            i++;
        }
        if (prev == null)
            throw new IndexOutOfBoundsException("Index is invalid.");

        prev.next = new Node(elem, prev.next);
    }

    /**
     * Remove the node at the given index and return the element of the
     * removed node
     * @param index
     * @return the element stored in the removed node
     */
    public Object remove(int index) {
        if (head == null)
            return null; // list is empty, nothing to do

        Object removedElem = null; // the element to return
        if (index == 0) { // removing the head
            removedElem = head.element;
            head = head.next;
            return removedElem;
        }
        // General case: find "prev" node: node right before the node
        // we are removing
        Node prev = head;
        int i = 0;
        while (prev != null && i < index - 1) {
            prev = prev.next;
            i++;
        }
        if (prev == null || prev.next == null) {
            throw new IndexOutOfBoundsException("Index is invalid.");
        }
        removedElem = prev.next.element;
        prev.next = prev.next.next;
        return removedElem;
    }

    // -------------------------------------------
	/** Inner class Node. Represents a single node in a linked list.
     *  Since Node is an inner class, we can access all its data fields
     *  from the outer class LinkedList (even private ones).
     *  */
    private class Node {
        Object element;
        Node next;

        Node() {
            this.element = null;
            this.next = null;
        }

		Node(Object elem, Node next) {
            this.element = elem;
            this.next = next;
        }

		Node next() {
            return next;
        }

        Object element() {
            return element;
        }

    }

}


