import java.util.*;

public class PlaylistRedesign {
    public static void main(String[] args) {

        ArrayList<String> playlist =
            new ArrayList<>();

        ArrayDeque<String> upNext =
            new ArrayDeque<>();

        playlist.add("Song A");
        playlist.add("Song B");
        playlist.add("Song C");
        playlist.add("Song D");

        upNext.addLast("Song E");
        upNext.addLast("Song F");
        upNext.addFirst("Priority Song");

        System.out.println("Main Playlist:");
        System.out.println(playlist);

        System.out.println("Up Next Queue:");
        System.out.println(upNext);

        System.out.println("Playing Next:");
        System.out.println(upNext.removeFirst());

        upNext.addFirst("New Priority Song");

        System.out.println("Updated Up Next:");
        System.out.println(upNext);

        System.out.println("K-th Song: " +
            playlist.get(2));
    }
}
