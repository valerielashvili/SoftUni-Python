import java.util.Scanner;

public class p12_Volleyball {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        String year = scanner.nextLine();
        int holidays = Integer.parseInt(scanner.nextLine());
        int travelWeekends = Integer.parseInt(scanner.nextLine());
        int weekends = 48;
        //Пресмятаме уикендите в София, пресмятаме броя игри в уикендите в София,
        //пресмятаме броя игри в празничните дни и сумираме всичко с броя игри в родния град - те са точно
        //колкото пътувания до родния град
        double numGames = ((weekends - travelWeekends) * 3.0 / 4) + (holidays * 2.0 / 3) + travelWeekends;
        //Добавяме 15% към общия брой игри, ако годината е високосна
        double leapGames = numGames * 0.15;
        double allGames = numGames + leapGames;

        if ("normal".equals(year)) {
            System.out.printf("%.0f", Math.floor(numGames));
        } else if ("leap".equals(year)) {
            System.out.printf("%.0f", Math.floor(allGames));
        }
    }
}
