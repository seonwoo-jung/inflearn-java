package generic.test.ex3;

import generic.test.ex3.unit.BioUnit;

// 제네릭보다는 와일드카드로 구현하는게 단순하기에 추천
public class UnitPrinter {

	// 제네릭으로 구현
	public static <T extends BioUnit> void printV1(Shuttle<T> t1) {
		T unit = t1.out();
		System.out.println("이름: " + unit.getName() + ", HP: " + unit.getHp());
	}

	// 와일드카드로 구현
	public static void printV2(Shuttle<? extends BioUnit> t1) {
		BioUnit unit = t1.out();
		System.out.println("이름: " + unit.getName() + ", HP: " + unit.getHp());
	}
}
