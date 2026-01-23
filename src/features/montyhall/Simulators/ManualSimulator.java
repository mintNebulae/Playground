package features.montyhall.Simulators;

import features.montyhall.*;
import features.montyhall.Settings.HallSettings;
import input.FromStdin;

import java.util.ArrayList;
import java.util.List;

public class ManualSimulator extends Simulator {

    @Override
    public void run() {
        control();
    }

    public void control() {
        Hall hall = new Hall(hallSettings);
        System.out.println("Door 1-" + hall.size() + ": Which door would you like to start with?");
        int firstDoor;
        while (true) {
            firstDoor = scanner.nextInt();
            if (firstDoor >= 1 && firstDoor <= hall.size()) break;
            else System.out.println("Invalid config, try again!");
        }
        hall.pickInitialDoor(firstDoor - 1);
        hall.revealGoats(hallSettings.revealed());
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
        int stayOrSwitch = FromStdin.getInt("Do you want to stay on your original choice, or switch? (type 0 or 1 respectively)", i -> i == 0 || i == 1, "Invalid input!");
        if (stayOrSwitch == 0) {
            System.out.println(hall.getStatus(firstDoor - 1) == Status.CAR ? "Your door had a car! :)" : "Your door had a goat! :(");
        } else {
            while (true) {
                System.out.println("Which door would you like to switch to?");
                int secondDoor = scanner.nextInt();
                if (secondDoor == firstDoor) System.out.println("This is the same door as your first choice!");
                else if (revealedGoats.contains(secondDoor - 1)) {
                    System.out.println("This door has already been revealed!");
                } else {
                    System.out.println(hall.getStatus(secondDoor - 1) == Status.CAR ? "Your door had a car! :)" : "Your door had a goat! :(");
                    break;
                }
            }
        }
    }

    public ManualSimulator(HallSettings hallSettings) {
        super(hallSettings);
    }
}
