package io.file.copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyMainV1 {

	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		FileInputStream fis = new FileInputStream("java-adv2/temp/copy.dat");
		FileOutputStream fos = new FileOutputStream("java-adv2/temp/copy.dat");

		byte[] bytes = fis.readAllBytes();
		fos.write(bytes);

		fis.close();
		fos.close();
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken: " + (endTime - startTime) + "ms");
	}
}
