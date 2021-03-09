package racingcar;

import racingcar.exception.NotZeroRoundException;
import racingcar.repository.CarManager;
import racingcar.ui.Printer;
import racingcar.ui.Receiver;
import racingcar.utils.Discriminator;
import racingcar.utils.RandomGenerator;

import java.util.InputMismatchException;
import java.util.List;

public class RacingGameApplication {
    private static final int INPUT_ZERO = 0;
    private static final String DELIMITER = ",";

    private final Printer printer = new Printer();
    private final Receiver receiver = new Receiver();
    private final CarManager carManager = new CarManager();
    private final RandomGenerator randomGenerator = new RandomGenerator();
    private final Discriminator discriminator = new Discriminator();

    public void run() {
        printer.requestCarName();
        String line = receiver.receiveCarNames();
        List<String> carList = splitInputLine(line);
        carManager.addAllCars(carList);

        printer.requestNumberOfRounds();
        int rounds = receiveRounds();

        printer.printResultHeader();
        for (int i = 0; i < rounds; i++) {
            carManager.proceedRound(randomGenerator, discriminator);
            carManager.printCarState(printer);
        }
        printer.printWinner(carManager.createWinnerMessage());
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
