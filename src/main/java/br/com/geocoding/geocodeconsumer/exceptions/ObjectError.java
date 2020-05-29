package br.com.geocoding.geocodeconsumer.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ObjectError {

    private final String message;
    private final String field;
    private final Object parameter;
}
