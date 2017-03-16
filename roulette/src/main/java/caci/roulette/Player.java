package caci.roulette;

/**
 * Created by gezas on 2017. 03. 17..
 */
public class Player {
    private String name;

    private int win;
    private Bet actualBet;

    public Player(String name) {
        this.name = name;
    }

    public void makeBet(Bet bet) {
        this.actualBet = bet;
        this.win = 0;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }


    public Bet getActualBet() {
        return actualBet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return name.equals(player.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
