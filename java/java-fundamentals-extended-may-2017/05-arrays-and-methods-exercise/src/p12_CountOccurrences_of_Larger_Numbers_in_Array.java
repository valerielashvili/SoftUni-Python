import java.util.Scanner;

public class p12_CountOccurrences_of_Larger_Numbers_in_Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String realNums = scanner.nextLine();
        double pNumber = Double.parseDouble(scanner.nextLine());
        int counter = 0;

        String splittedNums[] = realNums.split(" ");
        Double realNumsArray[] = new Double[splittedNums.length];

        for (int i = 0; i < splittedNums.length; i++) {
            realNumsArray[i] = Double.parseDouble(splittedNums[i]);

            if (realNumsArray[i] > pNumber) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
