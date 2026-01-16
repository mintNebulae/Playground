package input;

import java.util.Scanner;
public class Input {
    public static Scanner SCANNER = new Scanner(System.in);

    private Input() {}

    public static void setScanner(Scanner scanner) {
        Input.SCANNER = scanner;
    }
}
