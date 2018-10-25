package com.example.persistence.impl;


import com.example.model.Weather;
import com.example.persistence.WeatherAppPersistence;
import com.example.services.WeatherAppException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;

@Service
public class WeatherAppInMemoryPersistence implements WeatherAppPersistence {
    private HashMap<String,String> requests=new HashMap<>();


    @Override
    public String getCityWeather(String city) throws WeatherAppException {
        if(!requests.containsKey(city)){
            try {
                requests.put(city,Weather.getCityWeather(city));
            } catch (IOException e) {
                throw new WeatherAppException("No city found");
            }
        }
        return requests.get(city);
    }
}
