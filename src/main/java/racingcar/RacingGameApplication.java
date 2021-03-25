package racingcar;

import racingcar.domain.Round;
import racingcar.domain.car.Car;
import racingcar.domain.exception.NotBlankException;
import racingcar.dto.CarNumberDto;
import racingcar.exception.NotZeroRoundException;
import racingcar.repository.CarManager;
import racingcar.repository.exception.NotDuplicateNameException;
import racingcar.ui.Printer;
import racingcar.ui.Receiver;

import java.util.ArrayList;
import java.util.List;

public class RacingGameApplication {

    private final Printer printer = new Printer();
    private final Receiver receiver = new Receiver();
    private final CarManager carManager = new CarManager();

    public void run() {
        printer.requestCarName();
        try {
            List<Car> carList = createAllCars(receiver.receiveCarNames());
            carManager.addAllCars(carList);
        }catch (NotBlankException e) {
            printer.printExceptionMessage(e);
        }catch (NotDuplicateNameException e){
            printer.printExceptionMessage(e);
        }
        printer.requestNumberOfRounds();
        receiveRounds();

        printer.printWinner(carManager.createWinnerMessage());

    }

    private void proceedRound(Round rounds) {
        printer.printResultHeader();
        for (int i = 0; i < rounds.getRounds(); i++) {
            List<CarNumberDto> carNumberDtos = carManager.generateCarNumberDtos();
            carManager.moveAllCars(carNumberDtos);
            carManager.printCarState(printer);
        }
    }

    private List<Car> createAllCars(List<String> carNames) {
        List<Car> carList = new ArrayList<>();

        for (String name : carNames) {
            carList.add(new Car(name));
        }
        return carList;
    }

    private void receiveRounds() {
        try{
            Round rounds = new Round(receiver.receiveNumberOfRounds());
            proceedRound(rounds);
        }catch(NotZeroRoundException e) {
            printer.printExceptionMessage(e);
        }
    }

    public static void main(String[] args) {
        RacingGameApplication app = new RacingGameApplication();
        app.run();
    }
}

