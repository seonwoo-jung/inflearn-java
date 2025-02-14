package thread.util;

import static thread.util.MyLogger.log;

public abstract class MyLoggerMain {

	public static void main(String[] args) {
		log("hello thread");
		log(123);
	}
}
