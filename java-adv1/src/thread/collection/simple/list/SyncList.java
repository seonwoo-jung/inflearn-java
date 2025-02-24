package thread.collection.simple.list;

import static thread.util.ThreadUtils.sleep;

import java.util.Arrays;

public class SyncList implements SimpleList {

	private static final int DEFAULT_CAPACITY = 5;

	private Object[] elementData;

	private int size = 0;

	public SyncList() {
		elementData = new Object[DEFAULT_CAPACITY];
	}

	@Override
	public synchronized int size() {
		return size;
	}

	@Override
	public synchronized void add(Object e) {
		elementData[size] = e;
		// 멀티스레드 문제를 쉽게 확인하는 코드
		sleep(100);
		size++;
	}

	@Override
	public synchronized Object get(int index) {
		return elementData[index];
	}

	@Override
	public synchronized String toString() {
		return Arrays.toString(Arrays.copyOf(elementData, size)) +
			" size = " + size + ", capacity = " + elementData.length;
	}
}
