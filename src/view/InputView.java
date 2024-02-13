package view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public String requestExpression() {
        return scanner.nextLine();
    }

    public void stopReading() {
        scanner.close();
    }
}
