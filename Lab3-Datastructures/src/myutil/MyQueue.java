package myutil;

public class MyQueue<E> {

	private Node<E> first = null;
	private int size = 0;

	public MyQueue() {
	}


	public void enqueue(E element) {
		Node<E> newElement = new Node<E>(element, null);
		if (this.size != 0) {
			this.first.setLast(newElement);
		}else {
			this.first = newElement;
		}
		this.size += 1;
	}

	public E dequeue() throws IndexException {
		if (this.first == null) {
			throw new IndexException("K�n �r redan tom!");
		} else if (this.size() == 1) {
			E element;
			element = this.first.getData();
			this.size -= 1;
			return element;
		} else {
			E element;
			element = this.first.getData();
			this.first = this.first.getNext();
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

	public Node<E> getFirst() throws IndexException {
		if (this.isEmpty()) {
			throw new IndexException("getFirst skiter sig aka k�n �r helt tom..");
		}
		return this.first;
	}
}