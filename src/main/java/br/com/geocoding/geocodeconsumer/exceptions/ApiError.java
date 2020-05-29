package br.com.geocoding.geocodeconsumer.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

@Getter
public class ApiError {

    private HttpStatus status;
    private List<String> messages;
    private List<String> errors;

    public ApiError(HttpStatus status, List<String> message, List<String> errors) {
        super();
        this.status = status;
        this.messages = message;
        this.errors = errors;
    }

    public ApiError(HttpStatus status, List<String> message, String error) {
        super();
        this.status = status;
        this.messages = message;
        errors = Arrays.asList(error);
    }
}