import java.util.Scanner;

public class p11_USDtoBGN {
    public static void main(String[] args) {

        double bgn = 1.79549;

        Scanner console = new Scanner(System.in);
        double usd = Double.parseDouble(console.nextLine());
        double rate = usd * bgn;
        System.out.printf("BGN exchange rate: %.2f", rate);

    }
}
