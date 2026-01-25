package features.digitrecogniser;

public class DataPoint {
    public final Matrix input;
    public final Matrix expected;
    public final int label;

    public DataPoint(Matrix input, Matrix expected, int label) {
        this.input = input;
        this.expected = expected;
        this.label = label;
    }
}