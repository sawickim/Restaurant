package pl.inteca.creditApp.exception;

public class CustomerPeselAlreadyExistException extends RuntimeException{
    public CustomerPeselAlreadyExistException(String message) {
        super(message);
    }
}
