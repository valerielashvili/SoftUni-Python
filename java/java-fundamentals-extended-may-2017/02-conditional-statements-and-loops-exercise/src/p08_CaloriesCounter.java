import java.util.Scanner;

public class p08_CaloriesCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ingridientsNum = Integer.parseInt(scanner.nextLine());

        int cheese = 500;
        int tomatoSauce = 150;
        int salami = 600;
        int pepper = 50;
        int caloriesTotal = 0;

        for (int i = 0; i < ingridientsNum; i++)
        {
            String ingredient = scanner.nextLine().toLowerCase();

            if ("cheese".equals(ingredient))
            {
                caloriesTotal += cheese;
            }
            else if ("tomato sauce".equals(ingredient))
            {
                caloriesTotal += tomatoSauce;
            }
            else if ("salami".equals(ingredient))
            {
                caloriesTotal += salami;
            }
            else if ("pepper".equals(ingredient))
            {
                caloriesTotal += pepper;
            }
        }
        System.out.printf("Total calories: %d", caloriesTotal);
    }
}
