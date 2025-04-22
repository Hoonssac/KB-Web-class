package ch09.practice.p02;

public class Main {
    public static void main(String[] args) {
        PlayerSettings.Mode.printSettings();
        PlayerSettings.Mode.setShuffle(true);
        PlayerSettings.Mode.setRepeat(false);
        PlayerSettings.Mode.setVolumeLevel(11);
        PlayerSettings.Mode.setVolumeLevel(7);
        System.out.println();
        PlayerSettings.Mode.printSettings();

    }
}

