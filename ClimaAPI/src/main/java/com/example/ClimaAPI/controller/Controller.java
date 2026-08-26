package com.example.ClimaAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ClimaAPI.service.Service;

@RestController
public class Controller {

    Service service = new Service();

    @GetMapping("/clima/{latitude}/{longitude}")
    public String consultarCidade(
        @PathVariable double latitude,
        @PathVariable double longitude,
        @RequestParam (required = false) String hourly,
        @RequestParam (required = false) String daily) {
    return service.consultarCidade(latitude, longitude, hourly, daily);
    }

}
