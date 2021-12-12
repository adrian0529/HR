package com.data.hr.service;

import com.data.hr.dao.DaoRegion;
import com.data.hr.dto.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ServiceRegionImp implements ServiceRegion{
    private final Logger log = LoggerFactory.getLogger(ServiceJobImp.class);

    @Autowired
    DaoRegion daoRegion;

    @Override
    public Region save(Region region) {
        return daoRegion.save(region);
    }

    @Override
    public Region update(Region region) {
        return daoRegion.update(region);
    }

    @Override
    public Region getById(int region_id) {
        return daoRegion.getById(region_id);
    }

    @Override
    public String delete(int region_id) {
        return daoRegion.delete(region_id);
    }

    @Override
    public List<Region> allRegions() {
        return daoRegion.allRegions();
    }
}
