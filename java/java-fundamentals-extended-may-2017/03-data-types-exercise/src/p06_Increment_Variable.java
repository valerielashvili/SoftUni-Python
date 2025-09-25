import java.util.Scanner;

public class p06_Increment_Variable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int overflow = num / 256;
        int result = num % 256;
        System.out.println(result);
        if (overflow >= 1) {
            System.out.printf("Overflowed %d times", overflow);
        }

    }
}
