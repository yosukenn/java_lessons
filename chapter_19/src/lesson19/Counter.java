package lesson19;

public class Counter {
	private long count = 0;
	public synchronized void add(long i) {
		System.out.println("足し算します");
		this.count += i;
	}
	public synchronized void mul(long i) {
		System.out.println("掛け算します");
		this.count *= i;
	}
}
