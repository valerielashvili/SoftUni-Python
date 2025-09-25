import java.util.Scanner;

public class p15_EqualNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        if (num == num2 & num2 == num3) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
