import java.util.Scanner;

public class p15_Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int secondNum = Integer.parseInt(scanner.nextLine());
        int result = 0;
        byte var7 = -1;
        switch(operator.hashCode()) {
            case 42:
                if (operator.equals("*")) {
                    var7 = 3;
                }
                break;
            case 43:
                if (operator.equals("+")) {
                    var7 = 1;
                }
            case 44:
            case 46:
            default:
                break;
            case 45:
                if (operator.equals("-")) {
                    var7 = 0;
                }
                break;
            case 47:
                if (operator.equals("/")) {
                    var7 = 2;
                }
        }

        switch(var7) {
            case 0:
                result = firstNum - secondNum;
                break;
            case 1:
                result = firstNum + secondNum;
                break;
            case 2:
                result = firstNum / secondNum;
                break;
            case 3:
                result = firstNum * secondNum;
        }

        System.out.printf("%d %s %d = %d", firstNum, operator, secondNum, result);
    }
}
