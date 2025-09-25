import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p06_Ordered_Banking_System {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        LinkedHashMap<String, LinkedHashMap<String, BigDecimal>> bankAccounts = new LinkedHashMap<>();

        while (!"end".equals(inputLine)) {
            String[] tokens = inputLine.split(" -> ");
            String bank = tokens[0];
            String account = tokens[1];
            BigDecimal balance = new BigDecimal(tokens[2]);

            if (!bankAccounts.containsKey(bank)) {
                bankAccounts.put(bank, new LinkedHashMap<>());
            }
            if (!bankAccounts.get(bank).containsKey(account)) {
                bankAccounts.get(bank).put(account, BigDecimal.ZERO);
            }
            bankAccounts.get(bank).put(account, bankAccounts.get(bank).get(account).add(balance));

            inputLine = scanner.nextLine();
        }

        bankAccounts.entrySet().stream()
                .sorted((a, b) -> {
                    BigDecimal aBalancesSum = a.getValue().entrySet()
                            .stream()
                            .map(Map.Entry::getValue)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);

                    BigDecimal bBalancesSum = b.getValue().entrySet()
                            .stream()
                            .map(Map.Entry::getValue)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);

                    int compareBalances = bBalancesSum.compareTo(aBalancesSum);
                    if (compareBalances == 0) {

                        BigDecimal maxAValue = a.getValue().entrySet()
                                .stream()
                                .map(Map.Entry::getValue)
                                .max(BigDecimal::compareTo).get();

                        BigDecimal maxBValue = b.getValue().entrySet()
                                .stream()
                                .map(Map.Entry::getValue)
                                .max(BigDecimal::compareTo).get();

                        compareBalances = maxBValue.compareTo(maxAValue);
                    }
                    return compareBalances;
                })
                .forEach(b -> b.getValue().entrySet()
                        .stream()
                        .sorted((a1, a2) -> a2.getValue().compareTo(a1.getValue()))
                        .forEach(a -> {
                            System.out.printf("%s -> %s (%s)\n", a.getKey(), a.getValue(), b.getKey());
                        }));
    }
}
