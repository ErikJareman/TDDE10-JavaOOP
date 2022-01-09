package myutil;

public class Node<E> {

	private E data;
	private Node<E> next;

	public Node(E data, Node<E> next) {
		this.data = data;
		this.next = next;
	}

	public E getData() {
		return this.data;
	}

	public Node<E> getNext() throws IndexException{
		if (this.next != null) {
			return this.next;
		}else {
			throw new IndexException("Anropat element saknas!");
		}
	}

	public void setLast(Node<E> element) {
		if (this.next == null) {
			this.next = element;
		}else {
			this.next.setLast(element);
		}

	}

}
