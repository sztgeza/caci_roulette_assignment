package caci.roulette;

import caci.roulette.exception.RouletteGameException;

import java.util.Random;

/**
 * Created by gezas on 2017. 03. 17..
 */
public class Wheel {
    private Random random = new Random();

    private static final int NUMBER_OF_POCKETS = 36;

    public Pocket spin() {
        Pocket pocket = null;
        try {
            pocket = new Pocket(random.nextInt(NUMBER_OF_POCKETS + 1));
        } catch (RouletteGameException re) {
        }
        return pocket;
    }
}
