import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class p05_SoftUni_Party {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();
        TreeSet<String> vip = new TreeSet<>();
        TreeSet<String> regular = new TreeSet<>();

        while (!"PARTY".equals(inputLine)) {
            if (Character.isDigit(inputLine.charAt(0))) {
                vip.add(inputLine);
            } else {
                regular.add(inputLine);
            }
            inputLine = reader.readLine();
        }
        inputLine = reader.readLine();

        while (!"END".equals(inputLine)) {
            if (vip.contains(inputLine)) {
                vip.remove(inputLine);
            } else if (regular.contains(inputLine)) {
                regular.remove(inputLine);
            }
            inputLine = reader.readLine();
        }

        int guestsCount = vip.size() + regular.size();
        System.out.println(guestsCount);

        if (!vip.isEmpty()) {
            System.out.println(vip.stream().collect(Collectors.joining("\n")));
        }
        if (!regular.isEmpty()) {
            System.out.println(regular.stream().collect(Collectors.joining("\n")));
        }
    }
}
