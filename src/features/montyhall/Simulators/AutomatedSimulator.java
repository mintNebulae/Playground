package features.montyhall.Simulators;

import features.montyhall.Hall;
import features.montyhall.Settings.AutomationSettings;
import features.montyhall.Settings.HallSettings;
import features.montyhall.Status;

public class AutomatedSimulator extends Simulator {
    AutomationSettings automationSettings;
    int wins = 0;

    @Override
    public void run() {
        automate();
        printResults();
    }

    public AutomatedSimulator(HallSettings hallSettings, AutomationSettings automationSettings) {
        super(hallSettings);
        this.automationSettings = automationSettings;
    }

    public void printResults() {
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + (automationSettings.runs() - wins));
        System.out.println("Winrate: " + (double) wins / automationSettings.runs() * 100 + "%");
    }


    public void automate() {
        for (int i = 0; i < automationSettings.runs(); i++) {
            Hall hall = new Hall(hallSettings);

            if (automationSettings.strategy() == 0) {
                if (hall.getStatus(0) == Status.CAR) wins++;
                continue;
            }
            hall.pickInitialDoor(0);
            hall.revealGoats(hallSettings.revealed());
            for (int j = 1; j < hall.size(); j++) {
                if (hall.getStatus(j) != Status.REVEALED) {
                    if (hall.getStatus(j) == Status.CAR) wins++;
                    break;
                }
            }
        }
    }
}


