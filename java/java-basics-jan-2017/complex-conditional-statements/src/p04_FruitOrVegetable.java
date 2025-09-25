import java.util.Scanner;

public class p04_FruitOrVegetable {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        boolean isFruit = s.equals("banana") ||
                s.equals("apple") ||
                s.equals("kiwi") ||
                s.equals("cherry") ||
                s.equals("lemon") ||
                s.equals("grapes");

        boolean isVegetable = s.equals("tomato") ||
                s.equals("cucumber") ||
                s.equals("pepper") ||
                s.equals("carrot");

        if (isFruit) {
            System.out.println("fruit");
        } else if (isVegetable) {
            System.out.println("vegetable");
        } else {
            System.out.println("unknown");
        }
    }
}
