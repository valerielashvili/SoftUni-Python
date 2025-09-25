import java.util.Scanner;

public class p12_Butterfly {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String stars = "*";
        String line = "-";
        String spaces = " ";

        for (int row = 1; row <= n - 2; row++) {
            if (row % 2 != 0){
                for (int i = 1; i <= n - 2; i++) {
                    System.out.print(stars);
                }
                System.out.print("\\ /");
                for (int j = 1; j <= n - 2; j++) {
                    System.out.print(stars);
                }
                System.out.println();
            } else {
                for (int i = 1; i <= n - 2; i++) {
                    System.out.print(line);
                }
                System.out.print("\\ /");
                for (int j = 1; j <= n - 2; j++) {
                    System.out.print(line);
                }
                System.out.println();
            }
        }

        for (int i = 1; i <= n - 1; i++) {       // Printing center part of the butterfly
            System.out.print(spaces);
        }
        System.out.print("@");
        for (int j = 0; j < n - 1; j++) {
            System.out.print(spaces);
        }
        System.out.println();

        for (int rowB = 1; rowB <= n - 2; rowB++) {
            if (rowB % 2 != 0){
                for (int i = 1; i <= n - 2; i++) {
                    System.out.print(stars);
                }
                System.out.print("/ \\");
                for (int j = 1; j <= n - 2; j++) {
                    System.out.print(stars);
                }
                System.out.println();
            } else {
                for (int i = 1; i <= n - 2; i++) {
                    System.out.print(line);
                }
                System.out.print("/ \\");
                for (int j = 1; j <= n - 2; j++) {
                    System.out.print(line);
                }
                System.out.println();
            }
        }
    }
}
