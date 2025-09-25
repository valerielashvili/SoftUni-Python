import java.util.Scanner;

public class p06_Rhombus_of_Stars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int r = 1; r <= n; r++) {
            String line = "";
            for (int i = 1; i <= n - r; i++) {
                line += " ";
            }
            System.out.print(line);
            System.out.print("*");
            for (int c = 1; c <= r - 1; c++) {
                System.out.print(" *");
            }
            System.out.println();
        }
        for (int r = n - 1; r >= 1; r--) {
            String line = "";
            for (int i = n - r; i >= 1; i--) {
                line += " ";
            }
            System.out.print(line);
            System.out.print("*");
            for (int c = 1; c <= r - 1; c++) {
                System.out.print(" *");
            }
            System.out.println();
        }
    }
}
