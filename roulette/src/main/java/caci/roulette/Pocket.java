package caci.roulette;
/*
Pocket
  int number.
  Color

Wheel
  Pocket spin()

BetTarget
  color
  number
  colorandnumber
  evenodd

Bet
  BetTarget

Player
  makeBet(amount, betTarget)

RoluletteGame
List<Player>
 */

import caci.roulette.exception.RouletteGameException;

/**
 * Created by gezas on 2017. 03. 17..
 */
public class Pocket {
    private int number;
    private static final int MIN_POCKET_NUMBER = 0;
    private static final int MAX_POCKET_NUMBER = 36;

    private static final int SEGMENT_1 = 1;
    private static final int SEGMENT_2 = 10;
    private static final int SEGMENT_3 = 18;
    private static final int SEGMENT_4 = 28;

    public Pocket(int number) throws RouletteGameException {
        if (number < MIN_POCKET_NUMBER || number > MAX_POCKET_NUMBER) {
            throw new RouletteGameException("Invalid pocket!");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Color getColor() {
        if (SEGMENT_1 <= number && number <= SEGMENT_2 || SEGMENT_3 + 1 <= number && number <= SEGMENT_4) {
            return Color.values()[1 - number % 2];
        } else if (SEGMENT_2 + 1 <= number && number <= SEGMENT_3 || SEGMENT_4 + 1 <= number && number <= MAX_POCKET_NUMBER) {
            return Color.values()[number % 2];
        } else {
            return Color.GREEN;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pocket pocket = (Pocket) o;

        return number == pocket.number;

    }

    @Override
    public int hashCode() {
        return number;
    }
}
