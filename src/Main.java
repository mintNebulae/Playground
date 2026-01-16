import features.wordfrequency.Frequency;
import features.montyhall.Simulator;
import analytics.FileCounter;
import input.*;

void main() {
    FileCounter.run();
    Controller controller = new Controller();
    controller.start();
}
