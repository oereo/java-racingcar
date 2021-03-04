package domain.exception;

public class NotBlankException extends RuntimeException {
    public NotBlankException(String message) {
        super(message);
    }
}
