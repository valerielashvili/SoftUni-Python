import java.util.Scanner;

public class p12_CurrencyConverter {
    public static void main (String[] args) {
        double sum;
        double usd = 1.79549;
        double eur = 1.95583;
        double gbp = 2.53405;

        Scanner console = new Scanner(System.in);
        System.out.print("Въведете сума: ");
        sum = Double.parseDouble(console.nextLine());
        System.out.print("Въведете валута - BGN, USD, EUR, GBP: ");
        String currency1 = console.nextLine();
        System.out.print("Въведете валута за конвертиране - BGN, USD, EUR, GBP: ");
        String currency2 = console.nextLine();
        String currency = currency1 + currency2;
        switch (currency) {
            case "BGNUSD": System.out.printf("%.2f USD", (sum/usd)); break;
            case "BGNEUR": System.out.printf("%.2f EUR", (sum/eur)); break;
            case "BGNGBP": System.out.printf("%.2f GBP", (sum/gbp)); break;
            case "USDBGN": System.out.printf("%.2f BGN", (sum*usd)); break;
            case "USDEUR": System.out.printf("%.2f EUR", (sum*usd)/eur); break;
            case "USDGBP": System.out.printf("%.2f GBP", (sum*usd)/gbp); break;
            case "EURBGN": System.out.printf("%.2f BGN", (sum*eur)); break;
            case "EURUSD": System.out.printf("%.2f USD", (sum*eur)/usd); break;
            case "EURGBP": System.out.printf("%.2f GBP", (sum*eur)/gbp); break;
            case "GBPBGN": System.out.printf("%.2f BGN", (sum*gbp)); break;
            case "GBPUSD": System.out.printf("%.2f USD", (sum*gbp)/usd); break;
            case "GBPEUR": System.out.printf("%.2f EUR", (sum*gbp)/eur); break;
            default: System.out.println("Въвели сте неподдържана валута!");
        }

    }
}
