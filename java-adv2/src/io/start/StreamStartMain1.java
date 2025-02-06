package io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamStartMain1 {

	public static void main(String[] args) throws IOException {
		// 파일이 없으면 만듬(폴더는 직접 만들어야함)
		FileOutputStream fos = new FileOutputStream("java-adv2/temp/hello.dat", true); // append인수 default는 false
		fos.write(65);
		fos.write(66);
		fos.write(67);
		fos.close();

		FileInputStream fis = new FileInputStream("java-adv2/temp/hello.dat");
		System.out.println(fis.read());
		System.out.println(fis.read());
		System.out.println(fis.read());
		System.out.println(fis.read()); // -1 출력 (파일에 더 읽을것이 없다는 것을 의미)
		fis.close();
	}
}
