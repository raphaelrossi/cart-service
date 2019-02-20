package com.raphaelrossi.cartservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by e074467 on 2/13/2019.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidDataException extends RuntimeException{
    public InvalidDataException(String message) {
        super(message);
    }
}
