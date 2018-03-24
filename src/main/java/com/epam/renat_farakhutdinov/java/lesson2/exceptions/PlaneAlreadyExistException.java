package com.epam.renat_farakhutdinov.java.lesson2.exceptions;

/**
 * Created by Renat Farakhutdinov on 24.03.2018.
 */
public class PlaneAlreadyExistException extends Exception {
    public PlaneAlreadyExistException() {
        super();
    }

    public PlaneAlreadyExistException(String message) {
        super(message);
    }

    public PlaneAlreadyExistException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public PlaneAlreadyExistException(Throwable throwable) {
        super(throwable);
    }
}
