import java.util.Arrays;
import java.util.Scanner;

public class p03_Reverse_Array_In_Place {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] integersArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int tmpElement = 0;

        for (int i = 0; i < integersArray.length / 2; i++) {
            tmpElement = integersArray[i];
            integersArray[i] = integersArray[integersArray.length - 1 - i];
            integersArray[integersArray.length - 1 - i] = tmpElement;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : integersArray) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}
