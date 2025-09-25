import java.util.Scanner;

public class p06_Stateless {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String state = scanner.nextLine();

        while (!"collapse".equals(state)) {
            String fiction = scanner.nextLine();

            while (fiction.length() > 0) {
                if (state.contains(fiction)) {
                    state = state.replaceAll(fiction, "");
                } else {
                    if (fiction.length() == 1) {
                        break;
                    }
                    fiction = fiction.substring(1, fiction.length() - 1);
                }
            }

            if (!state.isEmpty()) {
                System.out.println(state.trim());
            } else {
                System.out.println("(void)");
            }

            state = scanner.nextLine();
        }
    }
}
