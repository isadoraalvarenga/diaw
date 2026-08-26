package com.example.ClimaAPI.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class Service {

    private static final String BASE_URL = "https://api.open-meteo.com/v1";

    private String consultarURL(String apiUrl){
        RestTemplate restTemplate = new RestTemplate();
        try{
             ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
            return responseEntity.getBody();
        } catch (Exception e) {
            return "Erro na requisição: " + e.getMessage();
        }
    }
    

    public String consultarCidade(double latitude, double longitude, String hourly, String daily){
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL)
                .queryParam("latitude", latitude)
                .queryParam("longitude", longitude)
                .queryParam("timezone", "America/Sao_Paulo")
                .queryParam("forecast_days", 1);

        if (daily != null && !daily.isEmpty()) {
            builder.queryParam("daily", daily);
        }
        if (hourly != null && !hourly.isEmpty()) {
            builder.queryParam("hourly", hourly);
        }

        return consultarURL(builder.toUriString());
    }

}
