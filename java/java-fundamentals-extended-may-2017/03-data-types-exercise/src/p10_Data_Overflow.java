import java.math.BigDecimal;
import java.util.Scanner;

public class p10_Data_Overflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal num1 = scanner.nextBigDecimal();
        BigDecimal num2 = scanner.nextBigDecimal();
        BigDecimal maxNum = BigDecimal.ZERO;
        BigDecimal minNum = BigDecimal.ZERO;
        if (num1.compareTo(num2) > 0) {
            maxNum = num1;
            minNum = num2;
        } else {
            maxNum = num2;
            minNum = num1;
        }

        BigDecimal bytE = new BigDecimal("255");
        BigDecimal ushort = new BigDecimal("65535");
        BigDecimal uint = new BigDecimal("4294967295");
        BigDecimal ulong = new BigDecimal("18446744073709551615");
        BigDecimal overflowValue = BigDecimal.ZERO;
        String smallerType = "";
        if (minNum.compareTo(bytE) <= 0) {
            overflowValue = bytE;
            smallerType = "byte";
        } else if (minNum.compareTo(ushort) <= 0) {
            overflowValue = ushort;
            smallerType = "ushort";
        } else if (minNum.compareTo(uint) <= 0) {
            overflowValue = uint;
            smallerType = "uint";
        } else if (minNum.compareTo(ulong) <= 0) {
            overflowValue = ulong;
            smallerType = "ulong";
        }

        String largerType = "";
        if (maxNum.compareTo(bytE) <= 0) {
            largerType = "byte";
        } else if (maxNum.compareTo(ushort) <= 0) {
            largerType = "ushort";
        } else if (maxNum.compareTo(uint) <= 0) {
            largerType = "uint";
        } else if (maxNum.compareTo(ulong) <= 0) {
            largerType = "ulong";
        }

        BigDecimal overflowCount = maxNum.divide(overflowValue, 4);
        System.out.printf("bigger type: %s\nsmaller type: %s\n%.0f can overflow %s %.0f times\n", largerType, smallerType, maxNum, smallerType, overflowCount);
    }
}
