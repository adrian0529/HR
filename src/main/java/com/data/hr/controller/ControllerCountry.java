package com.data.hr.controller;

import com.data.hr.service.ServiceCountry;
import com.data.hr.dto.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/hr")
public class ControllerCountry {

    @Autowired
    ServiceCountry serviceCountry;

    @PostMapping("/country")
    public Country addCountry(@RequestBody Country country){
        return serviceCountry.save(country);
    }

    @PutMapping("/country")
    public Country updateCountry(@RequestBody Country country){
        return serviceCountry.update(country);
    }

    @GetMapping("/country/{id}")
    public Country getCountry(@PathVariable("id") String country_id){
        return serviceCountry.getById(country_id);
    }

    @DeleteMapping("/country/{id}")
    public String deleteCountry(@PathVariable("id") String country_id){
        return serviceCountry.delete(country_id);
    }

    @GetMapping("/countries")
    public List<Country> getCountries(){
        return serviceCountry.allCountries();
    }
}
