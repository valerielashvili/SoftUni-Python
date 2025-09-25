import java.util.Scanner;

public class p01_PersonalTitles {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double age = Double.parseDouble(scanner.nextLine());
        String gender = scanner.nextLine().toLowerCase();

        if (age >= 16) {
            if ("m".equals(gender)) {
                System.out.println("Mr.");
            } else if ("f".equals(gender)) {
                System.out.println("Ms.");
            }
        } else {
            if ("m".equals(gender)) {
                System.out.println("Master");
            } else if ("f".equals(gender)) {
                System.out.println("Miss");
            }
        }
    }
}
