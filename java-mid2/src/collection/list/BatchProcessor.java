package collection.list;

public class BatchProcessor {

	// 의존관계를 런타임시에 결정한다.
	// new 연산자로 직접 주입하면, 컴파일 시점에 주입하는 것
	private final MyList<Integer> list;

	public BatchProcessor(MyList<Integer> list) {
		this.list = list;
	}

	public void logic(int size) {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < size; i++) {
			list.add(0, i);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("크기: " + size + ", 계산 시간: " + (endTime - startTime) + "ms");
	}
}
