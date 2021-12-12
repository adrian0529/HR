package com.data.hr.service;

import com.data.hr.dto.Country;

import java.util.List;

public interface ServiceCountry {
    Country save(Country country);
    Country update(Country country);
    Country getById(String country_id);
    String delete(String country_id);
    List<Country> allCountries();
}
