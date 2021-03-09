package racingcar.utils;

public class Discriminator {
    private static final int MOVING_THRESHOLD = 4;

    public boolean isMove(int randomNumber) {
        return randomNumber >= MOVING_THRESHOLD;
    }
}
