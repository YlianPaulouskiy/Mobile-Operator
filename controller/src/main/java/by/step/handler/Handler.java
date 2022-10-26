package by.step.handler;

import by.step.service.exception.EntityNotCorrectException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.sql.Date;
import java.time.Instant;

@RestControllerAdvice
public class Handler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public ErrorDetails handleEntityNotFound(EntityNotFoundException exception) {
        return ErrorDetails.builder()
                .timestamp(Date.from(Instant.now()))
                .message(exception.getMessage())
                .httpStatus(HttpStatus.I_AM_A_TEAPOT)
                .details("Nothing found.")
                .code(HttpStatus.I_AM_A_TEAPOT.value())
                .build();
    }

    @ExceptionHandler(EntityExistsException.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public ErrorDetails handleEntityExist(EntityExistsException exception) {
        return ErrorDetails.builder()
                .timestamp(Date.from(Instant.now()))
                .message(exception.getMessage())
                .httpStatus(HttpStatus.I_AM_A_TEAPOT)
                .details("This data already exist in database.")
                .code(HttpStatus.I_AM_A_TEAPOT.value())
                .build();
    }

    @ExceptionHandler(EntityNotCorrectException.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public ErrorDetails handleEntityNotCorrect(EntityNotCorrectException exception) {
        return ErrorDetails.builder()
                .timestamp(Date.from(Instant.now()))
                .message(exception.getMessage())
                .httpStatus(HttpStatus.I_AM_A_TEAPOT)
                .details("Incorrect input data.")
                .code(HttpStatus.I_AM_A_TEAPOT.value())
                .build();
    }
}
