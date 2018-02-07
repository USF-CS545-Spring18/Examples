package stacks;

public class Driver {
	public static void main(String[] args) {
		
		// Create an ArrayStack
		System.out.println("Array-based stack implementation");
		ArrayStack stack1 = new ArrayStack();
		stack1.push(5);
		stack1.push(17);
		stack1.push(89);
		System.out.println(stack1);
		System.out.println("Pop elem:" +  stack1.pop());
		System.out.println("Pop elem: " + stack1.pop());
		System.out.println("Pop elem: " + stack1.pop());
		System.out.println("Pop elem: " + stack1.pop());

		// Create a Linked-list stack
		System.out.println("\nLinked list-based stack implementation");
		ListStack stack2 = new ListStack();
		stack2.push(18);
		stack2.push(99);
		stack2.push(1);
		System.out.println(stack2);
		System.out.println("Pop elem: " + stack2.pop());
		System.out.println("Pop elem: " + stack2.pop());
		System.out.println("Pop elem: " + stack2.pop());
		System.out.println("Pop elem: " + stack2.pop());
		

	}
}
