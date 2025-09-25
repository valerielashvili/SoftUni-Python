import java.text.DecimalFormat;
import java.util.Scanner;

public class p04_Float_or_Integer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) { //Checking if the number is integer
            int numInt = Integer.parseInt(scanner.nextLine());
            System.out.println(numInt);
        } else {                    //If the number is double, rounding it
            double numDouble = Double.parseDouble(scanner.nextLine());
            String pattern = "###,###";
            DecimalFormat decimalFormat = new DecimalFormat(pattern);

            String format = decimalFormat.format(numDouble);
            System.out.printf(format);
        }
    }
}
