package racingcar.repository.Strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy{
    private final int UPPER_BOUND = 10;
    private static final int THRESHOLD = 4;

    @Override
    public int decideMoving(){
        return new Random().nextInt(UPPER_BOUND);
    }

    public int getThreshold(){
        return THRESHOLD;
    }
}
