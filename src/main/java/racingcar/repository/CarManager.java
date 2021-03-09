package racingcar.repository;

import racingcar.domain.Car;
import racingcar.repository.exception.NotDuplicateNameException;
import racingcar.ui.Printer;
import racingcar.utils.Discriminator;
import racingcar.utils.RandomGenerator;

import java.util.*;
import java.util.stream.Collectors;

public class CarManager {
    private final List<Car> cars;

    public CarManager() {
        cars = new ArrayList<>();
    }

    public void proceedRound(RandomGenerator randomGenerator, Discriminator discriminator) {
        for (Car car : cars) {
            int randomNumber = randomGenerator.generateNumber();
            if (discriminator.isMove(randomNumber)) {
                car.move();
            }
        }
    }

    public void printCarState(Printer printer) {
        for (Car car : cars) {
            printer.printCarState(car);
        }
        printer.printNewLine();
    }

    public void addAllCars(List<String> carNames) {
        for (String name : carNames) {
            Car car = new Car(name);
            checkDuplicateName(car);
            cars.add(car);
        }
    }

    private void checkDuplicateName(Car car) {
        if (cars.contains(car)) {
            throw new NotDuplicateNameException("중복되는 이름의 차를 입력하실 수 없습니다.");
        }
    }

    public int size() {
        return cars.size();
    }

    public String createWinnerMessage() {
        StringBuilder winnerNames = new StringBuilder();
        List<Car> winners = winnerList();
        winnerNames.append(winners.get(0).getName());

        for (int i = 1; i < winners.size(); i++) {
            Car winner = winners.get(i);
            winnerNames.append(", ");
            winnerNames.append(winner.getName());
        }

        return winnerNames.toString();
    }

    private List<Car> winnerList() {
        int winnerPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalArgumentException::new);

        return cars.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .collect(Collectors.toList());
    }
}
