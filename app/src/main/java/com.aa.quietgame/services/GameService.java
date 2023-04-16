public class GameService {

    private static final int MAX_PLAYERS = 4;

    private List<Player> players = new ArrayList<>();
    private int currentPlayerIndex = 0;

    public void addPlayer(Player player) throws Exception {
        if (players.size() < MAX_PLAYERS) {
            players.add(player);
        } else {
            throw new Exception("Maximum number of players reached.");
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public boolean isGameOver() {
        int count = 0;
        for (Player player : players) {
            if (player.isEliminated()) {
                count++;
            }
        }
        return count == players.size() - 1;
    }

    public Player getWinner() {
        for (Player player : players) {
            if (!player.isEliminated()) {
                return player;
            }
        }
        return null;
    }

}
