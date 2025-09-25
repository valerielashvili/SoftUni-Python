package p05_Online_Radio_Database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Playlist playlist = new Playlist();

        while (n-- > 0) {
            String[] tokens = reader.readLine().split("[;:]");
            try {
                Song song = new Song(tokens[0], tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
                playlist.addSong(song);
                System.out.println("Song added.");
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid song length.");
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }

        playlist.calculatePlaylistLength();
        System.out.printf("Songs added: %d\n", playlist.getTotalSongsCount());
        System.out.println(playlist.getTotalPlaylistLength());
    }
}
