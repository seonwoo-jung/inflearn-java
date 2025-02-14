package thread.start;

public class HelloThreadMain {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + ": main() start");

		HelloThread helloThread = new HelloThread();

		System.out.println(Thread.currentThread().getName() + ": start() 호출 전");

		// start() 메서드를 호출해야 별도의 스레드에서 run() 코드가 실행된다. (스레드 간 실행 순서는 보장하지 않음)
		helloThread.start(); // main thread가 기다리지 않음.

		System.out.println(Thread.currentThread().getName() + ": start() 호출 후");

		System.out.println(Thread.currentThread().getName() + ": main() end");
	}
}
