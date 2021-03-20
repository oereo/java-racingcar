package racingcar.domain.car;

import racingcar.domain.exception.NotBlankException;
import racingcar.domain.exception.NotValidNameLengthException;

public class CarName {
    private static final int CAR_NAME_MAX_LENGTH = 4;
    private String name;

    public CarName(String name) {
        checkBlankName(name);
        checkNameLength(name);
        this.name = name;
    }

    private void checkBlankName(String name) {
        if (name.isBlank()) {
            throw new NotBlankException();
        }
    }

    private void checkNameLength(String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new NotValidNameLengthException();
        }
    }
}
