import java.util.Scanner;

public class p19_Debugging_Exercise_Tricky_Strings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String delimiter = scanner.nextLine();
        int numberOfStrings = Integer.parseInt(scanner.nextLine());

        String result= "";
        String currentString = "";

        for(int i = 0; i < numberOfStrings; i++) {

            if (i > 0) {
                currentString += delimiter;
            }

            currentString += scanner.nextLine();
            result = currentString;
        }
        System.out.println(result);
    }
}
