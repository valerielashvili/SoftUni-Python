import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p01_Students_Results {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();
        String[] stData = inputLine.split("[ \\-,]+");

        String student = stData[0];
        double jadv = Double.parseDouble(stData[1]);
        double oop = Double.parseDouble(stData[2]);
        double advoop = Double.parseDouble(stData[3]);
        double average = (jadv + oop + advoop) / 3;

        System.out.printf("%-10s|%7s|%7s|%7s|%7s|\n", "Name", "JAdv", "JavaOOP", "AdvOOP", "Average");
        System.out.printf("%-10s|%7.2f|%7.2f|%7.2f|%7.4f|", student, jadv, oop, advoop, average);
    }
}
