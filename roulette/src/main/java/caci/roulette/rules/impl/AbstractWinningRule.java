package caci.roulette.rules.impl;

import caci.roulette.Pocket;
import caci.roulette.rules.WinningRule;

/**
 * Created by gezas on 2017. 03. 17..
 */
public abstract class AbstractWinningRule implements WinningRule {
    protected abstract int getMultiplier();
    protected abstract boolean isMatch(Pocket pocket);

    @Override
    public int match(Pocket pocket) {
        if (pocket == null) {
            throw new IllegalStateException();
        }
        if (isMatch(pocket)) {
            return getMultiplier();
        } else {
            return 0;
        }
    }

}
