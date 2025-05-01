package calculator.v1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorLv1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;

        while (true) {
            System.out.println("==============================================");
            System.out.println("계산을 시작합니다. 양의 정수 2개와 연산자를 입력해주세요.");

            System.out.print("첫 번째 숫자를 입력하세요: ");

            int firstNum;
            try {
                firstNum = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("양의 정수를 입력해주세요.");
                sc.nextLine();
                continue;
            }
            sc.nextLine();



            System.out.print("두 번째 숫자를 입력하세요: ");

            int secondNum;
            try {
                secondNum = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("양의 정수를 입력해주세요.");
                sc.nextLine();
                continue;
            }
            sc.nextLine();

            System.out.print("사칙 연산 기호를 입력하세요(더하기 +, 빼기 -, 곱하기 *, 나누기 /): ");
            String operator = sc.nextLine();

            if (operator.equals("+")) {
                result = firstNum + secondNum;
            } else if (operator.equals("-")) {
                result = firstNum - secondNum;
            } else if (operator.equals("*")) {
                result =firstNum * secondNum;
            } else if (operator.equals("/")) {
                if (secondNum == 0) {
                    System.out.println("나눗셈 연산 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    continue;
                } else {
                    result = firstNum / secondNum;
                }
            } else {
                System.out.println("+,-,*,/ 중 하나를 입력해주세요.");
            }

            System.out.printf("계산 결과 %d %s %d = %d\n", firstNum, operator, secondNum , result);

            System.out.println("계산을 계속하려면 엔터를, 그만두려면 exit을 입력해주세요.");
            if (sc.nextLine().equals("exit")) {
                System.out.println("계산을 종료합니다.");
                break;
            }
        }
    }

}
