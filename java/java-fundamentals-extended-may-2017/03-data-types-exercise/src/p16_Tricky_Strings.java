import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p16_Tricky_Strings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String separator = scanner.nextLine();
        int number = Integer.parseInt(scanner.nextLine());
        List<String> myList = new ArrayList<>();

        for(int i = 0; i < number; ++i) {
            String words = scanner.nextLine();
            myList.add(words);
        }

        System.out.println(String.join(separator, myList));
    }
}
