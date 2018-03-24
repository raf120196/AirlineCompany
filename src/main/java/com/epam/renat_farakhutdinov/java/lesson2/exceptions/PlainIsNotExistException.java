package com.epam.renat_farakhutdinov.java.lesson2.exceptions;

/**
 * Created by Renat Farakhutdinov on 24.03.2018.
 */
public class PlainIsNotExistException extends Exception {
    public PlainIsNotExistException() {
        super();
    }

    public PlainIsNotExistException(String message) {
        super(message);
    }

    public PlainIsNotExistException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public PlainIsNotExistException(Throwable throwable) {
        super(throwable);
    }
}
