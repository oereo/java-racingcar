package racingcar.domain;

import racingcar.ui.validator.ReceiverValidator;

public class Round {
    private final int rounds;
    private final ReceiverValidator receiverValidator = new ReceiverValidator();

    public Round() {
        int round = receiverValidator.getvalidateReceiveNumberOfRounds();
        this.rounds = round;
    }

    public int getRounds() {
        return rounds;
    }
}
