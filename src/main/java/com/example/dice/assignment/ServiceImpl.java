package com.example.dice.assignment;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceImpl {


    public ResponseEntity<Object> getWeatherForecast(String key, String host, String city, String api) {
        try {
            String url = "https://forecast9.p.rapidapi.com/rapidapi/forecast/" + city + "/" + api + "/";
            RestTemplate template = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set("X-RapidAPI-Key", key);
            headers.set("X-RapidAPI-Host", host);
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
            ResponseEntity<Object> respEntity = template.exchange(url, HttpMethod.GET, entity, Object.class);

            return respEntity;

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
    }
}
