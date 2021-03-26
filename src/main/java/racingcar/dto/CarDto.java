package racingcar.dto;

import racingcar.domain.car.Car;

public class CarDto {
    private final Car car;

    public CarDto(Car car) {
        this.car = car;

    }

    public Car getCar() {
        return car;
    }

}
