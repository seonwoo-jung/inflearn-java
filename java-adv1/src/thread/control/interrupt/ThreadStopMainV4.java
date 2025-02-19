package thread.control.interrupt;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

/**
 * 인터럽트가 발생하면, 스레드의 인터럽트 상태를 다시 정상으로 돌려두어야 한다.
 */
public class ThreadStopMainV4 {

	public static void main(String[] args) {
		MyTask task = new MyTask();
		Thread thread = new Thread(task, "work");
		thread.start();

		sleep(100); // 시간을 줄임
		log("작업 중단 지시 thread.interrupt()");
		// interrupt() 호출시, Exception 발생
		thread.interrupt();
		log("work 스레드 인터럽트 상태1 = " + thread.isInterrupted());
	}

	static class MyTask implements Runnable {

		@Override
		public void run() {
			/**
			 * Thread.interrupted()와 Thread.currentThread().isInterrupted()는 모두 동일하지만, 스레드가 인터럽트 상태면 false로 변경
			 */

			while (!Thread.interrupted()) { // 인터럽트 상태 변경O
				log("작업 중");
			}
			log("work 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted());

			try {
				log("자원 정리");
				Thread.sleep(1000);
				log("자원 종료");
			} catch (InterruptedException e) {
				log("자원 정리 실패 - 자원 정리 중 인터럽트 발생");
				log("work 스레드 인터럽트 상태3 = " + Thread.currentThread().isInterrupted());
			}
			log("작업 종료");
		}
	}
}
