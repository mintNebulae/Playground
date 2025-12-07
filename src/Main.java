import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        prompter();
    }
    public static void prompter() {
        System.out.println("Type the corresponding input for the tool.");
        System.out.println("""
                1: Frequency of words in a block of text.
                """);
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1: Frequency.run();
        }
            scanner.close();
    }
}