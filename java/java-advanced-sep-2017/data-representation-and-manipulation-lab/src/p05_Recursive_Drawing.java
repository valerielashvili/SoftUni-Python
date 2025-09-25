import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class p05_Recursive_Drawing {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        recursiveDraw(n);
    }

    private static void recursiveDraw(int n) {
        // Base case (Bottom of the recursion)
        if (n == 0) {
            return;
        }
        // Pre-action: print n asterisks
        System.out.println(String.join("", Collections.nCopies(n, "*")));
        // Recursive call: print figure of size n-1
        recursiveDraw(n - 1);
        // Post-action: print n hashtags
        System.out.println(String.join("", Collections.nCopies(n, "#")));
    }
}
