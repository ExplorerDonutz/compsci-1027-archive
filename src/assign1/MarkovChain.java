package assign1;

public class MarkovChain {
    private Vector stateVector;
    private Matrix transitionMatrix;

    public MarkovChain(Vector sVector, Matrix tMatrix) {
        stateVector = sVector;
        transitionMatrix = tMatrix;
    }

    public boolean isValid() {
        // Check all requirements of a markov chain
        boolean sqr = transitionMatrix.getNumRows() == transitionMatrix.getNumCols();
        boolean colsEqual = transitionMatrix.getNumCols() == stateVector.getNumCols();
        boolean isSumOne = false;
        double sum = 0;

        // Get the sum of each element in the state vector
        for (int i = 0; i < stateVector.getNumCols(); i++) {
            sum += stateVector.getElement(i);
        }

        // Check if sum is equal to one (+/- 0.1 for rounding)
        if (0.99 < sum && sum < 1.01) isSumOne = true;

        sum = 0;

        // Get the sum of each row in the transition matrix and check if it is equal to one
        for (int i = 0; i < transitionMatrix.getNumRows(); i++) {
            for (int j = 0; j < transitionMatrix.getNumCols(); j++) {
                sum += transitionMatrix.getElement(i, j);
            }
            if (0.99 > sum || sum > 1.01) {
                isSumOne = false;
                // At least one row's sum is not equal to one (+/- 0.1), so for loop can break
                break;
            }

            sum = 0;
        }

        // Return the result of all the booleans
        return sqr && colsEqual && isSumOne;
    }

    public Matrix computeProbabilityMatrix(int numSteps) {
        Matrix temp = transitionMatrix;
        if (!isValid())
            return null;

        // Multiply the matrix by itself for numSteps - 1 times
        for (int i = 0; i < numSteps - 1; i++) {
            temp = temp.multiply(transitionMatrix);
        }

        return stateVector.multiply(temp);
    }
}
