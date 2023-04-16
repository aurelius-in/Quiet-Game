import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LeaderboardService {

    private static List<Player> players = new ArrayList<>();

    public static void addPlayer(Player player) {
        players.add(player);
    }

    public static List<Player> getPlayers() {
        return players;
    }

    public static void sortPlayers() {
        Collections.sort(players, new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                return Integer.compare(p2.getScore(), p1.getScore());
            }
        });
    }

}
