import java.util.Scanner;

public class p08_TradeComissions {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String town = scanner.nextLine().toLowerCase();
        double sales = Double.parseDouble(scanner.nextLine());
        double commission = -1;
        //Пресмятаме търговски комисионни
        if ("sofia".equals(town)) {
                if (sales >= 0 && sales <=500) {
                    commission = sales * 0.05;
                    System.out.printf("%.2f%%", commission);
                } else if (sales > 500 && sales <= 1000) {
                    commission = sales * 0.07;
                    System.out.printf("%.2f%%", commission);
                } else if (sales > 1000 && sales <= 10000) {
                    commission = sales * 0.08;
                    System.out.printf("%.2f%%", commission);
                } else if (sales > 10000) {
                    commission = sales * 0.12;
                    System.out.printf("%.2f%%", commission);
                }
        } else if ("varna".equals(town)) {
            if (sales >= 0 && sales <= 500) {
                commission = sales * 0.045;
                System.out.printf("%.2f%%", commission);
            } else if (sales > 500 && sales <= 1000) {
                commission = sales * 0.075;
                System.out.printf("%.2f%%", commission);
            } else if (sales > 1000 && sales <= 10000) {
                commission = sales * 0.1;
                System.out.printf("%.2f%%", commission);
            } else if (sales > 10000) {
                commission = sales * 0.13;
                System.out.printf("%.2f%%", commission);
            }
        } else if ("plovdiv".equals(town)) {
            if (sales >= 0 && sales <= 500) {
                commission = sales * 0.055;
                System.out.printf("%.2f%%", commission);
            } else if (sales > 500 && sales <= 1000) {
                commission = sales * 0.08;
                System.out.printf("%.2f%%", commission);
            } else if (sales > 1000 && sales <= 10000) {
                commission = sales * 0.12;
                System.out.printf("%.2f%%", commission);
            } else if (sales > 10000) {
                commission = sales * 0.145;
                System.out.printf("%.2f%%", commission);
            }
        } if (commission < 0) {
            System.out.println("error");
        }
    }
}