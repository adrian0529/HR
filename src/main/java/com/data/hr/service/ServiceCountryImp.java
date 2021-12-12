package com.data.hr.service;


import com.data.hr.dao.DaoCountry;
import com.data.hr.dto.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ServiceCountryImp implements ServiceCountry {
    private final Logger log = LoggerFactory.getLogger(ServiceCountryImp.class);

    @Autowired
    DaoCountry daoCountry;

    @Override
    public Country save(Country country) {
        return daoCountry.save(country);
    }

    @Override
    public Country update(Country country) {
        return daoCountry.update(country);
    }

    @Override
    public Country getById(String country_id) {
        return daoCountry.getById(country_id);
    }

    @Override
    public String delete(String country_id) {
        return daoCountry.delete(country_id);
    }

    @Override
    public List<Country> allCountries() {
        return daoCountry.allCountries();
    }
}
