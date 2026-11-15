import java.util.*;

public class PlaylistDemo {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();

        String[] songs = {
            "Song A", "Song B", "Song C",
            "Song D", "Song E"
        };

        for (String song : songs) {
            arrayList.add(song);
            linkedList.add(song);
        }

        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);

        arrayList.add(0, "New Song");
        linkedList.add(0, "New Song");

        System.out.println("After Insertion:");
        System.out.println(arrayList);
        System.out.println(linkedList);

        arrayList.remove(2);
        linkedList.remove(2);

        System.out.println("After Removal:");
        System.out.println(arrayList);
        System.out.println(linkedList);

        System.out.println("K-th Song: " +
            arrayList.get(2));

        System.out.println("Playlist Iteration:");

        for (String song : arrayList) {
            System.out.println(song);
        }

        ArrayDeque<String> upNext = new ArrayDeque<>();

        upNext.addFirst("Priority Song");
        upNext.addLast("Next Song");

        System.out.println("Up Next: " + upNext);
    }
}
