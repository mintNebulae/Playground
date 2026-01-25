package features.digitrecogniser;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class MnistLoader {

    public List<DataPoint> loadData(Path imagePath, Path labelPath) throws Exception {
        List<DataPoint> dataset = new ArrayList<>();

        try (DataInputStream imgIn = new DataInputStream(new BufferedInputStream(Files.newInputStream(imagePath)));
             DataInputStream lblIn = new DataInputStream(new BufferedInputStream(Files.newInputStream(labelPath)))) {

            imgIn.readInt();
            int numImages = imgIn.readInt();
            imgIn.readInt();
            imgIn.readInt();

            lblIn.readInt();
            lblIn.readInt();

            for (int i = 0; i < numImages; i++) {
                Matrix input = new Matrix(784, 1);
                for (int p = 0; p < 784; p++) {
                    input.data[p][0] = imgIn.readUnsignedByte() / 255.0;
                }

                int label = lblIn.readUnsignedByte();
                Matrix expected = new Matrix(10, 1);
                expected.data[label][0] = 1.0;

                dataset.add(new DataPoint(input, expected, label));
            }
        }
        return dataset;
    }
}