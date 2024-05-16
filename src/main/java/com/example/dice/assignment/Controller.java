package com.example.dice.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/forecast")
public class Controller {

    @Autowired
    private ServiceImpl service;

    @GetMapping("/{locationName}/{api}/")
    public ResponseEntity<Object> getWeatherForecastSummary(@PathVariable("locationName") String city,
                                                            @PathVariable("api") String api,
                                                            @RequestHeader("X-RapidAPI-Key") String key,
                                                            @RequestHeader("X-RapidAPI-Host") String host) {
        return service.getWeatherForecast(key, host, city, api);
    }

}
