package MontyHall;

import java.util.*;

public class Simulator {
    static Hall hall;
    static Scanner scanner = new Scanner(System.in);
    static Config config;
    static int wins;

    public static void run() {
        setup();
        if (config.automation()) {
            simulate();
            printResults();
        } else {
            control();
        }
    }

    public static void printResults() {
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + (config.runs() - wins));
        System.out.println("Winrate: " + (double) wins / config.runs() * 100 + "%");
    }

    public static void setup() {
        config = Config.fromConsole();
    }

    public static void control() {
        System.out.println("Door 1-" + hall.size() + ": Which door would you like to start with?");
        int initialDoor;
        while (true) {
            initialDoor = scanner.nextInt();
            if (initialDoor >= 1 && initialDoor <= hall.size()) break;
            else System.out.println("Invalid config, try again!");
        }
    }

    public static void simulate() {

    }
}
