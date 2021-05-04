package bowling.domain;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private final List<Player> players;

    public Players() {
        players = new ArrayList<>();
    }

    public Players(List<Player> players) {
        this.players = players;
    }

    public List<Player> players() {
        return players;
    }

    public void add(Player player) {
        players.add(player);
    }
}