package io.buffered;

import static io.buffered.BufferedConst.BUFFER_SIZE;
import static io.buffered.BufferedConst.FILE_NAME;
import static io.buffered.BufferedConst.FILE_SIZE;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateFileV3 {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream(FILE_NAME);
		// 버퍼가 가득차면 어디에 보낼것인지 생성자 인수로 전달해야함
		BufferedOutputStream bos = new BufferedOutputStream(fos, BUFFER_SIZE);
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < FILE_SIZE; i++) {
			bos.write(1);
		}
		bos.close();

		long endTime = System.currentTimeMillis();
		System.out.println("File created: " + FILE_NAME);
		System.out.println("File size: " + FILE_SIZE / 1024 / 1024 + "MB");
		System.out.println("Time taken: " + (endTime - startTime) + "ms");
	}
}
