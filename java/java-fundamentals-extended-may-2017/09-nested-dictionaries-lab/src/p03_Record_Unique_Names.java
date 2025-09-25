import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p03_Record_Unique_Names {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashSet<String> names = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            names.add(name);
        }
        System.out.println(names.stream().collect(Collectors.joining("\n")));
    }
}
