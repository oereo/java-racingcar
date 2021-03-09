package racingcar.domain.exception;

public class NotBlankException extends RuntimeException {
    private static final String MESSAGE = "빈 문자열 이름의 차를 생성할 수는 없습니다.";

    public NotBlankException() {
        super(MESSAGE);
    }
}
