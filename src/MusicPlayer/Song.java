package MusicPlayer;

class Song {
    String title;
    Song next;//pointer olusturduk
    Song prev;

    public Song(String title) {
        this.title = title;
        this.next = null;
        this.prev = null;
    }

    public String getInfo() {
        return title ;
    }
}