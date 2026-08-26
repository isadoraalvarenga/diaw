package com.example.ClimaAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.ClimaAPI.service.Service;

@RestController
public class Controller {

    Service service = new Service();

    @GetMapping("/clima")
    public String consultarClima(){
        return service.consultarClima();
    }
    @GetMapping("/clima/{cidade}") // https://localhost:8080/climaBH
    public String consultarClimaCidade(@PathVariable String cidade){
        return service.consultarClimaCidade(cidade);
    }
    
}
