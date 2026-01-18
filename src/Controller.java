import features.montyhall.Simulators.Simulator;
import features.wordfrequency.Frequency;
import input.Input;

public class Controller {

    public void start() {
        outerLoop:
        while (true) {
            System.out.println("""
                Type the corresponding input for the tool.
                1: Frequency of words in a block of text.
                2. Monty Hall simulation.
                """);
            int input = Input.SCANNER.nextInt();
            switch (input) {
                case 1:
                    Frequency.run();
                    break outerLoop;
                case 2:
                    Simulator.run();
                    break outerLoop;
                default:
                    System.out.println("Invalid input, try again.");
            }
        }
    }
}
