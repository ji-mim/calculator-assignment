package calculator.v3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator {

    private List<Number> resultList = new ArrayList<>();
    private OperatorType[] operators = OperatorType.values();


    public List<Number> getResultList() {
        return resultList;
    }

    public void setResultList(List<Number> resultList) {
        this.resultList = resultList;
    }


    public <S extends Number> S calculate(S num1, S num2, String operator) {
        S result = null;
        boolean flag = false;
        for (OperatorType operatorType : operators) {
            if (operatorType.getOperator().equals(operator)) {
                if (num1 instanceof Integer && num2 instanceof Integer) {
                    result = (S) getIntResult((Integer)num1, (Integer) num2, operator);
                } else if (num1 instanceof Double && num2 instanceof Double) {
                    result = (S) getDoubleResult((Double) num1, (Double) num2, operator);

                }
                flag = true;
            }
        }

        if (!flag) {
            throw new RuntimeException("+,-,*,/ 중 하나를 입력해주세요.");
        }

        resultList.add(result);

        return result;
    }

    private static Integer getIntResult(Integer num1, Integer num2, String operator) {

        int result = 0 ;

        if (operator.equals("+")) {
            result = num1 + num2;
        } else if (operator.equals("-")) {
            result = num1 - num2;
        } else if (operator.equals("*")) {
            result = num1 * num2;
        } else if (operator.equals("/")) {
            if (num2 == 0) {
                throw new RuntimeException("나눗셈 연산 분모(두번째 정수)에 0이 입력될 수 없습니다.");
            } else {
                result = num1 / num2;
            }
        }
        return result;
    }
    private static Double getDoubleResult(Double num1, Double num2, String operator) {

        double result = 0;

        if (operator.equals("+")) {
            result = num1 + num2;
        } else if (operator.equals("-")) {
            result = num1 - num2;
        } else if (operator.equals("*")) {
            result = num1 * num2;
        } else if (operator.equals("/")) {
            if (num2 == 0) {
                throw new RuntimeException("나눗셈 연산 분모(두번째 정수)에 0이 입력될 수 없습니다.");
            } else {
                result = num1 / num2;
            }
        }
        return result;
    }

    public void removeFirst() {
        resultList.remove(0);
    }

    public List<Number> getBigNums(double num) {
        return resultList.stream().filter(n -> n.doubleValue() > num).collect(Collectors.toList());
    }

}
