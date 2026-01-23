package features.montyhall.Simulators;

import java.util.*;

import features.montyhall.Settings.AutomationSettings;
import features.montyhall.Settings.HallSettings;
import input.*;

public abstract class Simulator {
    Scanner scanner = Input.SCANNER;
    HallSettings hallSettings;

    public Simulator(HallSettings hallSettings) {
        this.hallSettings = hallSettings;
    }

    public abstract void run();

    public static Simulator create() {
        if (FromStdin.getBool("Do you want to gather stats by automating the simulation? (y/n)", "Invalid input, try again.")) {
            return new AutomatedSimulator(HallSettings.create(), AutomationSettings.create());
        }
        return new ManualSimulator(HallSettings.create());
    }
}
