package thread.executor.test;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NewOrderService {

	private final ExecutorService es = Executors.newFixedThreadPool(10);

	public void order(String orderNo) throws InterruptedException, ExecutionException {
		InventoryWork inventoryWork = new InventoryWork(orderNo);
		ShippingWork shippingWork = new ShippingWork(orderNo);
		AccountingWork accountingWork = new AccountingWork(orderNo);

		try {
			List<Future<Boolean>> futures = es.invokeAll(List.of(inventoryWork, shippingWork, accountingWork));

			for (Future<Boolean> future : futures) {
				if (!future.get()) {
					log("일부 작업이 실패했습니다.");
				}
			}
		} finally {
			es.close();
		}

		log("모든 주문 처리가 성공적으로 완료되었습니다.");
	}

	private static class InventoryWork implements Callable<Boolean> {

		private final String orderNo;

		public InventoryWork(String orderNo) {
			this.orderNo = orderNo;
		}

		public Boolean call() {
			log("재고 업데이트: " + orderNo);
			sleep(1000);
			return true;
		}
	}

	private static class ShippingWork implements Callable<Boolean> {

		private final String orderNo;

		public ShippingWork(String orderNo) {
			this.orderNo = orderNo;
		}

		public Boolean call() {
			log("배송 시스템 알림: " + orderNo);
			sleep(1000);
			return true;
		}
	}

	static class AccountingWork implements Callable<Boolean> {

		private final String orderNo;

		public AccountingWork(String orderNo) {
			this.orderNo = orderNo;
		}

		public Boolean call() {
			log("회계 시스템 업데이트: " + orderNo);
			sleep(1000);
			return true;
		}
	}
}
