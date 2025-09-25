import java.util.Scanner;

public class p20_Debugging_Exercise_Triangle_Formations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        boolean triangleValidityCondition1 = a + b > c;
        boolean triangleValidityCondition2 = b + c > a;
        boolean triangleValidityCondition3 = a + c > b;

        boolean rightTriangleCondition1 = a * a + b * b == c * c;
        boolean rightTriangleCondition2 = b * b + c * c == a * a;
        boolean rightTriangleCondition3 = a * a + c * c == b * b;

        boolean isValidTriangle = triangleValidityCondition1
                && triangleValidityCondition2
                && triangleValidityCondition3;

        if (isValidTriangle)
        {
            System.out.println("Triangle is valid.");

            if (rightTriangleCondition1)
                System.out.println("Triangle has a right angle between sides a and b");
            else if (rightTriangleCondition2)
                System.out.println("Triangle has a right angle between sides b and c");
            else if (rightTriangleCondition3)
                System.out.println("Triangle has a right angle between sides a and c");
            else
                System.out.println("Triangle has no right angles");
        }
        else
        {
            System.out.println("Invalid Triangle.");
        }
    }
}
