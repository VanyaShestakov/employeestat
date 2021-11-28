package com.leverx.employeestat.rest.exceptionhandler;

import com.leverx.employeestat.rest.controller.DepartmentController;
import com.leverx.employeestat.rest.exception.*;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice("com.leverx.employeestat.rest.controller")
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchRecordException.class)
    public ResponseEntity<ExceptionInfo> handleNoSuchRecordException(NoSuchRecordException exception) {
        ExceptionInfo info = new ExceptionInfo();
        info.setStatus(HttpStatus.NOT_FOUND);
        info.setCode(HttpStatus.NOT_FOUND.value());
        info.setMessage(exception.getMessage());
        return new ResponseEntity<>(info, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateRecordException.class)
    public ResponseEntity<ExceptionInfo> handleDuplicateRecordException(DuplicateRecordException exception) {
        ExceptionInfo info = new ExceptionInfo();
        info.setStatus(HttpStatus.BAD_REQUEST);
        info.setCode(HttpStatus.BAD_REQUEST.value());
        info.setMessage(exception.getMessage());
        return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityConversionException.class)
    public ResponseEntity<ExceptionInfo> handleEntityConversionException(EntityConversionException exception) {
        ExceptionInfo info = new ExceptionInfo();
        info.setStatus(HttpStatus.BAD_REQUEST);
        info.setCode(HttpStatus.BAD_REQUEST.value());
        info.setMessage(exception.getMessage());
        return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotValidRecordException.class)
    public ResponseEntity<ExceptionInfo> handleNotValidRecordException(NotValidRecordException exception) {
        ExceptionInfo info = new ExceptionInfo();
        info.setStatus(HttpStatus.BAD_REQUEST);
        info.setCode(HttpStatus.BAD_REQUEST.value());
        info.setMessage(exception.getMessage());
        return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotValidUUIDException.class)
    public ResponseEntity<ExceptionInfo> handleNotValidUUIDException(NotValidUUIDException exception) {
        ExceptionInfo info = new ExceptionInfo();
        info.setStatus(HttpStatus.BAD_REQUEST);
        info.setCode(HttpStatus.BAD_REQUEST.value());
        info.setMessage(exception.getMessage());
        return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
    }
}
