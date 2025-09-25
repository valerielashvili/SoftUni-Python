import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p01_Bit_Snow {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        int d = nums[3];

        int e = a | b;
        int f = e ^ c;
        System.out.println(Integer.toBinaryString(e));
        System.out.println(Integer.toBinaryString(f));
    }
}
