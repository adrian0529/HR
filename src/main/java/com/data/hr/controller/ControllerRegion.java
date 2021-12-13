package com.data.hr.controller;

import com.data.hr.dto.Region;
import com.data.hr.service.ServiceRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hr")
public class ControllerRegion {

    @Autowired
    ServiceRegion serviceRegion;

    @PostMapping("region")
    public Region addRegion(@RequestBody Region region){
        return serviceRegion.save(region);
    }

    @PutMapping("region")
    public Region updateRegion(@RequestBody Region region){
        return serviceRegion.update(region);
    }

    @GetMapping("region/{id}")
    public Region getRegion(@PathVariable("id") int region_id){
        return serviceRegion.getById(region_id);
    }

    @DeleteMapping("region/{id}")
    public String deleteRegion(@PathVariable("id") int region_id){
        return serviceRegion.delete(region_id);
    }

    @GetMapping("regions")
    public List<Region> getRegions(){
        return serviceRegion.allRegions();
    }
}
