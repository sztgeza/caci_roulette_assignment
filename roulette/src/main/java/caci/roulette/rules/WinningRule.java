package caci.roulette.rules;

import caci.roulette.Pocket;

/**
 * Created by gezas on 2017. 03. 17..
 */
public interface WinningRule {
    int match(Pocket pocket);
}
