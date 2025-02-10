package network.tcp.v6;

import static network.tcp.SocketCloseUtil.closeAll;
import static util.MyLogger.log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SessionV6 implements Runnable {

	private final Socket socket;
	private final DataInputStream input;
	private final DataOutputStream output;
	private final SessionManagerV6 sessionManager;
	private boolean closed = false;

	public SessionV6(Socket socket, SessionManagerV6 sessionManager) throws IOException {
		this.socket = socket;
		this.input = new DataInputStream(socket.getInputStream());
		this.output = new DataOutputStream(socket.getOutputStream());
		this.sessionManager = sessionManager;
		this.sessionManager.add(this);
	}

	@Override
	public void run() {
		// finally 블록에서 변수에 접근해야 한다. 따라서 try 블록 안에서 선언할 수 없다.
		try {
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
		} finally {
			sessionManager.remove(this);
			close();
		}
	}

	// 세션 종료시, 서버 종료시 동시에 호출될 수 있다.
	public synchronized void close() {
		if (closed) {
			return;
		}
		closeAll(socket, input, output);
		closed = true;
		log("연결 종료: " + socket);
	}
}
