package features.montyhall.Settings;

import input.FromStdin;

public record AutomationSettings (int runs, int strategy) {
    public static AutomationSettings create() {
        int runs, strategy = -1;
        runs = FromStdin.getInt("Enter number of runs:", "Invalid input, try again.");
        while (strategy != 0 && strategy != 1) {
            strategy = FromStdin.getInt("Enter strategy (0 => stay, 1 => switch):", "Invalid input, try again.");
        }
        return new AutomationSettings(runs, strategy);
    }
}
