package com.example.persistence;

import com.example.services.WeatherAppException;

import java.io.IOException;

public interface WeatherAppPersistence {
    /**
     * Metodo consulta el clime en una ciudad
     * @param City a consultar
     */
    String getCityWeather(String City) throws  WeatherAppException;
    void manejadorCache();
}
