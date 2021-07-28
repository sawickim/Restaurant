package pl.inteca.creditApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@ResponseBody
public class CreditNameAndNumberAlreadyExistException extends RuntimeException{
    public CreditNameAndNumberAlreadyExistException(String message) {
        super(message);
    }
}
