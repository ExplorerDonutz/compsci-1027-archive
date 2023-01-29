package assign1;
public class Matrix {
    private int numRows;
    private int numCols;
    private double[][] data;

    public Matrix(int r, int c) {
        numRows = r;
        numCols = c;

        // Initialize a new 2D double array with r rows and c columns
        data = new double[r][c];
    }

    public Matrix(int r, int c, double[] linArr) {
        numRows = r;
        numCols = c;
        data = new double[r][c];

        // Fill 2D data array with 1D array
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // Combine the current column value j with the row multiplied with the column size in order to convert from 2D to 1D
                data[i][j] = linArr[j + i * c];
            }
        }

    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public double[][] getData() {
        return data;
    }

    public double getElement(int r, int c) {
        return data[r][c];
    }

    public void setElement(int r, int c, double value) {
        data[r][c] = value;
    }

    public void transpose() {
        // Use variable to temporarily store the old number of columns
        int oldCols = numCols;
        numCols = numRows;
        numRows = oldCols;
        double[][] temp = new double[numRows][numCols];

        // Copy the old array onto the new array
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                // The rows of the new array are the columns of the old, and the columns are the rows
                temp[i][j] = data[j][i];
            }
        }
        data = temp;
    }

    public Matrix multiply(double scalar) {
        double[] temp = new double[numRows * numCols];

        // Multiply the matrix by the scalar
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                temp[j + i * numCols] = data[i][j] * scalar;
            }
        }
        return new Matrix(numRows, numCols, temp);
    }

    public Matrix multiply(Matrix matrix) {
        if (numCols != matrix.getNumRows())
            return null;

        // Create temp array to store the multiplication
        double[][] temp = new double[numRows][matrix.getNumCols()];

        // Multiply the matrices
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < matrix.getNumCols(); j++) {
                for (int k = 0; k < matrix.getNumRows(); k++) {
                    temp[i][j] += data[i][k] * matrix.data[k][j];
                }
            }
        }

        // Convert 2D temp array to 1D
        double[] converted = new double[numRows * matrix.numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < matrix.numCols; j++) {
                converted[j + i * matrix.numCols] = temp[i][j];
            }
        }

        return new Matrix(numRows, numCols, converted);
    }

    public String toString() {
        if (data.length == 0) {
            // Nothing in the array
            return "Empty matrix";
        } else {
            String str = "";

            // Loop through matrix
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numCols; j++) {
                    // Add data formatted to have a width of 8 and 3 decimals
                    str += String.format("%, 8.3f", data[i][j]);
                }
                // Add a space after each row
                str += "\n";
            }
            return str;
        }
    }
}
