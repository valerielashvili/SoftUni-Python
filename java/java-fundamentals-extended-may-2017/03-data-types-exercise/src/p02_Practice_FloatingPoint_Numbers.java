import java.math.BigDecimal;

public class p02_Practice_FloatingPoint_Numbers {
    public static void main (String[] args){
        BigDecimal num1Big = new BigDecimal("3.141592653589793238");
        double num2 = 1.60217657;
        BigDecimal num3Big = new BigDecimal("7.8184261974584555216535342341");
        System.out.printf("%.18f\n%.8f\n%.28f\n", num1Big, num2, num3Big);
    }
}
