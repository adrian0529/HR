package com.data.hr.dao;

import com.data.hr.dto.Region;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class DaoRegionImp implements DaoRegion{
    public static final String INSERT = "INSERT INTO regions (region_id, region_name) VALUES (?,?)";
    public static final String UPDATE = "UPDATE regions SET region_name=? WHERE region_id=?";
    public static final String GET_BY_ID = "SELECT * FROM regions WHERE region_id=?";
    public static final String DELETE = "DELETE FROM regions WHERE region_id=?";
    public static final String GET_ALL = "SELECT * FROM regions";

    JdbcTemplate jdbcTemplate;

    public DaoRegionImp(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Region save(Region region) {
        jdbcTemplate.update(INSERT,
                region.getRegion_id(), region.getRegion_name());

        return region;
    }

    @Override
    public Region update(Region region) {
        jdbcTemplate.update(UPDATE,
                region.getRegion_name(), region.getRegion_id());

        return region;
    }

    @Override
    public Region getById(int region_id) {
        return jdbcTemplate.queryForObject(GET_BY_ID, (rs, rowNum) -> {
            return new Region(rs.getInt("region_id"), rs.getString("region_name"));
        }, region_id);
    }

    @Override
    public String delete(int region_id) {
        jdbcTemplate.update(DELETE, region_id);

        return "Region with ID " + region_id + " deleted";
    }

    @Override
    public List<Region> allRegions() {
        return jdbcTemplate.query(GET_ALL, (rs, rowNum) -> {
            return new Region(rs.getInt("region_id"), rs.getString("region_name"));
        });
    }
}
