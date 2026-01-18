package input;

public class FromStdin {

    private FromStdin() {}

    public static int getInt(String prompt, String errorMessage) {
        while (true) {
            System.out.println(prompt);
            try {
                return Integer.parseInt(Input.SCANNER.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(errorMessage);
            }
        }
    }

    public static boolean getBool(String prompt, String errorMessage) {
        while (true) {
            System.out.println(prompt);
            System.out.println("Type y/n.");
            String input = Input.SCANNER.nextLine();
            if (input.equalsIgnoreCase("y")) return true;
            if (input.equalsIgnoreCase("n")) return false;
            System.out.println(errorMessage);
        }
    }
}
