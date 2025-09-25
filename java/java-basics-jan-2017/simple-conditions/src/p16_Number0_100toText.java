import java.util.Scanner;

public class p16_Number0_100toText {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        int in = Integer.parseInt(scanner.nextLine());

        if (in < 0 || in > 100) {
            System.out.println("invalid number");
        } else if (in == 0) {
            System.out.println("zero");
        } else if (in == 100) {
            System.out.println("one hundred");
        }
        else
        {
            if (in == 11) {
                System.out.println("eleven");
            } else if (in == 12) {
                System.out.println("twelve");
            } else if (in == 13) {
                System.out.println("thirteen");
            } else if (in == 14) {
                System.out.println("fourteen");
            } else if (in == 15) {
                System.out.println("fifteen");
            } else if (in == 16) {
                System.out.println("sixteen");
            } else if (in == 17) {
                System.out.println("seventeen");
            } else if (in == 18) {
                System.out.println("eighteen");
            } else if (in == 19) {
                System.out.println("nineteen");
            }
            else
            {
                String tens = "", ones = "";
                switch (in / 10)
                {
                    case 1: tens = "ten"; break;
                    case 2: tens = "twenty"; break;
                    case 3: tens = "thirty"; break;
                    case 4: tens = "forty"; break;
                    case 5: tens = "fifty"; break;
                    case 6: tens = "sixty"; break;
                    case 7: tens = "seventy"; break;
                    case 8: tens = "eighty"; break;
                    case 9: tens = "ninety"; break;
                }
                switch (in % 10)
                {
                    case 1: ones = "one"; break;
                    case 2: ones = "two"; break;
                    case 3: ones = "three"; break;
                    case 4: ones = "four"; break;
                    case 5: ones = "five"; break;
                    case 6: ones = "six"; break;
                    case 7: ones = "seven"; break;
                    case 8: ones = "eight"; break;
                    case 9: ones = "nine"; break;
                }
                /* Проверяваме колко има в остатъка и съответно печатаме десетки.
                *  В противен случай печатаме числа до 10 или по-големи числа от 20 до 100 */
                if (in % 10 == 0) {
                    System.out.println(tens);
                } else {
                    System.out.printf(in < 10 ? ones : "%s %s", tens, ones);
                }
            }
        }
    }
}
