package MusicPlayer;

public class DoublyLinkedPlayList {

    Song head;
    Song tail;
    Song current;

    public void addSong(String title) {
        Song newSong = new Song(title);

        if (head == null) {
            head = tail = current = newSong;
            System.out.println("Added " + newSong.getInfo());
            return;
        }

        tail.next = newSong;
        newSong.prev = tail;
        tail = newSong;

        System.out.println("Added: " + newSong.getInfo());
    }

    public void nextSong() {
        if (current == null) {
            System.out.println("Playlist is empty");
            return;
        }
        if (current.next == null) {
            System.out.println("You're on the last song!");
            return;
        }
        current = current.next;
        System.out.println("Now playing: " + current.getInfo());
    }

    public void previousSong() {
        if (current == null) {
            System.out.println("Playlist is empty");
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

    public void addSongAtBeginning(String title) {
        Song newSong = new Song(title);

        if (head == null) {
            head = tail = current = newSong;
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

    // removeSong artık showPlaylist'in dışında
    public void removeSong(String title) {
        if (head == null) {
            System.out.println("Çalma listesi boş!");
            return;
        }

        Song temp = head;

        while (temp != null && !temp.title.equals(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Şarkı bulunamadı!");
            return;
        }

        if (temp == current) {
            if (temp.next != null) current = temp.next;
            else if (temp.prev != null) current = temp.prev;
            else current = null;
        }

        if (temp == head && temp == tail) {
            head = tail = null;
        } else if (temp == head) {
            head = temp.next;
            head.prev = null;
        } else if (temp == tail) {
            tail = temp.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        System.out.println("✓ Silindi: " + temp.getInfo());
    }
}
