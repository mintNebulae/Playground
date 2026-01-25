package features.digitrecogniser;

public class NeuralNetwork {
    private final Layer hidden;
    private final Layer output;

    public NeuralNetwork(int inputNodes, int hiddenNodes, int outputNodes) {
        this.hidden = new Layer(inputNodes, hiddenNodes);
        this.output = new Layer(hiddenNodes, outputNodes);
    }

    public Matrix guess(Matrix input) {
        return output.activate(hidden.activate(input));
    }

    public void train(DataPoint point, double lr) {
        Matrix hOut = hidden.activate(point.input);
        Matrix guess = output.activate(hOut);

        Matrix error = point.expected.subtract(guess);

        Matrix hiddenError = output.backpropagate(error, lr);
        hidden.backpropagate(hiddenError, lr);
    }
}