package lab2;

import java.util.Arrays;

public class ClassA {
	private final int SIZE_ARRAY = 5;
	public int numItems;
	public int[] arrItems;

	public ClassA(int n, int[] arr) {
		numItems = n;
		arrItems = arr;
	}

	public ClassA() {
		numItems = 0;
		arrItems = new int[SIZE_ARRAY];
	}

	public boolean equals(ClassA otherObject) {
		return this.numItems == otherObject.numItems && Arrays.equals(this.arrItems, otherObject.arrItems);
	}
}
