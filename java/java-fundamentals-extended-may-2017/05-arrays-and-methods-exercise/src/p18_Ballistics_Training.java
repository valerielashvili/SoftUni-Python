import java.util.Scanner;

public class p18_Ballistics_Training {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String coordinates[] = scanner.nextLine().split(" ");
        String commands[] = scanner.nextLine().split(" ");

        int planeCoordinates[] = new int[2];

        for (int i = 0; i < coordinates.length; i++) {
            planeCoordinates[i] = Integer.parseInt(coordinates[i]);
        }

        int x = 0;
        int y = 0;

        for (int i = 0; i < commands.length - 1; i+= 2) {
            int coordinate = Integer.parseInt(commands[i + 1]);

            if ("up".equals(commands[i])) {
                y += coordinate;
            } else if ("down".equals(commands[i])) {
                y -= coordinate;
            } else if ("left".equals(commands[i])) {
                x -= coordinate;
            } else if ("right".equals(commands[i])) {
                x += coordinate;
            }
        }
        System.out.printf("firing at [%d, %d]\n", x, y);
        if (x == planeCoordinates[0] && y == planeCoordinates[1]) {
            System.out.println("got 'em!");
        } else {
            System.out.println("better luck next time...");
        }
    }
}
