package network.exception.connet;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectMain {

	public static void main(String[] args) throws IOException {
		unknownHostEx1();
		unknownHostEx2();
		connectionRefused();
	}

	private static void unknownHostEx1() throws IOException {
		try {
			Socket socket = new Socket("999.999.999.999", 80);
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
	}
	private static void unknownHostEx2() throws IOException {
		try {
			Socket socket = new Socket("google.gogo", 80);
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
	}

	// Server가 TCP RST 패킷을 보냄 -> 서버가 클라이언트의 연결을 거절한 것
	private static void connectionRefused() throws IOException {
		try {
			Socket socket = new Socket("localhost", 45678);
		} catch (ConnectException e) {
			e.printStackTrace();
		}
	}
}
