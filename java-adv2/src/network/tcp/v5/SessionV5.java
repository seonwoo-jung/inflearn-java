package network.tcp.v5;

import static util.MyLogger.log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SessionV5 implements Runnable {

	private final Socket socket;

	public SessionV5(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		// finally 블록에서 변수에 접근해야 한다. 따라서 try 블록 안에서 선언할 수 없다.

		try (
			socket;
			DataInputStream input = new DataInputStream(socket.getInputStream());
			DataOutputStream output = new DataOutputStream(socket.getOutputStream())) {

			while (true) {
				// 클라이언트로부터 문자 받기
				String received = input.readUTF(); // 블로킹
				log("client -> server: " + received);

				if (received.equals("exit")) {
					break;
				}

				// 클라이언트에게 문자 보내기
				String toSend = received + " World!";
				output.writeUTF(toSend);
				log("client <- server: " + toSend);
			}
		} catch (IOException e) {
			log(e);
		}

		log("연결 종료: " + socket + " isClosed: " + socket.isClosed());
	}
}
