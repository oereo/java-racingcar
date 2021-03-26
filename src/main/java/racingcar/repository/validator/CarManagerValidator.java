package racingcar.repository.validator;

import racingcar.domain.car.Car;
import racingcar.domain.exception.NotBlankException;
import racingcar.domain.exception.NotValidNameLengthException;
import racingcar.repository.CarManager;
import racingcar.ui.Printer;
import racingcar.ui.Receiver;

import java.util.ArrayList;
import java.util.List;

public class CarManagerValidator {
    private final Receiver receiver = new Receiver();
    private final Printer printer = new Printer();
    private final CarManager carManager = new CarManager();

    public List<Car> getValidateCarNames() {
        List<Car> carList = new ArrayList<>();;
        boolean isValidate;
        do{
            isValidate = false;
            try{
                carList = carManager.createAllCars(receiver.receiveCarNames());
            }catch (NotBlankException | NotValidNameLengthException e) {
                isValidate = true;
                printer.printExceptionMessage(e);
            }
        }while(isValidate);
        return carList;
    }


}
