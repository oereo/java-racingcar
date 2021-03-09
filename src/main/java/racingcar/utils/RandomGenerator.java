package racingcar.utils;

import java.util.Random;

public class RandomGenerator {
    private static final int UPPER_BOUND = 10;

    private static final Random RANDOM = new Random();

    public int generateNumber() {
        return RANDOM.nextInt(UPPER_BOUND);
    }
}
