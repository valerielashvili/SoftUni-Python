import java.util.*;

public class p07_LINQuistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        Map<String, LinkedHashSet<String>> collectionsData = new LinkedHashMap<>();

        String[] tokens;

        while (!"exit".equals(inputLine)) {
            tokens = inputLine.split("\\.");
            String collection = tokens[0];

            if (tokens.length > 1) {
                collectionsData.putIfAbsent(collection, new LinkedHashSet<>());
                addMethods(collectionsData, collection, Arrays.copyOfRange(tokens, 1, tokens.length));

            } else if (collectionsData.containsKey(tokens[0])) {
                collectionsData.get(collection)
                        .stream()
                        .sorted((a, b) -> {
                            int compareMethods = Integer.compare(b.length(), a.length());
                            if (compareMethods == 0) {
                                compareMethods = countUniqueCharacters(b) - countUniqueCharacters(a);
                            }
                            return compareMethods;
                        })
                        .forEach(m -> System.out.printf("* %s\n", m));
            } else {
                if (Character.isDigit(collection.charAt(0))) {
                    int n = Integer.parseInt(collection);
                    collectionsData.entrySet()
                            .stream()
                            .sorted((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()))
                            .limit(1)
                            .forEach(c -> c
                                    .getValue()
                                    .stream()
                                    .sorted((a, b) -> Integer.compare(a.length(), b.length()))
                                    .limit(n)
                                    .forEach(m -> System.out.printf("* %s\n", m)));
                }
            }
            inputLine = scanner.nextLine();
        }

        String[] lastInput = scanner.nextLine().split(" ");
        String method = lastInput[0];
        String selection = lastInput[1];

        collectionsData.entrySet()
                .stream()
                .filter(k -> k.getValue().contains(method))
                .sorted((a, b) -> {
                    int compareMethods = Integer.compare(b.getValue().size(), a.getValue().size());
                    if (compareMethods == 0) {
                        String firstValue = a.getValue().stream().min(Comparator.comparingInt(String::length)).get();
                        String secondValue = b.getValue().stream().min(Comparator.comparingInt(String::length)).get();
                        compareMethods = Integer.compare(secondValue.length(), firstValue.length());
                    }
                    return compareMethods;
                })
                .forEach(c -> {
                    System.out.println(c.getKey());
                    if ("all".equals(selection)) {
                        c.getValue().stream()
                                .sorted((m1, m2) -> m2.length() - m1.length())
                                .forEach(m -> System.out.printf("* %s\n", m));
                    }
                });
    }

    public static void addMethods(Map<String, LinkedHashSet<String>> collection, String key, String[] methods) {
        for (String method : methods) {
            collection.get(key).add(method.replace("(", "").replace(")", ""));
        }
    }
    private static int countUniqueCharacters(String input)
    {
        String unique = input.replaceAll("(.)(?=.*?\\1)", "");
        return unique.length();
    }
}
