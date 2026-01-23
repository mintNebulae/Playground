package features.montyhall.Settings;

import input.FromStdin;

public record HallSettings(int cars, int goats, int revealed) {

    public static HallSettings create() {
        int cars = FromStdin.getInt("Enter number of cars:", i -> i > 0, "Type a number {c: c > 0}.");
        int goats = FromStdin.getInt("Enter number of goats:", i -> i > 1, "Type a number {g: g > 1}.");
        final int finalGoats = goats;
        int revealed = FromStdin.getInt("Enter number of goats to reveal after the first pick:", i -> i >= 1 && i <= finalGoats - 1, "Type a number {n: 1 <= n <= goats - 1.");
        return new HallSettings(cars, goats, revealed);
    }
}
