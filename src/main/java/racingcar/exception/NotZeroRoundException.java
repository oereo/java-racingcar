package racingcar.exception;

public class NotZeroRoundException extends IllegalArgumentException {
    private static final String NOT_ZERO_ROUND_EXCEPTION_MESSAGE = "라운드 회수로 0은 입력하실 수 없습니다.";

    public NotZeroRoundException() {
        super(NOT_ZERO_ROUND_EXCEPTION_MESSAGE);
    }
}
