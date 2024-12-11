package generic.ex1;

/**
 * Object를 사용함으로 중복 해결(IntegerBox, StringBox 두개를 만들 필요가 없음)
 */
public class BoxMain2 {

	public static void main(String[] args) {
		// Object -> Integer
		ObjectBox integerBox = new ObjectBox();
		integerBox.set(10);
		Integer integer = (Integer) integerBox.get();
		System.out.println("integer = " + integer);

		// Object -> String
		ObjectBox stringBox = new ObjectBox();
		stringBox.set("hello");
		String str = (String) stringBox.get();
		System.out.println("str = " + str);

		// 잘못된 타입의 인수 전달시
		integerBox.set("문자100");
		Integer result = (Integer) integerBox.get(); // String -> Integer 캐스팅 예외 발생
		System.out.println("result = " + result);
	}
}