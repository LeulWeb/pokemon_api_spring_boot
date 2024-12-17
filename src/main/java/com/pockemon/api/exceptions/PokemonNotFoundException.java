package com.pockemon.api.exceptions;

import java.io.Serial;

public class PokemonNotFoundException extends  RuntimeException {
    @Serial
    private static final long serialVersionUID = 1; //serilaization
    public  PokemonNotFoundException(String message){
        super(message);
    }
}
