import java.util.Scanner;

public class p06_Interval_of_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        if (a < b) {
            
            for (int i = a; i <= b; i++) {
                System.out.println(i);
            }
        }
        else {
            
            for (int j = b; j <= a; j++) {
                System.out.println(j);
            }
        }
    }
}
