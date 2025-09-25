import java.util.*;
import java.util.stream.Collectors;

public class p06_Forum_Topics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        LinkedHashMap<String, ArrayList<String>> forumTopics = new LinkedHashMap<>();

        String[] tokens;
        String topic = "";

        while (!"filter".equals(inputLine)) {
            tokens = inputLine.split(" -> |, ");
            topic = tokens[0];

            if (!forumTopics.containsKey(topic)) {
                forumTopics.put(topic, new ArrayList<>());
            }
            for (int i = 1; i < tokens.length; i++) {
                if (!forumTopics.get(topic).contains(tokens[i])) {
                    forumTopics.get(topic).add(tokens[i]);
                }
            }

            inputLine = scanner.nextLine();
        }
        inputLine = scanner.nextLine();
        ArrayList<String> filteredTags = Arrays.stream(inputLine.split(", "))
                .map(Object::toString).collect(Collectors.toCollection(ArrayList::new));

        for (Map.Entry<String, ArrayList<String>> forumTopicsEntry : forumTopics.entrySet()) {
            String topicToPrint = forumTopicsEntry.getKey();
            ArrayList<String> topicTags = forumTopicsEntry.getValue();

            if (topicTags.containsAll(filteredTags)) {
                System.out.printf("%s | #%s\n", topicToPrint, topicTags.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(", #")));
            }
        }
    }
}
