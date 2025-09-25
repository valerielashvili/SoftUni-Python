import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class p03_Camels_Back {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Integer> listOfIntegers = IntStream.of(Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray()).boxed().collect(Collectors.toCollection(ArrayList::new));
    
    int m = Integer.parseInt(scanner.nextLine());
    int counter = 0;
    
    for (int i = 0; listOfIntegers.size() > m; i++) {
      listOfIntegers.remove(0);
      listOfIntegers.remove(listOfIntegers.size() - 1 );
      counter++;

    }
    
    StringBuilder sb = new StringBuilder();
        for (int num : listOfIntegers) {
            sb.append(num).append(" ");
        }
    
    if(counter == 0) {
      System.out.printf("already stable: %s\n", sb.toString().trim());
    } else {
      System.out.printf("%d rounds\n", counter);
      System.out.printf("remaining: %s", sb.toString().trim());
    }
  }
}