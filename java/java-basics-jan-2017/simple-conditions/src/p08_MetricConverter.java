//import java.text.DecimalFormat;
import java.util.Scanner;

public class p08_MetricConverter {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());
        String inputUnit = scanner.nextLine();
        String outputUnit = scanner.nextLine();

        double mm = 1000;                       //Metric converter
        double cm = 100;
        double mi = 0.000621371192;
        double in = 39.3700787;
        double km = 0.001;
        double ft = 3.2808399;
        double yd = 1.0936133;

        if (inputUnit.equals("mm")) {           // Исползваме if-else конструкцията за сравнение на входните данни
            number = number / mm;               // и изчисляване на мерните единици*/
        } else if (inputUnit.equals("cm")) {
            number = number / cm;
        } else if (inputUnit.equals("mi")) {
            number = number / mi;
        } else if (inputUnit.equals("in")) {
            number = number / in;
        } else if (inputUnit.equals("km")) {
            number = number / km;
        } else if (inputUnit.equals("ft")) {
            number = number / ft;
        } else if (inputUnit.equals("yd")) {
            number = number / yd;
        }

        if (outputUnit.equals("mm")) {
            number = number * mm;
        } else if (outputUnit.equals("cm")) {
            number = number * cm;
        } else if (outputUnit.equals("mi")) {
            number = number * mi;
        } else if (outputUnit.equals("in")) {
            number = number * in;
        } else if (outputUnit.equals("km")) {
            number = number * km;
        } else if (outputUnit.equals("ft")) {
            number = number * ft;
        } else if (outputUnit.equals("yd")) {
            number = number * yd;
        }

        //DecimalFormat format = new DecimalFormat("#.###############"); format.format(number)
        System.out.printf("%f %s", number, outputUnit);
    }
}
