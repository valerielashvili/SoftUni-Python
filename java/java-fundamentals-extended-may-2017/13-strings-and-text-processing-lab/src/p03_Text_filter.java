import java.util.Scanner;

public class p03_Text_filter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String word : bannedWords) {
            String repeatedChar = new String(new char[word.length()]).replace("\0", "*");
            text = text.replace(word, repeatedChar);
        }
        System.out.println(text);

    }
}
