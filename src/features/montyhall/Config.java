package features.montyhall;
import java.util.*;

public record Config(boolean automation, int strategy, int runs, int cars, int goats, int revealed) {
    public static Config create() {
        Scanner scanner = new Scanner(System.in);

        int cars;
        int goats;


        boolean automation;

        while (true) {
            System.out.println("Do you want to gather stats by automating the simulation? (y/n)");
            String input = scanner.next();
            if (input.equalsIgnoreCase("y")) { automation = true; break; }
            if (input.equalsIgnoreCase("n")) { automation = false; break; }
            System.out.println("Invalid config, try again!");
        }

        while (true) {
            System.out.println("How many cars and goats do you want? Type the numbers respectively.");
            cars = scanner.nextInt();
            goats = scanner.nextInt();
            if (cars > 0 && goats > 1) break;
            System.out.println("Invalid config, try again!");
        }

        int revealed;

        while (true) {
            if (goats == 2) {
                revealed = 1;
                break;
            }
            System.out.println("How many goats do you want revealed after the first pick?");
            revealed = scanner.nextInt();
            if (revealed > 0 && revealed < goats) break;
            System.out.println("Invalid config, try again!");
        }

        int strategy;

        while (true) {
            System.out.println("Stay or switch strategy? (0/1)");
            strategy = scanner.nextInt();
            if (strategy == 0 || strategy == 1) break;
            System.out.println("Invalid config, try again!");
        }

        if (!automation) return new Config(false, strategy, 0, cars, goats, revealed);

        int runs;

        while (true) {
            System.out.println("How many runs?");
            runs = scanner.nextInt();
            if (runs > 0) break;
            System.out.println("Invalid config, try again!");
        }

        return new Config(automation, strategy, runs, cars, goats, revealed);
    }
}