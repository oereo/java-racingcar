package util;

import java.util.Random;

public class RandomGenerator {
    private static final int UPPER_BOUND = 10;
    private static final Random RANDOM = new Random();

    private RandomGenerator(){

    }

    public static int generateNumber(){
        return RANDOM.nextInt(UPPER_BOUND);
    }
}
