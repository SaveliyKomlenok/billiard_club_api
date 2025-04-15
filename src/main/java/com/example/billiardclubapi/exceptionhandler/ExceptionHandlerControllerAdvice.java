package com.example.billiardclubapi.exceptionhandler;

import com.example.billiardclubapi.exception.AmountOfBilliardTableExceededException;
import com.example.billiardclubapi.exception.AmountOfCueExceededException;
import com.example.billiardclubapi.exception.BilliardTableNotExistsException;
import com.example.billiardclubapi.exception.CueNotExistsException;
import com.example.billiardclubapi.exception.CueTypeNotExistsException;
import com.example.billiardclubapi.exception.LimitOfCuesExceeded;
import com.example.billiardclubapi.exception.ManufacturerNotExistsException;
import com.example.billiardclubapi.exception.ReserveNotExistException;
import com.example.billiardclubapi.exception.SelectedCueNotExistsException;
import com.example.billiardclubapi.exception.SelectedTableNotExistsException;
import com.example.billiardclubapi.exception.UserNotExistsException;
import org.springdoc.api.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
    @ExceptionHandler({AmountOfBilliardTableExceededException.class,
            AmountOfCueExceededException.class,
            BilliardTableNotExistsException.class,
            CueNotExistsException.class,
            CueTypeNotExistsException.class,
            ManufacturerNotExistsException.class,
            ReserveNotExistException.class,
            SelectedCueNotExistsException.class,
            SelectedTableNotExistsException.class,
            UserNotExistsException.class,
            LimitOfCuesExceeded.class})
    public ResponseEntity<ErrorMessage> handleBadRequestErrors(RuntimeException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMessage(exception.getMessage()));
    }

//    @ExceptionHandler()
//    public ResponseEntity<ErrorMessage> handleConflictErrors(RuntimeException exception) {
//        return ResponseEntity
//                .status(HttpStatus.CONFLICT)
//                .body(new ErrorMessage(exception.getMessage()));
//    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationErrorResponse onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        final List<Violation> violations = e.getBindingResult().getFieldErrors().stream()
                .map(error -> new Violation(error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());
        return new ValidationErrorResponse(violations);
    }
}