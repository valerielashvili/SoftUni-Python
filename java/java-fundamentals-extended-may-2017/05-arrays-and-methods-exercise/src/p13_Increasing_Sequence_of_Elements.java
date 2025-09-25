import java.util.Scanner;

public class p13_Increasing_Sequence_of_Elements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String integersStr = scanner.nextLine();

        String splittedIntegersStr[] = integersStr.split(" ");
        int integersArr[] = new int[splittedIntegersStr.length];

        boolean isIncreasing = true;
        int tmpValue = 0;

        for (int i = 0; i < integersArr.length; i++) {
            integersArr[i] = Integer.parseInt(splittedIntegersStr[i]);

            if (integersArr[i] < tmpValue) {
                isIncreasing = false;
                break;
            }
            tmpValue = integersArr[i];
        }
        if (isIncreasing) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
