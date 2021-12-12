package com.data.hr.dao;

import com.data.hr.dto.Country;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class DaoCountryImp implements DaoCountry{
    public static final String INSERT = "INSERT INTO countries (country_id, country_name, region_id) VALUES (?,?,?)";
    public static final String UPDATE = "UPDATE countries SET country_name=?, region_id=? WHERE country_id=?";
    public static final String GET_BY_ID = "SELECT * FROM countries WHERE country_id=?";
    public static final String DELETE = "DELETE FROM countries WHERE country_id=?";
    public static final String GET_ALL = "SELECT * FROM countries";

    JdbcTemplate jdbcTemplate;

    public DaoCountryImp(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Country save(Country country) {
        jdbcTemplate.update(INSERT,
                country.getCountry_id(), country.getCountry_name(), country.getRegion_id());

        return country;
    }

    @Override
    public Country update(Country country) {
        jdbcTemplate.update(UPDATE,
                country.getCountry_name(), country.getRegion_id(), country.getCountry_id());

        return country;
    }

    @Override
    public Country getById(String country_id) {
        return jdbcTemplate.queryForObject(GET_BY_ID, (rs, rowNum) -> {
            return new Country(rs.getString("country_id"), rs.getString("country_name"), rs.getInt("region_id"));
        }, country_id);
    }

    @Override
    public String delete(String country_id) {
        jdbcTemplate.update(DELETE, country_id);
        return "Country with ID " + country_id + " deleted";
    }

    @Override
    public List<Country> allCountries() {
        return jdbcTemplate.query(GET_ALL, (rs, rowNum) -> {
            return new Country(rs.getString("country_id"), rs.getString("country_name"), rs.getInt("region_id"));
        });
    }
}
