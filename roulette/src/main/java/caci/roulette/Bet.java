package caci.roulette;

import caci.roulette.exception.RouletteGameException;

/**
 * Created by gezas on 2017. 03. 17..
 */
public class Bet {
    private int amount;
    private caci.roulette.rules.WinningRule winningRule;

    public Bet(int amount, caci.roulette.rules.WinningRule winningRule) throws RouletteGameException {
        if (amount <= 0) {
            throw new RouletteGameException("Amount of the bet must be greater than zero!");
        }
        this.amount = amount;
        this.winningRule = winningRule;
    }

    public int getAmount() {
        return amount;
    }

    public caci.roulette.rules.WinningRule getWinningRule() {
        return winningRule;
    }

    public int evaluatePrize(Pocket pocket) {
        return amount * winningRule.match(pocket);
    }

}
