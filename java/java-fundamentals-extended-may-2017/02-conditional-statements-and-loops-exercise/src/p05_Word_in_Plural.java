import java.util.Scanner;

import static java.lang.System.in;

public class p05_Word_in_Plural {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);

        String word = scanner.nextLine().toLowerCase();
        String[] matches = { "o", "s", "x", "z" };

        boolean val = false;

        for (String match:matches) {

            if (word.endsWith(match))
            {
                val = true;
                System.out.println(word + "es");
            }
        }
        if (word.endsWith("y"))
        {
            word = word.substring(0, word.length() - 1);
            System.out.println(word + "ies");
        }
        else if (word.endsWith("ch") || word.endsWith("sh"))
        {
            System.out.println(word + "es");
        }
        else if (!val)
        {
            System.out.println(word + "s");
        }
    }
}
