import java.util.Scanner;

public class p06_Replace_a_Tag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        String pattern = "<a\\s*?href=\"(.+?)\">(\\w+)<\\/\\w>";
        String replace = "[URL href=\"$1\"]$2[/URL]";

        while (!"end".equals(inputLine)) {
            System.out.println(inputLine.replaceAll(pattern, replace));

            inputLine = scanner.nextLine();
        }
    }
}
