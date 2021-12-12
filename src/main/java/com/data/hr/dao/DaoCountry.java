package com.data.hr.dao;

import com.data.hr.dto.Country;

import java.util.List;

public interface DaoCountry {
    Country save(Country country);
    Country update(Country country);
    Country getById(String country_id);
    String delete(String country_id);
    List<Country> allCountries();
}
