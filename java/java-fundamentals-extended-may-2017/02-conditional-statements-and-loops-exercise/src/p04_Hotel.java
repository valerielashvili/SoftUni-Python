import java.util.Scanner;

public class p04_Hotel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String month = scanner.nextLine().toLowerCase();
        int nights = Integer.parseInt(scanner.nextLine());

        double studioPrice = 0;
        double doublePrice = 0;
        double suitePrice = 0;
        double discount = 0;

        if ("may".equals(month) || "october".equals(month)) {
            studioPrice = 50 * nights;
            doublePrice = 65 * nights;
            suitePrice = 75 * nights;

            if (nights > 7) {
                discount = studioPrice * 0.05;
                studioPrice -= discount;
            }
            if ("october".equals(month) && nights > 7) {
                studioPrice = 50 * (nights - 1);
                discount = studioPrice * 0.05;
                studioPrice -= discount;
            }
        }
        else if ("june".equals(month) || "september".equals(month)) {
            studioPrice = 60 * nights;
            doublePrice = 72 * nights;
            suitePrice = 82 * nights;

            if (nights > 14) {
                discount = doublePrice * 0.1;
                doublePrice -= discount;
            }
            if ("september".equals(month) && nights > 7) {
                studioPrice = 60 * (nights - 1);
            }
        }
        else if ("july".equals(month) || "august".equals(month) || "december".equals(month)) {
            studioPrice = 68 * nights;
            doublePrice = 77 * nights;
            suitePrice = 89 * nights;

            if (nights > 14) {
                discount = suitePrice * 0.15;
                suitePrice -= discount;
            }
        }
        System.out.printf("Studio: %.2f lv.\nDouble: %.2f lv.\nSuite: %.2f lv.", studioPrice, doublePrice, suitePrice);
    }
}
