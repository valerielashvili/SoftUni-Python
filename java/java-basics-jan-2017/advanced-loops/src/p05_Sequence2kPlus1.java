import java.util.Scanner;

public class p05_Sequence2kPlus1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int num = 1;

        while (num <= n) { // Може да се реши и с for цикъл
            System.out.println(num);
            num = num * 2 + 1;
            }
    }
}
