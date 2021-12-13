package com.data.hr.controller;

import com.data.hr.dto.Location;
import com.data.hr.service.ServiceLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerLocation {

    @Autowired
    ServiceLocation serviceLocation;

    @PostMapping("/location")
    public Location addLocation(@RequestBody Location location){
        return serviceLocation.save(location);
    }

    @PutMapping("/location")
    public Location updateLocation(@RequestBody Location location){
        return serviceLocation.update(location);
    }

    @GetMapping("/location/{id}")
    public Location getLocation(@PathVariable("id") int location_id){
        return serviceLocation.getById(location_id);
    }

    @DeleteMapping("/location/{id}")
    public String deleteLocation(@PathVariable("id") int location_id){
        return serviceLocation.delete(location_id);
    }

    @GetMapping("/locations")
    public List<Location> getLocations(){
        return serviceLocation.allLocations();
    }
}
