import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p04_Series_of_Letters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] input = reader.readLine().toCharArray();
        StringBuilder result = new StringBuilder();

        int state = 0;
        int i = 0;
        char prev = input[0];

        while (i < input.length) {
            switch (state) {
                case 0: // Initial state
                    state = 1;
                    prev = input[i];
                    break;
                case 1: // Found a new letter
                    result.append(prev);
                    if (input[i] == prev) {
                        state = 2;
                    }
                    prev = input[i];
                    break;
                case 2: // Found the same letter
                    if (input[i] != prev) {
                        state = 1;
                    }
                    prev = input[i];
                    break;
            }
            i++;
        }
        if(input[i-2] != prev){
            result.append(prev);
        }
        System.out.println(result.toString());
    }
}
