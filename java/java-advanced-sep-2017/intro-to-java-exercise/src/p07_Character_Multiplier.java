import java.util.Scanner;

public class p07_Character_Multiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();

        int sum = 0;
        int minLength = Math.min(str1.length(), str2.length());
        int maxLength = Math.max(str1.length(), str2.length());

        for (int i = 0; i < minLength; i++) {
            sum += str1.charAt(i) * str2.charAt(i);
        }
        if (maxLength == str1.length()) {
            for (int i = minLength; i < maxLength; i++) {
                sum += str1.charAt(i);
            }
        } else {
            for (int i = minLength; i < maxLength; i++) {
                sum += str2.charAt(i);
            }
        }

        System.out.println(sum);
    }
}
