package assign1;

public class test {
    public static void main(String[] args) {
        Matrix m = new Matrix(2, 2, new double[]{3,0,2,1});
        double[][] d = m.getData();

        System.out.println(m.toString());

        m.transpose();
        d = m.getData();

        System.out.println(m.toString());

        m.transpose();
        m = m.multiply(2);
        d = m.getData();

        System.out.println(m.toString());

        m = m.multiply(new Matrix(2, 2, new double[]{7, 2, 4, 3}));
        d = m.getData();

        System.out.println(m.toString());
    }
}
