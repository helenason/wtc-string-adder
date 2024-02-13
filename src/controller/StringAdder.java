package controller;

import view.InputView;
import view.OutputView;

import java.util.List;

public class StringAdder {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public void run() {

        List<Integer> operands = inputView.requestOperands();

        int result = addNumbers(operands);

        outputView.writeResult(result);

    }

    private int addNumbers(List<Integer> numbers) {

        int result = 0;

        for (int number : numbers) {
            result += number;
        }

        return result;
    }

}
