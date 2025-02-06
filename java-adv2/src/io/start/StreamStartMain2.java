package io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamStartMain2 {

	public static void main(String[] args) throws IOException {
		// 파일이 없으면 만듬(폴더는 직접 만들어야함)
		FileOutputStream fos = new FileOutputStream("java-adv2/temp/hello.dat");
		fos.write(65);
		fos.write(66);
		fos.write(67);
		fos.close();

		FileInputStream fis = new FileInputStream("java-adv2/temp/hello.dat");
		int data;
		while ((data = fis.read()) != -1) {
			System.out.println(data);
		}
		fis.close();
	}
}
