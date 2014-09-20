package Test;

public class Tester {
	private int number;
	
	public Tester(Tester t) {
		this.number = t.number;
	}
	
	public Tester(int init) {
		this.number = init;
	}
	
	public Tester() {
		this.number = 0;
	}
	
	//Operation Number is 11
	public int inc() {
		this.number++;
		return this.number;
	}
	
	
	//Operation Number is 22
	public int dec() {
		this.number--;
		return this.number;
	}
	
	public int get() {
		return this.number;
	}
}
