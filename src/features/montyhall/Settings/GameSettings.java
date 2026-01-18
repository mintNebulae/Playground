package features.montyhall.Settings;

import input.FromStdin;

public record GameSettings(int cars, int goats, int revealed) {

    public static GameSettings create() {
        int cars = -1, goats = -1, revealed = -1;
        while (cars < 1) cars = FromStdin.getInt("Enter number of cars:", "Provide {c: c > 0}.");
        while (goats < 2) goats = FromStdin.getInt("Enter number of goats:", "Provide {g: g > 1}.");
        while (revealed < 1 || revealed > goats - 1) revealed = FromStdin.getInt("Enter number of goats to reveal after the first pick:", "Provide {n: 1 <= n <= goats - 1.");
        return new GameSettings(cars, goats, revealed);
    }
}
