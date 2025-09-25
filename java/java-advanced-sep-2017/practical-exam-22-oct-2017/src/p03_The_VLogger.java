import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class p03_The_VLogger {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, VloggersRecord> vloggersData = new LinkedHashMap<>();

        String inputLine = reader.readLine();
        while (!"Statistics".equals(inputLine)) {
            String[] tokens = inputLine.split("\\s");

            String target = "";
            if (tokens.length == 4) {
                target = tokens[2] + " " + tokens[3];
            } else {
                target = tokens[2];
            }
            String vlogger = tokens[0];
            String command = tokens[1];

            if ("joined".equals(command) && "The V-Logger".equals(target)) {
               vloggersData.putIfAbsent(vlogger, new VloggersRecord());
            }

            if ("followed".equals(command) && vloggersData.containsKey(vlogger) && vloggersData.containsKey(target)) {
                if (!vlogger.equals(target)) {
                    if (!vloggersData.get(target).getFollowers().contains(vlogger)) {
                        vloggersData.get(target).addFollower(vlogger);
                        vloggersData.get(vlogger).increaseFolloings(1);
                    }
                }
            }
            inputLine = reader.readLine();
        }
        System.out.printf("The V-Logger has a total of %d vloggers in its logs.\n", vloggersData.size());
        String mostFamous = Collections.max(vloggersData.entrySet(), (e1, e2) -> {
            int compareSize = Integer.compare(e1.getValue().getFollowers().size(), e2.getValue().getFollowers().size());
            if (compareSize == 0) {
                return Integer.compare(e2.getValue().getFollowings(), e1.getValue().getFollowings());
            }
            return Integer.compare(e1.getValue().getFollowers().size(), e2.getValue().getFollowers().size());
        }
        ).getKey();
        System.out.printf("1. %s : %d followers, %d following", mostFamous, vloggersData.get(mostFamous).getFollowers().size(),
                vloggersData.get(mostFamous).getFollowings());
        System.out.println(vloggersData.get(mostFamous)..stream().sorted((a, b) -> b.compareTo(a))
                .collect(Collectors.joining("* ")));
    }
}

class VloggersRecord {
    ArrayList<String> followers = new ArrayList<>();
    int following = 0;

    public void addFollower(String name) {
        this.followers.add(name);
    }

    public void increaseFolloings(int n) {
        this.following += n;
    }

    public ArrayList getFollowers() {
        return followers;
    }

    public int getFollowings() {
        return following;
    }
}
