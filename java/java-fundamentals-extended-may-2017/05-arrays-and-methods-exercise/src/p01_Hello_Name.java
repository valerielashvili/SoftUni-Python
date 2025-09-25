import java.util.Scanner;

public class p01_Hello_Name {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String readName = scanner.nextLine();

        String printingName = printName(readName);
        System.out.println(printingName);
    }

    static String printName(String name) {
        String result = "Hello, " + name + "!";
        return result;
    }
}
