import java.util.Scanner;

public class p06_BonusScore {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        int num = 100;
        int num1 = 1000;
        double bonusScore = 0;

        if (number <= num) {
            bonusScore = bonusScore + 5;
        } else if (number > num & number < num1) {
            bonusScore = number * 0.2;
        } else if (number > num1) {
            bonusScore = number * 0.1;
        }

        if (number % 2 == 0) {
            bonusScore = bonusScore + 1;
        } else if (number % 10 == 5) {
            bonusScore = bonusScore + 2;
        }

        System.out.println(bonusScore);
        System.out.println(number + bonusScore);
    }
}
