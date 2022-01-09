package myutil;

public class MyStack<E> {

	private Node<E> top = null;
	private int size = 0;

	public MyStack() {
	}

	public void push(E element) {
		Node<E> newElement = new Node<E>(element, top);
		top = newElement;
		this.size += 1;
	}

	//TODO: Komplettering: Gick inte igenom testet. Det kastas inget exception när
	//man anropar pop() en tom stack. 
	
	//Kommentar: Ni ska inte behöva skilja på när size==1 eller
	//size >1. Detta borde inte behövas.
	public E pop() throws IndexException {
		if (this.top == null) {
			throw new IndexException("Stacken �r redan tom!");
		} else if (this.size() == 1) {
			E element;
			element = this.top.getData();
			this.size -= 1;
			return element;
		} else {
			E element;
			element = this.top.getData();
			this.top = this.top.getNext();
			this.size -= 1;
			return element;
		}
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int size() {
		return this.size;
	}
	
	//Kommentar: När används denna? Den borde inte behövas utan man använder
	//pop() för att hämta element i listan. 
	public Node<E> getTop() throws IndexException {
		if (this.isEmpty()) {
			throw new IndexException("getTop skiter sig aka stacken �r helt tom..");
		}
		return this.top;
	}
}
