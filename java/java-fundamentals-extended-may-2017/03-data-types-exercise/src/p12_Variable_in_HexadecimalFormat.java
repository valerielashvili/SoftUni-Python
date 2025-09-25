import java.util.Scanner;

public class p12_Variable_in_HexadecimalFormat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputHex = scanner.nextLine().toUpperCase();
        inputHex = inputHex.toUpperCase();
        int val = 0;

        for(int i = 2; i < inputHex.length(); ++i) {
            char c = inputHex.charAt(i);
            int d = inputHex.indexOf(c);
            val = 16 * val + d;
        }

        System.out.println(val);
    }
}
