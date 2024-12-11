package generic.ex4;

public class GenericMethod {

	public static Object objMethod(Object obj) {
		System.out.println("Object print: " + obj);
		return obj;
	}

	// 메서드에만 한정적으로 사용되는 제네릭, 클래스에 정의하면 클래스 전체에서 사용됨
	public static <T> T genericMethod(T t) {
		System.out.println("generic print: " + t);
		return t;
	}

	public static <T extends Number> T numberMethod(T t) {
		System.out.println("bound print: " + t);
		return t;
	}
}
