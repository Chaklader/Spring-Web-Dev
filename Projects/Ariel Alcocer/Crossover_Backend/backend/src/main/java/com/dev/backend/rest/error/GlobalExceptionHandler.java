package com.dev.backend.rest.error;

import com.dev.backend.exception.InsufficientCreditException;
import com.dev.backend.exception.InsufficientStockException;
import com.dev.backend.rest.wrapper.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)//400
    @ExceptionHandler(value = InsufficientCreditException.class)
    public CommonResponse insufficientCreditException(InsufficientCreditException e)    {
        logger.warn("Error message...{}", e.getErrorMessage());
        return new CommonResponse(e.getErrorMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)//400
    @ExceptionHandler(value = InsufficientStockException.class)
    public CommonResponse outofStockException(InsufficientStockException e)    {
        logger.warn("Error message...{}", e.getErrorMessage());
        return new CommonResponse(e.getErrorMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)//400
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public CommonResponse notValidException(MethodArgumentNotValidException e)  {
        logger.warn("Error message...{}", e.getMessage());
        return new CommonResponse(e.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)//500
    @ExceptionHandler(value = Exception.class)
    public CommonResponse unknownException(Exception e)    {
        logger.warn("Error message...{}", e.getMessage());
        return new CommonResponse("Internal Server error");
    }

}
