package lesson19;

// 19 - 1
class CountUpThread extends Thread {
	private static Object lockObj = new Object();

	public void run() {
		// 「0 ~ 50の整数を順に表示する」[
		synchronized(lockObj) {
			for (int i = 0; i < 51; i++) {
				System.out.println(i);
			}
		}
	}
}

public class Main {
	public static void main(String[] args) {
		runThread();
		runThread();
		runThread();

	}

	public static synchronized void runThread() {
		Thread t = new CountUpThread();
		t.start();
	}
}
