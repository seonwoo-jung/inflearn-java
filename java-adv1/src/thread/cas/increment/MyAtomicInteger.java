package thread.cas.increment;

import java.util.concurrent.atomic.AtomicInteger;

public class MyAtomicInteger implements IncrementInteger {

	AtomicInteger atomicInteger = new AtomicInteger(0);

	@Override
	public void increment() {
		// 내부에 동시성을 위한 코드들이 전부 구현돼있음
		atomicInteger.incrementAndGet();
	}

	@Override
	public int get() {
		return atomicInteger.get();
	}
}
