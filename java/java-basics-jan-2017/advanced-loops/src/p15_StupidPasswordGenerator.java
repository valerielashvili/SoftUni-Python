import java.util.Scanner;

public class p15_StupidPasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int l = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (char l1 = 'a'; l1 < 'a' + l; l1++) {
                    for (char l2 = 'a'; l2 < 'a' + l; l2++) {
                        for (int k = 1; k <= n; k++) {
                            if (k > i && k > j) {
                                System.out.printf("%d%d%s%s%d ", i, j, l1, l2, k);
                            }
                        }
                    }
                }
            }
        }
    }
}
