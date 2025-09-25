import java.math.BigDecimal;
import java.util.Scanner;

public class p03_Euro_Trip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double quantity = scanner.nextDouble();

        double priceForKg = 1.20;
        BigDecimal totalPrice = new BigDecimal(quantity * priceForKg);
        BigDecimal priceInDMarks = new BigDecimal("4210500000000").multiply(totalPrice);

        System.out.printf("%.2f marks", priceInDMarks);
    }
}
