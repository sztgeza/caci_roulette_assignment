package caci.roulette.rules.impl;

import caci.roulette.Pocket;
import caci.roulette.rules.WinningRule;

/**
 * Created by gezas on 2017. 03. 17..
 */
public class OddOrEvenWinningRule extends AbstractWinningRule implements WinningRule {
    @Override
    public int getMultiplier() {
        return 1;
    }

    @Override
    public boolean isMatch(Pocket pocket) {
        return pocket.getNumber() != 0;
    }
}
