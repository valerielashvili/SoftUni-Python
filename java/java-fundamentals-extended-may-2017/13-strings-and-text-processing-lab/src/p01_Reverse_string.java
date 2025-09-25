import java.util.Scanner;

public class p01_Reverse_string {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            result  += input.substring(i, i+1);
        }
        System.out.println(result);
    }
}
