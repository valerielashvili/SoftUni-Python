package p05_Online_Radio_Database;

class Song {
    private String artistName;
    private String songName;
    private int minutes;
    private int seconds;
    private int lengthInSeconds;

    Song(String artistName, String songName, int minutes, int seconds) throws IllegalArgumentException {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setMinutes(minutes);
        this.setSeconds(seconds);
        this.calculateLengthInSeconds(minutes, seconds);
    }

    private void setArtistName(String artistName) throws IllegalArgumentException {
        if (artistName.length() < 3 || artistName.length() > 20) {
            throw new IllegalArgumentException("Artist name should be between 3 and 20 symbols.");
        }
        this.artistName = artistName;
    }

    private void setSongName(String songName) throws IllegalArgumentException {
        if (songName.length() < 3 || songName.length() > 20) {
            throw new IllegalArgumentException("Song name should be between 3 and 30 symbols.");
        }
        this.songName = songName;
    }

    private void setMinutes(int minutes) throws IllegalArgumentException {
        if (minutes < 0 || minutes > 14) {
            throw new IllegalArgumentException("Song minutes should be between 0 and 14.");
        }
    }

    private void setSeconds(int seconds) throws IllegalArgumentException {
        if (seconds < 0 || seconds > 59) {
            throw new IllegalArgumentException("Song seconds should be between 0 and 59.");
        }
    }

    private void calculateLengthInSeconds(int minutes, int seconds) {
        this.lengthInSeconds = minutes * 60 + seconds;
    }

    int getLengthInSeconds() {
        return this.lengthInSeconds;
    }
}
