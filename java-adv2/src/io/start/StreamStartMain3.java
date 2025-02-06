package io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class StreamStartMain3 {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("java-adv2/temp/hello.dat");
		byte[] input = {65, 66, 67, 68};
		fos.write(input);
		fos.close();

		FileInputStream fis = new FileInputStream("java-adv2/temp/hello.dat");
		byte[] readBytes = fis.readAllBytes();
		System.out.println(Arrays.toString(readBytes));
		fis.close();
	}
}
