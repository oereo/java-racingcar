package racingcar.repository.Strategy;

import racingcar.domain.car.Car;

public class ForwardMoveStrategy extends RandomMoveStrategy{
    public void forwardDeciding(Car car){
        if(decideMoving() >= getThreshold()){
            car.move();
        }
    }
}
