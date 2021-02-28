package ru.netology.exciption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class InvalidCredentials extends RuntimeException{
    public InvalidCredentials(String msg) {
        super(msg);
    }

}
