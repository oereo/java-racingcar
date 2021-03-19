package racingcar.domain;

import racingcar.domain.exception.NotBlankException;
import racingcar.domain.exception.NotValidNameLengthException;

import java.util.Objects;

public class Car {
    private final String name;
    private int position = 0;
    private static final int CAR_NAME_MAX_LENGTH = 4;
    private static final int MOVE_INTERVAL = 1;

    public Car(String name) {
        checkBlankName(name);
        checkNameLength(name);
        this.name = name;
    }

    private void checkBlankName(String name) {
        if (name.isBlank()) {
            throw new NotBlankException();
        }
    }

    private void checkNameLength(String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new NotValidNameLengthException();
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position += MOVE_INTERVAL;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(Math.max(0, position));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
