package generic.ex1;

// 다이아몬드(=제네릭 클래스) 사이에 T를 쓰기 (다른 문자도 가능)
public class GenericBox<T> {

	// 타입이 된다
	private T value;

	public void set(T value) {
		this.value = value;
	}

	public T get() {
		return value;
	}
}
