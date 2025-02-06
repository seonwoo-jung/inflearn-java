package io.streams;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamEtcMain {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("java-adv2/temp/data.dat");
		DataOutputStream dos = new DataOutputStream(fos);
		dos.writeUTF("회원A");
		dos.writeInt(20);
		dos.writeDouble(10.5);
		dos.writeBoolean(true);

		FileInputStream fis = new FileInputStream("java-adv2/temp/data.dat");
		DataInputStream dis = new DataInputStream(fis);
		System.out.println(dis.readUTF());
		System.out.println(dis.readInt());
		System.out.println(dis.readDouble());
		System.out.println(dis.readBoolean());
		dos.close();
	}
}
