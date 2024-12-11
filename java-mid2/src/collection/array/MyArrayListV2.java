package collection.array;

import java.util.Arrays;

public class MyArrayListV2 {

	private static final int DEFAULT_CAPACITY = 5;
	private Object[] elementData;
	private int size = 0;

	public MyArrayListV2() {
		elementData = new Object[DEFAULT_CAPACITY];
	}

	public MyArrayListV2(int initialCapacity) {
		elementData = new Object[initialCapacity];
	}

	public int size() {
		return size;
	}

	public void add(Object e) {
		// 코드 추가
		if (size == elementData.length) {
			grow();
		}
		elementData[size] = e;
		size++;
	}

	// 코드 추가
	private void grow() {
		int oldCapacity = elementData.length;
		int newCapacity = oldCapacity * 2;
//		for (int i = 0; i < elementData.length; i++) {
//			newArr[i] = elementData;
//		}
		// 배열을 새로 만들고, 기존 배열을 새로운 배열에 복사
		elementData = Arrays.copyOf(elementData, newCapacity);
	}

	public Object get(int index) {
		return elementData[index];
	}

	public Object set(int index, Object element) {
		Object oldValue = get(index);
		elementData[index] = element;
		return oldValue;
	}

	public int indexOf(Object o) {
		for (int i = 0; i < size; i++) {
			if (o.equals(elementData[i])) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public String toString() {
		return Arrays.toString(Arrays.copyOf(elementData, size)) + " size=" +
			size + ", capacity=" + elementData.length;
	}
}
