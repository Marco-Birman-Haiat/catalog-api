package com.marcohaiat.catalog_api.exceptions;

import com.marcohaiat.catalog_api.exceptions.notFoundExceptions.CategoryNotFoundException;
import com.marcohaiat.catalog_api.exceptions.notFoundExceptions.OwnerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler({
          CategoryNotFoundException.class,
          OwnerNotFoundException.class
    })
    public ResponseEntity<ErrorResponseDTO> handleNotFoundException(RuntimeException exception) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(exception.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleThrowable(Throwable exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_GATEWAY)
                .body(exception.getMessage());
    }
}
