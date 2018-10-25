package com.example.restcontrollers;

import com.example.services.WeatherAppException;
import com.example.services.WeatherAppServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController

public class RestAPIController {

    @Autowired
    WeatherAppServices service;

    @RequestMapping(value = "/weather/{city}")
    @ResponseBody
    public ResponseEntity<?> getCityWeather (@PathVariable("city") String city) {
        try {
            String values=service.getCityWeather(city);

            return new ResponseEntity<>(values, HttpStatus.ACCEPTED);

        }catch (WeatherAppException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }






}


