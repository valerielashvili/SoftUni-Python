//Второ решение на задачата "Сумиране на секунди"
import java.util.Scanner;

public class p07v2_SumSeconds {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

        int competitor1 = Integer.parseInt(scanner.nextLine());
        int competitor2 = Integer.parseInt(scanner.nextLine());
        int competitor3 = Integer.parseInt(scanner.nextLine());

        int sumSecs = competitor1 + competitor2 + competitor3;
        int minutes = sumSecs / 60;
        int seconds = sumSecs % 60;

        if (seconds < 10) {
            System.out.printf("%d:0%d", minutes, seconds);
        } else {
            System.out.printf("%d:%d", minutes, seconds);
        }
    }
}
