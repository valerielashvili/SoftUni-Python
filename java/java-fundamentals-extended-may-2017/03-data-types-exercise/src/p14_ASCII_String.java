import java.util.Scanner;

public class p14_ASCII_String {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String chars = "";

        for(int i = 0; i < n; ++i) {
            int charValues = Integer.parseInt(scanner.nextLine());
            chars += (char)charValues;
        }

        System.out.println(chars);
    }
}
