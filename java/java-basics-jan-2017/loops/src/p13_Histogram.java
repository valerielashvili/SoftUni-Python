import java.util.Scanner;

public class p13_Histogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        double p1 = 0;
        double p2 = 0;
        double p3 = 0;
        double p4 = 0;
        double p5 = 0;

        for (int i = 1; i <= n; i++) {
            int nums = Integer.parseInt(scanner.nextLine());

            if (nums < 200) {
                p1++;
            }
            else if (nums >= 200 && nums <= 399) {
                p2++;
            }
            else if (nums >= 400 && nums <= 599) {
                p3++;
            }
            else if (nums >= 600 && nums <= 799) {
                p4++;
            }
            else if (nums >= 800) {
                p5++;
            }
        }
        p1 =  p1 / n * 100;
        p2 =  p2 / n * 100;
        p3 =  p3 / n * 100;
        p4 =  p4 / n * 100;
        p5 =  p5 / n * 100;
        System.out.printf("%.2f%%%n%.2f%%%n%.2f%%%n%.2f%%%n%.2f%%", p1, p2, p3 , p4, p5);
    }
}
