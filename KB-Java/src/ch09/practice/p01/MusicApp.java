package ch09.practice.p01;

public class MusicApp {
    private String title;
    private String artist;
    private String genre;

    public MusicApp(String title, String artist, String genre) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    public class MusicPlayer {
        public void play() {
            String effect = getEffect(genre);
            System.out.println(effect + " " + title + " - " + artist + " 을(를) 재생합니다. " + effect);
        }

        private String getEffect(String genre) {
            switch(genre) {
                case "HIPHOP":
                    return "💥";
                case "BALLAD":
                    return "🎵";
                default:
                    return "🎧";
            }
        }
    }
}


