import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class p01_Matching_Brackets {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < inputLine.length(); i++) {
            if (inputLine.charAt(i) == '(') {
                stack.push(i);
            } else if (inputLine.charAt(i) == ')') {
                int startIndex = stack.pop();
                String expression = inputLine.substring(startIndex, i + 1);
                System.out.println(expression);
            }
        }
    }
}
