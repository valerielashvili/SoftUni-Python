import java.util.Scanner;

public class p04_EvenPowersOf2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int num = 1;

        System.out.println(num);

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                num = num * 4;
                System.out.println(num);
            }
        }
    }
}
