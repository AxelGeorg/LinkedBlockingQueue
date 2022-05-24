import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

public class FileWriteThread implements Runnable {

	PrintStream ps;
	LinkedBlockingQueue<Evento> buffer;

	public FileWriteThread(String nomeArq, LinkedBlockingQueue<Evento> buffer) {
		this.buffer = buffer;

		try {
			ps = new PrintStream(nomeArq);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			Evento evento = buffer.poll();
			if (evento != null) {
				String mensagem = evento.getMensagemCompleta();
				ps.print(mensagem);
				System.out.print("Gravando em arquivo mensagem: " + mensagem);
			} else {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
