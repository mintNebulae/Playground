package features.montyhall;

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

   public void removeGoats(int choice, int n) {
        int index = doors.size() - 1;
        int removed = 0;
        while (removed != n) {
            if (index == choice) {
                index--;
                continue;
            }
            if (!this.hasCar(index)) {
                doors.remove(index);
                removed++;
            }
            index--;
        }
   }

    public int size() {
        return doors.size();
    }
}
