package racingcar.domain;

public class Discriminator {
    private static final int THRESHOLD = 4;

    public static boolean isMove(int randomNumber) {
        return (randomNumber >= THRESHOLD);
    }
}
