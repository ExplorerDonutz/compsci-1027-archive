package lab9;

public class Abo {
    public static int rabo(int n) {
        if (n <= 0)
            return 0;
        else if (n == 1)
            return 1;
        else if (n % 2 == 0) {
            return 1 + rabo(n / 2);
        }

        return 2 + rabo((n + 1) / 2);
    }

    public static int iabo(int n) {
        if (n <= 0)
            return 0;
        else if (n == 1)
            return 1;
        else if (n % 2 == 0) {
            int product = 0;
            for (int i = 0; i < n; i++) {
                n = n / 2;

                // TODO finish
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.print(rabo(i) + " ");
        }
    }
}
