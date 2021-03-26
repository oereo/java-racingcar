package racingcar;

import racingcar.domain.Round;
import racingcar.domain.car.Car;
import racingcar.repository.validator.CarManagerValidator;
import racingcar.dto.CarDto;
import racingcar.repository.CarManager;
import racingcar.ui.Printer;
import racingcar.ui.Receiver;

import java.util.List;

public class RacingGameApplication {

    private final Printer printer = new Printer();
    private final Receiver receiver = new Receiver();
    private final CarManager carManager = new CarManager();
    private final CarManagerValidator carNameValidator = new CarManagerValidator();
    public void run() {
        printer.requestCarName();
        List<Car> carList = carNameValidator.getValidateCarNames();
        carManager.addAllCars(carList);
        printer.requestNumberOfRounds();
        Round rounds = receiveRounds();
        proceedRound(rounds);
        printer.printWinner(carManager.createWinnerMessage());

    }

    private void proceedRound(Round rounds) {
        printer.printResultHeader();
        for (int i = 0; i < rounds.getRounds(); i++) {
            List<CarDto> CarDtos = carManager.generateCarDtos();
            carManager.moveAllCars(CarDtos);
            carManager.printCarState(printer);
        }
    }

    private Round receiveRounds() {
        Round roundObject = new Round();
        return roundObject;
    }

    public static void main(String[] args) {
        RacingGameApplication app = new RacingGameApplication();
        app.run();
    }
}

