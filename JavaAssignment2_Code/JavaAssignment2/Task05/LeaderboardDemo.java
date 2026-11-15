import java.util.*;

class Team {
    final String name;
    final int points;
    final int goalDiff;

    Team(String name, int points, int goalDiff) {
        this.name = name;
        this.points = points;
        this.goalDiff = goalDiff;
    }

    @Override
    public String toString() {
        return name + "(" + points + "," +
               goalDiff + ")";
    }
}

class Leaderboard<T> {
    private final List<T> items = new ArrayList<>();
    private final Comparator<? super T> order;

    Leaderboard(Comparator<? super T> order) {
        this.order = order;
    }

    void add(T item) {
        items.add(item);
    }

    void addAll(List<? extends T> values) {
        items.addAll(values);
    }

    List<T> ranking() {
        List<T> copy = new ArrayList<>(items);
        copy.sort(order);
        return copy;
    }
}

public class LeaderboardDemo {
    public static void main(String[] args) {

        Comparator<Team> order =
            Comparator.comparingInt(
                (Team t) -> t.points).reversed()
            .thenComparing(
                Comparator.comparingInt(
                    (Team t) -> t.goalDiff).reversed())
            .thenComparing(t -> t.name);

        Leaderboard<Team> board =
            new Leaderboard<>(order);

        board.add(new Team("Team A", 30, 15));
        board.add(new Team("Team B", 25, 10));
        board.add(new Team("Team C", 30, 20));
        board.add(new Team("Team D", 25, 15));

        System.out.println("Final Ranking:");

        for (Team t : board.ranking()) {
            System.out.println(t);
        }
    }
}
