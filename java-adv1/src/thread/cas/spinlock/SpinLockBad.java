package thread.cas.spinlock;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class SpinLockBad {

	private volatile boolean lock = false;

	public void lock() {
		log("락 획득 시도");
		while (true) {
			// 1. 락 사용 여부 확인
			if (!lock) {
				sleep(100);
				// 2. 락의 값 변경
				lock = true;
				break;
			} else {
				// 락을 획득할 때까지 스핀 대기(바쁜 대기) 한다.
				log("락 획득 실패 - 스핀 대기");
			}
		}
		log("락 획득 완료");
	}

	public void unlock() {
		lock = false;
		log("락 반납 완료");
	}
}
