package thread.control;

import static thread.util.MyLogger.log;

import thread.start.HelloRunnable;

public class ThreadInfoMain {

	public static void main(String[] args) {
		// main thread
		Thread mainThread = Thread.currentThread();
		log("mainThread = " + mainThread);
		log("mainThread.threadId() = " + mainThread.threadId());
		log("mainThread.getName() = " + mainThread.getName());
		log("mainThread.getPriority() = " + mainThread.getPriority()); // 우선순위가 높을경우 CPU 스케줄링시 조금 더 많이 실행됨
		log("mainThread.getThreadGroup() = " + mainThread.getThreadGroup());
		log("mainThread.getState() = " + mainThread.getState());

		System.out.println("=============================");

		// myThread
		Thread myThread = new Thread(new HelloRunnable(), "myThread"); // Thread 구현체, 이름 전달
		log("myThread = " + myThread);
		// JVM 내에서 각 스레드에 대해 융리함
		log("myThread.threadId() = " + myThread.threadId());
		// 이름은 중복될 수 있음
		log("myThread.getName() = " + myThread.getName());
		// 우선순위가 높을경우 CPU 스케줄링시 조금 더 많이 실행됨
		log("myThread.getPriority() = " + myThread.getPriority());
		log("myThread.getThreadGroup() = " + myThread.getThreadGroup());
		// 스레드의 현재 상태를 반환
		log("myThread.getState() = " + myThread.getState());
	}
}
