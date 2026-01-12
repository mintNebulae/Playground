package features.montyhall;

import java.util.*;

public class Hall {
    private final List<Status> doors = new ArrayList<>();
    private final List<Integer> goatsIndices = new ArrayList<>();

    public Hall(Config config) {
        for (int i = 0; i < config.cars(); i++) doors.add(Status.CAR);
        for (int i = 0; i < config.goats(); i++) doors.add(Status.GOAT);
        Collections.shuffle(doors);
        for (int i = 0; i < doors.size(); i++) if (doors.get(i) == Status.GOAT) goatsIndices.add(i);
    }

    public Status getStatus(int door) {
        return doors.get(door);
    }

    public void revealGoats(int n) {
        for (int i = 0; i < n; i++) {
            Random random = new Random();
            int randomIndex = random.nextInt(goatsIndices.size());
            doors.set(goatsIndices.get(randomIndex), Status.REVEALED);
            goatsIndices.remove(goatsIndices.get(randomIndex));
        }
    }

    public List<Integer> getRevealedDoors() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < doors.size(); i++) {
            if (doors.get(i) == Status.REVEALED) list.add(i);
        }
        return list;
    }

    public void pickInitialDoor(int door) {
        if (goatsIndices.contains(door)) goatsIndices.remove(door);
    }

    public int size() {
        return doors.size();
    }
}
