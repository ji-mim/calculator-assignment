package calculator.v3;

public enum OperatorType {
    PLUS("+"), MINUS("-"), DIVIDE("/"), MULTIPLY("*");

    private final String operator;

    OperatorType(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

}
