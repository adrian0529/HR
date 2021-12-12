package com.data.hr.dao;

import com.data.hr.dto.Location;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class DaoLocationImp implements DaoLocation{
    public static final String INSERT = "INSERT INTO locations (location_id, street_address, postal_code, city, state_province, country_id) VALUES (?,?,?,?,?,?)";
    public static final String UPDATE = "UPDATE locations SET street_address=?, postal_code=?, city=?, state_province=?, country_id=? WHERE location_id=?";
    public static final String GET_BY_ID = "SELECT * FROM locations WHERE location_id=?";
    public static final String DELETE = "DELETE FROM locations WHERE location_id=?";
    public static final String GET_ALL = "SELECT * FROM locations";

    JdbcTemplate jdbcTemplate;

    public DaoLocationImp(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Location save(Location location) {
        jdbcTemplate.update(INSERT,
                location.getLocation_id(), location.getStreet_address(), location.getPostal_code(),
                location.getCity(), location.getState_province(), location.getCountry_id());

        return location;
    }

    @Override
    public Location update(Location location) {
        jdbcTemplate.update(UPDATE,
                location.getStreet_address(), location.getPostal_code(), location.getCity(),
                location.getState_province(), location.getCountry_id(), location.getLocation_id());

        return location;
    }

    @Override
    public Location getById(int location_id) {
        return jdbcTemplate.queryForObject(GET_BY_ID, (rs, rowNum) -> {
            return new Location(rs.getInt("location_id"), rs.getString("street_address"),
                    rs.getString("postal_code"), rs.getString("city"),
                    rs.getString("state_province"), rs.getString("country_id"));
        }, location_id);
    }

    @Override
    public String delete(int location_id) {
        jdbcTemplate.update(DELETE, location_id);

        return "Location with ID " + location_id + " deleted";
    }

    @Override
    public List<Location> allLocations() {
        return jdbcTemplate.query(GET_ALL, (rs, rowNum) -> {
            return new Location(rs.getInt("location_id"), rs.getString("street_address"),
                    rs.getString("postal_code"), rs.getString("city"),
                    rs.getString("state_province"), rs.getString("country_id"));
        });
    }
}
