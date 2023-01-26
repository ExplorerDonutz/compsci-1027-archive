package lab2;

public class DataTypes {
	public int intVar;
	public double doubleVar;
	public char charVar;
	public boolean boolVar;
	public ClassA varA;

	public DataTypes() {
	}

	public DataTypes(int newIntVar, double newDoubleVar, char newCharVar, boolean newBoolVar, ClassA newVarA) {
		intVar = newIntVar;
		doubleVar = newDoubleVar;
		charVar = newCharVar;
		boolVar = newBoolVar;
		varA = newVarA;
	}

	public boolean equals(DataTypes otherObject) {
		return this.charVar == otherObject.charVar && this.intVar == otherObject.intVar
				&& this.boolVar == otherObject.boolVar && this.doubleVar == otherObject.doubleVar
				&& this.varA.equals(otherObject.varA);
	}
}
