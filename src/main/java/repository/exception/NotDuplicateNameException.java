package repository.exception;

public class NotDuplicateNameException extends RuntimeException {
    public NotDuplicateNameException(String message) {
        super(message);
    }
}
