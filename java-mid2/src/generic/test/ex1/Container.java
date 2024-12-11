package generic.test.ex1;

public class Container<T> {
	private T item;

	public boolean isEmpty() {
		return item == null;
	}

	public void setItem(T value) {
		this.item = value;
	}

	public T getItem() {
		return this.item;
	}
}
