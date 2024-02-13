package controller;

import view.InputView;
import view.OutputView;

public class StringAdder {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public void run() {

        String input = inputView.readSentence();

        // default 구분자 지정하기
        String delimiter = ",|:";

        // input 에 // 와 \n 이 포함된 경우 커스텀 구분자 지정하기
        if (input.contains("//") && input.contains("\\n")) {
            delimiter = String.valueOf(input.charAt(2));
            input = input.substring(5);
        }

        String[] tokens = separateSentence(input, delimiter);

        int result = calculate(tokens);

        outputView.writeResult(result);

    }

    private String[] separateSentence(String input, String delimiter) {
        return input.split(delimiter);
    }

    private int calculate(String[] tokens) {

        int result = 0;

        for (String token : tokens) {
            // token: 분리된 숫자
            result += stringToInt(token);
        }

        return result;
    }

    private int stringToInt(String token) {
        return Integer.parseInt(token);
    }
}
