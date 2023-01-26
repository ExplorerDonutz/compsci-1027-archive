package lab2;

public class ClassB {

	private int counter = 0;

	public ClassB() {
		counter = 1;
	}

	public void incCounter() {
		++counter;
	}

	public int getCounter() {
		return counter;
	}



	public static void main(String[] args) {
		ClassB classB = new ClassB();
		int i = classB.counter;
		classB.incCounter();
		System.out.println("i = " + i + " counter = " + classB.counter);
	}

}
