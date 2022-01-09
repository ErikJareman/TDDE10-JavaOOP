package myutil;

public class nodeClassTestProgram {

	public static void stackAndNodeTest() throws IndexException {

//		Node<String> a = new Node<String>("hejd�", null);
//		Node<String> element = new Node<String>("hej", a);
//		System.out.println(element.getNext().getData());
//		System.out.println(element.getData() + "\n");

		MyStack<String> stackOne = new MyStack<String>();
//		stackOne.push("1");
//		stackOne.push("2");
//		stackOne.push("3");
//		System.out.println(stackOne.getTop().getData());
//		System.out.println(stackOne.getTop().getNext().getData());
//		System.out.println(stackOne.getTop().getNext().getNext().getData());
//		stackOne.pop();
//		System.out.println(stackOne.pop());
//		System.out.println(stackOne.pop() + "\n");
		stackOne.pop();

	}

	public static void queueTest() throws IndexException {

		MyQueue<String> stackOne = new MyQueue<String>();
		stackOne.enqueue("1");
		stackOne.enqueue("2");
		stackOne.enqueue("3");
		System.out.println(stackOne.getFirst().getData());
		System.out.println(stackOne.getFirst().getNext().getData());
		System.out.println(stackOne.getFirst().getNext().getNext().getData());
		stackOne.dequeue();
		System.out.println(stackOne.dequeue());
		System.out.println(stackOne.dequeue() + "\n");
	}

	public static void listTest() throws IndexException {

		MyList<String> stackOne = new MyList<String>();
		stackOne.add("1");
		stackOne.add("2");
		stackOne.add("3");
		System.out.println(stackOne.getElementAt(0));
		System.out.println(stackOne.getElementAt(1));
		System.out.println(stackOne.getElementAt(2));
		//System.out.println(stackOne.getElementAt(5));
		//System.out.println(stackOne.getElementAt(-4));
	}



	public static void main(String[] args) {
//		try {
			stackAndNodeTest();
//			queueTest();
//			listTest();
//		}
//		catch (IndexException e) {
//			System.out.println(e.getMessage());
//		}
	}
}