package me.mrsofiane.demographql.exceptions;

import java.util.Map;

public class StudentNotFoundException extends RuntimeException{


    public StudentNotFoundException(){
        super();
    }

    public StudentNotFoundException(String s){
        super(s);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
