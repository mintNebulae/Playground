package analytics;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.*;

public class FileCounter {
    static Path fileCounter = Path.of("files/counter");
    static int count;

    public static void incrementCount() throws IOException {
        if (Files.notExists(fileCounter)) {
            Files.createDirectories(fileCounter.getParent());
            Files.createFile(fileCounter);
            Files.write(fileCounter, new byte[]{0, 0, 0, 0});
        } else if (Files.readAllBytes(fileCounter).length != 4) {
            Files.write(fileCounter, new byte[]{0, 0, 0, 0});
        }
        byte[] bytes = Files.readAllBytes(fileCounter);
        count = ByteBuffer.wrap(bytes).getInt() + 1;
        Files.write(fileCounter, ByteBuffer.allocate(4).putInt(count).array());
    }

    public static void run() {
        try {
            incrementCount();
            if (count == 1) System.out.println("This is your first time running this program.");
            else System.out.printf("You've opened this program %d times!\n", count);
        } catch (IOException e) {
            throw new RuntimeException("IOException!", e);
        }
    }
}
