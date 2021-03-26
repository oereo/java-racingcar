package racingcar.ui.validator;

import racingcar.exception.NotZeroRoundException;
import racingcar.ui.Printer;
import racingcar.ui.Receiver;

import java.util.InputMismatchException;

public class ReceiverValidator {
    private static final int INPUT_ZERO = 0;

    private Receiver receiver = new Receiver();
    private Printer printer = new Printer();

    public int getValidateReceiveNumberOfRounds() {
        int validateReceiveNumberOfRounds = 0, isValidate;
        do{
            isValidate = 1;
            try{
                validateReceiveNumberOfRounds = receiver.receiveNumberOfRounds();
                checkInputZeroRound(validateReceiveNumberOfRounds);
            }catch (InputMismatchException e) {
                isValidate = 0;
                printer.printInputMismatchExceptionMessage();
            }catch (IllegalArgumentException e) {
                isValidate = 0;
                printer.printExceptionMessage(e);
            }
        }while(isValidate == 0);
        return validateReceiveNumberOfRounds;
    }

    private void checkInputZeroRound(int rounds) {
        if (rounds == INPUT_ZERO) {
            throw new NotZeroRoundException();
        }
    }

}
