package calculator.v3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator calculator = new ArithmeticCalculator();


        while (true) {
            System.out.println("==============================================");
            System.out.println("계산을 시작합니다.");
            System.out.println("계산을 진행할 타입을 입력해주세요(정수, 실수)");
            String type = sc.nextLine();

            if (type.equals("정수")) {
                Integer firstNum ;
                Integer secondNum ;

                try {
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    firstNum = sc.nextInt();

                    System.out.print("두 번째 숫자를 입력하세요: ");
                    secondNum = sc.nextInt();
                    sc.nextLine();

                } catch (InputMismatchException e) {
                    System.out.println("양의 정수를 입력해주세요.");
                    sc.nextLine();
                    continue;
                }

                System.out.print("사칙 연산 기호를 입력하세요(+, -, *, /): ");
                String operator = sc.nextLine();

                Integer result;
                try {
                    result = calculator.calculate(firstNum, secondNum, operator);
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                    continue;
                }

                System.out.printf("계산 결과 %d %s %d = %d\n", firstNum, operator, secondNum, result);
                System.out.println("계산 기록: " + calculator.getResultList());

                System.out.println("가장 오래된 계산 기록을 지우고 싶으시면 remove를 입력해주세요.(아니라면 엔터)");
                if (sc.nextLine().equals("remove")) {
                    calculator.removeFirst();
                    System.out.println("삭제 완료. 현재 기록: " + calculator.getResultList());
                }

                System.out.println("숫자를 입력하면, 해당 숫자보다 큰 계산 결과들이 출력됩니다.");
                int num = sc.nextInt();
                sc.nextLine();

                System.out.println(num + "보다 큰 계산 결과: " + calculator.getBigNums(num));

            } else if (type.equals("실수")) {
                Double firstNum ;
                Double secondNum ;

                try {
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    firstNum = sc.nextDouble();

                    System.out.print("두 번째 숫자를 입력하세요: ");
                    secondNum = sc.nextDouble();
                    sc.nextLine();

                } catch (InputMismatchException e) {
                    System.out.println("양의 실수를 입력해주세요.");
                    sc.nextLine();
                    continue;
                }

                System.out.print("사칙 연산 기호를 입력하세요(+, -, *, /): ");
                String operator = sc.nextLine();

                Double result;
                try {
                    result = calculator.calculate(firstNum, secondNum, operator);
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                    continue;
                }

                System.out.printf("계산 결과 %.2f %s %.2f = %.2f\n", firstNum, operator, secondNum, result);
                System.out.println("계산 기록: " + calculator.getResultList());

                System.out.println("가장 오래된 계산 기록을 지우고 싶으시면 remove를 입력해주세요.(아니라면 엔터)");
                if (sc.nextLine().equals("remove")) {
                    calculator.removeFirst();
                    System.out.println("삭제 완료. 현재 기록: " + calculator.getResultList());
                }

                System.out.println("숫자를 입력하면, 해당 숫자보다 큰 계산 결과들이 출력됩니다.");
                double num = sc.nextDouble();
                sc.nextLine();
                System.out.println(num + "보다 큰 계산 결과: " + calculator.getBigNums(num));

            } else {
                System.out.println("정수 또는 실수를 정확히 입력해주세요.");
                continue;
            }

            System.out.println("계산을 계속하려면 엔터를, 종료하려면 exit 입력");
            if (sc.nextLine().equals("exit")) {
                System.out.println("계산을 종료합니다.");
                break;
            }
        }
    }
}