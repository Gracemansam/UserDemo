package com.userlist.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {
    @ExceptionHandler(BusinessException.class)

    public ResponseEntity<ErrorModel>handleBuzError(BusinessException e){
        ErrorModel errorModel = e.getErrorModel();
        log.info( "error occur here {} -{}", errorModel.getErrorMessage(),errorModel.getErrorCode());

        return  new ResponseEntity<>(errorModel, HttpStatus.BAD_REQUEST);

    }

}
