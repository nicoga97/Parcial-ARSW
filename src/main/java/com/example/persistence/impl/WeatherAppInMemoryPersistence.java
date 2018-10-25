package com.example.persistence.impl;


import com.example.model.Weather;
import com.example.persistence.WeatherAppPersistence;
import com.example.services.WeatherAppException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class WeatherAppInMemoryPersistence implements WeatherAppPersistence {
    private ConcurrentHashMap<String,String> requests=new ConcurrentHashMap<>();

    public WeatherAppInMemoryPersistence(){
    }

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
    public void manejadorCache(){
        Calendar fecha = Calendar.getInstance();
        int minuto = fecha.get(Calendar.MINUTE);
        int cont=0;
        boolean br=true;
        while (br){
            if(minuto!=fecha.get(Calendar.MINUTE)){
                cont++;
                if(cont>5){
                    requests=new ConcurrentHashMap<>();
                    br=false;
                }

            }
        }
        manejadorCache();
    }

}
