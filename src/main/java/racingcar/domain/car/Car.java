package racingcar.domain.car;

import java.util.Objects;

public class Car {
    private final String name;
    private int position = 0;
    private static final int MOVE_INTERVAL = 1;

    public Car(String name) {
        CarName carName = new CarName(name);
        this.name = name;
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

    public boolean isWinnerPosition(int winnerPosition) {
        return winnerPosition == position;
    }
}
