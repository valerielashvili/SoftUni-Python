import java.util.Scanner;

public class p21_Debugging_Exercise_Tetris {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String currentDirection = scanner.nextLine();

        while (!"exit".equals(currentDirection)) {
            switch (currentDirection) {

                case "up": Up(n); break;
                case "right": Right(n); break;
                case "down": Down(n); break;
                case "left": Left(n); break;
            }
            currentDirection = scanner.nextLine();
        }
    }

    static void Left(int n) {
        String dotsTop = new String(new char[n]).replace("\0", ".");
        String starsTop = new String(new char[n]).replace("\0", "*");
        String starsCenter = new String(new char[2 * n]).replace("\0", "*");
        String dotsBottom = new String(new char[n]).replace("\0", ".");
        String starsBottom = new String(new char[n]).replace("\0", "*");

        for (int i = 0; i < n; i++) {
            System.out.println(dotsTop + starsTop);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(starsCenter);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(dotsBottom + starsBottom);
        }
    }

    static void Right(int n) {
        String starsTop = new String(new char[n]).replace("\0", "*");
        String dotsTop = new String(new char[n]).replace("\0", ".");
        String starsCenter = new String(new char[2 * n]).replace("\0", "*");
        String starsBottom = new String(new char[n]).replace("\0", "*");
        String dotsBottom = new String(new char[n]).replace("\0", ".");

        for (int i = 0; i < n; i++) {
            System.out.println(starsTop + dotsTop);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(starsCenter);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(starsBottom + dotsBottom);
        }
    }

    static void Up(int n) {
        String dotsTop = new String(new char[n]).replace("\0", ".");
        String starsTop = new String(new char[n]).replace("\0", "*");
        String starsBottom = new String(new char[n * 3]).replace("\0", "*");
        for (int i = 0; i < n; i++) {
            System.out.println(dotsTop + starsTop + dotsTop);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(starsBottom);
        }
    }

    static void Down(int n) {
        String starsTop = new String(new char[n * 3]).replace("\0", "*");
        String dotsBottom = new String(new char[n]).replace("\0", ".");
        String starsBottom = new String(new char[n]).replace("\0", "*");
        for (int i = 0; i < n; i++) {
            System.out.println(starsTop);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(dotsBottom + starsBottom + dotsBottom);
        }
    }
}
