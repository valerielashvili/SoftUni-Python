import java.util.Scanner;

public class p09_Count_the_Integers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int counter = 0;
        Boolean isNumeric = true;

        while (isNumeric)
        {
            String integersInput = scanner.nextLine();
            try {
                Integer.parseInt(integersInput);
                counter++;
            }
            catch (NumberFormatException ex) {
                isNumeric = false;
            }
        }
        System.out.println(counter);
    }
}
