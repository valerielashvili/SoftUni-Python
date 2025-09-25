import java.util.Scanner;

public class p04_TrainersSalary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lections = Integer.parseInt(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());

        double oneLectionPrice = budget / lections;

        int jelev = 0;
        int royal = 0;
        int roli = 0;
        int trofon = 0;
        int sino = 0;
        int ivanIvanov = 0;

        for (int i = 1; i <= lections; i++) {
            String name = scanner.nextLine();

            if ("Jelev".equals(name)) {
                jelev++;
            } else if ("RoYaL".equals(name)) {
                royal++;
            } else if ("Roli".equals(name)) {
                roli++;
            }else if ("Trofon".equals(name)) {
                trofon++;
            }else if ("Sino".equals(name)) {
                sino++;
            } else {
                ivanIvanov++;
            }
        }
        double jelevSalary = oneLectionPrice * jelev;
        double royalSalary = oneLectionPrice * royal;
        double roliSalary = oneLectionPrice * roli;
        double trofonSalary = oneLectionPrice * trofon;
        double sinoSalary = oneLectionPrice * sino;
        double ivanSalary = oneLectionPrice * ivanIvanov;

        System.out.printf("Jelev salary: %.2f lv%n", jelevSalary);
        System.out.printf("RoYaL salary: %.2f lv%n", royalSalary);
        System.out.printf("Roli salary: %.2f lv%n", roliSalary);
        System.out.printf("Trofon salary: %.2f lv%n", trofonSalary);
        System.out.printf("Sino salary: %.2f lv%n", sinoSalary);
        System.out.printf("Others salary: %.2f lv%n", ivanSalary);
    }
}
