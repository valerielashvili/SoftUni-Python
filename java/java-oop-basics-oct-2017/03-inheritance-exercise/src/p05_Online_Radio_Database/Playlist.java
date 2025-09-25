package p05_Online_Radio_Database;

import java.util.ArrayList;
import java.util.List;

class Playlist {
    private List<Song> playlist;
    private String totalPlaylistLength;

    Playlist() {
        this.playlist = new ArrayList<>();
    }

    void addSong(Song song) {
        this.playlist.add(song);
    }

    String getTotalPlaylistLength() {
        return this.totalPlaylistLength;
    }

    void calculatePlaylistLength() {
        int totalLengthInSeconds = playlist.stream()
                .mapToInt(Song::getLengthInSeconds)
                .reduce((s1, s2) -> (s1 + s2)).orElse(0);

        int hours = totalLengthInSeconds / 3600;
        int minutes = (totalLengthInSeconds % 3600) / 60;
        int seconds = totalLengthInSeconds % 60;
        this.totalPlaylistLength = String.format("Playlist length: %sh %sm %ss", hours, minutes, seconds);
    }

    int getTotalSongsCount() {
        return this.playlist.size();
    }
}
