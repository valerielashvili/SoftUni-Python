import java.util.Scanner;

public class p13_Digits_with_Words {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numInput = scanner.nextLine();
        int digit = 0;
        byte var5 = -1;
        switch(numInput.hashCode()) {
            case 110182:
                if (numInput.equals("one")) {
                    var5 = 1;
                }
                break;
            case 113890:
                if (numInput.equals("six")) {
                    var5 = 6;
                }
                break;
            case 115276:
                if (numInput.equals("two")) {
                    var5 = 2;
                }
                break;
            case 3143346:
                if (numInput.equals("five")) {
                    var5 = 5;
                }
                break;
            case 3149094:
                if (numInput.equals("four")) {
                    var5 = 4;
                }
                break;
            case 3381426:
                if (numInput.equals("nine")) {
                    var5 = 9;
                }
                break;
            case 3735208:
                if (numInput.equals("zero")) {
                    var5 = 0;
                }
                break;
            case 96505999:
                if (numInput.equals("eight")) {
                    var5 = 8;
                }
                break;
            case 109330445:
                if (numInput.equals("seven")) {
                    var5 = 7;
                }
                break;
            case 110339486:
                if (numInput.equals("three")) {
                    var5 = 3;
                }
        }

        switch(var5) {
            case 0:
                digit = 0;
                break;
            case 1:
                digit = 1;
                break;
            case 2:
                digit = 2;
                break;
            case 3:
                digit = 3;
                break;
            case 4:
                digit = 4;
                break;
            case 5:
                digit = 5;
                break;
            case 6:
                digit = 6;
                break;
            case 7:
                digit = 7;
                break;
            case 8:
                digit = 8;
                break;
            case 9:
                digit = 9;
        }

        System.out.print(digit);
    }
}
