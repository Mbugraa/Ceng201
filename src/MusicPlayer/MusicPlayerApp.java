package MusicPlayer;

public class MusicPlayerApp {
    public static void main(String[] args) {
        DoublyLinkedPlayList player = new DoublyLinkedPlayList();

        System.out.println(" Music Player\n");

        player.addSong("Avici Levels");
        player.addSong("Someone Like You");
        player.addSong("Hotel California");
        player.addSong("Imagine");


        player.removeSong("Hotel California");

    }
}