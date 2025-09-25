import java.util.Scanner;

public class p06_NumberInRange1_100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter a number in the range [1...100]: ");
        int n = Integer.parseInt(scanner.nextLine());

        while (n < 1 || n > 100) {
            System.out.println("Invalid number!");
            System.out.printf("Enter a number in the range [1...100]: ");
            n = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("The number is: " + n);
    }
}
