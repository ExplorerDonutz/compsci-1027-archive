package assign1;

public class Matrix {
    private int numRows;
    private int numCols;
    private double[][] data;

    public Matrix(int r, int c) {
        numRows = r;
        numCols = c;
        data = new double[r][c];
    }

    public Matrix (int r, int c, double[] linArr) {
        numRows = r;
        numCols = c;
        data = new double[r][c];
        
    }
}
