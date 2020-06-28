package domain;

public class Number {

    private String number;

    public Number(String number) {
        this.number = number;
    }

    private int toInteger(Number number) {
        return Integer.parseInt(number.number);
    }
}
