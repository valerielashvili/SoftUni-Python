import java.util.Scanner;

public class p03_Exchange_Variable_Values {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        int tmpVar = a;
        a = b;
        b = tmpVar;
        System.out.printf("%d\n%d", a, b);
    }
}
