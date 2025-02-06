package io.file.copy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileCopyMainV3 {

	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();

		Path source = Path.of("java-adv2/temp/copy.dat");
		Path target = Path.of("java-adv2/temp/copy.dat");
		// 파일의 데이터를 자바로 불러오지 않고, 운영체제의 파일 복사 기능을 사용한다. (파일을 다루어야 할 일이 있으면 Files를 먼저 고려)
		Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

		long endTime = System.currentTimeMillis();
		System.out.println("Time taken: " + (endTime - startTime) + "ms");
	}
}
