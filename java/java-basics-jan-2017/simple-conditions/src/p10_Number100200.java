import java.util.Scanner;

public class p10_Number100200 {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        if (num < 100) {                              //Проверяваме дали числото е под 100, между 100 и 200 или над 200
            System.out.println("Less than 100");
        } else if (num >= 100 & num <= 200) {
            System.out.println("Between 100 and 200");
        } else if (num > 200) {
            System.out.println("Greater than 200");
        }
    }
}
