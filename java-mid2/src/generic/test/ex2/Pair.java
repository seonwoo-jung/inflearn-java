package generic.test.ex2;

public class Pair<K, V> {
	private K key;
	private V value;

	public void setFirst(K key) {
		this.key = key;
	}

	public void setSecond(V value) {
		this.value = value;
	}

	public K getFirst() {
		return this.key;
	}

	public V getSecond() {
		return this.value;
	}

	@Override
	public String toString() {
		return "Pair{" +
			"key=" + key +
			", value=" + value +
			'}';
	}
}
