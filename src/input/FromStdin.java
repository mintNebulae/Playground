package input;

import java.util.Scanner;
import java.util.function.Predicate;

public class FromStdin {
    static Scanner scanner = new Scanner(System.in);
    private FromStdin() {}

    public static int getInt(String prompt, Predicate<Integer> predicate, String errorMessage) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine();
            try {
                if (!predicate.test(Integer.parseInt(input))) {
                    System.out.println(errorMessage);
                } else return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(errorMessage);
            }
        }
    }

    public static boolean getBool(String prompt, String errorMessage) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("y")) return true;
            if (input.equalsIgnoreCase("n")) return false;
            System.out.println(errorMessage);
        }
    }
}
