package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Operations {

    private static final List<String> basisOperations = Arrays.asList("\\+", "-", "/" , "\\*");
    private static final int INDEX = 0;

    private List<Operation> operations = new ArrayList<>();

    public void addOperation(String input) {
        if ( basisOperations.contains(input)) {
            operations.add(new Operation(input));
        }
        throw new IllegalArgumentException("올바르지 않은 수식입니다");
    }

    public Operation getOperation() {
        Operation result = operations.get(INDEX);
        operations.remove(INDEX);
        return result;
    }

    public Integer getOperationCount() {
        return operations.size();
    }
}
