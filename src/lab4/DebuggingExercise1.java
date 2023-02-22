package lab4;

public class DebuggingExercise1 {

    public static void main(String[] args) {
        int[][] testArray = new int[5][6];

        for (int i = 0; i < 5; i++)
            // Initialize j = 0 instead of 1, and loop while < 6 instead of <= 6
            for (int j = 0; j < 6; j++)
                testArray[i][j] = (i + 1) * j;

        printArray(testArray);
    }

    private static void printArray(int[][] array) {
        for (int i = 0; i < array.length; ++i)
            for (int j = 0; j < array[0].length; ++j) {
                System.out.print(array[i][j]);
                if (j < array[0].length - 1)
                    System.out.print(", ");
                else
                    System.out.print("\n");
            }
    }
}
