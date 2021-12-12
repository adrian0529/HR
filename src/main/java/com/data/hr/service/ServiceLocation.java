package com.data.hr.service;

import com.data.hr.dto.Location;

import java.util.List;

public interface ServiceLocation {
    Location save(Location location);
    Location update(Location location);
    Location getById(int location_id);
    String delete(int location_id);
    List<Location> allLocations();
}
