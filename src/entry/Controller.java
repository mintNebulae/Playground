package entry;

import features.montyhall.Simulators.Simulator;
import features.wordfrequency.Frequency;
import input.Input;

import java.util.Scanner;

public class Controller {
    Scanner scanner = Input.SCANNER;
    public void start() {
        outerLoop:
        while (true) {
            System.out.println("""
                Type the corresponding input for the tool.
                1: Frequency of words in a block of text.
                2. Monty Hall simulation.
                """);
            int input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1:
                    Frequency.run();
                    break outerLoop;
                case 2:
                    Simulator simulator = Simulator.create();
                    simulator.run();
                    break outerLoop;
                default:
                    System.out.println("Invalid input, try again.");
            }
        }
    }
}
