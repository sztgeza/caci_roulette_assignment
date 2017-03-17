package caci.roulette;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by gezas on 2017. 03. 17..
 */
public class RouletteGame {
    private Set<Player> players = new HashSet<>();
    private Wheel wheel;

    public RouletteGame(Wheel wheel) {
        this.wheel = wheel;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void doPlay() {
        Pocket winningPocket = wheel.spin();
        for (Player player : players) {
            int win = player.getActualBet().evaluatePrize(winningPocket);
            player.setWin(win);
        }
    }
}
