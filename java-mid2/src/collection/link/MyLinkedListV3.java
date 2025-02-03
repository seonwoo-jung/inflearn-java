package collection.link;

public class MyLinkedListV3<E> {

	private Node<E> first;
	private int size = 0;

	public void add(E e) {
		Node<E> newNode = new Node<>(e);
		if (first == null) {
			first = newNode;
		} else {
			Node<E> lastNode = getLastNode();
			lastNode.next = newNode;
		}
		size++;
	}

	private Node<E> getLastNode() {
		Node<E> x = first;

		while (x.next != null) {
			x = x.next;
		}

		return x;
	}

	// 추가 코드
	public void add(int index, E e) {
		Node<E> newNode = new Node(e);
		if (index == 0) {
			newNode.next = first;
			first = newNode;
		} else {
			Node<E> prev = getNode(index - 1);
			newNode.next = prev.next;
			prev.next = newNode;
		}
		size++;
	}

	public E set(int index, E element) {
		Node<E> x = getNode(index);
		E oldValue = x.item;
		x.item = element;
		return oldValue;
	}

	// 추가 코드
	public E remove(int index) {
		Node<E> removeNode = getNode(index);
		E removedItem = removeNode.item;
		if (index == 0) {
			first = removeNode.next;
		} else {
			Node<E> prev = getNode(index - 1);
			prev.next = removeNode.next;
		}
		removeNode.item = null;
		removeNode.next = null;
		size--;
		return removedItem;
	}

	public E get(int index) {
		Node<E> node = getNode(index);
		return node.item;
	}

	private Node<E> getNode(int index) {
		Node<E> x = first;
		for (int i = 0; i < index; i++) {
			x = x.next;
		}
		return x;
	}

	public int indexOf(E o) {
		int index = 0;

		for (Node<E> x = first; x != null; x = x.next) {
			if (o.equals(x.item)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	public int size() {
		return size;
	}

	@Override
	public String toString() {
		return "MyLinkedListV2{" +
			"first=" + first +
			", size=" + size +
			'}';
	}

	private static class Node<E> {

		E item;
		Node<E> next;

		public Node(E item) {
			this.item = item;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			Node<E> x = this;
			sb.append("[");
			while (x != null) {
				sb.append(x.item);
				if (x.next != null) {
					sb.append("->");
				}
				x = x.next;
			}
			sb.append("]");
			return sb.toString();
		}
	}
}