package biblioteca.controller;

public class InvalidOptionException extends RuntimeException {
    InvalidOptionException(final String message) {
        super(message);
    }
}
