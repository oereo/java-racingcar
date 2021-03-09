package racingcar;

import racingcar.domain.Car;
import racingcar.dto.CarNumberDto;
import racingcar.exception.NotZeroRoundException;
import racingcar.repository.CarManager;
import racingcar.ui.Printer;
import racingcar.ui.Receiver;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class RacingGameApplication {
    private static final int INPUT_ZERO = 0;
    private static final String DELIMITER = ",";

    private final Printer printer = new Printer();
    private final Receiver receiver = new Receiver();
    private final CarManager carManager = new CarManager();

    public void run() {
        printer.requestCarName();
        String line = receiver.receiveCarNames();
        List<Car> carList = createAllCars(splitInputLine(line));
        carManager.addAllCars(carList);

        printer.requestNumberOfRounds();
        int rounds = receiveRounds();

        printer.printResultHeader();
        for (int i = 0; i < rounds; i++) {
            List<CarNumberDto> carNumberDtos = carManager.generateCarNumberDtos();
            carManager.moveAllCars(carNumberDtos);
            carManager.printCarState(printer);
        }
        printer.printWinner(carManager.createWinnerMessage());
    }

    private List<Car> createAllCars(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name));
        }
        return carList;
    }

    private int receiveRounds() {
        int rounds = 0;
        boolean isInvalidInput = true;
        while (isInvalidInput) {
            try {
                rounds = receiver.receiveNumberOfRounds();
                throwExceptionIfInputIsZero(rounds);
                isInvalidInput = false;
            } catch (InputMismatchException e) {
                printer.printInputMismatchExceptionMessage(receiver);
            } catch (IllegalArgumentException e) {
                printer.printExceptionMessage(e);
            }
        }
        return rounds;
    }

    private void throwExceptionIfInputIsZero(int rounds) {
        if (rounds == INPUT_ZERO) {
            throw new NotZeroRoundException();
        }
    }

    private List<String> splitInputLine(String line) {
        return List.of(line.split(DELIMITER));
    }


    public static void main(String[] args) {
        RacingGameApplication app = new RacingGameApplication();
        app.run();
    }
}

