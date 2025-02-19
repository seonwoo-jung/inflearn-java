package thread.control;

public class CheckedExceptionMain {

	public static void main(String[] args) throws Exception {
		throw new Exception();
	}

	static class CheckedRunnable implements Runnable {

		@Override
		public void run() {
			// 런타임 예외로 변경
//			ThreadUtils.sleep(1000);
		}
	}
}
