package assign1;

public class test {
    public static void main(String[] args) {
        Matrix m = new Matrix(2, 2, new double[]{3,0,2,1});
        double[][] d = m.getData();

        for (int i = 0; i < m.getNumRows(); i++) {
            System.out.print("[ ");
            for (int j = 0; j < m.getNumCols(); j++) {
                System.out.print(d[i][j] + " , ");
            }
            System.out.print(" ]\n");
        }

        m.transpose();
        d = m.getData();

        for (int i = 0; i < m.getNumRows(); i++) {
            System.out.print("[ ");
            for (int j = 0; j < m.getNumCols(); j++) {
                System.out.print(d[i][j] + " , ");
            }
            System.out.print(" ]\n");
        }

        m.transpose();
        m = m.multiply(2);
        d = m.getData();

        for (int i = 0; i < m.getNumRows(); i++) {
            System.out.print("[ ");
            for (int j = 0; j < m.getNumCols(); j++) {
                System.out.print(d[i][j] + " , ");
            }
            System.out.print(" ]\n");
        }

        m = m.multiply(new Matrix(2, 2, new double[]{7, 2, 4, 3}));
        d = m.getData();

        for (int i = 0; i < m.getNumRows(); i++) {
            System.out.print("[ ");
            for (int j = 0; j < m.getNumCols(); j++) {
                System.out.print(d[i][j] + " , ");
            }
            System.out.print(" ]\n");
        }

        System.out.println(m.toString());
    }
}
