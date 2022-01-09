package myutil;

public class MyList<E> {

	private Node<E> first = null;
	private int size = 0;

	public MyList() {
	}



	public void add(E element) {
		Node<E> newElement = new Node<E>(element, null);
		if (this.size != 0) {
			this.first.setLast(newElement);
		}else {
			this.first = newElement;
		}
		this.size += 1;
	}

	public E getElementAt(int i) throws IndexException {

		if (i == 0 && this.size > 0) {
			return this.first.getData();
		} else if (0 < i && i < this.size) {
			Node<E> ref = this.first;
			for (int j = 0; j < i; j++) {
				ref = ref.getNext();
			}
			return ref.getData();
		} else {
			throw new IndexException("getElementAt() error");
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
			throw new IndexException("getFirst skiter sig aka kön är helt tom..");
		}
		return this.first;
	}
}