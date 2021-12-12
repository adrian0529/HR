package com.data.hr.service;

import com.data.hr.dao.DaoLocation;
import com.data.hr.dto.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ServiceLocationImp implements ServiceLocation{
    private final Logger log = LoggerFactory.getLogger(ServiceJobImp.class);

    @Autowired
    DaoLocation daoLocation;

    @Override
    public Location save(Location location) {
        return daoLocation.save(location);
    }

    @Override
    public Location update(Location location) {
        return daoLocation.update(location);
    }

    @Override
    public Location getById(int location_id) {
        return daoLocation.getById(location_id);
    }

    @Override
    public String delete(int location_id) {
        return daoLocation.delete(location_id);
    }

    @Override
    public List<Location> allLocations() {
        return daoLocation.allLocations();
    }
}
