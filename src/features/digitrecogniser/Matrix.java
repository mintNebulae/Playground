package features.digitrecogniser;

import java.util.Random;

public class Matrix {
    int rows;
    int columns;
    public double[][] data;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        data = new double[rows][columns];
    }

    public Matrix(double[][] inputData) {
        rows = inputData.length;
        columns = inputData[0].length;
        data = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(inputData[i], 0, data[i], 0, columns);
        }
    }

    public Matrix sigmoid() {
        double[][] result = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = 1.0 / (1 + Math.exp(-data[i][j]));
            }
        }
        return new Matrix(result);
    }

    public Matrix sigmoidGradients() {
        double[][] result = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = data[i][j] * (1.0 - data[i][j]);
            }
        }
        return new Matrix(result);
    }

    public void randomise(double lowerBound, double upperBound) {
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = random.nextDouble(lowerBound, upperBound);
            }
        }
    }

    public Matrix transposed() {
        double[][] transposed = new double[columns][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposed[j][i] = data[i][j];
            }
        }
        return new Matrix(transposed);
    }

    public Matrix dot(Matrix multiplier) {
        if (columns != multiplier.rows) throw new IllegalArgumentException("Matrices are not multiplicatively conformable!");
        else {
            double[][] result = new double[rows][multiplier.columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < multiplier.columns; j++) {
                    for (int k = 0; k < columns; k++) {
                        result[i][j] += data[i][k] * multiplier.data[k][j];
                    }
                }
            }
            return new Matrix(result);
        }
    }

    public Matrix scale(double scalar) {
        double[][] result = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = data[i][j] * scalar;
            }
        }
        return new Matrix(result);
    }

    public Matrix hadamard(Matrix multiplier) {
        double[][] result = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = data[i][j] * multiplier.data[i][j];
            }
        }
        return new Matrix(result);
    }

    public Matrix add(Matrix addend) {
        double[][] result = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = data[i][j] + addend.data[i][j];
            }
        }
        return new Matrix(result);
    }

    public Matrix subtract(Matrix subtrahend) {
        double[][] result = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = data[i][j] - subtrahend.data[i][j];
            }
        }
        return new Matrix(result);
    }
}
