import java.util.Scanner;

public class p01_Choose_a_Drink {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String profession = scanner.nextLine().toLowerCase().replace(" ", "");

        if ("athlete".equals(profession))
        {
            System.out.println("Water");
        }
        else if ("businessman".equals(profession) || "businesswoman".equals(profession))
        {
            System.out.println("Coffee");
        }
        else if ("softunistudent".equals(profession))
        {
            System.out.println("Beer");
        } else {
            System.out.println("Tea");
        }
    }
}
