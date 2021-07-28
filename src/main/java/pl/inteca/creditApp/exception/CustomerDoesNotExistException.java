package pl.inteca.creditApp.exception;

public class CustomerDoesNotExistException extends RuntimeException{
    public CustomerDoesNotExistException(String message) {
        super(message);
    }
}
