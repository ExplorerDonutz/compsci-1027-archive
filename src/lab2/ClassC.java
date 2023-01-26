package lab2;

public class ClassC {

	private static int  counter = 0;

	public ClassC() {
		counter += 1;
	}

	public void incCounter() {
		++counter;
	}

	public int getCounter() {
		return counter;
	}

}
