package com.example.services;

public class WeatherAppException extends Exception{

    public WeatherAppException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeatherAppException(String message) {
        super(message);
    }
}

