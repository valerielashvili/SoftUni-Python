import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.Scanner;

public class p01_SoftUni_Coffee_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputCount = Integer.parseInt(scanner.nextLine());

        BigDecimal totalPrice = BigDecimal.ZERO;

        while (inputCount-- > 0) {
            BigDecimal price = new BigDecimal(scanner.nextLine());
            String dateInput = scanner.nextLine();
            long count = Long.parseLong(scanner.nextLine());

            int[] dateToken = Arrays.stream(dateInput.split("/")).mapToInt(Integer::parseInt).toArray();
            YearMonth date = YearMonth.of(dateToken[2], dateToken[1]);

            BigDecimal result = new BigDecimal((date.lengthOfMonth() * count)).multiply(price);

            totalPrice = totalPrice.add(result);

            System.out.printf("The price for the coffee is: $%.2f%n", result);
        }
        System.out.printf("Total: $%.2f", totalPrice);
    }
}
