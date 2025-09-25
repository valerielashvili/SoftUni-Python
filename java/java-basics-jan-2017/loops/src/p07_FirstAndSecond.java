import java.util.Scanner;

public class p07_FirstAndSecond {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            leftSum += num;
        }
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            rightSum += num;
        }
        int diff = Math.abs(leftSum - rightSum);
        if (diff == 0) {
            System.out.printf("Yes, sum = %d%n", leftSum);
        } else {
            System.out.printf("No, diff = %d%n", diff);
        }
    }
}
