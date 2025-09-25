import java.util.Scanner;

public class p08_Travalling_At_LightSpeed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double lightYears = Double.parseDouble(scanner.nextLine());
        double kmsLightYear = 9.45E12D;
        double lightSpeed = 300000.0D;
        double secondsTotal = lightYears * kmsLightYear / lightSpeed;
        int minutes = (int)(secondsTotal / 60.0D);
        secondsTotal %= 60.0D;
        int hours = minutes / 60;
        minutes %= 60;
        int days = hours / 24;
        hours %= 24;
        int weeks = days / 7;
        days %= 7;
        System.out.printf("%d weeks\n%d days\n%d hours\n%d minutes\n%d seconds", weeks, days, hours, minutes, (int)secondsTotal);
    }
}
