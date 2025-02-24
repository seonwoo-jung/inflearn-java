package thread.cas.spinlock;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class SpinLockMain {

	public static void main(String[] args) {
		SpinLock spinLock = new SpinLock();
		Runnable task = new Runnable() {
			@Override
			public void run() {
				spinLock.lock();
				try {
					// critical section
					log("비즈니스 로직 실행");
					sleep(10);
				} finally {
					spinLock.unlock();
				}
			}
		};

		Thread t1 = new Thread(task, "Thread-1");
		Thread t2 = new Thread(task, "Thread-2");
		t1.start();
		t2.start();
	}
}
