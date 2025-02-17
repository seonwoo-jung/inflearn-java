package thread.control;

import static thread.util.MyLogger.log;

public class ThreadStateMain {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new MyRunnable(), "myThread");
		log("myThread.state1 = " + thread.getState());
		log("myThread.start()");
		// myThread는 start() 호출 전까지 NEW 상태
		thread.start();
		Thread.sleep(1000);
		log("myThread.state3 = " + thread.getState()); // TIMED_WAITING
		Thread.sleep(4000);
		log("myThread.state5 = " + thread.getState());

		log("end");
	}

	static class MyRunnable implements Runnable {

		@Override
		public void run() {
			try {
				log("start");
				log("myThread.state2 = " + Thread.currentThread().getState()); // RUNNABLE
				log("sleep() start");
				Thread.sleep(3000); // myThread의 상태를 확인하고 싶을 때는?
				log("sleep() end");
				log("myThread.state4 = " + Thread.currentThread().getState()); // RUNNABLE
				log("end");
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
