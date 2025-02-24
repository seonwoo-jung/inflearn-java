package thread.bounded;

import static thread.util.MyLogger.log;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedQueueV5 implements BoundedQueue {

	private final Lock lock = new ReentrantLock();
	private final Condition producerCond = lock.newCondition();
	private final Condition consumerCond = lock.newCondition();

	private final Queue<String> queue = new ArrayDeque<>();
	private final int max;

	public BoundedQueueV5(int max) {
		this.max = max;
	}

	@Override
	public void put(String data) {
		lock.lock();
		try {
			while (queue.size() == max) {
				log("[put] 큐가 가득 참, 생산자 대기");
				try {
					producerCond.await(); // 대기상태로 변경
					log("[put] 생산자 깨어남");
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
			queue.offer(data);
			log("[put] 생산자 데이터 저장, notify() 호출");
			consumerCond.signal(); // condition에서 대기중인 스레드를 하나 깨움
		} finally {
			lock.unlock();
		}
	}

	@Override
	public String take() {
		lock.lock();
		try {
			while (queue.isEmpty()) {
				log("[take] 큐에 데이터가 없음, 소비자 대기");
				try {
					consumerCond.await();
					log("[take] 소비자 깨어남");
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
			String data = queue.poll();
			log("[take] 소비자 데이터 획득, notify() 호출");
			producerCond.signal();
			return data;
		} finally {
			lock.unlock();
		}
	}

	@Override
	public String toString() {
		return queue.toString();
	}
}
