package features.montyhall.Simulators;

import java.util.*;

import features.montyhall.Settings.AutomationSettings;
import features.montyhall.Settings.GameSettings;
import features.montyhall.*;
import input.*;

public abstract class Simulator {
    Scanner scanner = Input.SCANNER;
    GameSettings gameSettings;
    int wins = 0;

    public Simulator(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
    }

    public abstract void run();

    public Simulator create() {
        if (FromStdin.getBool("Do you want to gather stats by automating the simulation? (y/n)", "Invalid input, try again.")) {
            return new AutomatedSimulator(GameSettings.create(), AutomationSettings.create());
        }
        return new ManualSimulator(GameSettings.create());
    }

    public void control() {
        Hall hall = new Hall(config);
        System.out.println("Door 1-" + hall.size() + ": Which door would you like to start with?");
        int firstDoor;
        while (true) {
            firstDoor = scanner.nextInt();
            if (firstDoor >= 1 && firstDoor <= hall.size()) break;
            else System.out.println("Invalid config, try again!");
        }
        hall.pickInitialDoor(firstDoor - 1);
        hall.revealGoats(config.revealed());
        List<Integer> revealedGoats = hall.getRevealedDoors();
        List<Integer> revealedGoatsIncremented = revealedGoats.stream()
                        .map(i -> i + 1)
                        .toList();
        System.out.println("Revealed doors: " + revealedGoatsIncremented);
        List<Integer> availableDoors = new ArrayList<>();

        for (int i = 0; i < hall.size(); i++) {
            if (!revealedGoats.contains(i)) availableDoors.add(i);
        }
        List<Integer> availableDoorsIncremented = availableDoors.stream()
                .map(i -> i + 1)
                .toList();
        System.out.println("Available doors: " + availableDoorsIncremented);
        if (config.strategy() == 0) {
            System.out.println(hall.getStatus(firstDoor - 1) == Status.CAR ? "Your door had a car! :)" : "Your door had a goat! :(");
        } else {
            while (true) {
                System.out.println("Which door would you like to switch to?");
                int secondDoor = scanner.nextInt();
                if (secondDoor == firstDoor) System.out.println("This is the same door as your first choice!");
                else if (revealedGoats.contains(secondDoor - 1)) {
                    System.out.println("This door has already been revealed!");
                }
                else {
                    System.out.println(hall.getStatus(secondDoor - 1) == Status.CAR ? "Your door had a car! :)" : "Your door had a goat! :(");
                    break;
                }
            }
        }
    }

    public void automate() {
        for (int i = 0; i < config.runs(); i++) {
            Hall hall = new Hall(config);

            if (config.strategy() == 0) {
                if (hall.getStatus(0) == Status.CAR) wins++;
                continue;
            }
            hall.pickInitialDoor(0);
            hall.revealGoats(config.revealed());
            for (int j = 1; j < hall.size(); j++) {
                if (hall.getStatus(j) != Status.REVEALED) {
                    if (hall.getStatus(j) == Status.CAR) wins++;
                    break;
                }
            }
        }
    }
}
