package racingcar.dto;

import racingcar.domain.Car;

public class CarNumberDto {
    private final Car car;
    private final int number;

    public CarNumberDto(Car car, int number) {
        this.car = car;
        this.number = number;
    }

    public Car getCar() {
        return car;
    }

    public int getNumber() {
        return number;
    }
}
