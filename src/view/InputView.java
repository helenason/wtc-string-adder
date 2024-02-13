package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {

    private static final String FORMAT_OF_CUSTOM_EXPRESSION = "//(.)\n(.*)";
    private static final String DEFAULT_DELIMITER = ",|:";

    private final Scanner scanner = new Scanner(System.in);

    public List<Integer> requestOperands() {

        String input = scanner.nextLine();

        final Matcher m = Pattern.compile(FORMAT_OF_CUSTOM_EXPRESSION).matcher(input);
        if (m.find()) {
            // 커스텀 구분자의 경우
            String customDelimiter = m.group(1); // 첫번째 () 부분
            String[] tokens = m.group(2).split(customDelimiter); // 두번째 () 부분
            return makeOperands(tokens);
        }
        // 기존 구분자의 경우
        String[] tokens = input.split(DEFAULT_DELIMITER);
        return makeOperands(tokens);
    }

    private List<Integer> makeOperands(String[] tokens) {

        List<Integer> operands = new ArrayList<>();

        for (String token : tokens) {
            operands.add(stringToInt(token));
        }

        return operands;
    }

    private int stringToInt(String number) {
        return Integer.parseInt(number);
    }

    public void stopReading() {
        scanner.close();
    }
}
