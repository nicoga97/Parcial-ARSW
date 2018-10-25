package com.example.services;

import java.io.IOException;

public interface WeatherAppServices {
    String getCityWeather(String city) throws  WeatherAppException;
}
