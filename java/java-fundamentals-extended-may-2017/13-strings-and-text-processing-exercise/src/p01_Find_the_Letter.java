import java.util.Scanner;

public class p01_Find_the_Letter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        String[] elements = scanner.nextLine().split(" ");

        String substr = elements[0];
        int n = Integer.parseInt(elements[1]);
        int index = 0;

        index = inputLine.indexOf(substr);
        while (--n > 0 && index != -1) {
            index = inputLine.indexOf(substr, index + 1);
        }

        if (index != -1) {
            System.out.println(index);
        } else {
            System.out.println("Find the letter yourself!");
        }
    }
}
