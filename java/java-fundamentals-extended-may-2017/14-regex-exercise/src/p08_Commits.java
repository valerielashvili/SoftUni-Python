import java.text.Collator;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class p08_Commits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        LinkedHashMap<String, LinkedHashMap<String, ArrayList<Commit>>> gitUsers = new LinkedHashMap<>();

        Pattern pattern = Pattern.compile("^https://github\\.com/(?<user>[A-Za-z0-9\\-]+)/" +
                "(?<repo>[A-Za-z\\-_]+)/commit/" +
                "(?<hash>[0-9a-f]{40})," +
                "(?<message>[^\\n]*)," +
                "(?<additions>\\d*)," +
                "(?<deletions>\\d*)$");

        while (!"git push".equals(inputLine)) {
            Matcher matcher = pattern.matcher(inputLine);

            if (matcher.find()) {
                String username = matcher.group("user");
                String repo = matcher.group("repo");
                String hash = matcher.group("hash");
                String message = matcher.group("message");
                long additions = Long.parseLong(matcher.group("additions"));
                long deletions = Long.parseLong(matcher.group("deletions"));

                Commit commit = new Commit(hash, message, additions, deletions);

                gitUsers.putIfAbsent(username, new LinkedHashMap<>());
                gitUsers.get(username).putIfAbsent(repo, new ArrayList<>());
                gitUsers.get(username).get(repo).add(commit);
            }
            inputLine = scanner.nextLine();
        }
        Collator collator = Collator.getInstance();

        /*LinkedHashMap<String, LinkedHashMap<String, ArrayList<Commit>>> sortedUsers*/ gitUsers = gitUsers.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(collator))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue()
                                .entrySet()
                                .stream()
                                .sorted(Map.Entry.comparingByKey(collator))
                                .collect(
                                        Collectors.toMap(
                                                Map.Entry::getKey,
                                                Map.Entry::getValue,
                                                (a, b) -> a,
                                                LinkedHashMap::new
                                        )
                                ),
                        (a, b) -> a,
                        LinkedHashMap::new
                        )
                );

        for (Map.Entry<String, LinkedHashMap<String, ArrayList<Commit>>> usersEntry : gitUsers.entrySet()) {
            String username = usersEntry.getKey();
            System.out.printf("%s:%n", username);

            Map<String, ArrayList<Commit>> repos = usersEntry.getValue();

            for (Map.Entry<String, ArrayList<Commit>> reposEntry : repos.entrySet()) {
                String repoName = reposEntry.getKey();
                ArrayList<Commit> commits = reposEntry.getValue();

                System.out.printf("  %s:%n", repoName);

                long totalAdditions = 0;
                long totalDeletions = 0;

                for (Commit commit : commits) {
                    System.out.printf("    commit %s: %s (%s additions, %s deletions)%n",
                            commit.getHash(), commit.getMessage(), commit.getAdditions(), commit.getDeletions());

                    totalAdditions += commit.getAdditions();
                    totalDeletions += commit.getDeletions();
                }
                System.out.printf("    Total: %s additions, %s deletions%n", totalAdditions, totalDeletions);
            }
        }

        // Printing the data
        /*sortedUsers.entrySet()
                .stream()
                //.sorted((u1, u2) -> collator.compare(u1.getKey(), u2.getKey()))
                .forEach(user -> {
                    System.out.printf("%s:%n", user.getKey());

                    user.getValue().entrySet()
                            .stream()
                            //.sorted((r1, r2) -> collator.compare(r1.getKey(), r2.getKey()))
                            .forEach(repo -> {
                                System.out.printf("  %s:%n", repo.getKey());

                                repo.getValue().forEach(c -> {
                                    System.out.printf("    commit %s: %s (%s additions, %s deletions)%n",
                                            c.getHash(), c.getMessage(), c.getAdditions(), c.getDeletions());
                                });

                                long totalAdditions = repo.getValue()
                                        .stream()
                                        .mapToLong(e -> e.getAdditions())
                                        .sum();

                                long totalDeletions = repo.getValue()
                                        .stream()
                                        .mapToLong(e -> e.getDeletions())
                                        .sum();

                                System.out.printf("    Total: %s additions, %s deletions%n", totalAdditions, totalDeletions);
                            });
                });*/
    }
}

class Commit {
    private String hash;
    private String message;
    private long additions;
    private long deletions;

    // Creating constructor
    public Commit(String hash, String message, long additions, long deletions) {
        this.hash = hash;
        this.message = message;
        this.additions = additions;
        this.deletions = deletions;
    }

    public String getHash() {
        return this.hash;
    }
    public String getMessage() {
        return this.message;
    }
    public long getAdditions() {
        return this.additions;
    }
    public long getDeletions() {
        return this.deletions;
    }
}
