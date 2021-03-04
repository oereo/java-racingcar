package racingcar.repository;

import racingcar.domain.Car;
import racingcar.repository.exception.NotDuplicateNameException;

import java.util.*;
import java.util.stream.Collectors;

public class CarManager {
    private final List<Car> cars;

    public CarManager() {
        cars = new ArrayList<>();
    }

    public void moveAllCars(List<Boolean> moveFlags) {
        for (int i = 0; i < moveFlags.size(); i++) {
            if (moveFlags.get(i)) {
                cars.get(i).move();
            }
        }
    }

    public Iterator<Car> getIterator() {
        return cars.listIterator();
    }

    public void add(Car car) {
        checkDuplicateName(car);
        cars.add(car);
    }

    private void checkDuplicateName(Car car) {
        if (cars.contains(car)) {
            throw new NotDuplicateNameException("중복되는 이름의 차를 입력하실 수 없습니다.");
        }
    }

    public int size() {
        return cars.size();
    }

    public List<Car> getWinner() {
        int winnerPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalArgumentException::new);

        return cars.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .collect(Collectors.toList());
    }
}
