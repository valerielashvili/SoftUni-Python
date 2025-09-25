import java.util.*;
import java.util.stream.Collectors;

public class p01_Remove_Elements_at_Odd_Positions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" "))); {

            for (int i = 0; i < list.size(); i+=1) {
                    list.remove(i);
            }
            System.out.println(list.stream().collect(Collectors.joining()));
        }
    }
}
