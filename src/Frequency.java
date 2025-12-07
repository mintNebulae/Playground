import java.util.*;

public class Frequency {
    private static final Map<String, Integer> map = new TreeMap<>();
    public static void run() {
        prompter();
        print();
    }

    public static void addToMap(String word) {
        if (word.isEmpty()) return;
        map.put(word, map.getOrDefault(word, 0) + 1);
    }

    public static String format(String word) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (Character.isLetter(currentChar) || currentChar == '\'' || currentChar == '-') {
                string.append(currentChar);
            }
        }
        return string.toString().toLowerCase();
    }

    public static void print() {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void prompter() {
        System.out.println("Enter document ending with [].");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.next();
            if (input.equals("[]")) break;
            addToMap(format(input));
        }
        scanner.close();
    }
}
