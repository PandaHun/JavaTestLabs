package view;

import domain.Numbers;
import domain.Operation;
import domain.Operations;

public class CalculatorMachine {

    private InputView inputView = new InputView();

    public void run() {
        Numbers numbers = inputView.getInputNumbers();
        Operations operations = inputView.getInputOperations();
        calculate(numbers, operations);
    }

    private void calculate(Numbers numbers, Operations operations) {
        int operationCount = operations.getOperationCount();
        while (operationCount-- > 0) {
            doOperation(numbers, operations.getOperation());
        }
    }

    private void doOperation(Numbers numbers, Operation operation) {

    }
}
