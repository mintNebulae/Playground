package features.montyhall.Simulators;

import features.montyhall.Settings.AutomationSettings;
import features.montyhall.Settings.GameSettings;

public class AutomatedSimulator extends Simulator {
    AutomationSettings automationSettings;

    @Override
    public void run() {

    }

    public AutomatedSimulator(GameSettings gameSettings, AutomationSettings automationSettings) {
        super(gameSettings);
        this.automationSettings = automationSettings;
    }

    public void printResults() {
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + (automationSettings.runs() - wins));
        System.out.println("Winrate: " + (double) wins / automationSettings.runs() * 100 + "%");
    }
}
