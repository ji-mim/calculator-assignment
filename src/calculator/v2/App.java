package calculator.v2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CalculatorLv2 calculatorLv2 = new CalculatorLv2();
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

            try {
                result = calculatorLv2.calculate(firstNum, secondNum, operator);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                continue;
            }


            System.out.printf("계산 결과 %d %s %d = %d\n", firstNum, operator, secondNum , result);

            System.out.println("계산 기록: " + calculatorLv2.getResultList());

            System.out.println("가장 오래된 계산 기록를 지우고 싶으시면 remove를 입력해주세요.(아나라면 엔터 입력)");
            if (sc.nextLine().equals("remove")) {
                calculatorLv2.removeFirst();
                System.out.println("삭제가 완료 되었습니다.");
                System.out.println("계산 기록: " + calculatorLv2.getResultList());
            }


            System.out.println("계산을 계속하려면 엔터를, 그만두려면 exit을 입력해주세요.");
            if (sc.nextLine().equals("exit")) {
                System.out.println("계산을 종료합니다.");
                break;
            }
        }
    }

}
