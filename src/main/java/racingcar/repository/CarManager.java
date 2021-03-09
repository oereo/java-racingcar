package racingcar.repository;

import racingcar.domain.Car;
import racingcar.dto.CarNumberDto;
import racingcar.repository.exception.NotDuplicateNameException;
import racingcar.util.Discriminator;
import racingcar.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class CarManager {
    private List<Car> cars;

    public CarManager() {
        cars = new ArrayList<>();
    }

    private void checkDuplicateName(Car car) {
        if (cars.contains(car)) {
            throw new NotDuplicateNameException("중복되는 이름의 차를 입력하실 수 없습니다.");
        }
    }

    public int size() {
        return cars.size();
    }

    public void addAllCars(List<Car> cars) {
        for (Car car : cars) {
            checkDuplicateName(car);
            this.cars.add(car);
        }
    }

    public void moveAllCars(List<CarNumberDto> carNumberList) {
        for (CarNumberDto dto : carNumberList) {
            if (Discriminator.isMove(dto.getNumber())) {
                dto.getCar().move();
            }
        }
    }
}
