package assign1;

public class Vector extends Matrix {
    public Vector(int c) {
        super(1, c);
    }

    public Vector(int c, double[] linArr) {
        super(1, c, linArr);
    }

    public double getElement(int c) {
        return getElement(0, c);
    }
}
