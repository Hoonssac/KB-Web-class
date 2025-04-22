package ch09.practice.p03;

public class GenrePlaybackManager {
    public interface GenrePlayer {
        void play(String title, String artist);
    }

    private GenrePlayer player; // ⭐ 현재 전략 저장하는 필드

    public void setPlayer(GenrePlayer player) {
        this.player = player; // ⭐ 전략 설정
    }

    public void play(String title, String artist) {
        if (player == null) {
            System.out.println("⚠️ 플레이어가 설정되지 않았습니다.");
            return;
        }
        player.play(title, artist); // ⭐ 현재 설정된 전략으로 play
    }
}
