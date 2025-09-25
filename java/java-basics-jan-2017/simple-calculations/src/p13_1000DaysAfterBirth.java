import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class p13_1000DaysAfterBirth {
    public static void main (String[] args) {

        Scanner console = new Scanner(System.in);
        System.out.printf("Въведете дата на раждане: ");
        String inputDate = console.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyy");
        LocalDate parsedDate = LocalDate.parse(inputDate, formatter);
        LocalDate resultDate = parsedDate.plusDays(999);

        System.out.println(formatter.format(resultDate));
    }
}
