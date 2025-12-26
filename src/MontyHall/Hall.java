package MontyHall;

import java.util.*;

public class Hall {
    private final List<Boolean> doors = new ArrayList<>();

    public Hall(Config config) {
        for (int i = 0; i < config.cars(); i++) doors.add(true);
        for (int i = 0; i < config.goats(); i++) doors.add(false);
        Collections.shuffle(doors);
    }

    public boolean hasCar(int door) {
        return doors.get(door);
    }

    public int getRandomGoatGivenGoat(int givenGoat) {
        Random random = new Random();
        int index;
        do {
            index = random.nextInt(doors.size());
        } while (this.hasCar(index) && index != givenGoat);
        return index;
    }

    public int size() {
        return doors.size();
    }

    public void shuffle() {
        Collections.shuffle(doors);
    }
}
