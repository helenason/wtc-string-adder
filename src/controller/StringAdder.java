package controller;

import view.InputView;
import view.OutputView;

public class StringAdder {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public void run() {

        String input = inputView.readSentence();

        String[] tokens = separateSentence(input);

        int result = calculate(tokens);

        outputView.writeResult(result);

    }

    private String[] separateSentence(String input) {
        return input.split(",|:");
    }

    private int calculate(String[] tokens) {

        int result = 0;

        for (String token : tokens) {
            result += stringToInt(token);
        }

        return result;
    }

    private int stringToInt(String token) {
        return Integer.parseInt(token);
    }
}
