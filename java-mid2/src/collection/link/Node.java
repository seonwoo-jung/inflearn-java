package collection.link;

import java.util.StringTokenizer;

public class Node {

	Object item;
	Node next;

	public Node(Object item) {
		this.item = item;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node x = this;
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
