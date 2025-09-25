import java.util.Scanner;

public class p07_SumSeconds {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

        int competitor1 = Integer.parseInt(scanner.nextLine());
        int competitor2 = Integer.parseInt(scanner.nextLine());
        int competitor3 = Integer.parseInt(scanner.nextLine());

        int sumSecs = competitor1 + competitor2 + competitor3;
        int min = 0;
        int min1 = sumSecs - 60;
        int min2 = sumSecs - 120;

        if (sumSecs >= 60 & sumSecs <= 119) {
            ++min;
            sumSecs = min1;
        } else if (sumSecs > 120 & sumSecs < 179) {
            min = 2;
            sumSecs = min2;
        }
        if (sumSecs < 10) {
            System.out.printf(min + ":0" + sumSecs);
        } else {
            System.out.printf(min + ":" + sumSecs);
        }
    }
}
