package collection.set;

import java.util.Arrays;

/**
 * 삽입시 중복을 조회가 필요해 성능이 떨어지는 이슈
 */
public class HashStart1 {

	public static void main(String[] args) {
		Integer[] inputArray = new Integer[4];
		inputArray[0] = 1;
		inputArray[1] = 2;
		inputArray[2] = 5;
		inputArray[3] = 8;
		System.out.println("inputArray = " + Arrays.toString(inputArray));

		int searchValue = 0;

		// 4번 반복 O(n)
		for (Integer inputValue : inputArray) {
			if (inputValue == searchValue) {
				System.out.println(inputValue);
			}
		}
	}
}
