import java.util.LinkedHashMap;
import java.util.Scanner;

public class p04_Files {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, LinkedHashMap<String, Long>> files = new LinkedHashMap<>();
        final boolean[] fileIsPresent = {false};

        while (n-- > 0){
            String inputLine = scanner.nextLine();
            String[] tokens = inputLine.split(";");
            long fileSize = Long.parseLong(tokens[1]);
            String[] directories = tokens[0].split("\\\\");
            String root = directories[0];
            String file = directories[directories.length - 1];

            files.putIfAbsent(root, new LinkedHashMap<>());
            files.get(root).put(file, fileSize);
        }
        String[] command = scanner.nextLine().split(" in ");
        String extension = command[0];
        String root = command[1];

        if (files.containsKey(root)) {
            files.get(root).entrySet()
                    .stream()
                    .filter(e -> e.getKey().endsWith(extension))
                    .sorted((f1, f2) -> {
                        if (Long.compare(f1.getValue(), f2.getValue()) == 0) {
                            return f1.getKey().compareTo(f2.getKey());
                        }
                        return Long.compare(f2.getValue(), f1.getValue());
                    })
                    .forEach(f -> {
                        fileIsPresent[0] = true;
                        System.out.printf("%s - %d KB%n", f.getKey(), f.getValue());
                    });
        }

        if (!fileIsPresent[0]) {
            System.out.printf("No%n");
        }
    }
}
