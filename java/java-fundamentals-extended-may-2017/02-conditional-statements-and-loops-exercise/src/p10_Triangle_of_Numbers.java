import java.util.Scanner;

public class p10_Triangle_of_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int num = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num);
                System.out.print(" ");
            }
            num++;
            System.out.println();
        }
    }
}
