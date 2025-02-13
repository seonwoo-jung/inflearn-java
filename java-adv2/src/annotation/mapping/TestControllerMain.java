package annotation.mapping;

import java.lang.reflect.Method;

public class TestControllerMain {

	public static void main(String[] args) {
		TestController testController = new TestController();

		Class<? extends TestController> aClass = testController.getClass();
		for (Method method : aClass.getDeclaredMethods()) {
			System.out.println("method = " + method);
			SimpleMapping simpleMapping = method.getAnnotation(SimpleMapping.class); // @SimpleMapping 어노테이션이 붙은 메소드를 가져옴
			if (simpleMapping != null) {
				System.out.println("[" + simpleMapping.value() + "] -> " + method);
			}
		}
	}
}
