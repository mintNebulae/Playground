package features.montyhall;

import java.util.*;
import input.Input;

public class Simulator {
    static Scanner scanner = Input.SCANNER;
    static Config config;
    static int wins;

    public static void run() {
        setup();
        if (config.automation()) {
            simulate();
            printResults();
        } else {
//            control();
        }
    }

    public static void printResults() {
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + (config.runs() - wins));
        System.out.println("Winrate: " + (double) wins / config.runs() * 100 + "%");
    }

    public static void setup() {
        config = Config.create();
    }

//    public static void control() {
//        System.out.println("Door 1-" + hall.size() + ": Which door would you like to start with?");
//        int initialDoor;
//        while (true) {
//            initialDoor = scanner.nextInt();
//            if (initialDoor >= 1 && initialDoor <= hall.size()) break;
//            else System.out.println("Invalid config, try again!");
//        }
//    }

    public static void simulate() {
        for (int i = 0; i < config.runs(); i++) {
            Hall hall = new Hall(config);

            if (config.strategy() == 0) {
                if (hall.hasCar(0)) wins++;
                continue;
            }

            hall.removeGoats(0, config.revealed());
            if (hall.hasCar(1)) wins++;
        }
    }
}
