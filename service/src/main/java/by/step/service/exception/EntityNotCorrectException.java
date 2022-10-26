package by.step.service.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
@Getter
public class EntityNotCorrectException extends RuntimeException {

    public EntityNotCorrectException(String message) {
        super(message);
    }
}
