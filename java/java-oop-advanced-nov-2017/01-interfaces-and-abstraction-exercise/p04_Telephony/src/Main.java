import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputPhoneNumbers = reader.readLine().split("\\s+");
        String[] inputWebSites = reader.readLine().split("\\s+");

        Smartphone smartphone = new Smartphone(inputPhoneNumbers, inputWebSites);
        StringBuilder output = new StringBuilder();

        output.append(smartphone.call());
        output.append(smartphone.browse());
        System.out.print(output);
    }
}
