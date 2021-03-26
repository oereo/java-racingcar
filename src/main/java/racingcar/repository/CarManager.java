package racingcar.repository;

import racingcar.domain.Winner;
import racingcar.domain.car.Car;
import racingcar.dto.CarDto;
import racingcar.repository.Strategy.ForwardMoveStrategy;
import racingcar.repository.exception.NotDuplicateNameException;
import racingcar.ui.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarManager {
    private List<Car> cars;
    private final ForwardMoveStrategy forwardMoveStrategy = new ForwardMoveStrategy();

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

    public void addAllCars(List<Car> carGroups) {
        cars = new ArrayList<>();
        for (Car car : carGroups) {
            checkDuplicateName(car);
            this.cars.add(car);
        }
    }

    public List<Car> createAllCars(List<String> carNames) {
        List<Car> carGroups = new ArrayList<>();

        for (String name : carNames) {
            carGroups.add(new Car(name));
        }
        return carGroups;
    }

    public List<CarDto> generateCarDtos() {
        List<CarDto> dtos = new ArrayList<>();
        for (Car car: cars) {
            dtos.add(new CarDto(car));
        }

        return dtos;
    }

    public void moveAllCars(List<CarDto> carNumberList) {
        for (CarDto dto : carNumberList) {
            forwardMoveStrategy.forwardDeciding(dto.getCar());
        }
    }

    public void printCarState(Printer printer) {
        for (Car car : cars) {
            printer.printCarState(car);
        }
        printer.printNewLine();
    }

    public String createWinnerMessage() {
        List<Car> winners = winnerList();
        Winner winner = new Winner(winners);

        return winner.getWinnerGroups();
    }

    private List<Car> winnerList() {
        int winnerPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalArgumentException::new);

        return cars.stream()
                .filter(car -> car.isWinnerPosition(winnerPosition))
                .collect(Collectors.toList());
    }
}
