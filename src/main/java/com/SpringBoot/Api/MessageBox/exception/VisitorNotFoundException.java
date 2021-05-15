package com.SpringBoot.Api.MessageBox.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class VisitorNotFoundException extends Exception{
    public VisitorNotFoundException(Long id) {
        super("Visitor not found with Id " + id);
    }

}
