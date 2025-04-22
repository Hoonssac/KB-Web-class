package ch09.practice.p03;

public class AppMain {
    public static void main(String[] args) {
        GenrePlaybackManager manager = new GenrePlaybackManager();

        // HIPHOP 전략
        manager.setPlayer(new GenrePlaybackManager.GenrePlayer() {
            @Override
            public void play(String title, String artist) {
                if (title.length() >= 8) {
                    System.out.println("💥💥💥 " + title + " - " + artist + " (힙합 스타일)");
                } else {
                    System.out.println("💥 " + title + " - " + artist + " (힙합 스타일)");
                }
            }
        });
        manager.play("Drowning", "WOODZ");

        // BALLAD 전략
        manager.setPlayer(new GenrePlaybackManager.GenrePlayer() {
            @Override
            public void play(String title, String artist) {
                if (artist.contains(" ")) {
                    System.out.println("🎵🎵 " + title + " - " + artist + " (감성 발라드)");
                } else {
                    System.out.println("🎵 " + title + " - " + artist + " (감성 발라드)");
                }
            }
        });
        manager.play("그녀가 웃잖아", "LUCY");

        // POP 전략
        manager.setPlayer(new GenrePlaybackManager.GenrePlayer() {
            @Override
            public void play(String title, String artist) {
                int totalLength = title.length() + artist.length();
                if (totalLength % 2 == 0) {
                    System.out.println("🎧🎧 " + title + " - " + artist + " (대중가요 스타일)");
                } else {
                    System.out.println("🎧 " + title + " - " + artist + " (대중가요 스타일)");
                }
            }
        });
        manager.play("오늘만 I LOVE YOU", "BOYNEXTDOOR");
    }
}
