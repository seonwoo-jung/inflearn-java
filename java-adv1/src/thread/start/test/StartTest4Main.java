package thread.start.test;

import static thread.util.MyLogger.log;

public class StartTest4Main {

	public static void main(String[] args) {
		Thread threadA = new Thread(() -> {
			for (int i = 1; i <= 5; i++) {
				log("A");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		}, "Thread-A");

		Thread threadB = new Thread(() -> {
			for (int i = 1; i <= 5; i++) {
				log("B");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		}, "Thread-B");

		threadA.start();
		threadB.start();
	}
}
