package racingcar;

import racingcar.domain.Car;
import racingcar.exception.NotZeroRoundException;
import racingcar.repository.CarManager;
import racingcar.ui.Printer;
import racingcar.ui.Receiver;

import java.util.*;

public class RacingGame {
    private static final int MOVING_THRESHOLD = 4;
    private static final int UPPER_BOUND = 10;
    private static final int INPUT_ZERO = 0;
    private static final String DELIMITER = ",";

    private static final Random RANDOM = new Random();
    private final Printer printer = new Printer();
    private final Receiver receiver = new Receiver();
    private final CarManager carManager = new CarManager();

    public void run() {
        printer.requestCarName();
        String line = receiver.receiveCarNames();
        List<String> carList = splitInputLine(line);
        addAllCars(carList);

        printer.requestNumberOfRounds();
        int rounds = receiveRounds();

        printer.printResultHeader();
        for (int i = 0; i < rounds; i++) {
            proceedRound();
            printRoundResult();
        }
        printer.printWinner(carManager.getWinner());
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
                receiver.clearBuffer();
                printer.printInputMismatchExceptionMessage();
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

    private void printRoundResult() {
        Iterator<Car> iterator = carManager.getIterator();
        for (Iterator<Car> it = iterator; it.hasNext(); ) {
            Car car = it.next();
            printer.printCarState(car);
        }
        printer.printNewLine();
    }

    private void proceedRound() {
        List<Boolean> moveFlags = new ArrayList<>();
        for (int i = 0; i < carManager.size(); i++) {
            int randomNumber = generateNumber();
            moveFlags.add(isMove(randomNumber));
        }
        carManager.moveAllCars(moveFlags);
    }

    private List<String> splitInputLine(String line) {
        return List.of(line.split(DELIMITER));
    }

    private void addAllCars(List<String> carList) {
        carList.forEach(carName -> {
            carManager.add(new Car(carName));
        });
    }

    private boolean isMove(int randomNumber) {
        return (randomNumber >= MOVING_THRESHOLD);
    }

    private int generateNumber() {
        return RANDOM.nextInt(UPPER_BOUND);
    }

}
