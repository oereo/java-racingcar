package racingcar.domain.exception;

public class NotValidNameLengthException extends RuntimeException {
    private static final String Message = "5자 이상의 이름을 가진 차는 생설할 수 없습니다.";

    public NotValidNameLengthException() {
        super(Message);
    }
}
