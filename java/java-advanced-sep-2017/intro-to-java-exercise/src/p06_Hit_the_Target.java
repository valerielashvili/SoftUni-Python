import java.util.Scanner;

public class p06_Hit_the_Target {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] intArr = new int[20];

        for (int i = 1; i <= 20; i++) {
            intArr[i - 1] = i;
        }

        for (int i = 0; i < intArr.length; i++) {
            for (int j = 0; j < intArr.length; j++) {
                if (intArr[i] + intArr[j] == n) {
                    System.out.printf("%d + %d = %d\n", intArr[i], intArr[j], n);
                }
            }
        }
        for (int i = 0; i < intArr.length; i++) {
            for (int j = 0; j < intArr.length; j++) {
                if (intArr[i] - intArr[j] == n) {
                    System.out.printf("%d - %d = %d\n", intArr[i], intArr[j], n);
                }
            }
        }
    }
}
