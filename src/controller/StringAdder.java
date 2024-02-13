package controller;

import view.InputView;
import view.OutputView;

public class StringAdder {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public void run() {

        String input = inputView.readSentence();

        String[] tokens = separateSentence(input);

    }

    private String[] separateSentence(String input) {
        return input.split(",|:");
    }
}
