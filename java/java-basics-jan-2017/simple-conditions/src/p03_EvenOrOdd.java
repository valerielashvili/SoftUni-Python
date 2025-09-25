import java.util.Scanner;

public class p03_EvenOrOdd {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int result = number % 2;
        boolean isEven = result == 0;

        if (isEven) {
            System.out.println("even");
        } else {
            System.out.println("odd");
        }
    }
}
