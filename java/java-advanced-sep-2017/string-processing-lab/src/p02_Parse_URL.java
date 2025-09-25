import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p02_Parse_URL {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] url = reader.readLine().split("://");

        if (url.length != 2) {
            System.out.println("Invalid URL");
        } else {
            String protocol = url[0];
            int serverEndIndex = url[1].indexOf("/");
            String server = url[1].substring(0, serverEndIndex);
            String resources = url[1].substring(serverEndIndex + 1);
            System.out.printf("Protocol = %s\nServer = %s\nResources = %s", protocol, server, resources);
        }
    }
}
