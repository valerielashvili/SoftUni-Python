import java.math.BigInteger;
import java.util.Scanner;

public class p07_Product_of_Numbers_NM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int counter = n;
        BigInteger numProduct = BigInteger.valueOf(n);

        do {
            counter++;
            BigInteger nextNum = BigInteger.valueOf(counter);
            numProduct = numProduct.multiply(nextNum);
        } while (counter < m);

        System.out.printf("product[%d..%d] = %s", n, m, numProduct);
    }
}
