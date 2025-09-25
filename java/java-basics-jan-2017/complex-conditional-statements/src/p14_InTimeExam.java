import java.text.DecimalFormat;
import java.util.Scanner;

public class p14_InTimeExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hExam = Integer.parseInt(scanner.nextLine());
        int mExam = Integer.parseInt(scanner.nextLine());
        int h = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());

        int timeSumExam = hExam * 60 + mExam;
        int timeSumStudent = h * 60 + m;

        int calcHoursResult = 0;
        double calcMinResult = 0;

        int result = 0;

        if (timeSumExam == timeSumStudent) {
            System.out.printf("On time");
        }
        else if ((timeSumExam - timeSumStudent) > 0 && (timeSumExam - timeSumStudent) <= 30) {
            result = timeSumExam - timeSumStudent;
            System.out.printf("On time %d minutes before the start", result);
        }
        else if ((timeSumExam - timeSumStudent) > 30 && (timeSumExam - timeSumStudent) <= 59) {
            result = timeSumExam - timeSumStudent;
            System.out.printf("Early %d minutes before the start", result);
        }
        else if ((timeSumExam - timeSumStudent) > 30){
            result = timeSumExam - timeSumStudent;
            calcHoursResult = result / 60;
            calcMinResult = result % 60;
            if (calcMinResult < 10) {
                System.out.printf("Early %d:0%d hours before the start", calcHoursResult, (int)calcMinResult);
            } else {
                System.out.printf("Early %d:%s hours before the start", calcHoursResult, decimalFormat(calcMinResult));
            }
        }
        else if ((timeSumStudent - timeSumExam) <= 59) {
            result = timeSumStudent - timeSumExam;
            System.out.printf("Late %d minutes after the start", result);
        }
        else {
            result = timeSumStudent - timeSumExam;
            calcHoursResult = result / 60;
            calcMinResult = result % 60;
            if (calcMinResult < 10) {
                System.out.printf("Late %d:0%d hours after the start", calcHoursResult, (int)calcMinResult);
            } else {
                System.out.printf("Late %d:%s hours after the start", calcHoursResult, decimalFormat(calcMinResult));
            }
        }
    }
    public static String decimalFormat (double number) {
        DecimalFormat format = new DecimalFormat("##");
        return format.format(number);
    }
}
