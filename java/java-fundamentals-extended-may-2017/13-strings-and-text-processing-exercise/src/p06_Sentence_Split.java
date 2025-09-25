import java.util.Scanner;

public class p06_Sentence_Split {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        String delimiter = scanner.nextLine();

        inputLine = inputLine.replace(delimiter, ", ");

        System.out.printf("[%s]", inputLine);
    }
}
