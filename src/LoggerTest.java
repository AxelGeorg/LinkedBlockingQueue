import java.io.FileNotFoundException;

public class LoggerTest {
	public LoggerTest() {
	}

	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		Logger logger = Logger.getInstance();
		int messages = 50;

		for (int i = 0; i < messages; ++i) {
			String msg = "Message number " + i;
			logger.putMessage(msg);
			Thread.sleep((long) (1000.0D * Math.random()));
		}

		System.out.println("Done");
	}
}
