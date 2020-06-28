package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {

    private static final int INDEX = 0;

    private List<Number> numbers = new ArrayList<>();

    public Numbers(String[] values) {
        numbers.addAll(Arrays.stream(values)
                .map(Number::new)
                .collect(Collectors.toList()));
    }

    public Number getNumber() {
        Number result = numbers.get(INDEX);
        numbers.remove(INDEX);
        return result;
    }
}
