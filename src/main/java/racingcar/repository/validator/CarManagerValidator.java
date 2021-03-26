package racingcar.repository.validator;

import racingcar.domain.car.Car;
import racingcar.domain.exception.NotBlankException;
import racingcar.domain.exception.NotValidNameLengthException;
import racingcar.repository.CarManager;
import racingcar.repository.exception.NotDuplicateNameException;
import racingcar.ui.Printer;
import racingcar.ui.Receiver;

import java.util.ArrayList;
import java.util.List;

public class CarManagerValidator {
    private final Receiver receiver = new Receiver();
    private final Printer printer = new Printer();

    public void ValidateAddCars(CarManager carManager) {
        List<Car> cars;;
        boolean isValidate;
        do{
            isValidate = false;
            try{
                cars = carManager.createAllCars(receiver.receiveCarNames());
                carManager.addAllCars(cars);
            }catch (NotBlankException | NotValidNameLengthException | NotDuplicateNameException e ) {
                isValidate = true;
                printer.printExceptionMessage(e);
            }
        }while(isValidate);
    }
}
