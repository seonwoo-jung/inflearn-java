package thread.executor.reject;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import thread.executor.RunnableTask;

public class RejectMainV2 {

	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS,
			new SynchronousQueue<>(), new ThreadPoolExecutor.DiscardPolicy());

		executor.submit(new RunnableTask("task1"));
		executor.submit(new RunnableTask("task2"));
		executor.submit(new RunnableTask("task3"));
		executor.close();
	}
}
