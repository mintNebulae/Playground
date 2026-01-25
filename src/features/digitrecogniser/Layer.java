package features.digitrecogniser;

public class Layer {
    private Matrix weights;
    private Matrix bias;
    private Matrix lastInput;
    private Matrix lastActivation;

    public Layer(int inputs, int neurons) {
        weights = new Matrix(neurons, inputs);
        bias = new Matrix(neurons, 1);
        weights.randomise(-1.0, 1.0);
        bias.randomise(-1.0, 1.0);
    }

    public Matrix activate(Matrix input) {
        lastInput = input;
        Matrix activated = input.dot(weights).add(bias).sigmoid();
        lastActivation = activated;
        return activated;
    }

    public Matrix backpropagate(Matrix error, double learningRate) {
        Matrix delta = error.hadamard(lastActivation.sigmoidGradients());
        Matrix nextError = weights.transposed().dot(delta);
        weights = weights.add(delta.dot(lastInput.transposed()).scale(learningRate));
        bias = bias.add(delta.scale(learningRate));
        return nextError;
    }
}