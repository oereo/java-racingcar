package racingcar.domain;

import racingcar.exception.NotZeroRoundException;

public class Round {
    private static final int INPUT_ZERO = 0;
    private int rounds;

    public Round(int rounds) {
        checkInputZeroRound(rounds);
        this.rounds = rounds;
    }

    private void checkInputZeroRound(int rounds) {
        if (rounds == INPUT_ZERO) {
            throw new NotZeroRoundException();
        }
    }
    public int getRounds() {
        return rounds;
    }
}
