import java.util.Scanner;

public class p01_Value_of_a_String {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        String command = scanner.nextLine();

        int sum = 0;

        if ("LOWERCASE".equals(command)) {
            for (int i = 0; i < inputLine.length(); i++) {
                if (inputLine.charAt(i) >= 97 && inputLine.charAt(i) <= 122) {
                    sum += (int) inputLine.charAt(i);
                }
            }
        } else if ("UPPERCASE".equals(command)) {
            for (int i = 0; i < inputLine.length(); i++) {
                if (inputLine.charAt(i) >= 65 && inputLine.charAt(i) <= 90) {
                    sum += (int) inputLine.charAt(i);
                }
            }
        }
        System.out.printf("The total sum is: %d", sum);
    }
}
