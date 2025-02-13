package annotation.mapping;

public class TestController {

	// 리플렉션 같은 기술로 실행시점에 읽어서 활용할 수 있는 특별한 주석
	// 프로그램이 읽을 수 있는 코드: 어노테이션
	@SimpleMapping(value = "/")
	public void home() {
		System.out.println("TestController.home");
	}

	@SimpleMapping(value = "/site1")
	public void page1() {
		System.out.println("TestController.page1");
	}
}
