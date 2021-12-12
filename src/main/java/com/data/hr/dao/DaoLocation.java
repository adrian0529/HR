package com.data.hr.dao;

import com.data.hr.dto.Location;

import java.util.List;

public interface DaoLocation {
    Location save(Location location);
    Location update(Location location);
    Location getById(int location_id);
    String delete(int location_id);
    List<Location> allLocations();
}
