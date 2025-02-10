package network.tcp.v5;

import static util.MyLogger.log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientV5 {

	private static final int PORT = 12345;

	public static void main(String[] args) throws IOException {
		log("클라이언트 시작");

		// finally 블록에서 변수에 접근해야 한다. 따라서 try 블록 안에서 선언할 수 없다.
		try (
			Socket socket = new Socket("localhost", PORT);
			DataInputStream input = new DataInputStream(socket.getInputStream());
			DataOutputStream output = new DataOutputStream(socket.getOutputStream())) {

			log("소켓 연결: " + socket);

			Scanner kb = new Scanner(System.in);

			while (true) {
				System.out.print("전송 문자: ");
				String toSend = kb.nextLine();

				// 서버에게 문자 보내기
				output.writeUTF(toSend);
				log("client -> server: " + toSend);

				if (toSend.equals("exit")) {
					break;
				}

				// 서버로부터 문자 받기
				String received = input.readUTF();
				log("client <- server: " + received);
			}
		} catch (IOException e) {
			log(e);
		}
	}
}
