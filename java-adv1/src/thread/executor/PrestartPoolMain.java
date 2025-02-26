package thread.executor;

import static thread.executor.ExecutorUtils.printState;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class PrestartPoolMain {

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(1000);
		printState(es);
		ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) es;
		poolExecutor.prestartAllCoreThreads();
		printState(es);
	}
}
