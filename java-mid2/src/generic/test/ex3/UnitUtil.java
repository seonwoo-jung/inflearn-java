package generic.test.ex3;

import generic.test.ex3.unit.BioUnit;

public class UnitUtil {

	public static <T extends BioUnit> T maxHp(T m1, T m2) {
		return m1.getHp() > m2.getHp() ? m1 : m2;
	}
}
