package assign1;

public class MarkovChain {
    private Vector stateVector;
    private Matrix transitionMatrix;

    public MarkovChain(Vector sVector, Matrix tMatrix) {
        stateVector = sVector;
        transitionMatrix = tMatrix;
    }

    public boolean isValid() {
        int sum = 0;
        for (int i = 0; i < stateVector.getNumCols(); i++) {
            sum += stateVector.getElement(i);
        }

        // Return true if the instance variables are valid for a Markov chain
        return transitionMatrix.getNumCols() == transitionMatrix.getNumRows() && transitionMatrix.getNumCols() == stateVector.getNumCols() && 0.99 < sum && sum < 1.01;
    }

    public Matrix computeProbabilityMatrix(int numSteps) {
        Matrix temp = transitionMatrix;
        if (!isValid())
            return null;
        for (int i = 0; i < numSteps; i++) {
            temp = temp.multiply(temp);
        }

        return temp;
    }
}
