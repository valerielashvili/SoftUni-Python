import java.util.ArrayList;
import java.util.Scanner;

public class p02_Track_Downloader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] blacklistedSongs = scanner.nextLine().split(" ");

        String song = scanner.nextLine();
        ArrayList<String> playlist = new ArrayList<>();

        while (!"end".equals(song)) {
            boolean isContained = false;

            for (int i = 0; i < blacklistedSongs.length; i++) {
                if (song.contains(blacklistedSongs[i])) {
                    isContained = true;
                }
            }
            if (!isContained) {
                playlist.add(song);
            }

            song = scanner.nextLine();
        }
        playlist.sort(String::compareTo); // (a, b) -> a.compareTo(b)
        playlist.forEach(System.out::println);
    }
}
