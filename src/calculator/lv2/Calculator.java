package calculator.lv2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private List<Integer> resultList = new ArrayList<>();

    public List<Integer> getResultList() {
        return resultList;
    }

    public void setResultList(List<Integer> resultList) {
        this.resultList = resultList;
    }

    public int calculate(int num1, int num2, String operator) {
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
        } else {
            throw new RuntimeException("+,-,*,/ 중 하나를 입력해주세요.");
        }

        resultList.add(result);

        return result;
    }

    public void removeFirst() {
        resultList.remove(0);
    }
}
