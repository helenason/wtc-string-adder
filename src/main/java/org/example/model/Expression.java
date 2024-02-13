package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {

    private static final String FORMAT_OF_CUSTOM_EXPRESSION = "//(.)\n(.*)";
    private static final String FORMAT_OF_NUMBER = "[0-9]+";
    private static final String DEFAULT_DELIMITER = ",|:";

    private final String expression;

    public Expression(String input) {
        this.expression = input;
    }

    public List<Integer> separateExpression() {
        final Matcher matcher = Pattern.compile(FORMAT_OF_CUSTOM_EXPRESSION).matcher(expression);
        if (matcher.find()) { // TODO fix bug
            // 커스텀 구분자의 경우
            String delimiter = matcher.group(1); // 첫번째 () 부분
            String expression = matcher.group(2); // 두번째 () 부분
            String[] tokens = separateByDelimiter(expression, delimiter);
            return makeOperands(tokens);
        }
        // 기존 구분자의 경우
        String[] tokens = separateByDelimiter(expression, DEFAULT_DELIMITER);
        return makeOperands(tokens);
    }

    private String[] separateByDelimiter(String input, String delimiter) {
        return input.split(delimiter);
    }

    private List<Integer> makeOperands(String[] tokens) {

        List<Integer> operands = new ArrayList<>();

        for (String token : tokens) {
            validate(token);
            operands.add(stringToInt(token));
        }

        return operands;
    }

    private int stringToInt(String number) {
        return Integer.parseInt(number);
    }

    private void validate(String input) {
        // 숫자 이외의 값 또는 음수를 전달하는 경우 예외 처리
        Matcher matcher = Pattern.compile(FORMAT_OF_NUMBER).matcher(input);
        if (!matcher.matches()) {
            throw new RuntimeException();
        }
    }
}
