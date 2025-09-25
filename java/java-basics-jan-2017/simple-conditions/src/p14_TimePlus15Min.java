import java.util.Scanner;

public class p14_TimePlus15Min {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int hour = Integer.parseInt(scanner.nextLine());
        int min = Integer.parseInt(scanner.nextLine());
        min = min + 15;                                 //Въвеждаме час и минути от 24-часово денонощие
                                                        // и изчисляваме колко ще е часът след 15 минути
        if (min > 59) {
            hour++;
            min = min - 60;
        } if (hour > 23) {
            hour = hour - 24;
        } if (min < 10) {
            System.out.println(hour + ":0" + min);
        } else {
            System.out.println(hour + ":" + min);
        }
    }
}
