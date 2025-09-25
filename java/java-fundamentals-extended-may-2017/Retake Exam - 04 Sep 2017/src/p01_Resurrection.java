import java.math.BigDecimal;
import java.util.Scanner;

public class p01_Resurrection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String bodyLengthStr = scanner.nextLine();
            String bodyWidthStr = scanner.nextLine();
            String wingLengthStr = scanner.nextLine();

            BigDecimal bodyLength = new BigDecimal(bodyLengthStr);
            BigDecimal bodyWidth = new BigDecimal(bodyWidthStr);
            BigDecimal wingLength = new BigDecimal(wingLengthStr);

            bodyLength = bodyLength.pow(2);
            wingLength = wingLength.multiply(new BigDecimal("2"));
            BigDecimal bodyAndWingSum = new BigDecimal("0");
            bodyAndWingSum = bodyWidth.add(wingLength);

            BigDecimal yearsToReincarnate = new BigDecimal("0");
            yearsToReincarnate = bodyLength.multiply(bodyAndWingSum);

            if (!bodyWidthStr.contains(".")) {
                System.out.printf("%s%n", yearsToReincarnate);
            } else {
                int countDecimal = countDecimalPlaces(bodyWidthStr);
                System.out.printf("%." + countDecimal + "f%n", yearsToReincarnate);
            }
        }
    }

    private static int countDecimalPlaces(String bodyWidthStr) {
        int index = bodyWidthStr.indexOf(".");
        bodyWidthStr = bodyWidthStr.substring(index + 1, bodyWidthStr.length());
        return bodyWidthStr.length();
    }
}
