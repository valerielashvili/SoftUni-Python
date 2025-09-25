import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p07_Social_Media_Posts {
    private static LinkedHashMap<String, LinkedHashMap<String, String>> postsData = new LinkedHashMap<>();
    private static LinkedHashMap<String, Integer> likesRecord = new LinkedHashMap<>();
    private static LinkedHashMap<String, Integer> dislikesRecord = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        while (!"drop the media".equals(inputLine)) {
            String[] tokens = inputLine.split(" ");
            String command = tokens[0];
            String postName = tokens[1];
            String commentatorsName;

            if ("post".equals(command)) {
                createPost(postName);
            }
            if ("like".equals(command)) {
                likePost(postName);

            } else if ("dislike".equals(command)) {
                dislikePost(postName);

            } else if ("comment".equals(command)) {
                commentatorsName = tokens[2];
                int commentStartIndex = command.length() + postName.length() + commentatorsName.length() + 3;
                String commentsContent = inputLine.substring(commentStartIndex);

                commentPost(postName, commentatorsName, commentsContent);
            }
            inputLine = scanner.nextLine();
        }
        printPostData();
    }

    private static void createPost(String postName) {
        if (!postsData.containsKey(postName)) {
            postsData.put(postName, new LinkedHashMap<>());
        }
        likesRecord.put(postName, 0);
        dislikesRecord.put(postName, 0);
    }
    private static void likePost(String postName) {
        if (!likesRecord.containsKey(postName)) {
            likesRecord.put(postName, 0);
        }
        int likesCount = likesRecord.get(postName);
        likesRecord.put(postName, likesCount + 1);
    }
    private static void dislikePost(String postName) {
        if (!dislikesRecord.containsKey(postName)) {
            dislikesRecord.put(postName, 0);
        }
        int likesCount = dislikesRecord.get(postName);
        dislikesRecord.put(postName, likesCount + 1);
    }
    private static void commentPost(String postName, String commentator, String comment) {
        postsData.get(postName).put(commentator, comment);
    }
    private static void printPostData() {

        for (Map.Entry<String, LinkedHashMap<String, String>> postData :
                postsData.entrySet()) {
            String postName = postData.getKey();

            LinkedHashMap<String, String> commentsData = postData.getValue();

            System.out.printf("Post: %s | Likes: %d | Dislikes: %d\n",
                    postName, likesRecord.get(postName), dislikesRecord.get(postName));
            System.out.printf("Comments:\n");

            if (commentsData.size() == 0) {
                System.out.println("None");
            }

            for (Map.Entry<String, String> commentData : commentsData.entrySet()) {
                String commentatorName = commentData.getKey();
                String commentContent = commentData.getValue();

                System.out.printf("*  %s: %s\n", commentatorName, commentContent);
            }
        }
    }
}
