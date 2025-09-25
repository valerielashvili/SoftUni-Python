import java.util.Scanner;

public class p06_SquareOfStars {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <=n; i++) {
            String stars = "";
            if (i==1 || i==n) {
                stars = new String(new char[n]).replace('\0', '*');
            } else {
                stars = stars + "*";
                stars = stars + new String(new char[n -2]).replace('\0', ' ');
                stars = stars + "*";
            }
            System.out.println(stars);
        }
    }
}
