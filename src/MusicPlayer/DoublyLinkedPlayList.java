package MusicPlayer;

public class DoublyLinkedPlayList {

    Song head;
    Song tail;
    Song current;

    // add playlist
    public void addSong(String title) {
        Song newSong = new Song(title);

        if (head == null) {
            head = tail = current = newSong; //ilk şarkıda hepsine şarkıyı atadakı: Avici Levels
            System.out.println("Added " + newSong.getInfo());
            return;
        }


        tail.next = newSong; // tail next ile en sona ekleme yaptık.  Someone Like You burayı atadakı
        newSong.prev = tail; // onceki sarkıya taildeki sarkıyı ekle
        tail = newSong;

        System.out.println("Added: " + newSong.getInfo());
    }



    public void nextSong() {
        if (current == null) {
            System.out.println(" Playlist is empty");
            return;
        }

        if (current.next == null) {
            System.out.println("You're on the last song!");
            return;
        }

        current = current.next;//bir sonraki şarkıya gectik
        System.out.println("Now playing: " + current.getInfo());
    }


    public void previousSong() {
        if (current == null) {
            System.out.println(" Playlist is empty");
            return;
        }

        if (current.prev == null) {
            System.out.println("Start of Playlist");
            return;
        }

        current = current.prev;
        System.out.println("Now playing: " + current.getInfo());
    }


    public void nowPlaying() {
        if (current == null) {
            System.out.println("No songs are playing!");
            return;
        }
        System.out.println("Now Playing: " + current.getInfo());
    }


    // Liste başına ekleme
    public void addSongAtBeginning(String title) {
        Song newSong = new Song(title);

        if (head == null) {
            head = newSong;
            tail = newSong;
            current = head;
        } else {
            newSong.next = head;
            head.prev = newSong;
            head = newSong;
        }

        System.out.println("Başa eklendi: " + newSong.getInfo());
    }



    public void showPlaylist() {
        if (head == null) {
            System.out.println("Çalma listesi boş!");
            return;
        }

        System.out.println("\n📋 Çalma Listesi:");
        System.out.println("─────────────────────────────────");
        Song temp = head;
        int index = 1;

        while (temp != null) {
            String marker = (temp == current) ? "> " : "  ";
            System.out.println(marker + index + ". " + temp.getInfo());
            temp = temp.next;
            index++;
        }
        System.out.println("─────────────────────────────────");
        System.out.println("Head: " + head.title + " | Tail: " + tail.title);
    }
}
