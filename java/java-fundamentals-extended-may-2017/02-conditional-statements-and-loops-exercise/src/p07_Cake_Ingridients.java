import java.util.Scanner;

public class p07_Cake_Ingridients {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int counter = 0;

        while (true) {
            String cakeIngredient = scanner.nextLine();

            if ("Bake!".equals(cakeIngredient)) {
                break;
            }

            counter++;
            System.out.printf("Adding ingredient %s.\n", cakeIngredient);
        }
        System.out.printf("Preparing cake with %d ingredients.\n", counter);
    }
}
