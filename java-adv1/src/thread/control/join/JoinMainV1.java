package thread.control.join;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class JoinMainV1 {

	public static void main(String[] args) {
		log("Start");
		SumTask task1 = new SumTask(1, 50);
		SumTask task2 = new SumTask(51, 100);
		Thread thread1 = new Thread(task1, "thread-1");
		Thread thread2 = new Thread(task2, "thread-2");

		thread1.start();
		thread2.start();

		// 작업이 끝나지 않았는데 값을 읽어버림
		log("task1.result = " + task1.result);
		log("task2.result = " + task2.result);

		int sumAll = task1.result + task2.result;
		log("task1 + task2 = " + sumAll);
		log("End");
	}

	static class SumTask implements Runnable {

		int startValue;
		int endValue;
		int result;

		public SumTask(int startValue, int endValue) {
			this.startValue = startValue;
			this.endValue = endValue;
		}

		@Override
		public void run() {
			log("작업 시작");
			sleep(2000);
			int sum = 0;
			for (int i = startValue; i <= endValue; i++) {
				sum += i;
			}
			result = sum; // 자바는 먼저 this를 붙여서 필드를 먼저 찾음.
			log("작업 완료 result = " + result);
		}
	}
}
