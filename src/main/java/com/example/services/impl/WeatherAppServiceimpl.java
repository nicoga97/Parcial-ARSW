package com.example.services.impl;

import com.example.persistence.WeatherAppPersistence;
import com.example.services.WeatherAppException;
import com.example.services.WeatherAppServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherAppServiceimpl implements WeatherAppServices {
    @Autowired
    WeatherAppPersistence persistence;

    @Override
    public String getCityWeather(String city) throws  WeatherAppException {
        return persistence.getCityWeather(city);
    }
}
