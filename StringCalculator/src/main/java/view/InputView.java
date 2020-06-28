package view;

import domain.Numbers;
import domain.Operations;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);
    private static final String ARGUMENTS = "\\+";
    private static final String BLANK = " ";
    private static final String NONE = "";
    private static int ZERO = 0;

    public Numbers getInputNumbers() {
        String inputLine = validatesInput(scanner.nextLine());
        return getNumbers(inputLine);
    }

    public Operations getInputOperations() {
        String inputLine = validatesInput(scanner.nextLine());
        return getOperations(inputLine);
    }

    private static Operations getOperations(String inputLine) {
        String[] values = inputLine.split(BLANK);
        Operations res = new Operations();
        for(String value : values) {
            res.addOperation(value);
        }
        return res;
    }

    private static Numbers getNumbers(String inputLine) {
        inputLine = inputLine.replaceAll(BLANK, NONE);
        String[] values = inputLine.split(ARGUMENTS);
        for (String value : values) {
            validatesInputNumber(value);
        }
        return new Numbers(values);
    }

    private static String validatesInput(String inputLine) {
        if (inputLine.endsWith(ARGUMENTS) && inputLine.startsWith(ARGUMENTS)) {
            throw new IllegalArgumentException("올바르지 않은 수식입니다.");
        }
        return inputLine;
    }

    private static void validatesInputNumber(String value) {
        int number = Integer.parseInt(value);
        if (number < ZERO) {
            throw new IllegalArgumentException("0 이상의 정수를 입력하세요");
        }
    }
}
