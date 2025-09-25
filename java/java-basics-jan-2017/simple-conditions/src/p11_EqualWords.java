import java.util.Scanner;

public class p11_EqualWords {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();
        input1 = input1.toLowerCase();    // Преди сравняване на думите ги обръщаме в долен регистър
        input2 = input2.toLowerCase();

        if (input1.equals(input2)) {      // Проверяваме дали думите са еднакви
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
