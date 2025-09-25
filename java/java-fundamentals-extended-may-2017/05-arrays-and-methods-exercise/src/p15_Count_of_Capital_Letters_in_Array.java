import java.util.Scanner;

public class p15_Count_of_Capital_Letters_in_Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String stringsArray[] = string.split(" ");

        int counter = 0;

        for (String singleWord : stringsArray) {

            if (singleWord.length() == 1) {
                char singleLetter = singleWord.charAt(0);

                if (singleLetter >= 65 && singleLetter <= 90) {
                    counter++;
                }
            }

        }
        System.out.println(counter);
    }
}
