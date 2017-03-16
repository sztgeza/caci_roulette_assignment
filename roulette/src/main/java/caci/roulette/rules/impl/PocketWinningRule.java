package caci.roulette.rules.impl;

import caci.roulette.Pocket;
import caci.roulette.rules.WinningRule;

/**
 * Created by gezas on 2017. 03. 17..
 */
public class PocketWinningRule extends AbstractWinningRule implements WinningRule {
    private Pocket pocket;

    public PocketWinningRule(Pocket pocket) {
        this.pocket = pocket;
    }

    @Override
    protected int getMultiplier() {
        return 36;
    }

    @Override
    protected boolean isMatch(Pocket pocket) {
        return this.pocket.equals(pocket);
    }
}
