package com.data.hr.service;

import com.data.hr.dto.Region;

import java.util.List;

public interface ServiceRegion {
    Region save(Region region);
    Region update(Region region);
    Region getById(int region_id);
    String delete(int region_id);
    List<Region> allRegions();
}
