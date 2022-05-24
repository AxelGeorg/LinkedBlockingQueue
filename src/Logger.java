import java.io.FileNotFoundException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Logger {
	private static Logger instance = null;

	LinkedBlockingQueue<Evento> buffer;
	FileWriteThread fileWriteThread;
	ExecutorService executorService;

	String nomeArqLog = "Log.txt";
	int numero = 0;

	public static synchronized Logger getInstance() throws FileNotFoundException {
		if (instance == null) {
			instance = new Logger();
		}

		return instance;
	}

	private Logger() throws FileNotFoundException {
		buffer = new LinkedBlockingQueue<Evento>();
		fileWriteThread = new FileWriteThread(nomeArqLog, buffer);
		executorService = Executors.newFixedThreadPool(1);
		executorService.execute(fileWriteThread);
	}

	public void putMessage(String mensagem) {
		try {
			buffer.put(new Evento(mensagem, numero));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		numero++;
	}
}
