import features.wordfrequency.Frequency;
import features.montyhall.Simulator;
import analytics.FileCounter;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        FileCounter.run();
        run();
    }

    public static void run() {
        outerLoop:
        while (true) {
            System.out.println("""
                Type the corresponding input for the tool.
                1: Frequency of words in a block of text.
                2. Monty Hall simulation.
                """);
            int input = scanner.nextInt();
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