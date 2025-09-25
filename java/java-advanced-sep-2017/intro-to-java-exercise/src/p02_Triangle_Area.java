import java.util.Scanner;

public class p02_Triangle_Area {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int aX = scanner.nextInt();
        int aY = scanner.nextInt();
        scanner.nextLine();
        int bX = scanner.nextInt();
        int bY = scanner.nextInt();
        scanner.nextLine();
        int cX = scanner.nextInt();
        int cY = scanner.nextInt();

        int result = (aX * (bY - cY) + bX * (cY - aY) + cX * (aY - bY)) / 2;
        result = Math.abs(result);

        System.out.println(result);
    }
}
