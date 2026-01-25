package entry;
import analytics.FileCounter;

public class Main {
    void main() {
        FileCounter.run();
        Controller controller = new Controller();
        controller.start();
    }
}
