package controller;

import model.Expression;
import view.InputView;
import view.OutputView;

import java.util.List;

public class StringAdder {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public void run() {

        String input = inputView.requestExpression();

        Expression expression = new Expression(input);
        List<Integer> operands = expression.separateExpression();

        int result = addNumbers(operands);

        outputView.writeResult(result);

        inputView.stopReading();

    }

    private int addNumbers(List<Integer> numbers) {

        int result = 0;

        for (int number : numbers) {
            result += number;
        }

        return result;
    }

}
