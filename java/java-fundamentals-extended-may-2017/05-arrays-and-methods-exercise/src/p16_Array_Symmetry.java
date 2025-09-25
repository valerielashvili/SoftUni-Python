import java.util.Scanner;

public class p16_Array_Symmetry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String stringsArray[] = string.split(" ");

        int halfLength = (stringsArray.length) / 2;
        String answer = "Yes";

        for (int i = 0; i < halfLength; i++) {

            if (!stringsArray[i].equals(stringsArray[stringsArray.length - 1 - i])) {
                answer = "No";
                break;
            }
        }
        System.out.println(answer);
    }
}
