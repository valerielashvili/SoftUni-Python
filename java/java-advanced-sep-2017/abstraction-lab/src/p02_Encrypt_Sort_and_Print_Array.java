import java.util.*;

public class p02_Encrypt_Sort_and_Print_Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            names[i] = scanner.nextLine();
        }
        int[] encryptedNames = encryptNames(names);
        Arrays.sort(encryptedNames);

        printNames(encryptedNames);
    }

    private static void printNames(int[] encryptedArr) {
        for (int i = 0; i < encryptedArr.length; i++) {
            System.out.println(encryptedArr[i]);
        }
    }

    private static int[] encryptNames(String[] names) {
        List<Character> vowels = new ArrayList<>();
        Collections.addAll(vowels, 'a','e','i','o','u','A','E','I','O','U');
        int sum = 0;
        int result[] = new int[names.length];
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < names[i].length(); j++) {
                int c = names[i].charAt(j);
                if (vowels.contains(names[i].charAt(j))) {
                    sum += c * names[i].length();
                } else {
                    sum += c / names[i].length();
                }
            }
            result[i] = sum;
            sum = 0;
        }
        return result;
    }
}
