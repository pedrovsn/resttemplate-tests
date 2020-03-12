package com.pedrovsn.handler.business;

import com.pedrovsn.domain.bean.ApiError;
import com.pedrovsn.exception.PostalCodeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Locale;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class PostalCodeExceptionHandler extends ResponseEntityExceptionHandler {

    private MessageSource messageSource;

    @Autowired
    public PostalCodeExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(PostalCodeNotFoundException.class)
    public ApiError customHandleNotFound(Exception ex, WebRequest request) {
        return new ApiError(HttpStatus.NOT_FOUND, ex.getLocalizedMessage(), messageSource.getMessage("Exception.notFound", null, Locale.getDefault()));
    }
}
