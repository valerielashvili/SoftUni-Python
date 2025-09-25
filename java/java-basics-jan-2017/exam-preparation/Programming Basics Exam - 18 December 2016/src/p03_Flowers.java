import java.util.Scanner;

public class p03_Flowers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int chryzanthemumsCount = Integer.parseInt(scanner.nextLine());
        int rosesCount = Integer.parseInt(scanner.nextLine());
        int tulipCount = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();

        boolean isHoliday = "Y".equals(scanner.nextLine());
        double chryzanthemumsPrice = 0d;
        double rosesPrice = 0d;
        double tulipPrice = 0d;

        if ("Spring".equals(season) || "Summer".equals(season)) {
            chryzanthemumsPrice = 2d;
            rosesPrice = 4.1d;
            tulipPrice = 2.5d;
        } else {
            chryzanthemumsPrice = 3.75d;
            rosesPrice = 4.5d;
            tulipPrice = 4.15d;
        }
        if (isHoliday) {
            chryzanthemumsPrice *= 1.15d;
            rosesPrice *= 1.15d;
            tulipPrice *= 1.15d;
        }
        chryzanthemumsPrice *= chryzanthemumsCount;
        rosesPrice *= rosesCount;
        tulipPrice *= tulipCount;
        double totalPrice = chryzanthemumsPrice + rosesPrice + tulipPrice;

        if (tulipCount > 7 && "Spring".equals(season)) {
            totalPrice -= totalPrice * 0.05d;
        }
        if (rosesCount >= 10 && "Winter".equals(season)) {
            totalPrice -= totalPrice * 0.1d;
        }
        if (tulipCount + rosesCount + chryzanthemumsCount > 20) {
            totalPrice -= totalPrice * 0.2d;
        }
        System.out.printf("%.2f", totalPrice + 2d);
    }
}
