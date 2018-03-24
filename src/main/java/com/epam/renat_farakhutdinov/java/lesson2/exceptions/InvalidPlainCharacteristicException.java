package com.epam.renat_farakhutdinov.java.lesson2.exceptions;

/**
 * Created by Renat Farakhutdinov on 24.03.2018.
 */
public class InvalidPlainCharacteristicException extends Exception {
    public InvalidPlainCharacteristicException() {
        super();
    }

    public InvalidPlainCharacteristicException(String message) {
        super(message);
    }

    public InvalidPlainCharacteristicException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public InvalidPlainCharacteristicException(Throwable throwable) {
        super(throwable);
    }
}
