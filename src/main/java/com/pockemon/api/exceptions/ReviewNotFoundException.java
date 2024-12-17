package com.pockemon.api.exceptions;

import java.io.Serial;

public class ReviewNotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1; //serilaization
    public  ReviewNotFoundException(String message){
        super(message);
    }

}

