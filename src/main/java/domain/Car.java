package domain;

import domain.exception.NotBlankException;

import java.util.Objects;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        checkBlankName(name);
        this.name = name;
    }

    private void checkBlankName(String name) {
        if (name.equals("")) {
            throw new NotBlankException("빈 문자열 이름의 차를 생성할 수는 없습니다.");
        }
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position += 1;
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
